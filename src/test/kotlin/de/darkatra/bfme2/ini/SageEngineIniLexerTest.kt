package de.darkatra.bfme2.ini

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniLexerTest {

    @Test
    fun `should lex simple property`() {

        assertTokens(
            "SelectPortrait = KUMilPortrait",
            SageEngineIniTokenTypes.PROPERTY to "SelectPortrait",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "KUMilPortrait",
        )
    }

    @Test
    fun `should lex property value with operators and conditions as raw value`() {

        assertTokens(
            "Query\t\t= 1 NONE\t +HERO ALLIES",
            SageEngineIniTokenTypes.PROPERTY to "Query",
            TokenType.WHITE_SPACE to "\t\t",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.NUMBER to "1",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "NONE",
            TokenType.WHITE_SPACE to "\t ",
            SageEngineIniTokenTypes.OPERATOR to "+",
            SageEngineIniTokenTypes.VALUE to "HERO",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "ALLIES",
        )
    }

    @Test
    fun `should lex property value with colons as raw value`() {

        assertTokens(
            "GeometryOffset = X:50 Y:0 Z:0",
            SageEngineIniTokenTypes.PROPERTY to "GeometryOffset",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "X",
            SageEngineIniTokenTypes.COLON to ":",
            SageEngineIniTokenTypes.NUMBER to "50",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "Y",
            SageEngineIniTokenTypes.COLON to ":",
            SageEngineIniTokenTypes.NUMBER to "0",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "Z",
            SageEngineIniTokenTypes.COLON to ":",
            SageEngineIniTokenTypes.NUMBER to "0",
        )
    }

    @Test
    fun `should lex known keywords as properties when followed by equals`() {

        assertTokens(
            "BuildCost = ANGMAR_MILL_BUILDCOST",
            SageEngineIniTokenTypes.PROPERTY to "BuildCost",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "ANGMAR_MILL_BUILDCOST",
        )
    }

    @Test
    fun `should stop property value at inline comment`() {

        assertTokens(
            "StaticModelLODMode = yes ; Will append M or L",
            SageEngineIniTokenTypes.PROPERTY to "StaticModelLODMode",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "yes",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_START to ";",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "Will",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "append",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "M",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "or",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "L",
        )
    }

    @Test
    fun `should strip trailing whitespace from property value before line end`() {

        assertTokens(
            "DisplayName = CONTROLBAR:ConstructMenPorter  ",
            SageEngineIniTokenTypes.PROPERTY to "DisplayName",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "CONTROLBAR:ConstructMenPorter",
            TokenType.WHITE_SPACE to "  ",
        )
    }

    private fun assertTokens(text: String, vararg expectedTokens: Pair<IElementType, String>) {

        val lexer = SageEngineIniLexer()
        lexer.start(text, 0, text.length, 0)

        val actualTokens = mutableListOf<Pair<IElementType, String>>()
        while (lexer.tokenType != null) {
            actualTokens += lexer.tokenType!! to text.substring(lexer.tokenStart, lexer.tokenEnd)
            lexer.advance()
        }

        assertThat(actualTokens).isEqualTo(expectedTokens.toList())
    }
}
