package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock

/**
 * Recommends declaration names without special characters like `'`, `&` or `+`. The engine accepts them, but they are easy to get wrong
 * when the name is referenced.
 */
class SageEngineIniSpecialCharacterNameInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniBlock || !SageEngineIniDeclarationSchema.isDeclarationKind(element.declarationKind)) {
                    return
                }

                val name = element.nameIdentifier ?: return
                // quoted names such as `FontSubstitution "SachaWynter"` are strings
                if (name.text.startsWith('"')) {
                    return
                }

                val specialCharacters = name.text.filterNot(::isPlainNameCharacter).toSet().map { "'$it'" }
                if (specialCharacters.isEmpty()) {
                    return
                }

                val description = if (specialCharacters.size == 1) {
                    "the special character ${specialCharacters.single()}"
                } else {
                    "the special characters ${specialCharacters.dropLast(1).joinToString(", ")} and ${specialCharacters.last()}"
                }
                holder.registerProblem(
                    name,
                    "'${name.text}' contains $description, names with only letters, digits, '_' and '-' are easier to work with",
                    ProblemHighlightType.WEAK_WARNING
                )
            }
        }
    }

    // `.` and `:` belong to window names, e.g. `ControlBarResizer ControlBar.wnd:ButtonLarge`
    private fun isPlainNameCharacter(character: Char): Boolean {
        return character in 'a'..'z' || character in 'A'..'Z' || character in '0'..'9' || character in "_-.:"
    }
}
