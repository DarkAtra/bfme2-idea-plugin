package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class MappedImageStatus(override val token: String) : SageIniEnum {
    ROTATED_90_CLOCKWISE("ROTATED_90_CLOCKWISE");

    companion object {

        val type: EnumValue<MappedImageStatus> = EnumValue("MappedImageStatus", entries)
    }
}
