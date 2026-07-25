package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin

data class RankInfo(val rankNumber: Int? = null, val unitType: SageReference<Object>? = null, val position: List<List<Double>> = emptyList()) {

    companion object {

        val type: SageIniValueType<RankInfo> = StructValue("RankInfo") {
            component("RankNumber", IntValue) { it.rankNumber }
            component("UnitType", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.unitType }
            component("Position", ListValue(ListValue(FloatValue))) { it.position }
        }
    }
}
