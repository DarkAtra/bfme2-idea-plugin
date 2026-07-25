package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class Descriptors(override val token: String) : SageIniEnum {
    ANY("ANY"),
    NONE("NONE"),
    ALL("ALL");

    companion object {

        val type: EnumValue<Descriptors> = EnumValue("Descriptors", entries)
    }
}
