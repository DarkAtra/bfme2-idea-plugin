package de.darkatra.bfme2.ini.model.common

/**
 * A property of a block, identified by its INI [name]. Nested blocks are properties with a [SageIniValueType.BlockValue] type.
 */
class SageIniProperty<in T, out V>(
    val name: String,
    val type: SageIniValueType<V>,
    val get: (T) -> V,
) {

    val isBlock: Boolean
        get() = type.elementType() is SageIniValueType.BlockValue<*>
}

class SageIniPropertiesBuilder<T> {

    val properties = mutableListOf<SageIniProperty<T, *>>()

    fun <V> property(name: String, type: SageIniValueType<V>, get: (T) -> V) {
        properties += SageIniProperty(name, type, get)
    }
}

/**
 * The type of a single value, unwrapping lists.
 */
fun SageIniValueType<*>.elementType(): SageIniValueType<*> {
    return when (this) {
        is SageIniValueType.ListValue<*> -> element.elementType()
        else -> this
    }
}
