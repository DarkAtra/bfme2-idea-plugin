package de.darkatra.bfme2.ini.declarations

import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.psi.PsiManager
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.IndexingTestUtil
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import de.darkatra.bfme2.ini.navigation.SageEngineIniDeclarationGotoDeclarationHandler
import de.darkatra.bfme2.ini.navigation.SageEngineIniIncludeReference
import de.darkatra.bfme2.ini.navigation.SageEngineIniMacroGotoDeclarationHandler
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.settings.SageEngineIniSettings
import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Test
import java.io.File

class SageEngineIniAdditionalSourcesTest : LightPlatformCodeInsightFixture4TestCase() {

    private val directories = mutableListOf<File>()

    @After
    fun resetAdditionalSourceDirectories() {
        SageEngineIniSettings.getInstance(project).updateAdditionalSourceDirectories(emptyList())
        directories.forEach { FileUtil.delete(it) }
    }

    @Test
    fun `should resolve and complete declarations from additional directories`() {

        val baseGame = createDirectory("data/ini/specialpower.ini" to "SpecialPower SpecialAbilityBaseGame\nEnd")
        useAdditionalDirectories(baseGame)

        myFixture.configureByText("commandbutton.ini", "SpecialPower = SpecialAbility<caret>BaseGame")

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)
        val targets = SageEngineIniDeclarationGotoDeclarationHandler().getGotoDeclarationTargets(sourceElement, myFixture.caretOffset, myFixture.editor)

        assertThat(targets).extracting<String> { it.text }.containsExactly("SpecialAbilityBaseGame")
        assertThat(SageEngineIniDeclarationLookup.allDeclarationNames(project, setOf("SpecialPower"))).contains("SpecialAbilityBaseGame")
    }

    @Test
    fun `should not resolve declarations from directories that were removed again`() {

        val baseGame = createDirectory("specialpower.ini" to "SpecialPower SpecialAbilityBaseGame\nEnd")
        useAdditionalDirectories(baseGame)
        useAdditionalDirectories()

        assertThat(SageEngineIniDeclarationLookup.findDeclarations(project, "SpecialAbilityBaseGame", setOf("SpecialPower"))).isEmpty()
    }

    @Test
    fun `should prefer declarations of the project over additional directories`() {

        val baseGame = createDirectory("object.ini" to "Object ElvenMallornTree\nEnd")
        useAdditionalDirectories(baseGame)
        val modFile = myFixture.addFileToProject("data/object.ini", "Object ElvenMallornTree\nEnd")

        val declarations = SageEngineIniDeclarationLookup.findDeclarations(project, "ElvenMallornTree", setOf("Object"))

        assertThat(declarations).extracting<String> { it.containingFile.virtualFile.path }.containsExactly(modFile.virtualFile.path)
    }

    @Test
    fun `should prefer declarations of directories listed first`() {

        val first = createDirectory("object.ini" to "Object ElvenMallornTree\nEnd")
        val second = createDirectory("object.ini" to "Object ElvenMallornTree\nEnd")

        useAdditionalDirectories(first, second)
        assertThat(winningDirectories("ElvenMallornTree", "Object")).containsExactly(first)

        useAdditionalDirectories(second, first)
        assertThat(winningDirectories("ElvenMallornTree", "Object")).containsExactly(second)
    }

    @Test
    fun `should only find usages of the declaration that wins`() {

        val baseGame = createDirectory(
            "object.ini" to "Object ElvenMallornTree\nEnd",
            "usage.ini" to "ObjectNames = ElvenMallornTree"
        )
        useAdditionalDirectories(baseGame)
        myFixture.configureByText("object.ini", "Object Elven<caret>MallornTree\nEnd")

        val baseGameDeclaration = PsiTreeUtil.findChildOfType(psiFile(baseGame, "object.ini"), SageEngineIniBlock::class.java)!!
        val modDeclaration = PsiTreeUtil.findChildOfType(myFixture.file, SageEngineIniBlock::class.java)!!

        assertThat(ReferencesSearch.search(baseGameDeclaration.nameIdentifier!!).findAll()).isEmpty()
        assertThat(ReferencesSearch.search(modDeclaration.nameIdentifier!!).findAll()).extracting<String> { it.element.text }
            .containsExactly("ElvenMallornTree")
    }

    @Test
    fun `should prefer macro definitions of the project over additional directories`() {

        val baseGame = createDirectory("macros.ini" to "#define MALLORN_COST 100")
        useAdditionalDirectories(baseGame)
        myFixture.addFileToProject("data/macros.ini", "#define MALLORN_COST 200")
        myFixture.configureByText("object.ini", "BuildCost = MALLORN_<caret>COST")

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)
        val targets = SageEngineIniMacroGotoDeclarationHandler().getGotoDeclarationTargets(sourceElement, myFixture.caretOffset, myFixture.editor)!!

        assertThat(SageEngineIniMacros.isDefined(project, "MALLORN_COST")).isTrue()
        assertThat(targets).extracting<String> { it.containingFile.virtualFile.path }.containsExactly("/src/data/macros.ini")
    }

    @Test
    fun `should resolve macros from additional directories`() {

        val baseGame = createDirectory("macros.ini" to "#define MALLORN_COST 100")
        useAdditionalDirectories(baseGame)

        assertThat(SageEngineIniMacros.allNames(project)).contains("MALLORN_COST")
        assertThat(SageEngineIniMacros.findDefinitions(project, "mallorn_cost")).extracting<String> { it.text }.containsExactly("MALLORN_COST")
    }

    @Test
    fun `should resolve includes within additional directories`() {

        val baseGame = createDirectory(
            "object.ini" to "#include \"includes/buildings.inc\"",
            "includes/buildings.inc" to ""
        )
        useAdditionalDirectories(baseGame)

        val includeValue = PsiTreeUtil.collectElements(psiFile(baseGame, "object.ini")) {
            it.firstChild == null && it.text.trim('"') == "includes/buildings.inc"
        }.single()

        assertThat(SageEngineIniIncludeReference(includeValue).resolve()).isEqualTo(psiFile(baseGame, "includes/buildings.inc"))
    }

    private fun winningDirectories(name: String, kind: String): List<File> {
        return SageEngineIniDeclarationLookup.findDeclarations(project, name, setOf(kind))
            .map { block -> directories.single { block.containingFile.virtualFile.path.startsWith(FileUtil.toSystemIndependentName(it.path) + "/") } }
    }

    private fun psiFile(directory: File, relativePath: String) = PsiManager.getInstance(project)
        .findFile(LocalFileSystem.getInstance().refreshAndFindFileByIoFile(File(directory, relativePath))!!)!!

    private fun createDirectory(vararg files: Pair<String, String>): File {
        val directory = FileUtil.createTempDirectory("sage-engine-ini", null)
        files.forEach { (path, content) -> File(directory, path).apply { parentFile.mkdirs() }.writeText(content) }
        directories += directory
        return directory
    }

    private fun useAdditionalDirectories(vararg directories: File) {
        SageEngineIniSettings.getInstance(project).updateAdditionalSourceDirectories(directories.map { it.path })
        IndexingTestUtil.waitUntilIndexesAreReady(project)
    }
}
