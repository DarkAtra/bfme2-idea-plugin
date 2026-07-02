package de.darkatra.bfme2.ini.navigation

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.util.TextRange
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniIncludeReferenceContributorTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should resolve include path to referenced file`() {

        val includedFile = myFixture.addFileToProject("includes/StandardBuildingEvaEvents.inc", "")

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            #include "includes\Standard<caret>BuildingEvaEvents.inc"
            Object ElvenMallornTree
            End
            """.trimIndent()
        )

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)
        val targets = SageEngineIniIncludeGotoDeclarationHandler().getGotoDeclarationTargets(
            sourceElement,
            myFixture.caretOffset,
            myFixture.editor
        )

        assertThat(targets).containsExactly(includedFile)
    }

    @Test
    fun `should resolve nested relative include path`() {

        val includedFile = myFixture.addFileToProject("includes/buildings/StandardBuildingEvaEvents.inc", "")

        myFixture.configureByText(
            "elvenmallorntree.ini",
            "#include \"includes/buildings/Standard<caret>BuildingEvaEvents.inc\""
        )

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)!!
        val reference = SageEngineIniIncludeReference(sourceElement)

        assertThat(sourceElement.isPartOfIncludeMacro()).isTrue()
        assertThat(reference.resolve()).isEqualTo(includedFile)
    }

    @Test
    fun `should resolve windows style include path separators`() {

        val includedFile = myFixture.addFileToProject("includes/buildings/StandardBuildingEvaEvents.inc", "")

        myFixture.configureByText(
            "elvenmallorntree.ini",
            "#include \"includes\\buildings\\Standard<caret>BuildingEvaEvents.inc\""
        )

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)!!
        val reference = SageEngineIniIncludeReference(sourceElement)

        assertThat(sourceElement.isPartOfIncludeMacro()).isTrue()
        assertThat(reference.resolve()).isEqualTo(includedFile)
    }

    @Test
    fun `should not resolve missing include target`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            "#include \"includes/Missing<caret>File.inc\""
        )

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)!!
        val reference = SageEngineIniIncludeReference(sourceElement)

        assertThat(sourceElement.isPartOfIncludeMacro()).isTrue()
        assertThat(reference.resolve()).isNull()
    }

    @Test
    fun `should not resolve include path outside project dir`() {

        WriteCommandAction.runWriteCommandAction(project) {
            ProjectRootManager.getInstance(project).contentRoots.single().parent.createChildData(this, "OutsideProjectResolve.inc")
        }

        myFixture.configureByText(
            "elvenmallorntree.ini",
            "#include \"../Outside<caret>ProjectResolve.inc\""
        )

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)!!
        val reference = SageEngineIniIncludeReference(sourceElement)

        assertThat(sourceElement.isPartOfIncludeMacro()).isTrue()
        assertThat(reference.resolve()).isNull()
    }

    @Test
    fun `should create include references for quoted path range`() {

        val includePath = "includes\\StandardBuildingEvaEvents.inc"
        val includedFile = myFixture.addFileToProject("includes/StandardBuildingEvaEvents.inc", "")

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            #include "includes\Standard<caret>BuildingEvaEvents.inc"
            Object ElvenMallornTree
            End
            """.trimIndent()
        )

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)!!
        val reference = SageEngineIniIncludeReference(sourceElement)

        assertThat(sourceElement.isPartOfIncludeMacro()).isTrue()
        assertThat(reference.rangeInElement).isEqualTo(TextRange(1, includePath.length + 1))
        assertThat(reference.element.text.substring(reference.rangeInElement.startOffset, reference.rangeInElement.endOffset))
            .isEqualTo(includePath)
        assertThat(reference.resolve()).isEqualTo(includedFile)
    }

    @Test
    fun `should not create references for non include strings`() {

        myFixture.configureByText("elvenmallorntree.ini", "DisplayName = \"OBJECT<caret>:ElvenMallornTree\"")

        val reference = myFixture.file.findReferenceAt(myFixture.caretOffset)

        assertThat(reference).isNull()
    }

    @Test
    fun `should complete include paths for simple include path`() {

        myFixture.addFileToProject("data/StandardBuildingEvaEvents.inc", "")
        myFixture.addFileToProject("includes/Shared.inc", "")
        myFixture.addFileToProject("data/elvenmallorntree.ini", "#include \"<caret>\"")

        myFixture.configureByFile("data/elvenmallorntree.ini")

        val lookups = myFixture.completeBasic().map { it.lookupString }

        assertThat(lookups).contains("StandardBuildingEvaEvents.inc")
    }

    @Test
    fun `should complete include paths for parent include path`() {

        myFixture.addFileToProject("data/StandardBuildingEvaEvents.inc", "")
        myFixture.addFileToProject("includes/Shared.inc", "")
        myFixture.addFileToProject("data/elvenmallorntree.ini", "#include \"../<caret>\"")

        myFixture.configureByFile("data/elvenmallorntree.ini")

        val lookups = myFixture.completeBasic().map { it.lookupString }

        assertThat(lookups).contains("includes/")
    }

    @Test
    fun `should complete include paths for directory in parent include path`() {

        myFixture.addFileToProject("data/StandardBuildingEvaEvents.inc", "")
        myFixture.addFileToProject("includes/Shared.inc", "")
        myFixture.addFileToProject("data/elvenmallorntree.ini", "#include \"../includes/<caret>\"")

        myFixture.configureByFile("data/elvenmallorntree.ini")

        val lookups = myFixture.completeBasic().map { it.lookupString }

        assertThat(lookups).contains("Shared.inc")
    }

    @Test
    fun `should not complete include paths outside project dir`() {

        WriteCommandAction.runWriteCommandAction(project) {
            ProjectRootManager.getInstance(project).contentRoots.single().parent.createChildData(this, "OutsideProjectCompletion.inc")
        }

        myFixture.addFileToProject("elvenmallorntree.ini", "#include \"../<caret>\"")

        myFixture.configureByFile("elvenmallorntree.ini")

        val lookups = myFixture.completeBasic().map { it.lookupString }

        assertThat(lookups).doesNotContain("OutsideProjectCompletion.inc")
    }
}
