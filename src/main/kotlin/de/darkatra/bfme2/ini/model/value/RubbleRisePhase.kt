package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class RubbleRisePhase(override val token: String) : SageIniEnum {
    INITIAL("INITIAL");

    companion object {

        val type: EnumValue<RubbleRisePhase> = EnumValue("RubbleRisePhase", entries)
    }
}
