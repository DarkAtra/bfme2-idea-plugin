package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class Coords(val x: Double = 0.0, val y: Double = 0.0, val z: Double = 0.0) {

    companion object {

        val type: SageIniValueType<Coords> = StructValue("Coords") {
            component("X", FloatValue) { it.x }
            component("Y", FloatValue) { it.y }
            component("Z", FloatValue) { it.z }
        }
    }
}
