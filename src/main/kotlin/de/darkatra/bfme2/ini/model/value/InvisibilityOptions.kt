package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class InvisibilityOptions(override val token: String) : SageIniEnum {
    UNTOGGLE_HIDDEN_WHEN_LEAVING_STEALTH("UNTOGGLE_HIDDEN_WHEN_LEAVING_STEALTH"),
    ALLOW_NEAR_TREES("ALLOW_NEAR_TREES"),
    DETECTED_BY_FRIENDLIES("DETECTED_BY_FRIENDLIES");

    companion object {

        val type: EnumValue<InvisibilityOptions> = EnumValue("InvisibilityOptions", entries)
    }
}
