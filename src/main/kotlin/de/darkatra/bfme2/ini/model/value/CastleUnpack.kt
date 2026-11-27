package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin

data class CastleUnpack(val faction: String = "", val castle: SageReference<Object>? = null) {

    companion object {

        val type: SageIniValueType<CastleUnpack> = StructValue("CastleUnpack") {
            component("Faction", StringValue) { it.faction }
            component("Castle", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.castle }
        }
    }
}
