package de.darkatra.bfme2.ini.model.common

/**
 * Properties named by a slot number, e.g. `1 = Command_ConstructElvenWarrior` in a `CommandSet`.
 */
class SageIniNumberedSlots<in T, V>(
    val type: SageIniValueType<V>,
    val get: (T) -> Map<Int, V>,
) {

    fun slot(index: Int): SageIniProperty<T, V?> {
        return SageIniProperty(index.toString(), type) { get(it)[index] }
    }
}
