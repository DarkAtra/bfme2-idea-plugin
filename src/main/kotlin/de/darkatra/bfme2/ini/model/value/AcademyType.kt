package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class AcademyType(override val token: String) : SageIniEnum {
    ACT_SUPERPOWER("ACT_SUPERPOWER"),
    ACT_UPGRADE_RADAR("ACT_UPGRADE_RADAR");

    companion object {

        val type: EnumValue<AcademyType> = EnumValue("AcademyType", entries)
    }
}
