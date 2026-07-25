package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class SpecialPowerUnpackConditions(override val token: String) : SageIniEnum {
    MOUNTED("MOUNTED"),
    WEAPON_TOGGLE("WEAPON_TOGGLE"),
    MOVING("MOVING");

    companion object {

        val type: EnumValue<SpecialPowerUnpackConditions> = EnumValue("SpecialPowerUnpackConditions", entries)
    }
}
