package de.darkatra.bfme2.ini.navigation

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns.psiElement
import com.intellij.psi.util.elementType
import com.intellij.util.ProcessingContext
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationLookup
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniDeclarationCompletionContributor : CompletionContributor() {

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
                    val element = parameters.originalPosition?.takeIf { it.elementType == SageEngineIniTokenTypes.VALUE }
                        ?: parameters.position.takeIf { it.elementType == SageEngineIniTokenTypes.VALUE }
                        ?: return

                    val expectedKinds = SageEngineIniDeclarationSchema.expectedKindsForProperty(element.propertyAssignmentName())
                    if (expectedKinds.isEmpty()) {
                        return
                    }

                    SageEngineIniDeclarationLookup.allDeclarationNames(element.project, expectedKinds).forEach { name ->
                        result.addElement(LookupElementBuilder.create(name).withTypeText(expectedKinds.joinToString(" | "), true))
                    }
                }
            }
        )
    }
}