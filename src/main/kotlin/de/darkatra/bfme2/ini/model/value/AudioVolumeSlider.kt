package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class AudioVolumeSlider(override val token: String) : SageIniEnum {
    SOUNDFX("SOUNDFX"),
    VOICE("VOICE"),
    MUSIC("MUSIC"),
    AMBIENT("AMBIENT"),
    MOVIE("MOVIE"),
    NONE("NONE");

    companion object {

        val type: EnumValue<AudioVolumeSlider> = EnumValue("AudioVolumeSlider", entries)
    }
}
