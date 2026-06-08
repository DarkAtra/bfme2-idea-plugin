package de.darkatra.bfme2.ini.psi

import com.intellij.psi.tree.IElementType

object SageEngineIniTokenTypes {

    val PROPERTY: IElementType = SageEngineIniTokenType("PROPERTY")
    val KEYWORD: IElementType = SageEngineIniTokenType("KEYWORD")
    val CONDITION: IElementType = SageEngineIniTokenType("CONDITION")
    val NUMBER: IElementType = SageEngineIniTokenType("NUMBER")
    val STRING: IElementType = SageEngineIniTokenType("STRING")
    val COMMENT: IElementType = SageEngineIniTokenType("COMMENT")
    val MACRO: IElementType = SageEngineIniTokenType("MACRO")
    val EQUALS: IElementType = SageEngineIniTokenType("EQUALS")
    val COLON: IElementType = SageEngineIniTokenType("COLON")
    val COMMA: IElementType = SageEngineIniTokenType("COMMA")
    val PERCENT: IElementType = SageEngineIniTokenType("PERCENT")
    val LPAREN: IElementType = SageEngineIniTokenType("LPAREN")
    val RPAREN: IElementType = SageEngineIniTokenType("RPAREN")
    val LBRACE: IElementType = SageEngineIniTokenType("LBRACE")
    val RBRACE: IElementType = SageEngineIniTokenType("RBRACE")
    val OPERATOR: IElementType = SageEngineIniTokenType("OPERATOR")
}
