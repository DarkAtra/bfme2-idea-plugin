package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.navigation.includePath
import de.darkatra.bfme2.ini.navigation.normalizedIncludePath
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
                    holder.registerProblem(path, "Cannot resolve file '$includePath'")
                }
            }
        }
    }
}
