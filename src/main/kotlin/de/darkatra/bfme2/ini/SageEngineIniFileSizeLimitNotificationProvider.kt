package de.darkatra.bfme2.ini

import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.fileEditor.FileEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentIterator
import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.roots.ProjectRootModificationTracker
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.psi.SingleRootFileViewProvider
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.ui.EditorNotificationPanel
import com.intellij.ui.EditorNotificationProvider
import com.intellij.ui.EditorNotifications
import de.darkatra.bfme2.ini.declarations.SageEngineIniSources
import java.util.function.Function
import javax.swing.JComponent

/**
 * Explains why declarations in files above the IDE's code insight size limit can't be resolved, e.g. the 4.8 MB `voice.ini` of mods. Those
 * files are neither parsed nor indexed, and plugins can't raise the limit, only users can.
 */
class SageEngineIniFileSizeLimitNotificationProvider : EditorNotificationProvider {

    override fun collectNotificationData(project: Project, file: VirtualFile): Function<in FileEditor, out JComponent?>? {
        if (file.fileType != SageEngineIniFileType || PropertiesComponent.getInstance(project).getBoolean(DISMISSED_KEY)) {
            return null
        }

        val tooLargeFiles = tooLargeFileNames(project).takeIf { it.isNotEmpty() } ?: return null

        return Function { fileEditor ->
            EditorNotificationPanel(fileEditor, EditorNotificationPanel.Status.Warning).apply {
                text = "${describe(tooLargeFiles)} larger than the IDE's file size limit for code insight, so declarations in them can't be resolved. " +
                    "Increase idea.max.intellisense.filesize (in KB) in Help | Edit Custom Properties and restart the IDE."
                createActionLabel("Edit custom properties", "EditCustomProperties")
                createActionLabel("Dismiss") { dismiss(project) }
            }
        }
    }

    // the indexes skip files above the limit, so the files are collected from the source roots instead
    private fun tooLargeFileNames(project: Project): List<String> {
        return CachedValuesManager.getManager(project).getCachedValue(project) {
            val fileNames = mutableListOf<String>()
            val collect = ContentIterator { file ->
                if (!file.isDirectory && file.fileType == SageEngineIniFileType && SingleRootFileViewProvider.isTooLargeForIntelligence(file)) {
                    fileNames += file.name
                }
                true
            }
            ProjectFileIndex.getInstance(project).iterateContent(collect)
            SageEngineIniSources.additionalDirectories(project).forEach { VfsUtilCore.iterateChildrenRecursively(it, null, collect) }
            CachedValueProvider.Result.create(fileNames.distinct().sorted(), VirtualFileManager.getInstance(), ProjectRootModificationTracker.getInstance(project))
        }
    }

    private fun describe(fileNames: List<String>): String {
        return when {
            fileNames.size == 1 -> "${fileNames.single()} is"
            fileNames.size <= MAX_LISTED_FILES -> "${fileNames.dropLast(1).joinToString(", ")} and ${fileNames.last()} are"
            else -> "${fileNames.take(MAX_LISTED_FILES).joinToString(", ")} and ${fileNames.size - MAX_LISTED_FILES} more files are"
        }
    }

    companion object {

        internal const val DISMISSED_KEY = "sage.engine.ini.fileSizeLimitNotification.dismissed"
        private const val MAX_LISTED_FILES = 3

        fun dismiss(project: Project) {
            PropertiesComponent.getInstance(project).setValue(DISMISSED_KEY, true)
            EditorNotifications.getInstance(project).updateAllNotifications()
        }
    }
}
