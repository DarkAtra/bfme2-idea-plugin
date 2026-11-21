package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.syntax.SageEngineIniSyntax
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * Reports properties without a value, e.g. `GeometryName ;= Geom_Orig` whose value was commented out, or `SelectPortrait =` for a
 * property that takes a single value. Empty value lists are reported by [SageEngineIniEmptyValueListInspection] and directives that never
 * take a value, such as `Blank` in `Credits` or `ClearNuggets`, aren't reported.
 */
class SageEngineIniMissingValueInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniPropertyAssignment || element.valueWords().isNotEmpty() || element.hasExpressionValue()) {
                    return
                }

                val propertyName = element.propertyName ?: return
                val block = element.parent as? SageEngineIniBlock ?: return
                val parentKind = block.declarationKind ?: return
                // valueless directives of blocks that aren't part of the model are unknown
                val descriptor = SageEngineIniModelResolver.descriptor(block) ?: return

                val missesValue = if (element.node.findChildByType(SageEngineIniTokenTypes.EQUALS) != null) {
                    takesSingleValue(element)
                } else {
                    !isValuelessDirective(descriptor, parentKind, propertyName)
                }

                if (missesValue) {
                    holder.registerProblem(element.firstChild, "'$propertyName' has no value")
                }
            }
        }
    }

    private fun takesSingleValue(assignment: SageEngineIniPropertyAssignment): Boolean {
        return when (SageEngineIniModelResolver.property(assignment)?.type) {
            null, is SageIniValueType.ListValue<*>, is SageIniValueType.MapValue<*, *>, is SageIniValueType.RawValue<*> -> false
            else -> true
        }
    }

    private fun isValuelessDirective(descriptor: SageIniBlockDescriptor<*>, parentKind: String, propertyName: String): Boolean {
        return SageEngineIniSyntax.isValuelessKey(parentKind, propertyName) ||
            SageEngineIniModelResolver.childBlockCandidates(descriptor, propertyName).any { it.bareDirective }
    }
}
