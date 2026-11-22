package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class Resolution(val width: Int = 0, val height: Int = 0) {

    companion object {

        val type: SageIniValueType<Resolution> = StructValue("Resolution") {
            component("Width", IntValue) { it.width }
            component("Height", IntValue) { it.height }
        }
    }
}
