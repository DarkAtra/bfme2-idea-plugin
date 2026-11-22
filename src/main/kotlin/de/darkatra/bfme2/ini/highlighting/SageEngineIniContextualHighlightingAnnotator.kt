package de.darkatra.bfme2.ini.highlighting

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.model.syntax.SageEngineIniSyntax
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes
import de.darkatra.bfme2.ini.validation.valueWords

/**
 * The highlighting lexer does not know the enclosing block of a token, so tokens that the parser remapped based on their parent block
 * (e.g. `Color = DefaultColor` inside a `FXParticleSystem`) or their file (e.g. `StaticGameLOD = High` in `Options.ini`) are highlighted here.
 */
class SageEngineIniContextualHighlightingAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {

        val textAttributes = textAttributes(element) ?: return

        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .textAttributes(textAttributes)
            .create()
    }

    private fun textAttributes(element: PsiElement): TextAttributesKey? {

        val statementParent = element.parent?.parent
        if (statementParent is PsiFile) {
            val assignment = element.parent as? SageEngineIniPropertyAssignment ?: return null
            val isRemappedBlockOpener = element.elementType == SageEngineIniTokenTypes.PROPERTY &&
                SageEngineIniSyntax.isBlocklessFile(statementParent.name) &&
                SageEngineIniSyntax.isBlockOpener(element.text, assignment.valueWords().firstOrNull()?.text)
            return SageEngineIniSyntaxHighlighter.IDENTIFIER.takeIf { isRemappedBlockOpener }
        }

        val parentKind = (statementParent as? SageEngineIniBlock)?.declarationKind ?: return null
        return when (element.elementType) {
            SageEngineIniTokenTypes.BLOCK_START if SageEngineIniSyntax.isContextualBlockOpener(parentKind, element.text) -> {
                SageEngineIniSyntaxHighlighter.BLOCK
            }

            SageEngineIniTokenTypes.PROPERTY if SageEngineIniSyntax.isContextualBareValueKey(parentKind, element.text) -> {
                SageEngineIniSyntaxHighlighter.IDENTIFIER
            }

            else -> null
        }
    }
}
