package de.darkatra.bfme2.ini.testdata

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiPolyVariantReference
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.assertExpected
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.cases
import de.darkatra.bfme2.ini.testdata.SageEngineIniTestData.runCases
import org.junit.Test

/**
 * Goes to the declarations of the element at the caret of the cases of `navigation`, through references and the goto declaration handlers,
 * and compares the targets with `expected.txt` or `<name>.txt`.
 */
class SageEngineIniNavigationDataTest : SageEngineIniTestDataTestCase() {

    @Test
    fun `should go to the expected declarations`() {

        runCases(cases("navigation")) { case ->
            val targets = withCaseFiles(case) { files ->
                openAtCaret(files)
                val offset = myFixture.caretOffset
                val element = myFixture.file.findElementAt(offset)
                val referenceTargets = myFixture.file.findReferenceAt(offset)?.let { reference ->
                    (reference as? PsiPolyVariantReference)?.multiResolve(false)?.mapNotNull { it.element } ?: listOfNotNull(reference.resolve())
                }.orEmpty()
                val handlerTargets = GotoDeclarationHandler.EP_NAME.extensionList
                    .flatMap { it.getGotoDeclarationTargets(element, offset, myFixture.editor)?.toList().orEmpty() }
                (referenceTargets + handlerTargets).distinct().map { describe(it) }.distinct().sorted().joinToString("") { "$it\n" }
            }
            assertExpected(case.expected(".txt"), targets.ifEmpty { "no declaration\n" })
        }
    }

    private fun describe(target: PsiElement): String {
        val file = target.containingFile ?: return target.toString()
        val document = file.viewProvider.document ?: return file.name
        val line = document.getLineNumber(target.textOffset)
        val path = file.virtualFile.path.substringAfter("/cases/").substringAfter('/').substringAfter('/')
        return "$path:${line + 1}: ${document.getText(TextRange(document.getLineStartOffset(line), document.getLineEndOffset(line))).trim()}"
    }
}
