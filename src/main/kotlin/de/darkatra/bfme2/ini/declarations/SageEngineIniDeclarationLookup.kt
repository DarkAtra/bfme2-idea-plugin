package de.darkatra.bfme2.ini.declarations

import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.util.indexing.FileBasedIndex
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

object SageEngineIniDeclarationLookup {

    fun findDeclarations(project: Project, name: String, expectedKinds: Set<String>): List<SageEngineIniBlock> {
        return expectedKinds.flatMap { kind -> findDeclarations(project, kind, name) }
    }

    fun findDeclarationsByName(project: Project, name: String): List<SageEngineIniBlock> {
        return SageEngineIniDeclarationSchema.declarationKinds.flatMap { kind -> findDeclarations(project, kind, name) }
    }

    /**
     * The names the declarations of one of the [kinds] that [name] resolves to are written with, e.g. `ElvenMallornTree` for
     * `elvenmallorntree`. Empty if [name] doesn't resolve. Only the best ranked source is considered, like [findDeclarations], but
     * only the index is read, so it is cheap enough to check every value of a file.
     */
    fun declaredNames(project: Project, name: String, kinds: Set<String>): List<String> {
        return declaredNamesCache.get(project, name.lowercase() to kinds) { readDeclaredNames(project, name, kinds) }
    }

    /**
     * The names of all declarations of the [kinds] as the index keys hold them, i.e. lowercased. Cheaper than [allDeclarationNames], e.g. to
     * find similar names, of which only the few suggested ones need their declared casing.
     */
    fun lowercasedDeclarationNames(project: Project, kinds: Set<String>): List<String> {
        return declaredNamesCache.get(project, kinds) {
            FileBasedIndex.getInstance().getAllKeys(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, project)
                .filter { SageEngineIniDeclarationIndexKey.kind(it) in kinds }
                .map { it.substringAfter(' ') }
        }
    }

    private val declaredNamesCache = SageEngineIniIndexCache(SAGE_ENGINE_INI_DECLARATION_INDEX_ID)

    private fun readDeclaredNames(project: Project, name: String, kinds: Set<String>): List<String> {
        return readDeclarations(project, name, kinds).map { it.second }.distinct()
    }

    private fun readDeclarations(project: Project, name: String, kinds: Set<String>): List<Pair<VirtualFile, String>> {
        return ReadAction.computeBlocking<List<Pair<VirtualFile, String>>, RuntimeException> {
            val scope = SageEngineIniSources.scope(project)
            val fileBasedIndex = FileBasedIndex.getInstance()
            val declarations = mutableListOf<Pair<VirtualFile, String>>()
            kinds.forEach { kind ->
                fileBasedIndex.processValues(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, SageEngineIniDeclarationIndexKey.create(kind, name), null, { file, value ->
                    if (value.mask and SageEngineIniDeclarationIndexKey.DECLARATION != 0) {
                        declarations += file to value.displayName
                    }
                    true
                }, scope)
            }
            SageEngineIniSources.keepBestRanked(project, declarations) { it.first }
        }
    }

    /**
     * The kinds of the declarations named [name], e.g. to tell that a reference names a declaration of another kind.
     */
    fun declaredKinds(project: Project, name: String): List<String> {
        return SageEngineIniDeclarationSchema.declarationKinds.filter { declaredNames(project, name, setOf(it)).isNotEmpty() }.sorted()
    }

    // reading the names of e.g. all objects takes long enough to delay completion noticeably, so they are cached until the index changes
    fun allDeclarationNames(project: Project, expectedKinds: Set<String>): List<String> {
        return declaredNamesCache.get(project, AllDeclarationNamesKey(expectedKinds)) {
            ReadAction.computeBlocking<List<String>, RuntimeException> {
                val fileBasedIndex = FileBasedIndex.getInstance()
                val scope = SageEngineIniSources.scope(project)

                fileBasedIndex.getAllKeys(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, project)
                    .asSequence()
                    .filter { SageEngineIniDeclarationIndexKey.kind(it) in expectedKinds }
                    .flatMap { key -> fileBasedIndex.getValues(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, key, scope) }
                    .filter { it.mask and SageEngineIniDeclarationIndexKey.DECLARATION != 0 }
                    .map { it.displayName }
                    .distinct()
                    .sortedWith(String.CASE_INSENSITIVE_ORDER)
                    .toList()
            }
        }
    }

    private data class AllDeclarationNamesKey(val kinds: Set<String>)

    /**
     * The files that declare [name] as a [kind], of the best ranked source only. Only the index is read, like [declaredNames].
     */
    fun declaringFiles(project: Project, name: String, kind: String): List<VirtualFile> {
        return declaredNamesCache.get(project, DeclaringFilesKey(name.lowercase(), kind)) {
            readDeclarations(project, name, setOf(kind)).map { it.first }.distinct()
        }
    }

    private data class DeclaringFilesKey(val name: String, val kind: String)

    /**
     * The declarations of [file] named [name] with the [kind], also those nested in other blocks.
     */
    fun declarationsInFile(file: PsiFile, kind: String, name: String): Collection<SageEngineIniBlock> {
        return file.findDeclarationBlocks(kind, name)
    }

    fun findUseSites(project: Project, kind: String, name: String): List<PsiElement> {
        return withIndexedFiles(project, kind, name, SageEngineIniDeclarationIndexKey.USE_SITE) { file ->
            file.findDeclarationUseSites(kind, name)
        }
    }

    /**
     * Whether a declaration of the same kind and name exists in a source with a higher priority, i.e. whether [declaration] is
     * overridden (e.g. a base game declaration that the mod redeclares).
     */
    fun isShadowed(project: Project, declaration: SageEngineIniBlock): Boolean {
        val kind = declaration.declarationKind ?: return false
        val name = declaration.name ?: return false
        val ownFile = declaration.containingFile?.virtualFile ?: return false
        val ownRank = SageEngineIniSources.rank(project, ownFile)

        return findDeclarations(project, kind, name).any { winner ->
            winner.containingFile?.virtualFile?.let { SageEngineIniSources.rank(project, it) < ownRank } ?: false
        }
    }

    /**
     * Only the declarations of the best ranked source are returned: the project wins over the additional directories, earlier
     * additional directories win over later ones.
     */
    private fun findDeclarations(project: Project, kind: String, name: String): List<SageEngineIniBlock> {
        val declarations = withIndexedFiles(project, kind, name, SageEngineIniDeclarationIndexKey.DECLARATION) { file ->
            file.findDeclarationBlocks(kind, name)
        }
        return SageEngineIniSources.keepBestRanked(project, declarations) { it.containingFile?.virtualFile }
    }

    private fun <T : PsiElement> withIndexedFiles(
        project: Project,
        kind: String,
        name: String,
        occurrence: Int,
        collect: (PsiFile) -> Collection<T>
    ): List<T> {
        return ReadAction.computeBlocking<List<T>, RuntimeException> {
            val result = mutableListOf<T>()
            val scope = SageEngineIniSources.scope(project)
            val fileBasedIndex = FileBasedIndex.getInstance()

            // The key is lowercased, so a single case-insensitive lookup resolves to exactly one index key.
            val key = SageEngineIniDeclarationIndexKey.create(kind, name)

            fileBasedIndex.processValues(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, key, null, { virtualFile, value ->
                if (value.mask and occurrence != 0) {
                    PsiManager.getInstance(project).findFile(virtualFile)?.let { file ->
                        result += collect(file)
                    }
                }
                true
            }, scope)

            result
        }
    }

    private fun PsiFile.findDeclarationBlocks(kind: String, name: String): Collection<SageEngineIniBlock> {
        return declarationBlocksByKey()[SageEngineIniDeclarationIndexKey.create(kind, name)].orEmpty()
    }

    private fun PsiFile.declarationBlocksByKey(): Map<String, List<SageEngineIniBlock>> {
        return CachedValuesManager.getCachedValue(this) {
            val blocks = PsiTreeUtil.findChildrenOfType(this, SageEngineIniBlock::class.java)
                .filter { it.declarationKind != null && it.name != null }
                .groupBy { SageEngineIniDeclarationIndexKey.create(it.declarationKind!!, it.name!!) }
            CachedValueProvider.Result.create(blocks, this)
        }
    }

    private fun PsiFile.findDeclarationUseSites(kind: String, name: String): Collection<PsiElement> {
        return PsiTreeUtil.findChildrenOfType(this, PsiElement::class.java)
            .asSequence()
            .filter { it.isValueUseSite(kind, name) || it.isPrefixedNameUseSite(kind, name) }
            .toList()
    }

    private fun PsiElement.isValueUseSite(kind: String, name: String): Boolean {
        if (elementType != SageEngineIniTokenTypes.VALUE || !text.endsWith(name, ignoreCase = true)) {
            return false
        }
        val reference = SageEngineIniModelResolver.valueReference(this) ?: return false
        return kind in reference.kinds && reference.name(this).equals(name, ignoreCase = true)
    }

    // e.g. `VoiceAttackUnitWildAzog` is a use-site of the object `WildAzog`
    private fun PsiElement.isPrefixedNameUseSite(kind: String, name: String): Boolean {
        if (elementType != SageEngineIniTokenTypes.PROPERTY || !text.endsWith(name, ignoreCase = true)) {
            return false
        }
        val (prefixLength, kinds) = SageEngineIniModelResolver.prefixedNameReference(this) ?: return false
        return kind in kinds && text.substring(prefixLength).equals(name, ignoreCase = true)
    }
}
