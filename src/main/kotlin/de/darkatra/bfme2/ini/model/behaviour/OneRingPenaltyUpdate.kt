package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.SageReference

data class OneRingPenaltyUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectName") val specialObjectName: SageReference<Object>? = null,
    @SageIniName("RingTimeBeforeSpawning") val ringTimeBeforeSpawning: Int = 0,
    @SageIniName("TimeSpentRoamingAround") val timeSpentRoamingAround: Int = 0,
    @SageIniName("TimeRingPowerSuppressed") val timeRingPowerSuppressed: Int = 0,
    @SageIniName("StartingDistanceFromMe") val startingDistanceFromMe: Double = 0.0,
    @SageIniName("TimeFrozenFromPenalty") val timeFrozenFromPenalty: Int = 0,
    @SageIniName("DiscoveredSound") val discoveredSound: SageReference<AudioEvent>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<OneRingPenaltyUpdate>(
        name = "OneRingPenaltyUpdate",
        properties = {
            property("SpecialObjectName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.specialObjectName }
            property("RingTimeBeforeSpawning", IntValue) { it.ringTimeBeforeSpawning }
            property("TimeSpentRoamingAround", IntValue) { it.timeSpentRoamingAround }
            property("TimeRingPowerSuppressed", IntValue) { it.timeRingPowerSuppressed }
            property("StartingDistanceFromMe", FloatValue) { it.startingDistanceFromMe }
            property("TimeFrozenFromPenalty", IntValue) { it.timeFrozenFromPenalty }
            property("DiscoveredSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.discoveredSound }
        },
    )
}
