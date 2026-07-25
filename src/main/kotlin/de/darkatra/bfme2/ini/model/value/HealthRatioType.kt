package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class HealthRatioType(override val token: String) : SageIniEnum {
    SAME_CURRENTHEALTH("SAME_CURRENTHEALTH"),
    PRESERVE_RATIO("PRESERVE_RATIO"),
    ADD_CURRENT_HEALTH_TOO("ADD_CURRENT_HEALTH_TOO");

    companion object {

        val type: EnumValue<HealthRatioType> = EnumValue("HealthRatioType", entries)
    }
}
