package de.darkatra.bfme2.ini.navigation

import com.intellij.openapi.vfs.VfsUtilCore
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.TokenType
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

internal fun PsiElement.resolveIncludeFile(): PsiFile? {

    val currentFile = containingFile?.virtualFile ?: return null
    val parent = currentFile.parent ?: return null
    val includePath = text.trim('"').replace('\\', '/')

    val targetFile = VfsUtilCore.findRelativeFile(includePath, parent)
        ?.takeIf { !it.isDirectory }
        ?: return null

    return PsiManager.getInstance(project).findFile(targetFile)
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
