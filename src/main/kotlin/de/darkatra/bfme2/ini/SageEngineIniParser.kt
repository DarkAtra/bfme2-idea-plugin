package de.darkatra.bfme2.ini

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import de.darkatra.bfme2.ini.psi.SageEngineIniElementTypes
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniParser : PsiParser {

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {

        val file = builder.mark()
        while (!builder.eof()) {
            parseStatement(builder)
        }
        file.done(root)

        return builder.treeBuilt
    }

    private fun parseStatement(builder: PsiBuilder) {
        when (builder.tokenType) {
            SageEngineIniTokenTypes.BLOCK_START -> parseBlock(builder)
            SageEngineIniTokenTypes.PROPERTY -> parseUntilStatementBoundary(builder, SageEngineIniElementTypes.PROPERTY_ASSIGNMENT)
            SageEngineIniTokenTypes.MACRO -> parseUntilStatementBoundary(builder, SageEngineIniElementTypes.MACRO_STATEMENT)
            SageEngineIniTokenTypes.COMMENT_START -> parseUntilStatementBoundary(builder, SageEngineIniElementTypes.COMMENT)
            else -> builder.advanceLexer()
        }
    }

    private fun parseBlock(builder: PsiBuilder) {
        if (builder.tokenText.equals("BeginScript", ignoreCase = true)) {
            parseScriptBlock(builder)
            return
        }

        parseUntilStatementBoundary(builder, SageEngineIniElementTypes.BLOCK)
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
        marker.done(SageEngineIniElementTypes.SCRIPT_BLOCK)
    }

    private fun parseUntilStatementBoundary(builder: PsiBuilder, elementType: IElementType) {
        val marker = builder.mark()
        do {
            builder.advanceLexer()
        } while (!builder.eof() && !isStatementBoundary(builder))
        marker.done(elementType)
    }

    private fun isStatementBoundary(builder: PsiBuilder): Boolean {
        val tokenType = builder.tokenType
        return tokenType == SageEngineIniTokenTypes.BLOCK_START ||
            tokenType == SageEngineIniTokenTypes.BLOCK_END ||
            tokenType == SageEngineIniTokenTypes.PROPERTY ||
            tokenType == SageEngineIniTokenTypes.MACRO ||
            tokenType == SageEngineIniTokenTypes.COMMENT_START ||
            tokenType == com.intellij.psi.TokenType.WHITE_SPACE && builder.tokenText?.any { it == '\n' || it == '\r' } == true
    }
}
