package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class SageIntRange(val low: Int = 0, val high: Int = 0) {

    companion object {

        val type: SageIniValueType<SageIntRange> = StructValue("SageIntRange") {
            component("Low", IntValue) { it.low }
            component("High", IntValue) { it.high }
        }
    }
}
