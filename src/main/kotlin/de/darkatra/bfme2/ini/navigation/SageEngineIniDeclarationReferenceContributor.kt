package de.darkatra.bfme2.ini.navigation

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.util.ProcessingContext
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniDeclarationReferenceContributor : PsiReferenceContributor() {

    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(
            psiElement(SageEngineIniTokenTypes.VALUE),
            object : PsiReferenceProvider() {

                override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
                    val expectedKinds = SageEngineIniModelResolver.expectedDeclarationKinds(element)
                    if (expectedKinds.isEmpty()) {
                        return PsiReference.EMPTY_ARRAY
                    }

                    return arrayOf(SageEngineIniDeclarationReference(element, expectedKinds))
                }
            }
        )
        registrar.registerReferenceProvider(
            psiElement(SageEngineIniTokenTypes.PROPERTY),
            object : PsiReferenceProvider() {

                override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
                    val (prefixLength, expectedKinds) = SageEngineIniModelResolver.prefixedNameReference(element) ?: return PsiReference.EMPTY_ARRAY
                    return arrayOf(SageEngineIniDeclarationReference(element, expectedKinds, TextRange(prefixLength, element.textLength)))
                }
            }
        )
    }
}
