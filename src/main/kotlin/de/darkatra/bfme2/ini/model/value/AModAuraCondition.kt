package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class AModAuraCondition(override val token: String) : SageIniEnum {
    MOUNTED("MOUNTED"),
    TAINT("TAINT"),
    ELVEN_WOOD("ELVEN_WOOD");

    companion object {

        val type: EnumValue<AModAuraCondition> = EnumValue("AModAuraCondition", entries)
    }
}
