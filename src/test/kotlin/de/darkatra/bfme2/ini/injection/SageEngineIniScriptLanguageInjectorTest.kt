package de.darkatra.bfme2.ini.injection

import com.intellij.lang.Language
import com.intellij.lang.injection.InjectedLanguageManager
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.fileTypes.PlainTextLanguage
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import com.intellij.util.IncorrectOperationException
import de.darkatra.bfme2.ini.psi.SageEngineIniScriptContent
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class SageEngineIniScriptLanguageInjectorTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should inject the script language into the content of script blocks`() {

        InjectedLanguageManager.getInstance(project).registerMultiHostInjector(
            SageEngineIniScriptLanguageInjector { PlainTextLanguage.INSTANCE },
            testRootDisposable
        )
        myFixture.configureByText("script.ini", SCRIPT)

        val injectedFiles = InjectedLanguageManager.getInstance(project).getInjectedPsiFiles(scriptContent()).orEmpty()

        assertThat(injectedFiles).extracting<Language> { it.first.language }.containsExactly(PlainTextLanguage.INSTANCE)
        assertThat(injectedFiles).extracting<String> { it.first.text }.containsExactly(SCRIPT_CONTENT)
    }

    @Test
    fun `should not inject anything without a Lua plugin`() {

        myFixture.configureByText("script.ini", SCRIPT)

        assertThat(InjectedLanguageManager.getInstance(project).getInjectedPsiFiles(scriptContent())).isNullOrEmpty()
    }

    @Test
    fun `should replace the content of a script block`() {

        myFixture.configureByText("script.ini", SCRIPT)

        WriteCommandAction.runWriteCommandAction(project) {
            scriptContent().updateText("CurDrawableAllowToContinue()")
        }

        assertThat(myFixture.file.text).isEqualTo(SCRIPT.replace(SCRIPT_CONTENT, "CurDrawableAllowToContinue()"))
    }

    @Test
    fun `should remove the content of a script block when it is cleared`() {

        myFixture.configureByText("script.ini", SCRIPT)

        WriteCommandAction.runWriteCommandAction(project) {
            scriptContent().updateText("")
        }

        assertThat(myFixture.file.text).isEqualTo(SCRIPT.replace("\n                $SCRIPT_CONTENT", ""))
        assertThat(PsiTreeUtil.findChildOfType(myFixture.file, SageEngineIniScriptContent::class.java)).isNull()
    }

    @Test
    fun `should not replace the content of a script block with text that ends the script block`() {

        myFixture.configureByText("script.ini", SCRIPT)

        assertThatThrownBy {
            WriteCommandAction.runWriteCommandAction(project) {
                scriptContent().updateText("CurDrawableAllowToContinue()\nEndScript\nAfter = 1")
            }
        }.isInstanceOf(IncorrectOperationException::class.java)
        assertThat(myFixture.file.text).isEqualTo(SCRIPT)
    }

    private fun scriptContent(): SageEngineIniScriptContent {
        return PsiTreeUtil.findChildOfType(myFixture.file, SageEngineIniScriptContent::class.java)!!
    }

    private companion object {

        val SCRIPT = """
            Object TestScriptBlock
                Draw = W3DHordeModelDraw ModuleTag_01
                    AnimationState = EMOTION_TAUNTING
                        BeginScript
                            if Flag
                            then
                                CurDrawableAllowToContinue()
                            end
                        EndScript
                    End
                End
            End
        """.trimIndent()

        val SCRIPT_CONTENT = "if Flag\n                then\n                    CurDrawableAllowToContinue()\n                end"
    }
}
