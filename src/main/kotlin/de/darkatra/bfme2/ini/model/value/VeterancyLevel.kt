package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class VeterancyLevel(override val token: String) : SageIniEnum {
    REGULAR("REGULAR"),
    VETERAN("VETERAN"),
    ELITE("ELITE"),
    HEROIC("HEROIC");

    companion object {

        val type: EnumValue<VeterancyLevel> = EnumValue("VeterancyLevel", entries)
    }
}
