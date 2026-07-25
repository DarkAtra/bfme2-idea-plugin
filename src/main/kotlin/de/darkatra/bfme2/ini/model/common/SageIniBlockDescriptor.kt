package de.darkatra.bfme2.ini.model.common

/**
 * Describes a block of type [T]: its INI [name], the metadata the engine uses to parse it and its properties. Every model class has a
 * companion object that is its descriptor, e.g. `Armor` can be used wherever a `SageIniBlockDescriptor<Armor>` is expected.
 *
 * @param parent the descriptor of the base class, whose properties are inherited
 * @param tableKey the global table the block registers its declarations in, `null` if it can't be referenced by name
 * @param uniqueName `false` if repeated declarations with the same name are legitimate
 * @param headerArity the number of name tokens on the header line, e.g. `2` for `ChildObject Name ParentName`
 * @param keyedByLabel `true` if the header label is a key instead of a type token, e.g. `ModelConditionState = DAMAGED`
 * @param equalsIsSpurious `true` if the engine ignores the `=` form of a [keyedByLabel] header
 * @param numberedSlots the numbered slots (`1 = Command_X`) the block supports, `null` if it has none
 * @param bareDirective `true` if the block can be a single line without body and `End`
 */
open class SageIniBlockDescriptor<T : Any>(
    val name: String,
    val parent: SageIniBlockDescriptor<in T>? = null,
    val tableKey: String? = null,
    val uniqueName: Boolean = true,
    val headerArity: Int = 1,
    val keyedByLabel: Boolean = false,
    val equalsIsSpurious: Boolean = false,
    val numberedSlots: SageIniNumberedSlots<T, *>? = null,
    val bareDirective: Boolean = false,
    properties: SageIniPropertiesBuilder<T>.() -> Unit = {},
) {

    val declaredProperties: List<SageIniProperty<T, *>> = SageIniPropertiesBuilder<T>().apply(properties).properties

    val properties: List<SageIniProperty<T, *>> by lazy {
        val inherited: List<SageIniProperty<T, *>> = parent?.properties.orEmpty()
        inherited + declaredProperties
    }

    /**
     * The table declarations of this block are registered in, inherited from the base class if the block doesn't define its own.
     */
    val effectiveTableKey: String?
        get() = tableKey ?: parent?.effectiveTableKey

    /**
     * Helper bases such as `_DefeatCondition` only share properties and never appear in INI files themselves.
     */
    val isAbstract: Boolean
        get() = name.startsWith("_")

    private val propertiesByName by lazy {
        this.properties.associateBy { it.name.lowercase() }
    }

    fun property(name: String): SageIniProperty<T, *>? {
        return propertiesByName[name.lowercase()]
            ?: name.toIntOrNull()?.let { numberedSlots?.slot(it) }
    }

    fun isSubtypeOf(other: SageIniBlockDescriptor<*>): Boolean {
        return this === other || parent?.isSubtypeOf(other) == true
    }

    override fun toString(): String {
        return name
    }
}
