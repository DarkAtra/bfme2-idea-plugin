package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class Coord2DInt(val x: Int = 0, val y: Int = 0) {

    companion object {

        val type: SageIniValueType<Coord2DInt> = StructValue("Coord2DInt") {
            component("X", IntValue) { it.x }
            component("Y", IntValue) { it.y }
        }
    }
}
