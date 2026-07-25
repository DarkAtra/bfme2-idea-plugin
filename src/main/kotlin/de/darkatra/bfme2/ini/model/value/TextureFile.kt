package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.AssetValue

@JvmInline
value class TextureFile(val path: String = "") {

    companion object {

        val type: SageIniValueType<TextureFile> = AssetValue(setOf(".tga", ".dds"))
    }
}
