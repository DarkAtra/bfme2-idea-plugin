package de.darkatra.bfme2.ini.psi

import com.intellij.psi.tree.IElementType
import de.darkatra.bfme2.ini.SageEngineIniLanguage

class SageEngineIniTokenType(
    debugName: String
) : IElementType(
    debugName,
    SageEngineIniLanguage
) {

    override fun toString(): String {
        return "SageEngineIniTokenType." + super.toString()
    }
}
