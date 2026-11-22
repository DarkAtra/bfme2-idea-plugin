package de.darkatra.bfme2.ini

import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.FileTypeManager
import com.intellij.openapi.fileTypes.PlainTextFileType
import com.intellij.openapi.fileTypes.impl.FileTypeOverrider
import com.intellij.openapi.util.Key
import com.intellij.openapi.vfs.VirtualFile
import java.io.IOException

/**
 * Standard ini files (e.g. launcher configurations) share the extensions of the game's ini files, but unlike them start with a
 * `[section]` header. They are treated as plain text instead.
 */
class SageEngineIniFileTypeOverrider : FileTypeOverrider {

    override fun getOverriddenFileType(file: VirtualFile): FileType? {
        if (file.isDirectory || FileTypeManager.getInstance().getFileTypeByFileName(file.nameSequence) != SageEngineIniFileType) {
            return null
        }
        return if (isStandardIni(file)) PlainTextFileType.INSTANCE else null
    }

    // called for every file type lookup, so the content is only read again after the file changed
    private fun isStandardIni(file: VirtualFile): Boolean {
        val stamp = file.modificationStamp
        file.getUserData(STANDARD_INI)?.takeIf { it.first == stamp }?.let { return it.second }

        val standardIni = try {
            isStandardIni(file.inputStream.use { String(it.readNBytes(CONTENT_PREFIX_LENGTH), Charsets.UTF_8) })
        } catch (_: IOException) {
            false
        }
        file.putUserData(STANDARD_INI, stamp to standardIni)
        return standardIni
    }

    companion object {

        private const val CONTENT_PREFIX_LENGTH = 4096
        private val STANDARD_INI = Key.create<Pair<Long, Boolean>>("sage.engine.ini.standardIni")

        fun isStandardIni(text: CharSequence): Boolean {
            val firstStatement = text.lineSequence()
                .map { line -> line.trim { it.isWhitespace() || it == '\uFEFF' } }
                .firstOrNull { it.isNotEmpty() && !isCommentOrMacro(it) }
            return firstStatement?.startsWith('[') == true
        }

        private fun isCommentOrMacro(line: String): Boolean {
            return line.startsWith(';') || line.startsWith("//") || line.startsWith("--") || line.startsWith('#')
        }
    }
}
