package de.darkatra.bfme2.ini.declarations

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.util.indexing.DataIndexer
import com.intellij.util.indexing.DefaultFileTypeSpecificInputFilter
import com.intellij.util.indexing.FileBasedIndex
import com.intellij.util.indexing.FileBasedIndexExtension
import com.intellij.util.indexing.FileContent
import com.intellij.util.indexing.ID
import com.intellij.util.io.DataExternalizer
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.KeyDescriptor
import de.darkatra.bfme2.ini.SageEngineIniFileType
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

val SAGE_ENGINE_INI_MACRO_INDEX_ID: ID<String, String> = ID.create("sage.engine.ini.macros")

private val MACRO_DEFINITION = Regex("^\\s*#define\\s+(\\S+)", RegexOption.IGNORE_CASE)

/**
 * Indexes the names of all `#define` macros. Keys are lowercased because the engine resolves macros case-insensitively, values are the
 * names as they are written in the definition.
 */
class SageEngineIniMacroIndex : FileBasedIndexExtension<String, String>() {

    override fun getName(): ID<String, String> = SAGE_ENGINE_INI_MACRO_INDEX_ID

    override fun getIndexer(): DataIndexer<String, String, FileContent> = DataIndexer { inputData ->
        val macros = mutableMapOf<String, String>()
        inputData.contentAsText.lineSequence()
            .mapNotNull { MACRO_DEFINITION.find(it)?.groupValues?.get(1) }
            .forEach { macros.putIfAbsent(it.lowercase(), it) }
        macros
    }

    override fun getKeyDescriptor(): KeyDescriptor<String> = EnumeratorStringDescriptor.INSTANCE

    override fun getValueExternalizer(): DataExternalizer<String> = EnumeratorStringDescriptor.INSTANCE

    override fun getVersion(): Int = 2

    override fun getInputFilter(): FileBasedIndex.InputFilter = object : DefaultFileTypeSpecificInputFilter(SageEngineIniFileType) {

        override fun acceptInput(file: VirtualFile): Boolean {
            return file.fileType == SageEngineIniFileType
        }
    }

    override fun dependsOnFileContent(): Boolean = true
}

object SageEngineIniMacros {

    fun isDefined(project: Project, name: String): Boolean {
        return FileBasedIndex.getInstance()
            .getContainingFiles(SAGE_ENGINE_INI_MACRO_INDEX_ID, name.lowercase(), GlobalSearchScope.projectScope(project))
            .isNotEmpty()
    }

    /**
     * The name tokens of the `#define` statements of the macro [name].
     */
    fun findDefinitions(project: Project, name: String): List<PsiElement> {
        val psiManager = PsiManager.getInstance(project)
        return FileBasedIndex.getInstance()
            .getContainingFiles(SAGE_ENGINE_INI_MACRO_INDEX_ID, name.lowercase(), GlobalSearchScope.projectScope(project))
            .mapNotNull { psiManager.findFile(it) }
            .flatMap { file -> PsiTreeUtil.findChildrenOfType(file, SageEngineIniMacroStatement::class.java) }
            .mapNotNull { definedName(it) }
            .filter { it.text.equals(name, ignoreCase = true) }
    }

    fun allNames(project: Project): List<String> {
        val fileBasedIndex = FileBasedIndex.getInstance()
        val scope = GlobalSearchScope.projectScope(project)
        return fileBasedIndex.getAllKeys(SAGE_ENGINE_INI_MACRO_INDEX_ID, project)
            .flatMap { fileBasedIndex.getValues(SAGE_ENGINE_INI_MACRO_INDEX_ID, it, scope) }
            .distinct()
            .sortedWith(String.CASE_INSENSITIVE_ORDER)
    }

    /**
     * The name token of a `#define NAME value` statement, `null` for other macro statements.
     */
    fun definedName(statement: SageEngineIniMacroStatement): PsiElement? {
        val macro = statement.firstChild?.takeIf { it.elementType == SageEngineIniTokenTypes.MACRO } ?: return null
        if (!macro.text.equals("#define", ignoreCase = true)) {
            return null
        }
        return generateSequence(macro.nextSibling) { it.nextSibling }.firstOrNull { it.elementType == SageEngineIniTokenTypes.VALUE }
    }
}
