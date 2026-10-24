package de.darkatra.bfme2.ini.declarations

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.AdditionalLibraryRootsProvider
import com.intellij.openapi.roots.SyntheticLibrary
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.GlobalSearchScopesCore
import de.darkatra.bfme2.ini.settings.SageEngineIniSettings

/**
 * The places declarations and macros are looked up in: the project itself (the mod) and the additionally configured directories
 * (e.g. the base game ini files).
 */
object SageEngineIniSources {

    /**
     * Priority of the project itself. Lower ranks win, so the project always wins over the additional directories.
     */
    const val PROJECT_RANK: Int = 0

    fun additionalDirectories(project: Project): List<VirtualFile> {
        val fileSystem = LocalFileSystem.getInstance()
        return SageEngineIniSettings.getInstance(project).additionalSourceDirectories
            .mapNotNull { fileSystem.findFileByPath(it)?.takeIf { directory -> directory.isDirectory } }
    }

    fun scope(project: Project): GlobalSearchScope {
        val directories = additionalDirectories(project)
        val projectScope = GlobalSearchScope.projectScope(project)
        if (directories.isEmpty()) {
            return projectScope
        }
        return projectScope.union(GlobalSearchScopesCore.directoriesScope(project, true, *directories.toTypedArray()))
    }

    fun rank(project: Project, file: VirtualFile): Int {
        return rank(additionalDirectories(project), file)
    }

    fun isInAdditionalDirectory(project: Project, file: VirtualFile): Boolean {
        return rank(project, file) != PROJECT_RANK
    }

    /**
     * Keeps only the elements from the best ranked source: if something is present in the project, the additional directories are
     * ignored, otherwise the first additional directory that contains it wins.
     */
    fun <T> keepBestRanked(project: Project, elements: Collection<T>, fileOf: (T) -> VirtualFile?): List<T> {
        val directories = additionalDirectories(project)
        val ranked = elements.map { element -> element to (fileOf(element)?.let { rank(directories, it) } ?: PROJECT_RANK) }
        val bestRank = ranked.minOfOrNull { it.second } ?: return emptyList()
        return ranked.filter { it.second == bestRank }.map { it.first }
    }

    private fun rank(directories: List<VirtualFile>, file: VirtualFile): Int {
        val index = directories.indexOfFirst { VfsUtilCore.isAncestor(it, file, false) }
        return index + 1
    }
}

/**
 * Makes the additional directories known to the platform so that their files are indexed.
 */
class SageEngineIniAdditionalLibraryRootsProvider : AdditionalLibraryRootsProvider() {

    override fun getAdditionalProjectLibraries(project: Project): Collection<SyntheticLibrary> {
        val directories = SageEngineIniSources.additionalDirectories(project)
        if (directories.isEmpty()) {
            return emptyList()
        }
        return listOf(SyntheticLibrary.newImmutableLibrary("Sage Engine INI sources", directories, emptyList(), emptySet(), null))
    }

    override fun getRootsToWatch(project: Project): Collection<VirtualFile> {
        return SageEngineIniSources.additionalDirectories(project)
    }
}
