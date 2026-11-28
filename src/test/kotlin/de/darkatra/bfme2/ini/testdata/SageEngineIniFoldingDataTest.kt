package de.darkatra.bfme2.ini.testdata

import com.intellij.lang.folding.LanguageFolding
import de.darkatra.bfme2.ini.folding.SageEngineIniFoldingBuilder
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.assertExpected
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.cases
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.runCases
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.text
import org.junit.Test

/**
 * Builds the fold regions of the files of `folding` and compares them with `<name>.txt`.
 */
class SageEngineIniFoldingDataTest : SageEngineIniTestDataTestCase() {

    @Test
    fun `should fold the expected regions`() {

        runCases(cases("folding")) { case ->
            val input = case.inputs.single()
            val file = myFixture.configureByText(input.name, text(input))
            val document = myFixture.editor.document
            val builder = SageEngineIniFoldingBuilder()
            val regions = LanguageFolding.buildFoldingDescriptors(builder, file, document, false)
                .sortedBy { it.range.startOffset }
                .joinToString("") { descriptor ->
                    val start = document.getLineNumber(descriptor.range.startOffset) + 1
                    val end = document.getLineNumber(descriptor.range.endOffset) + 1
                    val firstLine = document.getText(descriptor.range).lineSequence().first()
                    "$start-$end '${builder.getPlaceholderText(descriptor.element)}' $firstLine\n"
                }
            assertExpected(case.expected(".txt"), regions)
        }
    }
}
