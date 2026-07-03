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

class SageEngineIniDeclarationUseSiteIndex : ScalarIndexExtension<String>() {

    override fun getName(): ID<String, Void> = NAME

    override fun getIndexer(): DataIndexer<String, Void, FileContent> = DataIndexer { inputData ->
        buildMap {
            inputData.contentAsText.lineSequence()
                .map { StringUtil.split(it.trim(), " ") }
                .filter { it.size >= 3 && it[1] == "=" }
                .forEach { parts ->
                    SageEngineIniDeclarationSchema.expectedKindsForProperty(parts[0]).forEach { kind ->
                        put(key(kind, parts[2]), null)
                    }
                }
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

    companion object {

        val NAME: ID<String, Void> = ID.create("sage.engine.ini.declaration.use.sites")

        fun key(kind: String, name: String): String = "$kind\u0000$name"
    }
}