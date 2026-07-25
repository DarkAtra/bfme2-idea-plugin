package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class TimedPosition(val position: List<Double> = emptyList(), val t: Int = 0) {

    companion object {

        val type: SageIniValueType<TimedPosition> = StructValue("TimedPosition") {
            component("Position", ListValue(FloatValue)) { it.position }
            component("T", IntValue) { it.t }
        }
    }
}
