package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class AudioControlFlags(override val token: String) : SageIniEnum {
    NONE("NONE"),
    LOOP("LOOP"),
    SEQUENTIAL("SEQUENTIAL"),
    RANDOMSTART("RANDOMSTART"),
    INTERRUPT("INTERRUPT"),
    FADE_ON_KILL("FADE_ON_KILL"),
    FADE_ON_START("FADE_ON_START"),
    ALLOW_KILL_MID_FILE("ALLOW_KILL_MID_FILE"),
    ALL("ALL"),
    RANDOM("RANDOM"),
    PLAY_ONE("PLAY_ONE");

    companion object {

        val type: EnumValue<AudioControlFlags> = EnumValue("AudioControlFlags", entries)
    }
}
