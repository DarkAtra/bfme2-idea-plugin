package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class ContactPoint(val position: List<Double> = emptyList(), val bone: String? = null) {

    companion object {

        val type: SageIniValueType<ContactPoint> = StructValue("ContactPoint") {
            component("Position", ListValue(FloatValue)) { it.position }
            component("Bone", StringValue) { it.bone }
        }
    }
}
