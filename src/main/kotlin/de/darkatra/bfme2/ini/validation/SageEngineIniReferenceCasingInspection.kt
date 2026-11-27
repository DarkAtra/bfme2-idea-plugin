package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationLookup
import de.darkatra.bfme2.ini.declarations.SageEngineIniMacros
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * Reports references whose casing differs from the declaration, e.g. `elvenmallorntree` for `ElvenMallornTree`. The engine resolves names
 * case-insensitively, so this only keeps the names consistent.
 */
class SageEngineIniReferenceCasingInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element.elementType != SageEngineIniTokenTypes.VALUE) {
                    return
                }

                if (!isModelProperty(element)) {
                    return
                }
                val reference = SageEngineIniModelResolver.valueReference(element) ?: return
                val name = reference.name(element)
                // the engine replaces macros before it reads a value, e.g. `TargetNames = MINI_HORDE`
                if (SageEngineIniMacros.isDefined(element.project, name)) {
                    return
                }
                val declaredNames = SageEngineIniDeclarationLookup.declaredNames(element.project, name, reference.kinds)
                if (declaredNames.isEmpty() || name in declaredNames) {
                    return
                }

                val declaredName = declaredNames.first()
                holder.registerProblem(element, reference.range, "'$name' is declared as '$declaredName'", SageEngineIniReplaceTextQuickFix(declaredName))
            }
        }
    }
}
