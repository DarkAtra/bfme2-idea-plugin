package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin

data class BannerCarrierPosition(val unitType: SageReference<Object>? = null, val pos: List<Double> = emptyList()) {

    companion object {

        val type: SageIniValueType<BannerCarrierPosition> = StructValue("BannerCarrierPosition") {
            component("UnitType", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.unitType }
            component("Pos", ListValue(FloatValue)) { it.pos }
        }
    }
}
