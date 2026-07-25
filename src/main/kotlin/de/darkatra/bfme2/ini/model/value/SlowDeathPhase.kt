package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class SlowDeathPhase(override val token: String) : SageIniEnum {
    INITIAL("INITIAL"),
    MIDPOINT("MIDPOINT"),
    FINAL("FINAL"),
    HIT_GROUND("HIT_GROUND");

    companion object {

        val type: EnumValue<SlowDeathPhase> = EnumValue("SlowDeathPhase", entries)
    }
}
