package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class ParticleVelocityType(override val token: String) : SageIniEnum {
    ORTHO("ORTHO"),
    SPHERICAL("SPHERICAL"),
    HEMISPHERICAL("HEMISPHERICAL"),
    CYLINDRICAL("CYLINDRICAL"),
    OUTWARD("OUTWARD");

    companion object {

        val type: EnumValue<ParticleVelocityType> = EnumValue("ParticleVelocityType", entries)
    }
}
