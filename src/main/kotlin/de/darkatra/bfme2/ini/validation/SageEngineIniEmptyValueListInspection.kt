package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * Reports properties with an empty value list, e.g. `KindOf =`. The engine ignores them, so they have no effect.
 */
class SageEngineIniEmptyValueListInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniPropertyAssignment || element.valueWords().isNotEmpty() || element.hasExpressionValue()) {
                    return
                }
                if (element.node.findChildByType(SageEngineIniTokenTypes.EQUALS) == null) {
                    return
                }

                val type = SageEngineIniModelResolver.property(element)?.type ?: return
                if (type !is SageIniValueType.ListValue<*> && type !is SageIniValueType.MapValue<*, *>) {
                    return
                }

                holder.registerProblem(
                    element,
                    "'${element.propertyName}' has an empty value list, which has no effect",
                    ProblemHighlightType.LIKE_UNUSED_SYMBOL,
                    SageEngineIniRemoveAssignmentQuickFix("Remove property")
                )
            }
        }
    }
}
