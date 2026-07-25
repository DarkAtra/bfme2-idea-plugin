package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class ButtonBorderTypes(override val token: String) : SageIniEnum {
    NONE("NONE"),
    ACTION("ACTION"),
    BUILD("BUILD"),
    UPGRADE("UPGRADE"),
    SYSTEM("SYSTEM");

    companion object {

        val type: EnumValue<ButtonBorderTypes> = EnumValue("ButtonBorderTypes", entries)
    }
}
