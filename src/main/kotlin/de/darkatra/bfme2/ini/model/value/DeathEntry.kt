package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList

data class DeathEntry(val animState: ModelCondition? = null, val animTime: Int = 0, val riderOcl: SageReference<ObjectCreationList>? = null) {

    companion object {

        val type: SageIniValueType<DeathEntry> = StructValue("DeathEntry") {
            component("AnimState", ModelCondition.type) { it.animState }
            component("AnimTime", IntValue) { it.animTime }
            component("RiderOcl", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.riderOcl }
        }
    }
}
