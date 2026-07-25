package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class AudioTypeFlags(override val token: String) : SageIniEnum {
    NONE("NONE"),
    UI("UI"),
    WORLD("WORLD"),
    SHROUDED("SHROUDED"),
    VOICE("VOICE"),
    PLAYER("PLAYER"),
    ALLIES("ALLIES"),
    ENEMIES("ENEMIES"),
    EVERYONE("EVERYONE"),
    DEFAULT("DEFAULT"),
    GLOBAL("GLOBAL"),
    FAKE("FAKE");

    companion object {

        val type: EnumValue<AudioTypeFlags> = EnumValue("AudioTypeFlags", entries)
    }
}
