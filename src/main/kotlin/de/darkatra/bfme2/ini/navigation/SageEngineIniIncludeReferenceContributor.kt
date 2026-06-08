package de.darkatra.bfme2.ini.navigation

import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.util.ProcessingContext
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniIncludeReferenceContributor : PsiReferenceContributor() {

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            psiElement(SageEngineIniTokenTypes.STRING),
            object : PsiReferenceProvider() {

                override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
                    if (!element.isPartOfIncludeMacro()) {
                        return PsiReference.EMPTY_ARRAY
                    }

                    return arrayOf(SageEngineIniIncludeReference(element))
                }
            }
        )
    }
}
