package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class ParticleVolumeType(override val token: String) : SageIniEnum {
    POINT("POINT"),
    LINE("LINE"),
    BOX("BOX"),
    SPHERE("SPHERE"),
    CYLINDER("CYLINDER");

    companion object {

        val type: EnumValue<ParticleVolumeType> = EnumValue("ParticleVolumeType", entries)
    }
}
