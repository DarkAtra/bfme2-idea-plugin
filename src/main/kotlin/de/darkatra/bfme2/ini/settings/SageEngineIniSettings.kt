package de.darkatra.bfme2.ini.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.StoragePathMacros
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.RootsChangeRescanningInfo
import com.intellij.openapi.roots.ex.ProjectRootManagerEx
import com.intellij.openapi.util.EmptyRunnable
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.LocalFileSystem

/**
 * Project level settings. The paths are machine specific, so they are stored in the workspace file instead of a shared project file.
 */
@Service(Service.Level.PROJECT)
@State(name = "SageEngineIniSettings", storages = [Storage(StoragePathMacros.WORKSPACE_FILE)])
class SageEngineIniSettings(private val project: Project) : PersistentStateComponent<SageEngineIniSettings.State> {

    class State {
        var additionalSourceDirectories: MutableList<String> = mutableListOf()
    }

    private var state = State()

    /**
     * Directories (e.g. the base game ini files) that are indexed in addition to the project. The order defines the priority: the
     * project itself always wins over all of them, and earlier directories win over later ones.
     */
    val additionalSourceDirectories: List<String>
        get() = state.additionalSourceDirectories.toList()

    fun updateAdditionalSourceDirectories(directories: List<String>) {
        val normalized = directories.map { FileUtil.toSystemIndependentName(it) }.distinct()
        if (normalized == state.additionalSourceDirectories) {
            return
        }
        state.additionalSourceDirectories = normalized.toMutableList()

        // The provider resolves the directories from the VFS cache, so make sure newly added directories are known to it.
        normalized.forEach { LocalFileSystem.getInstance().refreshAndFindFileByPath(it) }
        ApplicationManager.getApplication().runWriteAction {
            ProjectRootManagerEx.getInstanceEx(project).makeRootsChange(EmptyRunnable.getInstance(), RootsChangeRescanningInfo.TOTAL_RESCAN)
        }
    }

    override fun getState(): State = state

    override fun loadState(state: State) {
        this.state = state
    }

    companion object {

        fun getInstance(project: Project): SageEngineIniSettings = project.service()
    }
}
