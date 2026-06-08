package de.darkatra.bfme2.ini

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object SageEngineIniFileType : LanguageFileType(SageEngineIniLanguage) {

    override fun getName(): String {
        return "Sage Engine Ini"
    }

    override fun getDescription(): String {
        return "Sage Engine Ini / BFME II object definition"
    }

    override fun getDefaultExtension(): String {
        return "ini"
    }

    override fun getIcon(): Icon {
        return SageEngineIniIcons.FILE
    }
}
