package de.darkatra.bfme2.ini.navigation

import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationLookup
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock

class SageEngineIniDeclarationReference(
    element: PsiElement,
    private val expectedKinds: Set<String>
) : PsiReferenceBase<PsiElement>(element, TextRange(0, element.textLength)) {

    override fun resolve(): PsiElement? {
        return SageEngineIniDeclarationLookup.findDeclarations(element.project, element.text, expectedKinds)
            .firstOrNull()
            ?.nameIdentifier
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        val declaration = element.declarationBlock() ?: return false
        return declaration.name == myElement.text && declaration.declarationKind in expectedKinds
    }

    override fun getVariants(): Array<Any> {
        return SageEngineIniDeclarationLookup.allDeclarationNames(element.project, expectedKinds)
            .map { LookupElementBuilder.create(it).withTypeText(expectedKinds.joinToString(" | "), true) }
            .toTypedArray()
    }

    private fun PsiElement.declarationBlock(): SageEngineIniBlock? {
        return when (this) {
            is SageEngineIniBlock -> this
            else -> PsiTreeUtil.getParentOfType(this, SageEngineIniBlock::class.java, false)
        }
    }
}