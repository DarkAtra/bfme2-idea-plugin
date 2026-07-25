package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class SubsystemLoader(override val token: String) : SageIniEnum {
    INI("INI");

    companion object {

        val type: EnumValue<SubsystemLoader> = EnumValue("SubsystemLoader", entries)
    }
}
