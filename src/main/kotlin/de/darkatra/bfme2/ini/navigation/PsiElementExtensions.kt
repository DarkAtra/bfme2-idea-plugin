package de.darkatra.bfme2.ini.navigation

import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.TokenType
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.declarations.SageEngineIniSources
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

internal fun PsiElement.resolveIncludeFile(): PsiFile? {

    val currentFile = containingFile?.virtualFile ?: return null
    val parent = currentFile.parent ?: return null
    val includePath = normalizedIncludePath()
        ?: return null

    val targetFile = parent.findRelativeFileIgnoringCase(includePath)
        ?.takeIf { !it.isDirectory }
        ?.takeIf { it.isInProjectDirectory(this) }
        ?: findInAdditionalDirectories(parent, includePath)
        ?: return null

    return PsiManager.getInstance(project).findFile(targetFile)
}

// the game reads mods and the base game as one file system, so mods can include base game files that aren't part of the mod, e.g. the base
// game's `data/ini/includes/x.inc` for an include in the mod's `data/ini/object/a.ini`, the longest matching path wins
private fun PsiElement.findInAdditionalDirectories(parent: VirtualFile, includePath: String): VirtualFile? {
    val segments = FileUtil.toCanonicalPath("${parent.path}/$includePath").split('/').filter { it.isNotEmpty() }
    return SageEngineIniSources.additionalDirectories(project).firstNotNullOfOrNull { directory ->
        segments.indices.firstNotNullOfOrNull { start ->
            directory.findRelativeFileIgnoringCase(segments.drop(start).joinToString("/"))?.takeIf { !it.isDirectory }
        }
    }
}

// the game resolves paths case-insensitively on every file system, e.g. `Includes/CaptureBuilding.inc` for `includes/capturebuilding.inc`
private fun VirtualFile.findRelativeFileIgnoringCase(path: String): VirtualFile? {
    return path.split('/').filter { it.isNotEmpty() && it != "." }.fold(this as VirtualFile?) { directory, segment ->
        when {
            directory == null -> null
            segment == ".." -> directory.parent
            else -> directory.findChild(segment) ?: directory.children.firstOrNull { it.name.equals(segment, ignoreCase = true) }
        }
    }
}

internal fun PsiElement.resolveIncludeDirectory(): VirtualFile? {
    val parent = containingFile?.virtualFile?.parent ?: return null
    val includePath = normalizedIncludePath()
        ?: return parent
    val includeDirectoryPath = includePath.substringBeforeLast('/', missingDelimiterValue = "")

    if (includeDirectoryPath.isBlank()) {
        return parent
    }

    return parent.findRelativeFileIgnoringCase(includeDirectoryPath)
        ?.takeIf { it.isDirectory }
        ?.takeIf { it.isInProjectDirectory(this) }
}

private fun VirtualFile.isInProjectDirectory(element: PsiElement): Boolean {
    return ProjectFileIndex.getInstance(element.project).isInContent(this) || SageEngineIniSources.isInAdditionalDirectory(element.project, this)
}

internal fun PsiElement.normalizedIncludePath(): String? {
    val includePath = text.trim('"').replace('\\', '/').trim()
    return includePath.takeIf { it.isNotBlank() }
}

/**
 * The path token of an `#include "path"` statement, `null` for other macro statements.
 */
internal fun SageEngineIniMacroStatement.includePath(): PsiElement? {
    return generateSequence(firstChild) { it.nextSibling }.firstOrNull { it !is PsiWhiteSpace && it.isPartOfIncludeMacro() }
}

internal fun PsiElement.isPartOfIncludeMacro(): Boolean {
    val macro = previousSignificantSibling() ?: return false
    return macro.node?.elementType == SageEngineIniTokenTypes.MACRO && macro.text.equals("#include", ignoreCase = true)
}

private fun PsiElement.previousSignificantSibling(): PsiElement? {

    var previousNode: PsiElement = this
    do {
        previousNode = PsiTreeUtil.prevLeaf(previousNode)
            ?: return null
    } while (previousNode.elementType == TokenType.WHITE_SPACE)

    return previousNode
}
