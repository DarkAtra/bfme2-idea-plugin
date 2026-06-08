package de.darkatra.bfme2.ini

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class SageEngineIniFile(
    viewProvider: FileViewProvider
) : PsiFileBase(
    viewProvider,
    SageEngineIniLanguage
) {

    override fun getFileType(): FileType {
        return SageEngineIniFileType
    }

    override fun toString(): String {
        return "${SageEngineIniFileType.name} File"
    }
}
