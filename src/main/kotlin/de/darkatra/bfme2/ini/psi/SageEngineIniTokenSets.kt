package de.darkatra.bfme2.ini.psi

import com.intellij.psi.tree.TokenSet

object SageEngineIniTokenSets {

    val BLOCKS: TokenSet = TokenSet.create(
        SageEngineIniTokenTypes.BLOCK_START,
        SageEngineIniTokenTypes.BLOCK_END,
    )
    val COMMENTS: TokenSet = TokenSet.create(
        SageEngineIniTokenTypes.COMMENT
    )
    val IDENTIFIERS: TokenSet = TokenSet.create(
        SageEngineIniTokenTypes.PROPERTY,
        SageEngineIniTokenTypes.BLOCK_START,
    )
    val VALUES: TokenSet = TokenSet.create(
        SageEngineIniTokenTypes.VALUE,
    )
    val STRINGS: TokenSet = TokenSet.create(
        SageEngineIniTokenTypes.STRING
    )
    val NUMBERS: TokenSet = TokenSet.create(
        SageEngineIniTokenTypes.NUMBER
    )
    val BRACES: TokenSet = TokenSet.create(
        SageEngineIniTokenTypes.LPAREN,
        SageEngineIniTokenTypes.RPAREN,
        SageEngineIniTokenTypes.LBRACE,
        SageEngineIniTokenTypes.RBRACE
    )
    val OPERATORS: TokenSet = TokenSet.create(
        SageEngineIniTokenTypes.EQUALS,
        SageEngineIniTokenTypes.COLON,
        SageEngineIniTokenTypes.COMMA,
        SageEngineIniTokenTypes.PERCENT,
        SageEngineIniTokenTypes.OPERATOR
    )
}
