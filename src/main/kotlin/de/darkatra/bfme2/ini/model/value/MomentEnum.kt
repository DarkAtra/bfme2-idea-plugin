package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class MomentEnum(override val token: String) : SageIniEnum {
    INITIAL("INITIAL"),
    MIDPOINT("MIDPOINT"),
    FINAL("FINAL");

    companion object {

        val type: EnumValue<MomentEnum> = EnumValue("MomentEnum", entries)
    }
}
