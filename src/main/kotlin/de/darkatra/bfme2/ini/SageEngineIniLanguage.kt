package de.darkatra.bfme2.ini

import com.intellij.lang.Language

object SageEngineIniLanguage : Language("SageEngineIni") {

    @Suppress("unused")
    private fun readResolve(): Any = SageEngineIniLanguage
}
