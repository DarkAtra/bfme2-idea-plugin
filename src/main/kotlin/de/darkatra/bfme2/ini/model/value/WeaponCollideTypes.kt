package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class WeaponCollideTypes(override val token: String) : SageIniEnum {
    STRUCTURES("STRUCTURES"),
    WALLS("WALLS"),
    ENEMIES("ENEMIES"),
    SHRUBBERY("SHRUBBERY"),
    ALLIES("ALLIES"),
    NEUTRAL("NEUTRAL"),
    MONSTERS("MONSTERS");

    companion object {

        val type: EnumValue<WeaponCollideTypes> = EnumValue("WeaponCollideTypes", entries)
    }
}
