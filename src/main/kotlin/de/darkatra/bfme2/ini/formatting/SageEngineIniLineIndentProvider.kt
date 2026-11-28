package de.darkatra.bfme2.ini.formatting

import com.intellij.application.options.CodeStyle
import com.intellij.lang.Language
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.ex.EditorEx
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.project.Project
import com.intellij.psi.TokenType
import com.intellij.psi.codeStyle.lineIndent.LineIndentProvider
import de.darkatra.bfme2.ini.SageEngineIniFileType
import de.darkatra.bfme2.ini.SageEngineIniLanguage
import de.darkatra.bfme2.ini.model.syntax.SageEngineIniSyntax
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenSets
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * Indents new lines like the line before them, one level deeper if that line opens a block. The formatter would build the blocks of the
 * whole file for every new line, which blocks the IDE for seconds in files like `weapon.ini`. Reads the tokens of the editor, because the
 * document isn't committed when a line is added.
 */
class SageEngineIniLineIndentProvider : LineIndentProvider {

    override fun isSuitableFor(language: Language?): Boolean {
        return language == SageEngineIniLanguage
    }

    override fun getLineIndent(project: Project, editor: Editor, language: Language?, offset: Int): String? {
        val document = editor.document
        val text = document.charsSequence
        var line = document.getLineNumber(offset) - 1
        while (line >= 0 && text.subSequence(document.getLineStartOffset(line), document.getLineEndOffset(line)).isBlank()) {
            line--
        }
        if (line < 0) {
            return ""
        }

        val lineStart = document.getLineStartOffset(line)
        val lineEnd = document.getLineEndOffset(line)
        var contentStart = lineStart
        while (contentStart < lineEnd && text[contentStart].isWhitespace()) {
            contentStart++
        }
        val indent = text.subSequence(lineStart, contentStart).toString()
        if (!opensBlock(editor, contentStart, lineEnd, isIndented = contentStart > lineStart)) {
            return indent
        }
        return indent + " ".repeat(CodeStyle.getSettings(project).getIndentOptions(SageEngineIniFileType).INDENT_SIZE)
    }

    private fun opensBlock(editor: Editor, contentStart: Int, lineEnd: Int, isIndented: Boolean): Boolean {
        val tokens = (editor as? EditorEx)?.highlighter?.createIterator(contentStart) ?: return false
        if (tokens.atEnd() || tokens.start >= lineEnd) {
            return false
        }
        val key = editor.document.charsSequence.subSequence(tokens.start, tokens.end).toString()
        return when (tokens.tokenType) {
            // keys like `CommandSet X` inside an `Object` are values there, the parser decides by the enclosing block
            SageEngineIniTokenTypes.BLOCK_START -> !(isIndented && SageEngineIniSyntax.contextualBareValueKeys.values.any { key in it })
            // keys like `Alpha` open a block inside an `FXParticleSystem`
            SageEngineIniTokenTypes.PROPERTY -> SageEngineIniSyntax.contextualBlockOpeners.values.any { key in it } && !hasValue(tokens, lineEnd)
            else -> false
        }
    }

    private fun hasValue(tokens: HighlighterIterator, lineEnd: Int): Boolean {
        tokens.advance()
        while (!tokens.atEnd() && tokens.start < lineEnd) {
            if (tokens.tokenType != TokenType.WHITE_SPACE && tokens.tokenType !in SageEngineIniTokenSets.COMMENTS) {
                return true
            }
            tokens.advance()
        }
        return false
    }
}
