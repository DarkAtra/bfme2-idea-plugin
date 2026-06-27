package de.darkatra.bfme2.ini.navigation

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

class SageEngineIniIncludeReference(
    element: PsiElement
) : PsiReferenceBase<PsiElement>(
    element,
    includePathRange(element)
) {

    override fun resolve(): PsiElement? {
        return element.resolveIncludeFile()
    }

    companion object {

        private fun includePathRange(element: PsiElement): TextRange {
            val text = element.text
            return if (text.length >= 2 && text.first() == '"' && text.last() == '"') {
                TextRange(1, text.length - 1)
            } else {
                TextRange(0, text.length)
            }
        }
    }
}
