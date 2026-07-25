package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.declarations.SageEngineIniMacros
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment

/**
 * Reports values that don't match the type of their property. Only booleans, numbers and enum tokens are validated so far. Words that could
 * be macros are only reported for enums, whose tokens can't be told apart from macro names otherwise.
 */
class SageEngineIniInvalidValueInspection : LocalInspectionTool() {

    // a trailing `%` turns a number into a fraction, a trailing `f` is ignored
    private val number = Regex("[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?[fF]?%?")

    // mods often use macros that are defined by the base game and not part of the project
    private val possibleMacro = Regex("[A-Za-z_][A-Za-z0-9_]*")

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniPropertyAssignment || element.hasExpressionValue()) {
                    return
                }

                val property = SageEngineIniModelResolver.property(element) ?: return
                // a lone `%` belongs to the preceding value, e.g. `MACRO %`
                val words = element.valueWords().filter { it.text != "%" }
                if (words.isEmpty()) {
                    return
                }

                val type = property.type
                // the engine reads a single token for scalar values and ignores the rest of the line
                val (elementType, checkedWords) = when (type) {
                    is SageIniValueType.ListValue<*> -> type.element to words
                    else -> type to words.take(1)
                }

                checkedWords.forEach { word ->
                    val problem = problem(elementType, word.text) ?: return@forEach
                    if (!SageEngineIniMacros.isDefined(element.project, word.text)) {
                        holder.registerProblem(element, word.range, problem, *fixes(elementType, word.text))
                    }
                }
            }
        }
    }

    private fun problem(type: SageIniValueType<*>, value: String): String? {
        return when (type) {
            is SageIniValueType.BooleanValue -> "Expected Yes or No but found '$value'".takeUnless {
                value.equals("Yes", ignoreCase = true) || value.equals("No", ignoreCase = true) || possibleMacro.matches(value)
            }

            is SageIniValueType.IntValue, is SageIniValueType.FloatValue -> "Expected a number but found '$value'".takeUnless {
                number.matches(value) || possibleMacro.matches(value)
            }

            // `None` is accepted by every enum and means that no entry is set
            is SageIniValueType.EnumValue<*> -> "Unknown ${type.name} '$value'".takeUnless {
                type.entry(value) != null || value.equals("None", ignoreCase = true)
            }

            else -> null
        }
    }

    private fun fixes(type: SageIniValueType<*>, value: String): Array<LocalQuickFix> {
        if (type !is SageIniValueType.EnumValue<*>) {
            return LocalQuickFix.EMPTY_ARRAY
        }

        // keeps the `+`/`-` prefix of flag lists
        val token = value.removePrefix("+").removePrefix("-")
        return replaceWithSimilarNameFixes(token, type.tokens, prefix = value.removeSuffix(token))
    }
}
