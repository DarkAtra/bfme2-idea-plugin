package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationLookup
import de.darkatra.bfme2.ini.declarations.SageEngineIniFactionSides
import de.darkatra.bfme2.ini.declarations.SageEngineIniMacros
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * Reports values that reference a declaration that doesn't exist, e.g. a misspelled `Weapon`, or a declaration of another kind.
 */
class SageEngineIniUnresolvedReferenceInspection : LocalInspectionTool() {

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
                if (reference.factionSides && SageEngineIniFactionSides.isDefined(element.project, name)) {
                    return
                }
                if (SageEngineIniDeclarationLookup.declaredNames(element.project, name, reference.kinds).isNotEmpty()) {
                    return
                }

                val expectedKinds = reference.kinds.sorted().joinToString(" or ")
                val actualKinds = SageEngineIniDeclarationLookup.declaredKinds(element.project, name)
                val message = if (actualKinds.isEmpty()) {
                    "Cannot resolve $expectedKinds '$name'"
                } else {
                    "Expected $expectedKinds, but '$name' is ${actualKinds.joinToString(" or ")}"
                }
                holder.registerProblem(element, reference.range, message)
            }
        }
    }
}