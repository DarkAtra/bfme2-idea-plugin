package de.darkatra.bfme2.ini.testdata

import com.intellij.codeInspection.LocalInspectionEP
import com.intellij.codeInspection.LocalInspectionTool
import de.darkatra.bfme2.ini.SageEngineIniLanguage
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.assertExpected
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.features
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.runCases
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.text
import org.junit.Test

/**
 * Applies the quick fix named by the first line of the file with the caret, e.g. `; fix: Change to 'BuildCost'`, for the problem of the
 * inspection `quickfixes/<short name>` at the caret and compares the file with `<name>.after.ini`.
 */
class SageEngineIniQuickFixDataTest : SageEngineIniTestDataTestCase() {

    private val inspections: Map<String, LocalInspectionEP> by lazy {
        LocalInspectionEP.LOCAL_INSPECTION.extensionList.filter { it.language == SageEngineIniLanguage.id }.associateBy { it.getShortName() }
    }

    @Test
    fun `should apply the quick fixes`() {

        runCases(features("quickfixes").flatMap { SageEngineIniTestData.cases(it) }) { case ->
            val inspection = inspections.getValue(case.name.split('/')[1]).instantiateTool() as LocalInspectionTool
            myFixture.enableInspections(inspection)
            try {
                withCaseFiles(case) { files ->
                    val input = openAtCaret(files)
                    val fixName = FIX.find(text(input).lineSequence().first())?.groupValues?.get(1)
                        ?: throw AssertionError("the first line of ${input.name} needs to name the fix, e.g. '; fix: Change to 'BuildCost''")
                    myFixture.launchAction(myFixture.findSingleIntention(fixName))
                    assertExpected(case.expectedAfter(input), myFixture.editor.document.text)
                }
            } finally {
                myFixture.disableInspections(inspection)
            }
        }
    }

    private companion object {
        val FIX = Regex("^; fix: (.+)$")
    }
}
