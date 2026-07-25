package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

open class GateBehavior(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("OpenByDefault") open val openByDefault: Boolean = false,
    @SageIniName("ResetTimeInMilliseconds") open val resetTimeInMilliseconds: Int = 0,
    @SageIniName("PercentOpenForPathing") open val percentOpenForPathing: Int = 0,
    @SageIniName("Proxy") open val proxy: Untyped? = null,
    @SageIniName("RepelCollidingUnits") open val repelCollidingUnits: Boolean = false,
    @SageIniName("GeometryForOpen") open val geometryForOpen: List<Untyped> = emptyList(),
    @SageIniName("GeometryForClosed") open val geometryForClosed: List<Untyped> = emptyList(),
    @SageIniName("SoundOpeningGateLoop") open val soundOpeningGateLoop: SageReference<AudioEvent>? = null,
    @SageIniName("SoundFinishedOpeningGate") open val soundFinishedOpeningGate: SageReference<AudioEvent>? = null,
    @SageIniName("SoundClosingGateLoop") open val soundClosingGateLoop: SageReference<AudioEvent>? = null,
    @SageIniName("SoundFinishedClosingGate") open val soundFinishedClosingGate: SageReference<AudioEvent>? = null,
    @SageIniName("TimeBeforePlayingOpenSound") open val timeBeforePlayingOpenSound: Int = 0,
    @SageIniName("TimeBeforePlayingClosedSound") open val timeBeforePlayingClosedSound: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<GateBehavior>(
        name = "GateBehavior",
        properties = {
            property("OpenByDefault", BooleanValue) { it.openByDefault }
            property("ResetTimeInMilliseconds", IntValue) { it.resetTimeInMilliseconds }
            property("PercentOpenForPathing", IntValue) { it.percentOpenForPathing }
            property("Proxy", Untyped.type) { it.proxy }
            property("RepelCollidingUnits", BooleanValue) { it.repelCollidingUnits }
            property("GeometryForOpen", ListValue(Untyped.type)) { it.geometryForOpen }
            property("GeometryForClosed", ListValue(Untyped.type)) { it.geometryForClosed }
            property("SoundOpeningGateLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundOpeningGateLoop }
            property("SoundFinishedOpeningGate", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundFinishedOpeningGate }
            property("SoundClosingGateLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundClosingGateLoop }
            property("SoundFinishedClosingGate", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundFinishedClosingGate }
            property("TimeBeforePlayingOpenSound", IntValue) { it.timeBeforePlayingOpenSound }
            property("TimeBeforePlayingClosedSound", IntValue) { it.timeBeforePlayingClosedSound }
        },
    )
}
