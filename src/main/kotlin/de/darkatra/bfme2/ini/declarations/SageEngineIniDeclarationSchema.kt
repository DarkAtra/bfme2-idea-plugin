package de.darkatra.bfme2.ini.declarations

import de.darkatra.bfme2.ini.model.SageIniModel
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.common.SageIniComponent
import de.darkatra.bfme2.ini.model.common.SageIniPrefixedProperties
import de.darkatra.bfme2.ini.model.common.SageIniProperty
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.`object`.NewEvaEvent
import de.darkatra.bfme2.ini.model.`object`.PredefinedEvaEvent

/**
 * Declaration kinds and the properties that reference them, derived from the descriptors of the [SageIniModel].
 */
object SageEngineIniDeclarationSchema {

    private const val EVA_EVENT_PREFIX = "EVA:"

    private val declaredProperties: List<SageIniProperty<*, *>> = SageIniModel.blocks.flatMap { it.declaredProperties }

    // e.g. `1 = Command_ConstructElvenWarrior` in a `CommandSet`
    private val numberedSlotKinds: Set<String> = SageIniModel.blocks
        .mapNotNull { it.numberedSlots }
        .flatMap { referencedKinds(it.type) }
        .toSet()

    val declarationKinds: Set<String> = SageIniModel.declarations.map { it.name }.toSet()

    private val prefixedProperties: List<SageIniPrefixedProperties<*, *>> = SageIniModel.blocks.flatMap { it.prefixedProperties }.distinct()

    private val evaEventKinds: Set<String> = setOf(NewEvaEvent.name, PredefinedEvaEvent.name)

    // declared by labeled blocks inside other blocks, e.g. `RadiusCursorTemplate = RainOfFireRadiusCursor` inside the `InGameUI`
    private val labeledDeclarationKinds: Set<String> = SageIniModel.declarations.filter { it.keyedByLabel }.map { it.name }.toSet()

    // statements outside of blocks aren't part of the model, e.g. `EvaEventForwardReference DiscoveredRing`
    private val topLevelStatementReferenceRules: Map<String, Set<String>> = mapOf(
        "EvaEventForwardReference" to evaEventKinds,
    )

    private val propertyReferenceRules: Map<String, Set<String>> = buildMap<String, Set<String>> {
        putAll(topLevelStatementReferenceRules)
        declaredProperties.forEach { property ->
            val kinds = referencedKinds(property)
            if (kinds.isNotEmpty()) {
                put(property.name, get(property.name).orEmpty() + kinds)
            }
        }
    }

    // values such as `PRIMARY` in `Weapon = PRIMARY SomeWeapon` are tokens of an enum and never reference a declaration
    private val propertyEnumTokens: Map<String, Set<String>> = buildMap<String, Set<String>> {
        declaredProperties.filter { propertyReferenceRules.containsKey(it.name) }.forEach { property ->
            val tokens = enumTokens(property.type)
            if (tokens.isNotEmpty()) {
                put(property.name, get(property.name).orEmpty() + tokens)
            }
        }
    }

    fun isDeclarationKind(kind: String?): Boolean {
        return kind in declarationKinds
    }

    fun isLabeledDeclarationKind(kind: String?): Boolean {
        return kind in labeledDeclarationKinds
    }

    /**
     * Sounds can name an eva event instead, e.g. `VoiceFullyCreated = EVA:GenericBuildingComplete-Builder`.
     */
    fun evaEventReference(kinds: Set<String>, word: String): WordReference? {
        return WordReference(evaEventKinds, EVA_EVENT_PREFIX.length).takeIf { word.startsWith(EVA_EVENT_PREFIX) && AudioEvent.name in kinds }
    }

    fun expectedKindsForProperty(propertyName: String?): Set<String> {
        if (propertyName?.toIntOrNull() != null) {
            return numberedSlotKinds
        }
        return propertyReferenceRules[propertyName]
            ?: prefixedProperties.firstOrNull { propertyName != null && it.matches(propertyName) }?.let { referencedKinds(it.type) }
            ?: emptySet()
    }

    /**
     * The length of the prefix and the declaration kinds the rest of a prefixed property name references, e.g. `WildAzog` in
     * `VoiceAttackUnitWildAzog`.
     */
    fun prefixedNameReference(propertyName: String): Pair<Int, Set<String>>? {
        val prefixed = prefixedProperties.firstOrNull { it.matches(propertyName) } ?: return null
        return prefixed.prefix.length to referencedKinds(prefixed.suffix)
    }

    fun expectedKindsForPropertyValue(propertyName: String?, propertyValue: String?): Set<String> {
        if (propertyValue != null && (isNullToken(propertyValue) || propertyValue.uppercase() in propertyEnumTokens[propertyName].orEmpty())) {
            return emptySet()
        }

        return expectedKindsForProperty(propertyName)
    }

    /**
     * A word of a property value that references a declaration of one of the [kinds]. The name starts at [nameOffset] of the word, e.g.
     * after `RiderOCL:` in `RiderOCL:OCL_RohirrimSpawnDeadRider`.
     */
    data class WordReference(val kinds: Set<String>, val nameOffset: Int = 0)

    /**
     * The references of the [words] of a value of [type], by position. Struct components are matched by the `Key:` prefix of a word or
     * else by position, and single values only consist of their first word, like the engine reads them.
     */
    fun wordReferences(type: SageIniValueType<*>, words: List<String>): List<WordReference?> {
        return when (type) {
            is SageIniValueType.StructValue<*> -> structWordReferences(type, words)
            // a list of structs holds one struct per line, e.g. `ParticleSysBone = B_SWORDBONE LightningCharge FollowBone:Yes`
            is SageIniValueType.ListValue<*> if type.element is SageIniValueType.StructValue<*> -> {
                structWordReferences(type.element, words)
            }

            is SageIniValueType.ListValue<*> -> words.map { listElementReference(type.element, it) }
            else -> words.mapIndexed { index, word -> if (index == 0) wordReference(type, word) else null }
        }
    }

    private fun structWordReferences(type: SageIniValueType.StructValue<*>, words: List<String>): List<WordReference?> {

        val references = MutableList<WordReference?>(words.size) { null }
        val keyedComponents = mutableSetOf<SageIniComponent<*, *>>()
        val positionalWords = mutableListOf<Int>()
        words.forEachIndexed { index, word ->
            val separator = word.indexOf(':')
            if (separator < 0) {
                positionalWords += index
                return@forEachIndexed
            }
            // words like `FollowBone:Yes` that don't name a component are options
            val component = type.components.firstOrNull { it.name.equals(word.substring(0, separator), ignoreCase = true) } ?: return@forEachIndexed
            keyedComponents += component
            references[index] = wordReference(component.type, word.substring(separator + 1))?.copy(nameOffset = separator + 1)
        }

        val components = type.components.filterNot { it in keyedComponents }
        var next = 0
        components.forEachIndexed { componentIndex, component ->
            if (next >= positionalWords.size) {
                return@forEachIndexed
            }
            val componentType = component.type
            when {
                isMultiWord(componentType) -> {
                    val trailingWords = trailingWords(components.drop(componentIndex + 1), positionalWords.drop(next).map { words[it] })
                    repeat(positionalWords.size - next - trailingWords) {
                        val index = positionalWords[next++]
                        references[index] = (componentType as? SageIniValueType.ListValue<*>)?.let { listElementReference(it.element, words[index]) }
                    }
                }

                // optional leading tokens, e.g. the phase in `OCL = INITIAL OCL_StructureRubblePileLarge`
                componentType is SageIniValueType.EnumValue<*> && componentType.entry(words[positionalWords[next]]) == null -> Unit
                else -> {
                    val index = positionalWords[next++]
                    references[index] = wordReference(componentType, words[index])
                }
            }
        }
        return references
    }

    // single word components after a list are optional, so they only take the last words if those fit, e.g. `Upgrade = Upgrade_Drafted 500`
    private fun trailingWords(components: List<SageIniComponent<*, *>>, words: List<String>): Int {
        val singleWordComponents = components.filterNot { isMultiWord(it.type) }.asReversed()
        return singleWordComponents.zip(words.asReversed()).takeWhile { (component, word) -> fits(component.type, word) }.size
    }

    private fun fits(type: SageIniValueType<*>, word: String): Boolean {
        return when (type) {
            is SageIniValueType.IntValue, is SageIniValueType.FloatValue -> word.first().let { it.isDigit() || it in "+-." }
            is SageIniValueType.BooleanValue -> word.equals("Yes", ignoreCase = true) || word.equals("No", ignoreCase = true)
            is SageIniValueType.EnumValue<*> -> type.entry(word) != null
            else -> true
        }
    }

    private fun isMultiWord(type: SageIniValueType<*>): Boolean {
        return type is SageIniValueType.ListValue<*> || type is SageIniValueType.MapValue<*, *>
    }

    private fun listElementReference(element: SageIniValueType<*>, word: String): WordReference? {
        // alternatives are separated by `OR`, e.g. `PrerequisiteSciences = SCIENCE_GOOD OR SCIENCE_MEN`
        if (element is SageIniValueType.ListValue<*> && word == "OR") {
            return null
        }
        return wordReference(element, word)
    }

    private fun wordReference(type: SageIniValueType<*>, word: String): WordReference? {
        if (isNullToken(word) || isEnumToken(type, word)) {
            return null
        }
        val kinds = referencedKinds(type)
        return evaEventReference(kinds, word) ?: kinds.takeIf { it.isNotEmpty() }?.let { WordReference(it) }
    }

    // stand for no declaration at all
    private fun isNullToken(word: String): Boolean {
        return word.equals("None", ignoreCase = true) || word.equals("NoSound", ignoreCase = true)
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

    fun referencedKinds(type: SageIniValueType<*>): Set<String> {
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
