package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class LivingWorldBuildingType(override val token: String) : SageIniEnum {
    Resource("Resource"),
    Armory("Armory"),
    Barracks("Barracks"),
    Fortress("Fortress");

    companion object {

        val type: EnumValue<LivingWorldBuildingType> = EnumValue("LivingWorldBuildingType", entries)
    }
}
