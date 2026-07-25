package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class TimeOfDay(override val token: String) : SageIniEnum {
    NONE("NONE"),
    MORNING("MORNING"),
    AFTERNOON("AFTERNOON"),
    EVENING("EVENING"),
    NIGHT("NIGHT"),
    INTERPOLATE("INTERPOLATE");

    companion object {

        val type: EnumValue<TimeOfDay> = EnumValue("TimeOfDay", entries)
    }
}
