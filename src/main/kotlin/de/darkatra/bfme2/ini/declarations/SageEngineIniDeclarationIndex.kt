package de.darkatra.bfme2.ini.declarations

import com.intellij.openapi.util.text.StringUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.DefaultFileTypeSpecificInputFilter
import com.intellij.util.indexing.FileBasedIndex
import com.intellij.util.indexing.FileContent
import com.intellij.util.indexing.ID
import com.intellij.util.indexing.ScalarIndexExtension
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.KeyDescriptor
import de.darkatra.bfme2.ini.SageEngineIniFileType

val SAGE_ENGINE_INI_DECLARATION_INDEX_ID: ID<String, Void> = ID.create("sage.engine.ini.declarations")

class SageEngineIniDeclarationIndex : ScalarIndexExtension<String>() {

    override fun getName(): ID<String, Void> = SAGE_ENGINE_INI_DECLARATION_INDEX_ID

    override fun getIndexer(): DataIndexer<String, Void, FileContent> = DataIndexer { inputData ->
        buildMap {
            inputData.contentAsText.lineSequence()
                .map { StringUtil.split(it.trim(), " ") }
                .filter { it.size >= 2 && SageEngineIniDeclarationSchema.isDeclarationKind(it[0]) }
                .forEach { put(SageEngineIniDeclarationIndexKey.create(it[0], it[1]), null) }
        }
    }

    override fun getKeyDescriptor(): KeyDescriptor<String> = EnumeratorStringDescriptor.INSTANCE

    override fun getVersion(): Int = 1

    override fun getInputFilter(): FileBasedIndex.InputFilter = object : DefaultFileTypeSpecificInputFilter(SageEngineIniFileType) {

        override fun acceptInput(file: VirtualFile): Boolean {
            return file.fileType == SageEngineIniFileType
        }
    }

    override fun dependsOnFileContent(): Boolean = true
}

object SageEngineIniDeclarationIndexKey {

    fun create(kind: String, name: String): String = "$kind\u0000$name"

    fun kind(key: String): String = key.substringBefore('\u0000')

    fun declarationName(key: String): String = key.substringAfter('\u0000')
}