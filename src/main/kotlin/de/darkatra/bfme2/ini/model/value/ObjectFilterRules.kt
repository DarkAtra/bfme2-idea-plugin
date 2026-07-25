package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class ObjectFilterRules(override val token: String) : SageIniEnum {
    ALL("ALL"),
    NONE("NONE"),
    ANY("ANY"),
    ALLIES("ALLIES"),
    ENEMIES("ENEMIES"),
    NEUTRAL("NEUTRAL"),
    NEUTRALS("NEUTRALS"),
    NOT_SIMILAR("NOT_SIMILAR"),
    SELF("SELF"),
    SUICIDE("SUICIDE"),
    NOT_AIRBORNE("NOT_AIRBORNE"),
    SAME_HEIGHT_ONLY("SAME_HEIGHT_ONLY"),
    MINES("MINES"),
    SAME_PLAYER("SAME_PLAYER");

    companion object {

        val type: EnumValue<ObjectFilterRules> = EnumValue("ObjectFilterRules", entries)
    }
}
