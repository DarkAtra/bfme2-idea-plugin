package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class Relations(override val token: String) : SageIniEnum {
    ENEMIES("ENEMIES"),
    ALLIES("ALLIES"),
    SAME_PLAYER("SAME_PLAYER"),
    NEUTRAL("NEUTRAL"),
    SELF("SELF"),
    SUICIDE("SUICIDE");

    companion object {

        val type: EnumValue<Relations> = EnumValue("Relations", entries)
    }
}
