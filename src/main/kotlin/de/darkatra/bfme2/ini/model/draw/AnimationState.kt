package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.ParticleSysBone
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

open class AnimationState(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StateName") open val stateName: Untyped? = null,
    @SageIniName("Flags") open val flags: Untyped? = null,
    @SageIniName("FrameForPristineBonePositions") open val frameForPristineBonePositions: Int = 0,
    @SageIniName("SimilarRestart") open val similarRestart: Boolean = false,
    @SageIniName("EnteringStateFX") open val enteringStateFX: SageReference<FXList>? = null,
    @SageIniName("ShareAnimation") open val shareAnimation: Boolean = false,
    @SageIniName("AllowRepeatInRandomPick") open val allowRepeatInRandomPick: Boolean = false,
    @SageIniName("ParticleSysBone") open val particleSysBone: List<ParticleSysBone> = emptyList(),
    @SageIniName("FXEvent") open val fXEvent: List<Untyped> = emptyList(),
    @SageIniName("LuaEvent") open val luaEvent: List<Untyped> = emptyList(),
    @SageIniName("BeginScript") open val beginScript: Opaque? = null,
    @SageIniName("Animation") open val animation: List<Animation> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<AnimationState>(
        name = "AnimationState",
        keyedByLabel = true,
        properties = {
            property("StateName", Untyped.type) { it.stateName }
            property("Flags", Untyped.type) { it.flags }
            property("FrameForPristineBonePositions", IntValue) { it.frameForPristineBonePositions }
            property("SimilarRestart", BooleanValue) { it.similarRestart }
            property("EnteringStateFX", ReferenceValue<FXList> { listOf(FXList) }) { it.enteringStateFX }
            property("ShareAnimation", BooleanValue) { it.shareAnimation }
            property("AllowRepeatInRandomPick", BooleanValue) { it.allowRepeatInRandomPick }
            property("ParticleSysBone", ListValue(ParticleSysBone.type)) { it.particleSysBone }
            property("FXEvent", ListValue(Untyped.type)) { it.fXEvent }
            property("LuaEvent", ListValue(Untyped.type)) { it.luaEvent }
            property("BeginScript", Opaque.type) { it.beginScript }
            property("Animation", ListValue(BlockValue<Animation> { listOf(Animation) })) { it.animation }
        },
    )
}
