package de.darkatra.bfme2.ini

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import de.darkatra.bfme2.ini.model.syntax.SageEngineIniSyntax
import de.darkatra.bfme2.ini.psi.SageEngineIniElementTypes
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenSets
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
            SageEngineIniTokenTypes.BLOCK_END -> {
                builder.error("'${builder.tokenText}' without an open block")
                builder.advanceLexer()
            }

            else -> {
                val marker = builder.mark()
                val tokenText = builder.tokenText
                parseUntilStatementBoundary(builder)
                marker.error("Unexpected '$tokenText'")
            }
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
        builder.advanceLexer()
        while (!builder.eof()) {
            if (builder.tokenType == SageEngineIniTokenTypes.BLOCK_END && builder.tokenText.equals("EndScript", ignoreCase = true)) {
                builder.advanceLexer()
                marker.done(SageEngineIniElementTypes.SCRIPT_BLOCK)
                return
            }
            if (builder.tokenType == SageEngineIniTokenTypes.SCRIPT_BODY && builder.tokenText.equals("BeginScript", ignoreCase = true)) {
                builder.error("Missing 'EndScript' before 'BeginScript'")
            }
            builder.advanceLexer()
        }
        builder.error("Missing 'EndScript'")
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
            startsLine(builder)
    }

    // the builder skips whitespace and comments, so line breaks are only visible in the raw tokens before the current one
    private fun startsLine(builder: PsiBuilder): Boolean {
        var step = -1
        while (true) {
            val tokenType = builder.rawLookup(step) ?: return true
            if (tokenType == TokenType.WHITE_SPACE) {
                val whitespace = builder.originalText.subSequence(builder.rawTokenTypeStart(step), builder.rawTokenTypeStart(step + 1))
                if (whitespace.any { it == '\n' || it == '\r' }) {
                    return true
                }
            } else if (!SageEngineIniTokenSets.COMMENTS.contains(tokenType)) {
                return false
            }
            step--
        }
    }
}
