package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.ParticleSysBone
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class IdleAnimationState(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StateName") override val stateName: Untyped? = null,
    @SageIniName("Flags") override val flags: Untyped? = null,
    @SageIniName("FrameForPristineBonePositions") override val frameForPristineBonePositions: Int = 0,
    @SageIniName("SimilarRestart") override val similarRestart: Boolean = false,
    @SageIniName("EnteringStateFX") override val enteringStateFX: SageReference<FXList>? = null,
    @SageIniName("ShareAnimation") override val shareAnimation: Boolean = false,
    @SageIniName("AllowRepeatInRandomPick") override val allowRepeatInRandomPick: Boolean = false,
    @SageIniName("ParticleSysBone") override val particleSysBone: List<ParticleSysBone> = emptyList(),
    @SageIniName("FXEvent") override val fXEvent: List<Untyped> = emptyList(),
    @SageIniName("LuaEvent") override val luaEvent: List<Untyped> = emptyList(),
    @SageIniName("BeginScript") override val beginScript: Opaque? = null,
    @SageIniName("Animation") override val animation: List<Animation> = emptyList(),
) : AnimationState() {

    companion object : SageIniBlockDescriptor<IdleAnimationState>(
        name = "IdleAnimationState",
        parent = AnimationState,
    )
}
