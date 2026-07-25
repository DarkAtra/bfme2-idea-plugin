package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class TerrainLod(override val token: String) : SageIniEnum {
    DISABLE("DISABLE");

    companion object {

        val type: EnumValue<TerrainLod> = EnumValue("TerrainLod", entries)
    }
}
