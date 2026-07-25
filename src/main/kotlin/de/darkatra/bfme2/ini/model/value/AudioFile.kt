package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.AssetValue

@JvmInline
value class AudioFile(val path: String = "") {

    companion object {

        val type: SageIniValueType<AudioFile> = AssetValue(setOf(".wav", ".mp3"))
    }
}
