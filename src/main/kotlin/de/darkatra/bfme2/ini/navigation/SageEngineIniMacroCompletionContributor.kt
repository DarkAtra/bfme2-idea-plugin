package de.darkatra.bfme2.ini.navigation

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext
import de.darkatra.bfme2.ini.declarations.SageEngineIniMacros
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.elementType
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * Completes macro names for numbers, booleans and enum values as well as for the operands of arithmetic expressions such as
 * `#MULTIPLY( MALLORN_COST 2 )`. Other values, e.g. references, are rarely macros and would only be cluttered by them.
 */
class SageEngineIniMacroCompletionContributor : CompletionContributor() {

    init {
        extend(
            CompletionType.BASIC,
            psiElement(SageEngineIniTokenTypes.VALUE),
            object : CompletionProvider<CompletionParameters>() {

                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    val position = parameters.position
                    if (!acceptsMacros(position)) {
                        return
                    }

                    SageEngineIniMacros.allNames(position.project).forEach { name ->
                        result.addElement(LookupElementBuilder.create(name).withTypeText("Macro", true))
                    }
                }
            }
        )
    }

    private fun acceptsMacros(position: PsiElement): Boolean {
        return when (val parent = position.parent) {
            is SageEngineIniPropertyAssignment -> when (SageEngineIniModelResolver.property(parent)?.type?.elementType()) {
                is SageIniValueType.BooleanValue,
                is SageIniValueType.IntValue,
                is SageIniValueType.FloatValue,
                is SageIniValueType.EnumValue<*> -> true

                else -> false
            }

            is SageEngineIniMacroStatement -> {
                val macro = parent.firstChild.text
                !macro.equals("#define", ignoreCase = true) && !macro.equals("#include", ignoreCase = true)
            }

            else -> false
        }
    }
}
