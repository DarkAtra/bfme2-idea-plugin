package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class StructureCollapsePhase(override val token: String) : SageIniEnum {
    INITIAL("INITIAL"),
    ALMOST_FINAL("ALMOST_FINAL"),
    FINAL("FINAL");

    companion object {

        val type: EnumValue<StructureCollapsePhase> = EnumValue("StructureCollapsePhase", entries)
    }
}
