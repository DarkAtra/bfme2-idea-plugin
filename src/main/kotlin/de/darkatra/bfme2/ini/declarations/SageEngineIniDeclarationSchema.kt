package de.darkatra.bfme2.ini.declarations

import de.darkatra.bfme2.ini.model.SageIniModel
import de.darkatra.bfme2.ini.model.common.SageIniProperty
import de.darkatra.bfme2.ini.model.common.SageIniValueType

/**
 * Declaration kinds and the properties that reference them, derived from the descriptors of the [SageIniModel].
 */
object SageEngineIniDeclarationSchema {

    private val declaredProperties: List<SageIniProperty<*, *>> = SageIniModel.blocks.flatMap { it.declaredProperties }

    // e.g. `1 = Command_ConstructElvenWarrior` in a `CommandSet`
    private val numberedSlotKinds: Set<String> = SageIniModel.blocks
        .mapNotNull { it.numberedSlots }
        .flatMap { referencedKinds(it.type) }
        .toSet()

    val declarationKinds: Set<String> = SageIniModel.declarations.map { it.name }.toSet()

    private val propertyReferenceRules: Map<String, Set<String>> = buildMap<String, Set<String>> {
        declaredProperties.forEach { property ->
            val kinds = referencedKinds(property)
            if (kinds.isNotEmpty()) {
                put(property.name.lowercase(), get(property.name.lowercase()).orEmpty() + kinds)
            }
        }
    }

    // values such as `PRIMARY` in `Weapon = PRIMARY SomeWeapon` are tokens of an enum and never reference a declaration
    private val propertyEnumTokens: Map<String, Set<String>> = buildMap<String, Set<String>> {
        declaredProperties.filter { propertyReferenceRules.containsKey(it.name.lowercase()) }.forEach { property ->
            val tokens = enumTokens(property.type)
            if (tokens.isNotEmpty()) {
                put(property.name.lowercase(), get(property.name.lowercase()).orEmpty() + tokens)
            }
        }
    }

    fun isDeclarationKind(kind: String?): Boolean {
        return kind in declarationKinds
    }

    fun expectedKindsForProperty(propertyName: String?): Set<String> {
        if (propertyName?.toIntOrNull() != null) {
            return numberedSlotKinds
        }
        return propertyReferenceRules[propertyName?.lowercase()].orEmpty()
    }

    fun expectedKindsForPropertyValue(propertyName: String?, propertyValue: String?): Set<String> {
        if (propertyValue != null && propertyValue.uppercase() in propertyEnumTokens[propertyName?.lowercase()].orEmpty()) {
            return emptySet()
        }

        return expectedKindsForProperty(propertyName)
    }

    /**
     * The declaration kinds [propertyValue] can reference if it is a value of [property].
     */
    fun expectedKindsForPropertyValue(property: SageIniProperty<*, *>, propertyValue: String?): Set<String> {
        if (propertyValue != null && isEnumToken(property.type, propertyValue)) {
            return emptySet()
        }

        return referencedKinds(property)
    }

    private fun isEnumToken(type: SageIniValueType<*>, token: String): Boolean {
        return when (type) {
            is SageIniValueType.EnumValue<*> -> type.entry(token) != null
            is SageIniValueType.ListValue<*> -> isEnumToken(type.element, token)
            is SageIniValueType.MapValue<*, *> -> isEnumToken(type.key, token) || isEnumToken(type.value, token)
            is SageIniValueType.StructValue<*> -> type.components.any { isEnumToken(it.type, token) }
            else -> false
        }
    }

    /**
     * The names of the declaration kinds a value of [property] can reference.
     */
    fun referencedKinds(property: SageIniProperty<*, *>): Set<String> {
        return referencedKinds(property.type)
    }

    private fun referencedKinds(type: SageIniValueType<*>): Set<String> {
        return when (type) {
            is SageIniValueType.ReferenceValue<*> -> type.targets.map { it.name }.toSet()
            is SageIniValueType.ListValue<*> -> referencedKinds(type.element)
            is SageIniValueType.MapValue<*, *> -> referencedKinds(type.key) + referencedKinds(type.value)
            is SageIniValueType.StructValue<*> -> type.components.flatMap { referencedKinds(it.type) }.toSet()
            else -> emptySet()
        }
    }

    private fun enumTokens(type: SageIniValueType<*>): Set<String> {
        return when (type) {
            is SageIniValueType.EnumValue<*> -> type.tokens.map { it.uppercase() }.toSet()
            is SageIniValueType.ListValue<*> -> enumTokens(type.element)
            is SageIniValueType.MapValue<*, *> -> enumTokens(type.key) + enumTokens(type.value)
            is SageIniValueType.StructValue<*> -> type.components.flatMap { enumTokens(it.type) }.toSet()
            else -> emptySet()
        }
    }
}
