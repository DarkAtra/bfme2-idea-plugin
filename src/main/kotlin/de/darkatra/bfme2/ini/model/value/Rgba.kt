package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class Rgba(val r: Int = 0, val g: Int = 0, val b: Int = 0, val a: Int = 0) {

    companion object {

        val type: SageIniValueType<Rgba> = StructValue("Rgba") {
            component("R", IntValue) { it.r }
            component("G", IntValue) { it.g }
            component("B", IntValue) { it.b }
            component("A", IntValue) { it.a }
        }
    }
}
