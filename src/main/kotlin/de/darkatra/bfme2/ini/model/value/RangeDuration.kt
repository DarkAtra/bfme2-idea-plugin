package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

/**
 * A duration in milliseconds that is either a single time (`4000`) or a range (`Min:500 Max:1000`).
 */
data class RangeDuration(val min: Int = 0, val max: Int = 0) {

    companion object {

        val type: SageIniValueType<RangeDuration> = StructValue("RangeDuration") {
            component("Min", IntValue) { it.min }
            component("Max", IntValue) { it.max }
        }
    }
}
