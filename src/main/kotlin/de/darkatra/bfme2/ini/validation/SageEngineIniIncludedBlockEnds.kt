package de.darkatra.bfme2.ini.validation

import com.intellij.codeInsight.highlighting.HighlightErrorFilter
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.navigation.includePath
import de.darkatra.bfme2.ini.navigation.resolveIncludeFile
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * Hides the parser errors of blocks that an included file closes, e.g. an `Object` whose last `End` is part of an included `.inc`. The
 * engine reads included files as part of the including one, so they are valid, but [SageEngineIniIncludedBlockEndInspection] discourages
 * them.
 */
class SageEngineIniIncludedBlockEndErrorFilter : HighlightErrorFilter() {

    override fun shouldHighlightErrorElement(element: PsiErrorElement): Boolean {
        return !isMissingEndOfIncludedFile(element) && !isEndOfIncludedFile(element)
    }

    // e.g. `Missing 'End' for block 'Object'` in the file that includes the `End`
    private fun isMissingEndOfIncludedFile(element: PsiErrorElement): Boolean {
        val block = element.parent as? SageEngineIniBlock ?: return false
        if (element.textLength != 0 || block.node.findChildByType(SageEngineIniTokenTypes.BLOCK_END) != null) {
            return false
        }
        return PsiTreeUtil.findChildrenOfType(block, SageEngineIniMacroStatement::class.java).any { statement ->
            statement.includePath()?.resolveIncludeFile()?.closesIncludingBlock(mutableSetOf()) == true
        }
    }

    // e.g. `'End' without an open block` in the included file
    private fun isEndOfIncludedFile(element: PsiErrorElement): Boolean {
        val file = element.parent as? PsiFile ?: return false
        return isIncludedFile(file) && isBlockEnd(PsiTreeUtil.skipWhitespacesAndCommentsForward(element))
    }
}

/**
 * Reports an `End` of an included file that closes a block of the file that includes it. The engine accepts it, but the block is easier
 * to follow if it is closed in the file that opens it.
 */
class SageEngineIniIncludedBlockEndInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                val file = element.parent as? PsiFile ?: return
                if (isIncludedFile(file) && isBlockEnd(element)) {
                    holder.registerProblem(element, "'${element.text}' closes a block of the file that includes this one, close it in the file that opens it")
                }
            }
        }
    }
}

private fun isIncludedFile(file: PsiFile): Boolean {
    return file.name.endsWith(".inc", ignoreCase = true)
}

private fun isBlockEnd(element: PsiElement?): Boolean {
    return element?.elementType == SageEngineIniTokenTypes.BLOCK_END && element?.text.equals("End", ignoreCase = true)
}

// an `End` outside of any block, also of a file that this one includes, closes a block of the including file
private fun PsiFile.closesIncludingBlock(visited: MutableSet<PsiFile>): Boolean {
    if (!visited.add(this)) {
        return false
    }
    return generateSequence(firstChild) { it.nextSibling }.any { child ->
        (isIncludedFile(this) && isBlockEnd(child)) ||
            (child as? SageEngineIniMacroStatement)?.includePath()?.resolveIncludeFile()?.closesIncludingBlock(visited) == true
    }
}
