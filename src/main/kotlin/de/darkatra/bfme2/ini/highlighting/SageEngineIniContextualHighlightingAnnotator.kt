package de.darkatra.bfme2.ini.highlighting

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.model.syntax.SageEngineIniSyntax
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * The highlighting lexer does not know the enclosing block of a token, so tokens that the parser remapped based on their parent block
 * (e.g. `Color = DefaultColor` inside a `FXParticleSystem`) are highlighted here.
 */
class SageEngineIniContextualHighlightingAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {

        val parentKind = (element.parent?.parent as? SageEngineIniBlock)?.declarationKind ?: return
        val textAttributes = when (element.elementType) {
            SageEngineIniTokenTypes.BLOCK_START if SageEngineIniSyntax.isContextualBlockOpener(parentKind, element.text) -> {
                SageEngineIniSyntaxHighlighter.BLOCK
            }

            SageEngineIniTokenTypes.PROPERTY if SageEngineIniSyntax.isContextualBareValueKey(parentKind, element.text) -> {
                SageEngineIniSyntaxHighlighter.IDENTIFIER
            }

            else -> return
        }

        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .textAttributes(textAttributes)
            .create()
    }
}
