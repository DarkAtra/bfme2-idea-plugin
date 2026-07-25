package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class LogicTypes(override val token: String) : SageIniEnum {
    INCREASE_BURN_RATE("INCREASE_BURN_RATE"),
    INCREASE_FUEL("INCREASE_FUEL"),
    INCREASE_FUEL_ON_EXISTING_FIRE("INCREASE_FUEL_ON_EXISTING_FIRE"),
    INCREASE_BURN_RATE_ON_EXISTING_FIRE("INCREASE_BURN_RATE_ON_EXISTING_FIRE"),
    DECREASE_BURN_RATE("DECREASE_BURN_RATE"),
    DECREASE_FUEL("DECREASE_FUEL"),
    DECREASE_FUEL_ON_EXISTING_FIRE("DECREASE_FUEL_ON_EXISTING_FIRE"),
    DECREASE_BURN_RATE_ON_EXISTING_FIRE("DECREASE_BURN_RATE_ON_EXISTING_FIRE");

    companion object {

        val type: EnumValue<LogicTypes> = EnumValue("LogicTypes", entries)
    }
}
