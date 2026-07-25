package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class WeatherFlag(override val token: String) : SageIniEnum {
    RAINY("RAINY"),
    CLOUDYRAINY("CLOUDYRAINY"),
    SUNNY("SUNNY"),
    CLOUDY("CLOUDY"),
    NORMAL("NORMAL"),
    SNOWY("SNOWY");

    companion object {

        val type: EnumValue<WeatherFlag> = EnumValue("WeatherFlag", entries)
    }
}
