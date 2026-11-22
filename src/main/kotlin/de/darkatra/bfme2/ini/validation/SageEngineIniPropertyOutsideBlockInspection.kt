package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
import de.darkatra.bfme2.ini.model.syntax.SageEngineIniSyntax
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment

/**
 * Reports properties that aren't inside a block, e.g. because the block header was commented out. Statements that the engine reads outside
 * of blocks, such as `LODPreset`, the top level of `.inc` files, which are included into blocks, and files without blocks, such as
 * `Options.ini`, aren't reported.
 */
class SageEngineIniPropertyOutsideBlockInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniPropertyAssignment || element.parent !is PsiFile) {
                    return
                }
                val fileName = element.containingFile.name
                if (fileName.endsWith(".inc", ignoreCase = true) || SageEngineIniSyntax.isBlocklessFile(fileName)) {
                    return
                }

                val propertyName = element.propertyName ?: return
                if (SageEngineIniSyntax.isTopLevelKey(propertyName)) {
                    return
                }

                holder.registerProblem(element.firstChild, "'$propertyName' is outside of a block")
            }
        }
    }
}
