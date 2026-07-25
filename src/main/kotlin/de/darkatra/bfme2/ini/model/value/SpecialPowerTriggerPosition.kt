package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class SpecialPowerTriggerPosition(override val token: String) : SageIniEnum {
    TARGETPOS("TARGETPOS"),
    OBJECTPOS("OBJECTPOS");

    companion object {

        val type: EnumValue<SpecialPowerTriggerPosition> = EnumValue("SpecialPowerTriggerPosition", entries)
    }
}
