package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class BodyDamageType(override val token: String) : SageIniEnum {
    PRISTINE("PRISTINE"),
    DAMAGED("DAMAGED"),
    REALLYDAMAGED("REALLYDAMAGED"),
    RUBBLE("RUBBLE");

    companion object {

        val type: EnumValue<BodyDamageType> = EnumValue("BodyDamageType", entries)
    }
}
