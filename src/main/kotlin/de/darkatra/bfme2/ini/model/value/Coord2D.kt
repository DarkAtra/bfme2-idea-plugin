package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class Coord2D(val x: Double = 0.0, val y: Double = 0.0) {

    companion object {

        val type: SageIniValueType<Coord2D> = StructValue("Coord2D") {
            component("X", FloatValue) { it.x }
            component("Y", FloatValue) { it.y }
        }
    }
}
