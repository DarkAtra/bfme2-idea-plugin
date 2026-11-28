package de.darkatra.bfme2.ini.testdata

import com.intellij.codeInspection.LocalInspectionEP
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import de.darkatra.bfme2.ini.SageEngineIniLanguage
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.assertExpected
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.cases
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.runCases
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Runs each inspection over the cases of `inspections/<short name>` and compares the problems of all their files with `expected.txt` or
 * `<name>.txt`. Parser errors are part of the output as well.
 */
class SageEngineIniInspectionDataTest : SageEngineIniTestDataTestCase() {

    private val inspections: Map<String, LocalInspectionEP> by lazy {
        LocalInspectionEP.LOCAL_INSPECTION.extensionList.filter { it.language == SageEngineIniLanguage.id }.associateBy { it.getShortName() }
    }

    @Test
    fun `should have cases for every inspection`() {

        assertThat(inspections.keys.filter { cases("inspections/$it").isEmpty() }).isEmpty()
    }

    @Test
    fun `should report the expected problems`() {

        runCases(inspections.keys.sorted().flatMap { cases("inspections/$it") }) { case ->
            val inspection = inspections.getValue(case.name.split('/')[1]).instantiateTool() as LocalInspectionTool
            myFixture.enableInspections(inspection)
            try {
                val problems = withCaseFiles(case) { files ->
                    files.entries.joinToString("") { (input, virtualFile) ->
                        myFixture.openFileInEditor(virtualFile)
                        problems(case.relativePath(input))
                    }
                }
                assertExpected(case.expected(".txt"), problems)
            } finally {
                myFixture.disableInspections(inspection)
            }
        }
    }

    private fun problems(path: String): String {
        val document = myFixture.editor.document
        return myFixture.doHighlighting(HighlightSeverity.WEAK_WARNING).sortedBy { it.startOffset }.joinToString("") { info ->
            val line = document.getLineNumber(info.startOffset)
            val column = info.startOffset - document.getLineStartOffset(line)
            val text = document.getText(TextRange(info.startOffset, info.endOffset))
            "$path:${line + 1}:${column + 1}: ${info.severity.name} '$text' ${info.description}\n"
        }
    }
}
