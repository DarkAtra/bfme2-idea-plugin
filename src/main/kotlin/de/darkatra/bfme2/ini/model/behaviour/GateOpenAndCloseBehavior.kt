package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class GateOpenAndCloseBehavior(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("OpenByDefault") override val openByDefault: Boolean = false,
    @SageIniName("ResetTimeInMilliseconds") override val resetTimeInMilliseconds: Int = 0,
    @SageIniName("PercentOpenForPathing") override val percentOpenForPathing: Int = 0,
    @SageIniName("Proxy") override val proxy: Untyped? = null,
    @SageIniName("RepelCollidingUnits") override val repelCollidingUnits: Boolean = false,
    @SageIniName("GeometryForOpen") override val geometryForOpen: List<Untyped> = emptyList(),
    @SageIniName("GeometryForClosed") override val geometryForClosed: List<Untyped> = emptyList(),
    @SageIniName("SoundOpeningGateLoop") override val soundOpeningGateLoop: SageReference<AudioEvent>? = null,
    @SageIniName("SoundFinishedOpeningGate") override val soundFinishedOpeningGate: SageReference<AudioEvent>? = null,
    @SageIniName("SoundClosingGateLoop") override val soundClosingGateLoop: SageReference<AudioEvent>? = null,
    @SageIniName("SoundFinishedClosingGate") override val soundFinishedClosingGate: SageReference<AudioEvent>? = null,
    @SageIniName("TimeBeforePlayingOpenSound") override val timeBeforePlayingOpenSound: Int = 0,
    @SageIniName("TimeBeforePlayingClosedSound") override val timeBeforePlayingClosedSound: Int = 0,
) : GateBehavior() {

    companion object : SageIniBlockDescriptor<GateOpenAndCloseBehavior>(
        name = "GateOpenAndCloseBehavior",
        parent = GateBehavior,
    )
}
