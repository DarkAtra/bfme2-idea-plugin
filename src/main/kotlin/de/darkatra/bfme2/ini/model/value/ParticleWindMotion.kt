package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class ParticleWindMotion(override val token: String) : SageIniEnum {
    UNUSED("Unused"),
    PING_PONG("PingPong"),
    CIRCULAR("Circular");

    companion object {

        val type: EnumValue<ParticleWindMotion> = EnumValue("ParticleWindMotion", entries)
    }
}
