package de.darkatra.bfme2.ini.navigation

import com.intellij.codeInsight.TargetElementEvaluatorEx2
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.util.PsiTreeUtil
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock

class SageEngineIniDeclarationTargetElementEvaluator : TargetElementEvaluatorEx2() {

    override fun getNamedElement(element: PsiElement): PsiElement? {
        val declaration = PsiTreeUtil.getParentOfType(element, SageEngineIniBlock::class.java, false) ?: return null
        if (declaration.nameIdentifier != element) {
            return null
        }

        return element.takeIf { SageEngineIniDeclarationSchema.isDeclarationKind(declaration.declarationKind) }
    }

    override fun adjustTargetElement(editor: Editor, offset: Int, flags: Int, targetElement: PsiElement): PsiElement? {
        val declaration = targetElement.declarationBlock() ?: return targetElement

        return when {
            declaration == targetElement || declaration.nameIdentifier == targetElement ->
                declaration.declarationNameIdentifier()
            targetElement.references.isNotEmpty() -> targetElement
            else -> null
        }
    }

    override fun getTargetCandidates(reference: PsiReference): Collection<PsiElement>? {
        return reference.resolve()?.declarationNameIdentifier()?.let { listOf(it) }
    }

    private fun PsiElement.declarationNameIdentifier(): PsiElement? {
        val declaration = declarationBlock() ?: return null

        return declaration.nameIdentifier
            ?.takeIf { SageEngineIniDeclarationSchema.isDeclarationKind(declaration.declarationKind) }
    }

    private fun PsiElement.declarationBlock(): SageEngineIniBlock? {
        return when (this) {
            is SageEngineIniBlock -> this
            else -> PsiTreeUtil.getParentOfType(this, SageEngineIniBlock::class.java, false)
        }
    }
}