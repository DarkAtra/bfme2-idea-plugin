package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class WeaponReloadType(override val token: String) : SageIniEnum {
    No("No"),
    Yes("Yes"),
    RETURN_TO_BASE("RETURN_TO_BASE");

    companion object {

        val type: EnumValue<WeaponReloadType> = EnumValue("WeaponReloadType", entries)
    }
}
