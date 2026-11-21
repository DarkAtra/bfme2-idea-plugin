package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.model.syntax.SageEngineIniSyntax
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * Reports properties written without the `=` their block requires, e.g. `CommandSet Foo` inside an `Object`, and properties written
 * with an `=` they never take, e.g. `RemoveModule = ModuleTag_Death`. Whether the `=` is required depends on the enclosing block.
 */
class SageEngineIniEqualsSignInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniPropertyAssignment) {
                    return
                }

                val propertyName = element.propertyName ?: return
                val parentKind = (element.parent as? SageEngineIniBlock)?.declarationKind ?: return
                val equals = element.node.findChildByType(SageEngineIniTokenTypes.EQUALS)?.psi

                // lines without any value are reported by SageEngineIniMissingValueInspection
                if (equals == null && element.valueWords().isNotEmpty() && SageEngineIniSyntax.requiresEquals(parentKind, propertyName)) {
                    holder.registerProblem(
                        element.firstChild,
                        "'$propertyName' requires '=' in '$parentKind'",
                        SageEngineIniInsertEqualsQuickFix()
                    )
                }

                if (equals != null && SageEngineIniSyntax.forbidsEquals(parentKind, propertyName)) {
                    holder.registerProblem(
                        equals,
                        "'$propertyName' must be written without '='",
                        SageEngineIniRemoveEqualsQuickFix()
                    )
                }
            }
        }
    }
}
