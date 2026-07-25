package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class FCurveKey(val t: Double = 0.0, val v: Double = 0.0, val i: Double = 0.0, val o: Double = 0.0) {

    companion object {

        val type: SageIniValueType<FCurveKey> = StructValue("FCurveKey") {
            component("T", FloatValue) { it.t }
            component("V", FloatValue) { it.v }
            component("I", FloatValue) { it.i }
            component("O", FloatValue) { it.o }
        }
    }
}
