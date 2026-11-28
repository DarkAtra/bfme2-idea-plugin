package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import de.darkatra.bfme2.ini.navigation.includePath
import de.darkatra.bfme2.ini.navigation.normalizedIncludePath
import de.darkatra.bfme2.ini.navigation.resolveIncludeFile
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement

/**
 * Reports `#include` statements whose file includes the including file again, directly or through other files, so that the includes never
 * end.
 */
class SageEngineIniIncludeCycleInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniMacroStatement) {
                    return
                }

                val path = element.includePath() ?: return
                val includedFile = path.resolveIncludeFile() ?: return
                if (includes(includedFile, element.containingFile.originalFile, mutableSetOf())) {
                    holder.registerProblem(
                        path,
                        "'${path.normalizedIncludePath()}' includes this file again, so the includes never end",
                        SageEngineIniRemoveAssignmentQuickFix("Remove '#include'")
                    )
                }
            }
        }
    }

    private fun includes(file: PsiFile, target: PsiFile, visited: MutableSet<PsiFile>): Boolean {
        if (file == target) {
            return true
        }
        if (!visited.add(file)) {
            return false
        }
        return PsiTreeUtil.findChildrenOfType(file, SageEngineIniMacroStatement::class.java).any { statement ->
            statement.includePath()?.resolveIncludeFile()?.let { includes(it, target, visited) } == true
        }
    }
}
