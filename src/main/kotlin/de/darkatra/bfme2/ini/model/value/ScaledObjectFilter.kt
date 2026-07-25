package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class ScaledObjectFilter(val scalar: Double = 0.0, val objectFilter: SageFilter? = null) {

    companion object {

        val type: SageIniValueType<ScaledObjectFilter> = StructValue("ScaledObjectFilter") {
            component("Scalar", FloatValue) { it.scalar }
            component("ObjectFilter", SageFilter.type) { it.objectFilter }
        }
    }
}
