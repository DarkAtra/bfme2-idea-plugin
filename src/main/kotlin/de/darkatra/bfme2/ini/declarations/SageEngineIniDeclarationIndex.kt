package de.darkatra.bfme2.ini.declarations

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.DefaultFileTypeSpecificInputFilter
import com.intellij.util.indexing.FileBasedIndex
import com.intellij.util.indexing.FileBasedIndexExtension
import com.intellij.util.indexing.FileContent
import com.intellij.util.indexing.ID
import com.intellij.util.io.DataExternalizer
import com.intellij.util.io.DataInputOutputUtil
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.IOUtil
import com.intellij.util.io.KeyDescriptor
import de.darkatra.bfme2.ini.SageEngineIniFileType
import java.io.DataInput
import java.io.DataOutput

val SAGE_ENGINE_INI_DECLARATION_INDEX_ID: ID<String, DeclarationOccurrence> = ID.create("sage.engine.ini.declarations.v2")

private val WHITESPACE = Regex("\\s+")

/**
 * Per-file occurrence of a declaration key: an [mask] of [SageEngineIniDeclarationIndexKey.DECLARATION] and
 * [SageEngineIniDeclarationIndexKey.USE_SITE], plus the [displayName] carrying the casing the declaration was
 * declared with (empty for use-site-only occurrences). The key itself is lowercased so lookups can match the
 * game's case-insensitive reference names with a single index hit; [displayName] restores the real casing for
 * completion.
 */
data class DeclarationOccurrence(val mask: Int, val displayName: String)

/**
 * Single index correlating declarations and their use-sites. Because both navigation directions query the same
 * key, a use-site can never be indexed without its declaration key being reachable and vice versa.
 */
class SageEngineIniDeclarationIndex : FileBasedIndexExtension<String, DeclarationOccurrence>() {

    override fun getName(): ID<String, DeclarationOccurrence> = SAGE_ENGINE_INI_DECLARATION_INDEX_ID

    override fun getIndexer(): DataIndexer<String, DeclarationOccurrence, FileContent> = DataIndexer { inputData ->
        buildMap {
            inputData.contentAsText.lineSequence().forEach { rawLine ->
                val line = SageEngineIniDeclarationIndexKey.stripComment(rawLine).trim()
                if (line.isEmpty()) {
                    return@forEach
                }

                val equalsIndex = line.indexOf('=')
                if (equalsIndex >= 0) {
                    indexUseSites(line, equalsIndex)
                } else {
                    indexDeclaration(line)
                }
            }
        }
    }

    private fun MutableMap<String, DeclarationOccurrence>.indexDeclaration(line: String) {
        val tokens = line.split(WHITESPACE)
        if (tokens.size < 2 || !SageEngineIniDeclarationSchema.isDeclarationKind(tokens[0])) {
            return
        }
        mergeOccurrence(SageEngineIniDeclarationIndexKey.create(tokens[0], tokens[1]), SageEngineIniDeclarationIndexKey.DECLARATION, tokens[1])
    }

    private fun MutableMap<String, DeclarationOccurrence>.indexUseSites(line: String, equalsIndex: Int) {
        val propertyName = line.substring(0, equalsIndex).trim()
        val expectedKinds = SageEngineIniDeclarationSchema.expectedKindsForProperty(propertyName)
        if (expectedKinds.isEmpty()) {
            return
        }

        line.substring(equalsIndex + 1).split(WHITESPACE)
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .forEach { value ->
                expectedKinds.forEach { kind ->
                    mergeOccurrence(SageEngineIniDeclarationIndexKey.create(kind, value), SageEngineIniDeclarationIndexKey.USE_SITE, "")
                }
            }
    }

    private fun MutableMap<String, DeclarationOccurrence>.mergeOccurrence(key: String, occurrence: Int, displayName: String) {
        merge(key, DeclarationOccurrence(occurrence, displayName)) { existing, added ->
            // Prefer a declaration's casing over a use-site's (empty) display name.
            val mergedDisplayName = if (added.mask and SageEngineIniDeclarationIndexKey.DECLARATION != 0) {
                added.displayName
            } else {
                existing.displayName.ifEmpty { added.displayName }
            }
            DeclarationOccurrence(existing.mask or added.mask, mergedDisplayName)
        }
    }

    override fun getKeyDescriptor(): KeyDescriptor<String> = EnumeratorStringDescriptor.INSTANCE

    override fun getValueExternalizer(): DataExternalizer<DeclarationOccurrence> = OccurrenceExternalizer

    override fun getVersion(): Int = 5

    override fun getInputFilter(): FileBasedIndex.InputFilter = object : DefaultFileTypeSpecificInputFilter(SageEngineIniFileType) {

        override fun acceptInput(file: VirtualFile): Boolean {
            return file.fileType == SageEngineIniFileType
        }
    }

    override fun dependsOnFileContent(): Boolean = true

    private object OccurrenceExternalizer : DataExternalizer<DeclarationOccurrence> {

        override fun save(out: DataOutput, value: DeclarationOccurrence) {
            DataInputOutputUtil.writeINT(out, value.mask)
            IOUtil.writeUTF(out, value.displayName)
        }

        override fun read(input: DataInput): DeclarationOccurrence {
            val mask = DataInputOutputUtil.readINT(input)
            val displayName = IOUtil.readUTF(input)
            return DeclarationOccurrence(mask, displayName)
        }
    }
}

object SageEngineIniDeclarationIndexKey {

    const val DECLARATION: Int = 1
    const val USE_SITE: Int = 2

    /** Names are lowercased so the case-insensitive reference names of the game map to a single index key. */
    fun create(kind: String, name: String): String = "$kind ${name.lowercase()}"

    fun kind(key: String): String = key.substringBefore(' ')

    fun stripComment(line: String): String {
        var end = line.length
        for (i in line.indices) {
            if (startsComment(line, i)) {
                end = i
                break
            }
        }
        return line.substring(0, end)
    }

    private fun startsComment(line: String, offset: Int): Boolean {
        val current = line[offset]
        if (current == ';') {
            return true
        }
        val next = line.getOrNull(offset + 1)
        return (current == '/' && next == '/') || (current == '-' && next == '-')
    }
}
