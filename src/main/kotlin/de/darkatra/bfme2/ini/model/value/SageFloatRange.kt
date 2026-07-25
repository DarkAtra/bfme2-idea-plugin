package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class SageFloatRange(val low: Double = 0.0, val high: Double = 0.0) {

    companion object {

        val type: SageIniValueType<SageFloatRange> = StructValue("SageFloatRange") {
            component("Low", FloatValue) { it.low }
            component("High", FloatValue) { it.high }
        }
    }
}
