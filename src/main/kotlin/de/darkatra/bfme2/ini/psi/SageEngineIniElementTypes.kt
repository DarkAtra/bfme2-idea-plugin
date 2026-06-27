package de.darkatra.bfme2.ini.psi

import com.intellij.psi.tree.IElementType

object SageEngineIniElementTypes {

    val BLOCK: IElementType = SageEngineIniElementType("BLOCK")
    val PROPERTY_ASSIGNMENT: IElementType = SageEngineIniElementType("PROPERTY_ASSIGNMENT")
    val MACRO_STATEMENT: IElementType = SageEngineIniElementType("MACRO_STATEMENT")
    val COMMENT: IElementType = SageEngineIniElementType("COMMENT")
    val SCRIPT_BLOCK: IElementType = SageEngineIniElementType("SCRIPT_BLOCK")
}