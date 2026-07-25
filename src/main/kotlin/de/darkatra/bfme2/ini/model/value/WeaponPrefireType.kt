package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class WeaponPrefireType(override val token: String) : SageIniEnum {
    PER_ATTACK("PER_ATTACK"),
    PER_CLIP("PER_CLIP"),
    PER_SHOT("PER_SHOT"),
    PER_POSITION("PER_POSITION");

    companion object {

        val type: EnumValue<WeaponPrefireType> = EnumValue("WeaponPrefireType", entries)
    }
}
