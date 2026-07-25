package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class CivilianSpawnUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpawnDelayTime") val spawnDelayTime: Int = 0,
    @SageIniName("MaximumDistance") val maximumDistance: Int = 0,
    @SageIniName("RunToFilter") val runToFilter: SageFilter? = null,
    @SageIniName("Civilian") val civilian: List<SageReference<Object>> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<CivilianSpawnUpdate>(
        name = "CivilianSpawnUpdate",
        properties = {
            property("SpawnDelayTime", IntValue) { it.spawnDelayTime }
            property("MaximumDistance", IntValue) { it.maximumDistance }
            property("RunToFilter", SageFilter.type) { it.runToFilter }
            property("Civilian", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.civilian }
        },
    )
}
