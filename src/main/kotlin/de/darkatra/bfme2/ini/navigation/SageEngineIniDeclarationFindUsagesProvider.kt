package de.darkatra.bfme2.ini.navigation

import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock

class SageEngineIniDeclarationFindUsagesProvider : FindUsagesProvider {

    override fun getWordsScanner(): WordsScanner? = null

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        val declaration = psiElement.declarationBlock() ?: return false
        return (declaration == psiElement || declaration.nameIdentifier == psiElement) &&
            SageEngineIniDeclarationSchema.isDeclarationKind(declaration.declarationKind)
    }

    override fun getHelpId(psiElement: PsiElement): String? = null

    override fun getType(element: PsiElement): String = element.declarationBlock()?.declarationKind ?: "declaration"

    override fun getDescriptiveName(element: PsiElement): String = element.declarationBlock()?.name ?: ""

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String = getDescriptiveName(element)

    private fun PsiElement.declarationBlock(): SageEngineIniBlock? {
        return when (this) {
            is SageEngineIniBlock -> this
            else -> PsiTreeUtil.getParentOfType(this, SageEngineIniBlock::class.java, false)
        }
    }
}
