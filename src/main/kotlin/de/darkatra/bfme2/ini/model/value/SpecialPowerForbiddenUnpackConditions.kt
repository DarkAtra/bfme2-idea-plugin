package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class SpecialPowerForbiddenUnpackConditions(override val token: String) : SageIniEnum {
    MOUNTED("MOUNTED");

    companion object {

        val type: EnumValue<SpecialPowerForbiddenUnpackConditions> = EnumValue("SpecialPowerForbiddenUnpackConditions", entries)
    }
}
