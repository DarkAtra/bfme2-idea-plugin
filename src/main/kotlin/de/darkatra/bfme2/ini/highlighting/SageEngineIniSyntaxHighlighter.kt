package de.darkatra.bfme2.ini.highlighting

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import de.darkatra.bfme2.ini.SageEngineIniLexer
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenSets
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniSyntaxHighlighter : SyntaxHighlighterBase() {

    override fun getHighlightingLexer(): Lexer {
        return SageEngineIniLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when {
            SageEngineIniTokenSets.BLOCKS.contains(tokenType) -> BLOCK_KEYS
            SageEngineIniTokenSets.IDENTIFIERS.contains(tokenType) -> IDENTIFIER_KEYS
            SageEngineIniTokenSets.VALUES.contains(tokenType) -> VALUE_KEYS
            SageEngineIniTokenSets.NUMBERS.contains(tokenType) -> NUMBER_KEYS
            SageEngineIniTokenSets.STRINGS.contains(tokenType) -> STRING_KEYS
            SageEngineIniTokenSets.COMMENTS.contains(tokenType) -> COMMENT_KEYS
            tokenType === SageEngineIniTokenTypes.MACRO -> MACRO_KEYS
            SageEngineIniTokenSets.OPERATORS.contains(tokenType) -> OPERATOR_KEYS
            tokenType === TokenType.BAD_CHARACTER -> BAD_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {

        private val BLOCK: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "OPENSAGE_INI_BLOCK",
            DefaultLanguageHighlighterColors.KEYWORD
        )
        private val IDENTIFIER: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "OPENSAGE_INI_IDENTIFIER",
            DefaultLanguageHighlighterColors.INSTANCE_FIELD
        )
        private val VALUE: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "OPENSAGE_INI_VALUE",
            HighlighterColors.NO_HIGHLIGHTING
        )
        private val NUMBER: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "OPENSAGE_INI_NUMBER",
            DefaultLanguageHighlighterColors.NUMBER
        )
        private val STRING: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "OPENSAGE_INI_STRING",
            DefaultLanguageHighlighterColors.STRING
        )
        private val COMMENT: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "OPENSAGE_INI_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        private val MACRO: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "OPENSAGE_INI_MACRO",
            DefaultLanguageHighlighterColors.METADATA
        )
        private val OPERATOR: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "OPENSAGE_INI_OPERATOR",
            DefaultLanguageHighlighterColors.OPERATION_SIGN
        )
        private val BAD_CHARACTER: TextAttributesKey = TextAttributesKey.createTextAttributesKey(
            "OPENSAGE_INI_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER
        )

        private val BLOCK_KEYS: Array<TextAttributesKey> = arrayOf(BLOCK)
        private val IDENTIFIER_KEYS: Array<TextAttributesKey> = arrayOf(IDENTIFIER)
        private val VALUE_KEYS: Array<TextAttributesKey> = arrayOf(VALUE)
        private val NUMBER_KEYS: Array<TextAttributesKey> = arrayOf(NUMBER)
        private val STRING_KEYS: Array<TextAttributesKey> = arrayOf(STRING)
        private val COMMENT_KEYS: Array<TextAttributesKey> = arrayOf(COMMENT)
        private val MACRO_KEYS: Array<TextAttributesKey> = arrayOf(MACRO)
        private val OPERATOR_KEYS: Array<TextAttributesKey> = arrayOf(OPERATOR)
        private val BAD_KEYS: Array<TextAttributesKey> = arrayOf(BAD_CHARACTER)
        private val EMPTY_KEYS: Array<TextAttributesKey> = arrayOf()
    }
}
