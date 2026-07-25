package de.darkatra.bfme2.ini

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import de.darkatra.bfme2.ini.model.syntax.SageEngineIniSyntax
import de.darkatra.bfme2.ini.psi.SageEngineIniElementTypes
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniParser : PsiParser {

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {

        val file = builder.mark()
        while (!builder.eof()) {
            parseStatement(builder, null)
        }
        file.done(root)

        return builder.treeBuilt
    }

    private fun parseStatement(builder: PsiBuilder, parentKind: String?) {
        remapContextualToken(builder, parentKind)
        when (builder.tokenType) {
            SageEngineIniTokenTypes.BLOCK_START -> parseBlock(builder)
            SageEngineIniTokenTypes.PROPERTY -> parseUntilStatementBoundary(builder, SageEngineIniElementTypes.PROPERTY_ASSIGNMENT)
            SageEngineIniTokenTypes.MACRO -> parseUntilStatementBoundary(builder, SageEngineIniElementTypes.MACRO_STATEMENT)
            SageEngineIniTokenTypes.COMMENT_START -> parseUntilStatementBoundary(builder, SageEngineIniElementTypes.COMMENT)
            SageEngineIniTokenTypes.BLOCK_END -> {
                builder.error("'${builder.tokenText}' without an open block")
                builder.advanceLexer()
            }

            else -> builder.advanceLexer()
        }
    }

    // the lexer has no knowledge about the enclosing block, so rules that depend on it are applied here
    private fun remapContextualToken(builder: PsiBuilder, parentKind: String?) {
        val tokenText = builder.tokenText ?: return
        when (builder.tokenType) {
            SageEngineIniTokenTypes.PROPERTY if SageEngineIniSyntax.isContextualBlockOpener(parentKind, tokenText) -> {
                builder.remapCurrentToken(SageEngineIniTokenTypes.BLOCK_START)
            }

            SageEngineIniTokenTypes.BLOCK_START if SageEngineIniSyntax.isContextualBareValueKey(parentKind, tokenText) -> {
                builder.remapCurrentToken(SageEngineIniTokenTypes.PROPERTY)
            }
        }
    }

    private fun parseBlock(builder: PsiBuilder) {
        if (builder.tokenText.equals("BeginScript", ignoreCase = true)) {
            parseScriptBlock(builder)
            return
        }

        val blockKind = builder.tokenText
        val marker = builder.mark()
        parseUntilStatementBoundary(builder)
        while (!builder.eof() && builder.tokenType != SageEngineIniTokenTypes.BLOCK_END) {
            parseStatement(builder, blockKind)
        }
        if (builder.tokenType == SageEngineIniTokenTypes.BLOCK_END) {
            builder.advanceLexer()
        } else {
            builder.error("Missing 'End' for block '$blockKind'")
        }
        marker.done(SageEngineIniElementTypes.BLOCK)
    }

    private fun parseScriptBlock(builder: PsiBuilder) {
        val marker = builder.mark()
        var nesting = 0
        while (!builder.eof()) {
            val tokenType = builder.tokenType
            val tokenText = builder.tokenText
            builder.advanceLexer()

            if (tokenType == SageEngineIniTokenTypes.BLOCK_START && tokenText.equals("BeginScript", ignoreCase = true)) {
                nesting++
            }
            if (tokenType == SageEngineIniTokenTypes.BLOCK_END && tokenText.equals("EndScript", ignoreCase = true)) {
                nesting--
                if (nesting <= 0) {
                    break
                }
            }
        }
        if (nesting > 0) {
            builder.error("Missing 'EndScript'")
        }
        marker.done(SageEngineIniElementTypes.SCRIPT_BLOCK)
    }

    private fun parseUntilStatementBoundary(builder: PsiBuilder, elementType: IElementType) {
        val marker = builder.mark()
        parseUntilStatementBoundary(builder)
        marker.done(elementType)
    }

    private fun parseUntilStatementBoundary(builder: PsiBuilder) {
        do {
            builder.advanceLexer()
        } while (!builder.eof() && !isStatementBoundary(builder))
    }

    private fun isStatementBoundary(builder: PsiBuilder): Boolean {
        val tokenType = builder.tokenType
        return tokenType == SageEngineIniTokenTypes.BLOCK_START ||
            tokenType == SageEngineIniTokenTypes.BLOCK_END ||
            tokenType == SageEngineIniTokenTypes.PROPERTY ||
            tokenType == SageEngineIniTokenTypes.MACRO ||
            tokenType == SageEngineIniTokenTypes.COMMENT_START ||
            tokenType == TokenType.WHITE_SPACE && builder.tokenText?.any { it == '\n' || it == '\r' } == true
    }
}
