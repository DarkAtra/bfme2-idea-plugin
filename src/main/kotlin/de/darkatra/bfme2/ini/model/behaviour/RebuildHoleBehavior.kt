package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.SageReference

data class RebuildHoleBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("WorkerObjectName") val workerObjectName: SageReference<Object>? = null,
    @SageIniName("WorkerRespawnDelay") val workerRespawnDelay: Int = 0,
    @SageIniName("HoleHealthRegen%PerSecond") val holeHealthRegenPerSecond: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<RebuildHoleBehavior>(
        name = "RebuildHoleBehavior",
        properties = {
            property("WorkerObjectName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.workerObjectName }
            property("WorkerRespawnDelay", IntValue) { it.workerRespawnDelay }
            property("HoleHealthRegen%PerSecond", FloatValue) { it.holeHealthRegenPerSecond }
        },
    )
}
