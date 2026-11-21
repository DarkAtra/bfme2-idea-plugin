package de.darkatra.bfme2.ini.model.common

/**
 * Properties named by a fixed [prefix] followed by the name of a declaration that [suffix] describes, e.g. `VoiceAttackUnitWildAzog` in
 * `UnitSpecificSounds`.
 */
class SageIniPrefixedProperties<in T, V>(
    val prefix: String,
    val suffix: SageIniValueType.ReferenceValue<*>,
    val type: SageIniValueType<V>,
    val get: (T) -> Map<String, V>,
) {

    fun matches(name: String): Boolean {
        return name.length > prefix.length && name.startsWith(prefix)
    }

    fun property(name: String): SageIniProperty<T, V?> {
        return SageIniProperty(name, type) { get(it)[name.removePrefix(prefix)] }
    }
}
