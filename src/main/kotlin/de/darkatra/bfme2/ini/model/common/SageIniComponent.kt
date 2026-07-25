package de.darkatra.bfme2.ini.model.common

class SageIniComponent<in S, out V>(
    val name: String,
    val type: SageIniValueType<V>,
    val get: (S) -> V,
)

class SageIniComponentsBuilder<S> {

    val components = mutableListOf<SageIniComponent<S, *>>()

    fun <V> component(name: String, type: SageIniValueType<V>, get: (S) -> V) {
        components += SageIniComponent(name, type, get)
    }
}
