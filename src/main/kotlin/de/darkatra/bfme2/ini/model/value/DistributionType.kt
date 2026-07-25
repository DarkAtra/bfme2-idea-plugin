package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class DistributionType(override val token: String) : SageIniEnum {
    CONSTANT("CONSTANT"),
    UNIFORM("UNIFORM");

    companion object {

        val type: EnumValue<DistributionType> = EnumValue("DistributionType", entries)
    }
}
