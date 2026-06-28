package de.darkatra.bfme2.ini

import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiComment
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import de.darkatra.bfme2.ini.folding.SageEngineIniFoldingBuilder
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniScriptBlock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniParserTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should create PSI elements for top level statements`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            ; Mallorn tree
            #include "includes\StandardBuildingEvaEvents.inc"
            Object ElvenMallornTree
                DisplayName = OBJECT:ElvenMallornTree
            End
            """.trimIndent()
        )

        assertThat(myFixture.file.descendantsOfType(PsiComment::class.java)).extracting<String> { it.text }
            .contains(";", "Mallorn", "tree")
        assertThat(myFixture.file.descendantsOfType(SageEngineIniMacroStatement::class.java)).hasSize(1)
        assertThat(myFixture.file.descendantsOfType(SageEngineIniBlock::class.java)).extracting<String> { it.text.trim() }
            .contains("Object ElvenMallornTree\n    DisplayName = OBJECT:ElvenMallornTree\nEnd")
        assertThat(myFixture.file.descendantsOfType(SageEngineIniPropertyAssignment::class.java)).extracting<String> { it.text.trim() }
            .contains("DisplayName = OBJECT:ElvenMallornTree")
    }

    @Test
    fun `should create a script block PSI element`() {

        myFixture.configureByText(
            "script.ini",
            """
            BeginScript
                if Flag
                then
                    BeginScript
                        nested
                    EndScript
                end
            EndScript
            After = EndScript
            """.trimIndent()
        )

        val scriptBlocks = myFixture.file.descendantsOfType(SageEngineIniScriptBlock::class.java)

        assertThat(scriptBlocks).hasSize(1)
        assertThat(scriptBlocks.single().text.trim()).startsWith("BeginScript")
        assertThat(scriptBlocks.single().text.trim()).endsWith("EndScript")
        assertThat(myFixture.file.descendantsOfType(SageEngineIniPropertyAssignment::class.java)).extracting<String> { it.text.trim() }
            .contains("After = EndScript")
    }

    @Test
    fun `should create folding regions for blocks`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            Object ElvenMallornTree
                DisplayName = OBJECT:ElvenMallornTree
            End
            """.trimIndent()
        )

        val document = PsiDocumentManager.getInstance(project).getDocument(myFixture.file)!!
        val descriptors = SageEngineIniFoldingBuilder().buildFoldRegions(myFixture.file, document, false)

        assertThat(descriptors).extracting<String> { it.element.text.trim() }
            .contains("Object ElvenMallornTree\n    DisplayName = OBJECT:ElvenMallornTree\nEnd")
    }

    @Test
    fun `should create folding regions for script blocks`() {

        myFixture.configureByText(
            "script.ini",
            """
            BeginScript
                CurDrawableAllowToContinue()
            EndScript
            """.trimIndent()
        )

        val document = PsiDocumentManager.getInstance(project).getDocument(myFixture.file)!!
        val descriptors = SageEngineIniFoldingBuilder().buildFoldRegions(myFixture.file, document, false)

        assertThat(descriptors).extracting<String> { it.element.text.trim() }
            .contains("BeginScript\n    CurDrawableAllowToContinue()\nEndScript")
    }

    private fun <T : PsiElement> PsiElement.descendantsOfType(type: Class<T>): Collection<T> {
        return PsiTreeUtil.findChildrenOfType(this, type)
    }
}
