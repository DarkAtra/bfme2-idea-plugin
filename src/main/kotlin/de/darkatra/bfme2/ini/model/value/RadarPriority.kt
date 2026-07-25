package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class RadarPriority(override val token: String) : SageIniEnum {
    INVALID("INVALID"),
    NOT_ON_RADAR("NOT_ON_RADAR"),
    UNIT("UNIT"),
    STRUCTURE("STRUCTURE"),
    LOCAL_UNIT_ONLY("LOCAL_UNIT_ONLY");

    companion object {

        val type: EnumValue<RadarPriority> = EnumValue("RadarPriority", entries)
    }
}
