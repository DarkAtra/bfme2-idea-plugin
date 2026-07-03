package de.darkatra.bfme2.ini.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType

open class SageEngineIniPsiElement(node: ASTNode) : ASTWrapperPsiElement(node)

class SageEngineIniBlock(node: ASTNode) : SageEngineIniPsiElement(node), PsiNameIdentifierOwner {

    val declarationKind: String?
        get() = PsiTreeUtil.firstChild(this)
            .takeIf { it.elementType == SageEngineIniTokenTypes.BLOCK_START }
            ?.text

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun setName(name: String): PsiElement {
        return this
    }

    override fun getNameIdentifier(): PsiElement? {
        return PsiTreeUtil.findChildrenOfType(this, PsiElement::class.java)
            .firstOrNull { it.elementType == SageEngineIniTokenTypes.VALUE }
    }

    override fun getTextOffset(): Int {
        return nameIdentifier?.textOffset ?: super.getTextOffset()
    }
}

class SageEngineIniPropertyAssignment(node: ASTNode) : SageEngineIniPsiElement(node) {

    val propertyName: String?
        get() = PsiTreeUtil.firstChild(this)
            .takeIf { it.elementType == SageEngineIniTokenTypes.PROPERTY }
            ?.text
}

class SageEngineIniMacroStatement(node: ASTNode) : SageEngineIniPsiElement(node)

class SageEngineIniComment(node: ASTNode) : SageEngineIniPsiElement(node)

class SageEngineIniScriptBlock(node: ASTNode) : SageEngineIniPsiElement(node)