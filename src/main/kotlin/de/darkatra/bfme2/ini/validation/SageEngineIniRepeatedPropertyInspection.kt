package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment

/**
 * Reports properties with a single value that are set more than once in a block. The engine only keeps the last value, so earlier
 * assignments have no effect. Properties with list or map values collect every assignment and are not reported, neither are properties
 * whose structure is unknown.
 */
class SageEngineIniRepeatedPropertyInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniBlock) {
                    return
                }

                val descriptor = SageEngineIniModelResolver.descriptor(element) ?: return
                element.children
                    .filterIsInstance<SageEngineIniPropertyAssignment>()
                    .groupBy { it.propertyName?.lowercase() }
                    .forEach { (propertyName, assignments) ->
                        val property = propertyName?.let { descriptor.property(it) } ?: return@forEach
                        if (assignments.size < 2 || property.isBlock || property.type.mayBeRepeated()) {
                            return@forEach
                        }

                        assignments.dropLast(1).forEach { assignment ->
                            holder.registerProblem(
                                assignment.firstChild,
                                "'${assignment.propertyName}' is set again later, only the last value takes effect",
                                SageEngineIniRemoveAssignmentQuickFix()
                            )
                        }
                    }
            }
        }
    }

    private fun SageIniValueType<*>.mayBeRepeated(): Boolean {
        // the structure of raw values is unknown, real files repeat some of them, e.g. `DamagePerRound` of an `AutoResolveWeapon`
        return this is SageIniValueType.ListValue<*> || this is SageIniValueType.MapValue<*, *> || this is SageIniValueType.RawValue<*>
    }
}
