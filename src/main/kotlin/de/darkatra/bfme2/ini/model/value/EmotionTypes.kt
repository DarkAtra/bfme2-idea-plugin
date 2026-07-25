package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class EmotionTypes(override val token: String) : SageIniEnum {
    TAUNT("TAUNT"),
    CHEER("CHEER"),
    HERO_CHEER("HERO_CHEER"),
    POINT("POINT"),
    FEAR("FEAR"),
    UNCONTROLLABLE_FEAR("UNCONTROLLABLE_FEAR"),
    TERROR("TERROR"),
    DOOM("DOOM"),
    QUARRELSOME("QUARRELSOME"),
    ALERT("ALERT"),
    BRACE_FOR_BEING_CRUSHED("BRACE_FOR_BEING_CRUSHED"),
    CHEER_FOR_ABOUT_TO_CRUSH("CHEER_FOR_ABOUT_TO_CRUSH");

    companion object {

        val type: EnumValue<EmotionTypes> = EnumValue("EmotionTypes", entries)
    }
}
