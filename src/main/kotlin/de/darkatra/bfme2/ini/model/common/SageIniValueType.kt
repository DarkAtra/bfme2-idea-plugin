package de.darkatra.bfme2.ini.model.common

import de.darkatra.bfme2.ini.model.value.SageReference

/**
 * Describes how a value is written in an INI file. [V] is the Kotlin type of the described value, which ties every descriptor to the
 * property or component it describes at compile time.
 */
sealed interface SageIniValueType<out V> {

    data object BooleanValue : SageIniValueType<Boolean>

    data object IntValue : SageIniValueType<Int>

    data object FloatValue : SageIniValueType<Double>

    data object StringValue : SageIniValueType<String>

    /**
     * A value whose structure is not known precisely yet (upstream `Untyped`, `Opaque` or `FakeEnum`).
     */
    class RawValue<V>(val name: String) : SageIniValueType<V>

    class AssetValue<V>(val extensions: Set<String>) : SageIniValueType<V>

    class EnumValue<E>(val name: String, val entries: List<E>) : SageIniValueType<E> where E : Enum<E>, E : SageIniEnum {

        val tokens: List<String> = entries.map { it.token }

        private val entriesByToken = entries.associateBy { it.token.uppercase() }

        /**
         * Resolves a token case-insensitively, ignoring the `+`/`-` prefixes used by flag lists.
         */
        fun entry(token: String): E? {
            return entriesByToken[token.removePrefix("+").removePrefix("-").uppercase()]
        }
    }

    /**
     * A reference to a declaration of one of the [targets].
     */
    class ReferenceValue<T : Any>(targets: () -> List<SageIniBlockDescriptor<out T>>) : SageIniValueType<SageReference<T>> {

        // lazy because declarations reference each other cyclically
        val targets: List<SageIniBlockDescriptor<out T>> by lazy(targets)
    }

    class ListValue<E>(val element: SageIniValueType<E>) : SageIniValueType<List<E>>

    class MapValue<K, V>(val key: SageIniValueType<K>, val value: SageIniValueType<V>) : SageIniValueType<Map<K, V>>

    /**
     * A value consisting of several tokens on a single line, e.g. `X:1 Y:2 Z:3`.
     */
    class StructValue<S>(val name: String, components: SageIniComponentsBuilder<S>.() -> Unit) : SageIniValueType<S> {

        val components: List<SageIniComponent<S, *>> = SageIniComponentsBuilder<S>().apply(components).components
    }

    /**
     * A nested block that is one of the [candidates].
     */
    class BlockValue<B : Any>(candidates: () -> List<SageIniBlockDescriptor<out B>>) : SageIniValueType<B> {

        // lazy because blocks can contain each other cyclically
        val candidates: List<SageIniBlockDescriptor<out B>> by lazy(candidates)
    }
}
