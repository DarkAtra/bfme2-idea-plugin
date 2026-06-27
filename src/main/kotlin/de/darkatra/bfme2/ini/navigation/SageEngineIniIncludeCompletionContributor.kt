package de.darkatra.bfme2.ini.navigation

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.util.ProcessingContext
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniIncludeCompletionContributor : CompletionContributor() {

    init {
        extend(
            CompletionType.BASIC,
            psiElement(),
            object : CompletionProvider<CompletionParameters>() {

                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    result: CompletionResultSet
                ) {
                    val element = parameters.originalPosition?.takeIf { it.elementType == SageEngineIniTokenTypes.STRING }
                        ?: parameters.position.takeIf { it.elementType == SageEngineIniTokenTypes.STRING }
                        ?: return
                    if (!element.isPartOfIncludeMacro()) {
                        return
                    }

                    addIncludePathCompletions(element, result)
                }
            }
        )
    }

    private fun addIncludePathCompletions(element: PsiElement, result: CompletionResultSet) {
        val includeDirectory = element.resolveIncludeDirectory()
            ?: return

        includeDirectory.children
            .sortedWith(compareBy({ !it.isDirectory }, { it.name.lowercase() }))
            .forEach { file ->
                val lookupString = if (file.isDirectory) "${file.name}/" else file.name
                result.addElement(LookupElementBuilder.create(lookupString))
            }
    }
}