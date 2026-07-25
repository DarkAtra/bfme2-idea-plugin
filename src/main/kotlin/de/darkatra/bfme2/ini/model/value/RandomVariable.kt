package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class RandomVariable(val low: Double = 0.0, val high: Double = 0.0, val distribution: DistributionType = DistributionType.UNIFORM) {

    companion object {

        val type: SageIniValueType<RandomVariable> = StructValue("RandomVariable") {
            component("Low", FloatValue) { it.low }
            component("High", FloatValue) { it.high }
            component("Distribution", DistributionType.type) { it.distribution }
        }
    }
}
