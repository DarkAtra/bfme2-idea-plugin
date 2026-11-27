package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.declarations.SageEngineIniMacros
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * Reports names that can only be macros but aren't defined by any `#define`: words of numbers and booleans, e.g. `BuildCost = MALLORN_COST`,
 * and the operands of expressions such as `#MULTIPLY( HERO_DAMAGE 2 )`.
 */
class SageEngineIniUnresolvedMacroInspection : LocalInspectionTool() {

    private val macroName = Regex("[A-Za-z_][A-Za-z0-9_]*")

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                val names = when (element) {
                    is SageEngineIniPropertyAssignment -> valueMacroNames(element)
                    is SageEngineIniMacroStatement -> expressionMacroNames(element)
                    else -> return
                }
                names.filterNot { (_, name) -> SageEngineIniMacros.isDefined(element.project, name) }.forEach { (range, name) ->
                    holder.registerProblem(element, range, "Cannot resolve macro '$name'")
                }
            }
        }
    }

    private fun valueMacroNames(assignment: SageEngineIniPropertyAssignment): List<Pair<TextRange, String>> {
        if (assignment.hasExpressionValue()) {
            return emptyList()
        }
        val type = SageEngineIniModelResolver.property(assignment)?.type ?: return emptyList()
        // the engine reads a single token for scalar values and ignores the rest of the line
        val (elementType, words) = when (type) {
            is SageIniValueType.ListValue<*> -> type.element to assignment.valueWords()
            else -> type to assignment.valueWords().take(1)
        }
        if (!isNumberOrBoolean(elementType)) {
            return emptyList()
        }
        return words
            .filter { macroName.matches(it.text) && !isBoolean(elementType, it.text) }
            .map { it.range to it.text }
    }

    // the operands of e.g. `#ADD( MALLORN_COST 25 )`, but neither `#define` nor `#include` statements nor the words after the `)`
    private fun expressionMacroNames(statement: SageEngineIniMacroStatement): List<Pair<TextRange, String>> {
        val children = generateSequence(statement.firstChild) { it.nextSibling }.toList()
        if (children.getOrNull(1)?.elementType != SageEngineIniTokenTypes.LPAREN) {
            return emptyList()
        }
        var depth = 0
        return children.filter { child ->
            when (child.elementType) {
                SageEngineIniTokenTypes.LPAREN -> depth++
                SageEngineIniTokenTypes.RPAREN -> depth--
            }
            depth > 0 && child.elementType == SageEngineIniTokenTypes.VALUE && macroName.matches(child.text)
        }.map { TextRange.from(it.startOffsetInParent, it.textLength) to it.text }
    }

    private fun isNumberOrBoolean(type: SageIniValueType<*>): Boolean {
        return type is SageIniValueType.IntValue || type is SageIniValueType.FloatValue || type is SageIniValueType.UnsignedIntValue ||
            type is SageIniValueType.BooleanValue
    }

    private fun isBoolean(type: SageIniValueType<*>, word: String): Boolean {
        return type is SageIniValueType.BooleanValue && (word.equals("Yes", ignoreCase = true) || word.equals("No", ignoreCase = true))
    }
}
