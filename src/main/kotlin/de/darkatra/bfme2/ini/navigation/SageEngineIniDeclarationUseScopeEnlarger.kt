package de.darkatra.bfme2.ini.navigation

import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.SearchScope
import com.intellij.psi.search.UseScopeEnlarger
import com.intellij.psi.util.PsiTreeUtil
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock

class SageEngineIniDeclarationUseScopeEnlarger : UseScopeEnlarger() {

    override fun getAdditionalUseScope(element: PsiElement): SearchScope? {
        val declaration = element.declarationBlock() ?: return null

        if (declaration != element && declaration.nameIdentifier != element) {
            return null
        }

        if (!SageEngineIniDeclarationSchema.isDeclarationKind(declaration.declarationKind)) {
            return null
        }

        return GlobalSearchScope.projectScope(element.project)
    }

    private fun PsiElement.declarationBlock(): SageEngineIniBlock? {
        return when (this) {
            is SageEngineIniBlock -> this
            else -> PsiTreeUtil.getParentOfType(this, SageEngineIniBlock::class.java, false)
        }
    }
}