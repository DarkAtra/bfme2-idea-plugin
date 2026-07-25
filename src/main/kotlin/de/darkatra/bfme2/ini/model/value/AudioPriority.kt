package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class AudioPriority(override val token: String) : SageIniEnum {
    LOWEST("LOWEST"),
    LOW("LOW"),
    NORMAL("NORMAL"),
    HIGH("HIGH"),
    CRITICAL("CRITICAL");

    companion object {

        val type: EnumValue<AudioPriority> = EnumValue("AudioPriority", entries)
    }
}
