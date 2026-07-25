package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class EntEnragedUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("EnragedLifeTimer") val enragedLifeTimer: Double = 0.0,
    @SageIniName("HatedObjectFilter") val hatedObjectFilter: SageFilter? = null,
    @SageIniName("FriendlyDeadFilter") val friendlyDeadFilter: SageFilter? = null,
    @SageIniName("EnragedTime") val enragedTime: Int = 0,
    @SageIniName("TimeUntilCanRageAgain") val timeUntilCanRageAgain: Int = 0,
    @SageIniName("EnragedTransitionTime") val enragedTransitionTime: Int = 0,
    @SageIniName("EnragedTransitionFX") val enragedTransitionFX: SageReference<FXList>? = null,
    @SageIniName("EnragedOnBuffFX") val enragedOnBuffFX: SageReference<FXList>? = null,
    @SageIniName("EnragedOffBuffFX") val enragedOffBuffFX: SageReference<FXList>? = null,
    @SageIniName("ScanDelayTime") val scanDelayTime: Int = 0,
    @SageIniName("ScanDistance") val scanDistance: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<EntEnragedUpdate>(
        name = "EntEnragedUpdate",
        properties = {
            property("EnragedLifeTimer", FloatValue) { it.enragedLifeTimer }
            property("HatedObjectFilter", SageFilter.type) { it.hatedObjectFilter }
            property("FriendlyDeadFilter", SageFilter.type) { it.friendlyDeadFilter }
            property("EnragedTime", IntValue) { it.enragedTime }
            property("TimeUntilCanRageAgain", IntValue) { it.timeUntilCanRageAgain }
            property("EnragedTransitionTime", IntValue) { it.enragedTransitionTime }
            property("EnragedTransitionFX", ReferenceValue<FXList> { listOf(FXList) }) { it.enragedTransitionFX }
            property("EnragedOnBuffFX", ReferenceValue<FXList> { listOf(FXList) }) { it.enragedOnBuffFX }
            property("EnragedOffBuffFX", ReferenceValue<FXList> { listOf(FXList) }) { it.enragedOffBuffFX }
            property("ScanDelayTime", IntValue) { it.scanDelayTime }
            property("ScanDistance", FloatValue) { it.scanDistance }
        },
    )
}
