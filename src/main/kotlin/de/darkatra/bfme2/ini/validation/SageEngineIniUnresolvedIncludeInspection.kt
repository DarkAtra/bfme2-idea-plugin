package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.navigation.includePath
import de.darkatra.bfme2.ini.navigation.normalizedIncludePath
import de.darkatra.bfme2.ini.navigation.resolveIncludeDirectory
import de.darkatra.bfme2.ini.navigation.resolveIncludeFile
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement

/**
 * Reports `#include` statements whose file doesn't exist, neither in the project nor in the additional directories.
 */
class SageEngineIniUnresolvedIncludeInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniMacroStatement) {
                    return
                }

                val path = element.includePath() ?: return
                val includePath = path.normalizedIncludePath() ?: return
                if (path.resolveIncludeFile() == null) {
                    val range = pathRange(path)
                    holder.registerProblem(path, range, "Cannot resolve file '$includePath'", *fixes(path, range.substring(path.text)))
                }
            }
        }
    }

    // the path without its quotes
    private fun pathRange(path: PsiElement): TextRange {
        val text = path.text
        return if (text.length >= 2 && text.startsWith('"') && text.endsWith('"')) TextRange(1, text.length - 1) else TextRange(0, text.length)
    }

    // files of the same directory with a similar name, keeping the directory as it is written, e.g. with `\` as separator
    private fun fixes(path: PsiElement, writtenPath: String): Array<LocalQuickFix> {
        val directory = path.resolveIncludeDirectory() ?: return LocalQuickFix.EMPTY_ARRAY
        val fileNameStart = writtenPath.lastIndexOfAny(charArrayOf('/', '\\')) + 1
        val fileNames = directory.children.filterNot { it.isDirectory }.map { it.name }
        return replaceWithSimilarNameFixes(writtenPath.substring(fileNameStart), fileNames, prefix = writtenPath.substring(0, fileNameStart))
    }
}
