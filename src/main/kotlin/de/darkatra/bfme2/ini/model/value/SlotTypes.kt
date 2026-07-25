package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class SlotTypes(override val token: String) : SageIniEnum {
    PRIMARY("PRIMARY"),
    SECONDARY("SECONDARY"),
    TERTIARY("TERTIARY"),
    QUATERNARY("QUATERNARY"),
    QUINARY("QUINARY");

    companion object {

        val type: EnumValue<SlotTypes> = EnumValue("SlotTypes", entries)
    }
}
