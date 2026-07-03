package de.darkatra.bfme2.ini.navigation

import com.intellij.codeInsight.TargetElementUtil
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ReadAction
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationLookup
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniDeclarationReferenceContributorTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should expose declaration kind and name from block PSI`() {

        myFixture.configureByText(
            "specialpower.ini",
            """
            SpecialPower SpecialAbilityAragornAthelas
                Enum = SPECIAL_ATHELAS
            End
            """.trimIndent()
        )

        val block = PsiTreeUtil.findChildOfType(myFixture.file, SageEngineIniBlock::class.java)!!

        assertThat(block.declarationKind).isEqualTo("SpecialPower")
        assertThat(block.name).isEqualTo("SpecialAbilityAragornAthelas")
        assertThat(block.nameIdentifier?.text).isEqualTo("SpecialAbilityAragornAthelas")
        assertThat(block.textOffset).isEqualTo(block.nameIdentifier!!.textOffset)
        assertThat(
            SageEngineIniDeclarationTargetElementEvaluator().adjustTargetElement(
                myFixture.editor,
                block.textOffset,
                TargetElementUtil.ELEMENT_NAME_ACCEPTED,
                block
            )
        ).isSameAs(block.nameIdentifier)
    }

    @Test
    fun `should navigate to declaration from property value`() {

        myFixture.addFileToProject(
            "data/specialpower.ini",
            """
            SpecialPower SpecialAbilityAragornAthelas
            End
            """.trimIndent()
        )
        myFixture.configureByText(
            "commandbutton.ini",
            "SpecialPower = SpecialAbility<caret>AragornAthelas"
        )

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)
        val targets = SageEngineIniDeclarationGotoDeclarationHandler().getGotoDeclarationTargets(
            sourceElement,
            myFixture.caretOffset,
            myFixture.editor
        )

        assertThat(targets).extracting<String> { it.text }.containsExactly("SpecialAbilityAragornAthelas")
    }

    @Test
    fun `should navigate to use-sites from declaration`() {

        myFixture.addFileToProject(
            "data/test.ini",
            "SpecialPowerTemplate = SpecialAbilityAragornAthelas"
        )
        myFixture.configureByText(
            "specialpower.ini",
            """
            SpecialPower SpecialAbility<caret>AragornAthelas
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!
        val usages = myFixture.findUsages(sourceElement)

        assertThat(sourceElement.text).isEqualTo("SpecialAbilityAragornAthelas")
        assertThat(usages).extracting<String> { it.element!!.text }.containsExactly("SpecialAbilityAragornAthelas")
        assertThat(usages).extracting<String> { (it.element!!.parent.firstChild as LeafPsiElement).text }.containsExactly("SpecialPowerTemplate")
        assertThat(usages).extracting<String> { it.element!!.containingFile.virtualFile.path }.containsExactly("/src/data/test.ini")
    }

    @Test
    fun `should complete declarations for expected property kind`() {

        myFixture.addFileToProject("data/object.ini", "Object ElvenMallornTree\nEnd")
        myFixture.addFileToProject("data/specialpower.ini", "SpecialPower SpecialAbilityAragornAthelas\nEnd")
        myFixture.configureByText("commandbutton.ini", "SpecialPower = <caret>")

        val lookups = myFixture.completeBasic().map { it.lookupString }

        assertThat(lookups).contains("SpecialAbilityAragornAthelas")
        assertThat(lookups).doesNotContain("ElvenMallornTree")
    }

    @Test
    fun `should list declaration names from project index`() {

        myFixture.addFileToProject("data/object.ini", "Object ElvenMallornTree\nEnd")
        myFixture.addFileToProject("data/specialpower.inc", "SpecialPower SpecialAbilityAragornAthelas\nEnd")

        val names = SageEngineIniDeclarationLookup.allDeclarationNames(project, setOf("SpecialPower"))

        assertThat(names).contains("SpecialAbilityAragornAthelas")
        assertThat(names).doesNotContain("ElvenMallornTree")
    }

    @Test
    fun `should keep declaration and use-site indexes separate`() {

        myFixture.addFileToProject("data/declaration.ini", "SpecialPower DeclarationOnly\nEnd")
        myFixture.addFileToProject("data/usage.ini", "SpecialPower = UseSiteOnly")

        val declarationNames = SageEngineIniDeclarationLookup.allDeclarationNames(project, setOf("SpecialPower"))
        val useSitesForDeclaration = SageEngineIniDeclarationLookup.findUseSites(project, "SpecialPower", "DeclarationOnly")
        val declarationsForUseSite = SageEngineIniDeclarationLookup.findDeclarations(project, "UseSiteOnly", setOf("SpecialPower"))

        assertThat(declarationNames).contains("DeclarationOnly")
        assertThat(declarationNames).doesNotContain("UseSiteOnly")
        assertThat(useSitesForDeclaration).isEmpty()
        assertThat(declarationsForUseSite).isEmpty()
    }

    @Test
    fun `should find declaration use-sites from background thread`() {

        myFixture.addFileToProject("data/usage.ini", "SpecialPower = SpecialAbilityAragornAthelas")

        val useSites = ApplicationManager.getApplication().executeOnPooledThread<List<String>> {
            SageEngineIniDeclarationLookup.findUseSites(project, "SpecialPower", "SpecialAbilityAragornAthelas")
                .map { it.text }
        }.get()

        assertThat(useSites).containsExactly("SpecialAbilityAragornAthelas")
    }

    @Test
    fun `should search declaration references from background thread`() {

        myFixture.addFileToProject(
            "data/test.ini",
            "SpecialPowerTemplate = SpecialAbilityAragornAthelas"
        )
        myFixture.configureByText(
            "specialpower.ini",
            """
            SpecialPower SpecialAbility<caret>AragornAthelas
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!
        val usages = ApplicationManager.getApplication().executeOnPooledThread<List<String>> {
            val references = ReferencesSearch.search(sourceElement).findAll()
            ReadAction.computeBlocking<List<String>, RuntimeException> {
                references.map { it.element.text }
            }
        }.get()

        assertThat(usages).containsExactly("SpecialAbilityAragornAthelas")
    }

    @Test
    fun `should highlight unresolved declaration reference`() {

        myFixture.configureByText("commandbutton.ini", "SpecialPower = MissingSpecialPower")

        val warnings = myFixture.doHighlighting().filter { it.severity == HighlightSeverity.WARNING }

        assertThat(warnings).extracting<String> { it.description }.contains("Cannot resolve SpecialPower 'MissingSpecialPower'")
    }

    @Test
    fun `should highlight declaration reference with wrong kind`() {

        myFixture.addFileToProject("data/object.ini", "Object ElvenMallornTree\nEnd")
        myFixture.configureByText("commandbutton.ini", "SpecialPower = ElvenMallornTree")

        val warnings = myFixture.doHighlighting().filter { it.severity == HighlightSeverity.WARNING }

        assertThat(warnings).extracting<String> { it.description }.contains("Expected SpecialPower, but 'ElvenMallornTree' is Object")
    }
}
