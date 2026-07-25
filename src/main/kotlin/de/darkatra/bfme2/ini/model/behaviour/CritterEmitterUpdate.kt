package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.SageReference

data class CritterEmitterUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("FX") val fX: SageReference<FXList>? = null,
    @SageIniName("SpawnObject") val spawnObject: SageReference<Object>? = null,
    @SageIniName("ReloadTime") val reloadTime: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<CritterEmitterUpdate>(
        name = "CritterEmitterUpdate",
        properties = {
            property("FX", ReferenceValue<FXList> { listOf(FXList) }) { it.fX }
            property("SpawnObject", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.spawnObject }
            property("ReloadTime", IntValue) { it.reloadTime }
        },
    )
}
