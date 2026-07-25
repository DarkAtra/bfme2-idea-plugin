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
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * Completes block and property names as well as enum and boolean values based on the descriptors of the INI model.
 */
class SageEngineIniModelCompletionContributor : CompletionContributor() {

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
                    val position = parameters.position
                    when (position.elementType) {
                        SageEngineIniTokenTypes.BLOCK_START, SageEngineIniTokenTypes.PROPERTY -> addStatementCompletions(position, result)
                        SageEngineIniTokenTypes.VALUE -> addValueCompletions(position, result)
                    }
                }
            }
        )
    }

    private fun addStatementCompletions(position: PsiElement, result: CompletionResultSet) {

        val statement = position.parent
        if (statement.firstChild != position) {
            return
        }

        val enclosingBlock = statement.parent as? SageEngineIniBlock
        if (enclosingBlock == null) {
            SageEngineIniDeclarationSchema.declarationKinds.forEach { kind ->
                result.addElement(LookupElementBuilder.create(kind).withTypeText("Declaration", true))
            }
            return
        }

        val descriptor = SageEngineIniModelResolver.descriptor(enclosingBlock) ?: return
        descriptor.properties.forEach { property ->
            result.addElement(LookupElementBuilder.create(property.name).withTypeText(describe(property.type), true))
        }
    }

    private fun addValueCompletions(position: PsiElement, result: CompletionResultSet) {

        val assignment = position.parent as? SageEngineIniPropertyAssignment ?: return
        val property = SageEngineIniModelResolver.property(assignment) ?: return

        valueTokens(property.type).forEach { token ->
            result.addElement(LookupElementBuilder.create(token).withTypeText(describe(property.type), true))
        }
    }

    private fun valueTokens(type: SageIniValueType<*>): List<String> {
        return when (type) {
            is SageIniValueType.BooleanValue -> listOf("Yes", "No")
            is SageIniValueType.EnumValue<*> -> type.tokens
            is SageIniValueType.ListValue<*> -> valueTokens(type.element)
            is SageIniValueType.StructValue<*> -> type.components.flatMap { valueTokens(it.type) }
            else -> emptyList()
        }
    }

    private fun describe(type: SageIniValueType<*>): String {
        return when (type) {
            is SageIniValueType.BooleanValue -> "Boolean"
            is SageIniValueType.IntValue -> "Int"
            is SageIniValueType.FloatValue -> "Float"
            is SageIniValueType.StringValue -> "String"
            is SageIniValueType.RawValue<*> -> type.name
            is SageIniValueType.AssetValue<*> -> "File (${type.extensions.joinToString()})"
            is SageIniValueType.EnumValue<*> -> type.name
            is SageIniValueType.ReferenceValue<*> -> type.targets.joinToString(" | ")
            is SageIniValueType.ListValue<*> -> "${describe(type.element)}..."
            is SageIniValueType.MapValue<*, *> -> "Map"
            is SageIniValueType.StructValue<*> -> type.name
            is SageIniValueType.BlockValue<*> -> "Block"
        }
    }
}
