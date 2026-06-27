package de.darkatra.bfme2.ini.navigation

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
}
