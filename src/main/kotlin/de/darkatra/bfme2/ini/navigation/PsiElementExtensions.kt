package de.darkatra.bfme2.ini.navigation

import com.intellij.openapi.roots.ProjectFileIndex
import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.TokenType
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

internal fun PsiElement.resolveIncludeFile(): PsiFile? {

    val currentFile = containingFile?.virtualFile ?: return null
    val parent = currentFile.parent ?: return null
    val includePath = normalizedIncludePath()
        ?: return null

    val targetFile = VfsUtilCore.findRelativeFile(includePath, parent)
        ?.takeIf { !it.isDirectory }
        ?.takeIf { it.isInProjectDirectory(this) }
        ?: return null

    return PsiManager.getInstance(project).findFile(targetFile)
}

internal fun PsiElement.resolveIncludeDirectory(): VirtualFile? {
    val parent = containingFile?.virtualFile?.parent ?: return null
    val includePath = normalizedIncludePath()
        ?: return parent
    val includeDirectoryPath = includePath.substringBeforeLast('/', missingDelimiterValue = "")

    if (includeDirectoryPath.isBlank()) {
        return parent
    }

    return VfsUtilCore.findRelativeFile(includeDirectoryPath, parent)
        ?.takeIf { it.isDirectory }
        ?.takeIf { it.isInProjectDirectory(this) }
}

private fun VirtualFile.isInProjectDirectory(element: PsiElement): Boolean {
    return ProjectFileIndex.getInstance(element.project).isInContent(this)
}

internal fun PsiElement.normalizedIncludePath(): String? {
    val includePath = text.trim('"').replace('\\', '/').trim()
    return includePath.takeIf { it.isNotBlank() }
}

internal fun PsiElement.isPartOfIncludeMacro(): Boolean {
    val macro = previousSignificantSibling() ?: return false
    return macro.node?.elementType == SageEngineIniTokenTypes.MACRO && macro.text.equals("#include", ignoreCase = true)
}

fun PsiElement.propertyAssignmentName(): String? {
    return PsiTreeUtil.getParentOfType(this, SageEngineIniPropertyAssignment::class.java)?.propertyName
}

private fun PsiElement.previousSignificantSibling(): PsiElement? {

    var previousNode: PsiElement = this
    do {
        previousNode = PsiTreeUtil.prevLeaf(previousNode)
            ?: return null
    } while (previousNode.elementType == TokenType.WHITE_SPACE)

    return previousNode
}
