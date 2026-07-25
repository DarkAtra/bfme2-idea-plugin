package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class LocomotorSetType(override val token: String) : SageIniEnum {
    SET_NORMAL("SET_NORMAL"),
    SET_NORMAL_UPGRADED("SET_NORMAL_UPGRADED"),
    SET_FREEFALL("SET_FREEFALL"),
    SET_WANDER("SET_WANDER"),
    SET_PANIC("SET_PANIC"),
    SET_TAXIING("SET_TAXIING"),
    SET_SUPERSONIC("SET_SUPERSONIC"),
    SET_SLUGGISH("SET_SLUGGISH"),
    SET_ENRAGED("SET_ENRAGED"),
    SET_SCARED("SET_SCARED"),
    SET_MOUNTED("SET_MOUNTED"),
    SET_COMBO("SET_COMBO"),
    SET_CONTAINED("SET_CONTAINED"),
    SET_BURNINGDEATH("SET_BURNINGDEATH");

    companion object {

        val type: EnumValue<LocomotorSetType> = EnumValue("LocomotorSetType", entries)
    }
}
