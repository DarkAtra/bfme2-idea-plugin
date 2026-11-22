package de.darkatra.bfme2.ini.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.util.IncorrectOperationException
import de.darkatra.bfme2.ini.SageEngineIniLanguage

open class SageEngineIniPsiElement(node: ASTNode) : ASTWrapperPsiElement(node)

class SageEngineIniBlock(node: ASTNode) : SageEngineIniPsiElement(node) {

    val declarationKind: String?
        get() = PsiTreeUtil.firstChild(this)
            .takeIf { it.elementType == SageEngineIniTokenTypes.BLOCK_START }
            ?.text

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    val nameIdentifier: PsiElement?
        get() = node.findChildByType(SageEngineIniTokenTypes.VALUE)?.psi

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

class SageEngineIniScriptBlock(node: ASTNode) : SageEngineIniPsiElement(node)

class SageEngineIniScriptContent(node: ASTNode) : SageEngineIniPsiElement(node), PsiLanguageInjectionHost {

    override fun isValidHost(): Boolean {
        return true
    }

    override fun updateText(text: String): PsiLanguageInjectionHost {
        val dummyFile = PsiFileFactory.getInstance(project).createFileFromText("dummy.ini", SageEngineIniLanguage, "BeginScript\n$text\nEndScript")
        val newContent = PsiTreeUtil.findChildOfType(dummyFile, SageEngineIniScriptContent::class.java)
            ?.takeIf { it.text == text.trim() }
            ?: throw IncorrectOperationException("'$text' can not be the content of a script block")
        return replace(newContent) as PsiLanguageInjectionHost
    }

    override fun createLiteralTextEscaper(): LiteralTextEscaper<out PsiLanguageInjectionHost> {
        return LiteralTextEscaper.createSimple(this)
    }
}