package de.darkatra.bfme2.ini.navigation

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase

class SageEngineIniIncludeReference(element: PsiElement) : PsiReferenceBase<PsiElement>(element) {

    override fun resolve(): PsiElement? {
        return element.resolveIncludeFile()
    }
}
