package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * Reports headers like `ThreatBreakdown = Tag` of blocks that take a plain header. The engine tolerates the `=`, but ignores it.
 */
class SageEngineIniSpuriousBlockLabelInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniBlock) {
                    return
                }

                val descriptor = SageEngineIniModelResolver.descriptor(element) ?: return
                if (!descriptor.equalsIsSpurious) {
                    return
                }

                val equals = element.node.findChildByType(SageEngineIniTokenTypes.EQUALS)?.psi ?: return
                holder.registerProblem(
                    equals,
                    "'${element.declarationKind}' takes a plain header, the engine ignores the '='",
                    SageEngineIniRemoveEqualsQuickFix()
                )
            }
        }
    }
}
