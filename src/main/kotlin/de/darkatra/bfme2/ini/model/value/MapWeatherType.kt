package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class MapWeatherType(override val token: String) : SageIniEnum {
    NORMAL("NORMAL"),
    SNOWY("SNOWY");

    companion object {

        val type: EnumValue<MapWeatherType> = EnumValue("MapWeatherType", entries)
    }
}
