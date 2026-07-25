package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment

/**
 * Reports properties that the model doesn't know for the enclosing block. Properties of blocks that aren't part of the model are ignored.
 */
class SageEngineIniUnknownPropertyInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniPropertyAssignment) {
                    return
                }

                val propertyName = element.propertyName ?: return
                val block = element.parent as? SageEngineIniBlock ?: return
                val descriptor = SageEngineIniModelResolver.descriptor(block) ?: return
                if (descriptor.property(propertyName) != null) {
                    return
                }

                holder.registerProblem(
                    element.firstChild,
                    "Unknown property '$propertyName' in '${descriptor.name}'",
                    *replaceWithSimilarNameFixes(propertyName, descriptor.properties.filterNot { it.isBlock }.map { it.name })
                )
            }
        }
    }
}
