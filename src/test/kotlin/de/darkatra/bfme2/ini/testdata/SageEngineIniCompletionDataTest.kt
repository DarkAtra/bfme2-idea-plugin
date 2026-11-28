package de.darkatra.bfme2.ini.testdata

import com.intellij.openapi.util.TextRange
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.assertExpected
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.cases
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.runCases
import org.junit.Test

/**
 * Completes at the caret of the cases of `completion` and compares the suggestions with `expected.txt` or `<name>.txt`. A single
 * suggestion is inserted right away, then the completed line is the output.
 */
class SageEngineIniCompletionDataTest : SageEngineIniTestDataTestCase() {

    @Test
    fun `should suggest the expected completions`() {

        runCases(cases("completion")) { case ->
            val completions = withCaseFiles(case) { files ->
                openAtCaret(files)
                val suggestions = myFixture.completeBasic()?.map { it.lookupString }
                if (suggestions == null) {
                    val document = myFixture.editor.document
                    val line = document.getLineNumber(myFixture.caretOffset)
                    "inserted: ${document.getText(TextRange(document.getLineStartOffset(line), document.getLineEndOffset(line)))}\n"
                } else {
                    suggestions.distinct().sortedWith(String.CASE_INSENSITIVE_ORDER).joinToString("") { "$it\n" }
                }
            }
            assertExpected(case.expected(".txt"), completions)
        }
    }
}
