package de.darkatra.bfme2.ini.navigation

import com.intellij.codeInsight.highlighting.HighlightUsagesHandlerBase
import com.intellij.codeInsight.highlighting.HighlightUsagesHandlerFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.Consumer
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock

class SageEngineIniDeclarationHighlightUsagesHandlerFactory : HighlightUsagesHandlerFactory {

    override fun createHighlightUsagesHandler(editor: Editor, file: PsiFile): HighlightUsagesHandlerBase<*>? {
        val element = file.findElementAt(editor.caretModel.offset) ?: return null
        val declaration = PsiTreeUtil.getParentOfType(element, SageEngineIniBlock::class.java, false) ?: return null
        val nameIdentifier = declaration.nameIdentifier ?: return null

        if (nameIdentifier != element || !SageEngineIniDeclarationSchema.isDeclarationKind(declaration.declarationKind)) {
            return null
        }

        return SageEngineIniDeclarationHighlightUsagesHandler(editor, file, nameIdentifier)
    }

    private class SageEngineIniDeclarationHighlightUsagesHandler(
        editor: Editor,
        file: PsiFile,
        private val declarationName: PsiElement
    ) : HighlightUsagesHandlerBase<PsiElement>(editor, file) {

        override fun getTargets(): MutableList<PsiElement> = mutableListOf(declarationName)

        override fun selectTargets(
            targets: List<PsiElement>,
            selectionConsumer: Consumer<in List<PsiElement>>
        ) {
            selectionConsumer.consume(targets)
        }

        override fun computeUsages(targets: MutableList<out PsiElement>) {
            addOccurrence(declarationName)
        }
    }
}