package de.darkatra.bfme2.ini.testdata

import com.intellij.psi.impl.DebugUtil
import de.darkatra.bfme2.ini.SageEngineIniLexer
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.assertExpected
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.cases
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.runCases
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.text
import org.junit.Test

/**
 * Lexes and parses the files of `syntax` and compares the tokens with `<name>.tokens.txt` and the PSI tree with `<name>.psi.txt`.
 */
class SageEngineIniSyntaxDataTest : SageEngineIniTestDataTestCase() {

    @Test
    fun `should lex the files into the expected tokens`() {

        runCases(cases("syntax")) { case ->
            val text = text(case.inputs.single())
            val lexer = SageEngineIniLexer()
            lexer.start(text, 0, text.length, 0)
            val tokens = buildString {
                while (lexer.tokenType != null) {
                    appendLine("${lexer.tokenType} '${escape(text.substring(lexer.tokenStart, lexer.tokenEnd))}'")
                    lexer.advance()
                }
            }
            assertExpected(case.expected(".tokens.txt"), tokens)
        }
    }

    @Test
    fun `should parse the files into the expected PSI trees`() {

        runCases(cases("syntax")) { case ->
            val input = case.inputs.single()
            val file = myFixture.configureByText(input.name, text(input))
            assertExpected(case.expected(".psi.txt"), DebugUtil.psiToString(file, false, false))
        }
    }

    private fun escape(text: String): String {
        return text.replace("\n", "\\n").replace("\t", "\\t")
    }
}
