package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class LivingWorldObjectType(override val token: String) : SageIniEnum {
    ARMY("ARMY"),
    BATTLE_MARKER("BATTLE_MARKER"),
    REGION_AWARD_DISPUTE("REGION_AWARD_DISPUTE"),
    CLOUD("CLOUD"),
    BUILDING("BUILDING"),
    DEFAULT("DEFAULT");

    companion object {

        val type: EnumValue<LivingWorldObjectType> = EnumValue("LivingWorldObjectType", entries)
    }
}
