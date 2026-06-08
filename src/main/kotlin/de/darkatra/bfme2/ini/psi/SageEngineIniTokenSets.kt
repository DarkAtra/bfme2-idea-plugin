package de.darkatra.bfme2.ini.psi

import com.intellij.psi.tree.TokenSet

object SageEngineIniTokenSets {

    val COMMENTS: TokenSet = TokenSet.create(
        SageEngineIniTokenTypes.COMMENT
    )
    val IDENTIFIERS: TokenSet = TokenSet.create(
        SageEngineIniTokenTypes.PROPERTY,
        SageEngineIniTokenTypes.KEYWORD,
        SageEngineIniTokenTypes.CONDITION
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
