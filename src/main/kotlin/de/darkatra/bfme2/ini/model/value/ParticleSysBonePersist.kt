package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class ParticleSysBonePersist(override val token: String) : SageIniEnum {
    NONE("NONE"),
    HOLD("HOLD"),
    KILL("KILL"),
    SPAWN("SPAWN");

    companion object {

        val type: EnumValue<ParticleSysBonePersist> = EnumValue("ParticleSysBonePersist", entries)
    }
}
