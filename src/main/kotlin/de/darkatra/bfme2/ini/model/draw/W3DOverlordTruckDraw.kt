package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

data class W3DOverlordTruckDraw(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("IgnoreConditionStates") override val ignoreConditionStates: Untyped? = null,
    @SageIniName("OkToChangeModelColor") override val okToChangeModelColor: Boolean = false,
    @SageIniName("ReceivesDynamicLights") override val receivesDynamicLights: Boolean = false,
    @SageIniName("ProjectileBoneFeedbackEnabledSlots") override val projectileBoneFeedbackEnabledSlots: Untyped? = null,
    @SageIniName("AnimationsRequirePower") override val animationsRequirePower: Boolean = false,
    @SageIniName("ParticlesAttachedToAnimatedBones") override val particlesAttachedToAnimatedBones: Boolean = false,
    @SageIniName("MinLODRequired") override val minLODRequired: Untyped? = null,
    @SageIniName("ExtraPublicBone") override val extraPublicBone: List<Opaque> = emptyList(),
    @SageIniName("AttachToBoneInAnotherModule") override val attachToBoneInAnotherModule: Opaque? = null,
    @SageIniName("TrackMarks") override val trackMarks: TextureFile? = null,
    @SageIniName("TrackMarksLeftBone") override val trackMarksLeftBone: Opaque? = null,
    @SageIniName("TrackMarksRightBone") override val trackMarksRightBone: Opaque? = null,
    @SageIniName("InitialRecoilSpeed") override val initialRecoilSpeed: Double = 0.0,
    @SageIniName("MaxRecoilDistance") override val maxRecoilDistance: Double = 0.0,
    @SageIniName("RecoilSettleSpeed") override val recoilSettleSpeed: Double = 0.0,
    @SageIniName("StaticModelLODMode") override val staticModelLODMode: Boolean = false,
    @SageIniName("TireRotationMultiplier") override val tireRotationMultiplier: Double = 0.0,
    @SageIniName("PowerslideRotationAddition") override val powerslideRotationAddition: Double = 0.0,
    @SageIniName("WadingParticleSys") override val wadingParticleSys: String = "",
    @SageIniName("DependencySharedModelFlags") override val dependencySharedModelFlags: Untyped? = null,
    @SageIniName("LeftFrontTireBone") override val leftFrontTireBone: Opaque? = null,
    @SageIniName("RightFrontTireBone") override val rightFrontTireBone: Opaque? = null,
    @SageIniName("LeftRearTireBone") override val leftRearTireBone: Opaque? = null,
    @SageIniName("RightRearTireBone") override val rightRearTireBone: Opaque? = null,
    @SageIniName("LeftFrontTireBone2") override val leftFrontTireBone2: Opaque? = null,
    @SageIniName("RightFrontTireBone2") override val rightFrontTireBone2: Opaque? = null,
    @SageIniName("LeftRearTireBone2") override val leftRearTireBone2: Opaque? = null,
    @SageIniName("RightRearTireBone2") override val rightRearTireBone2: Opaque? = null,
    @SageIniName("MidLeftMidTireBone") override val midLeftMidTireBone: Opaque? = null,
    @SageIniName("MidLeftMidTireBone2") override val midLeftMidTireBone2: Opaque? = null,
    @SageIniName("MidRightMidTireBone") override val midRightMidTireBone: Opaque? = null,
    @SageIniName("MidRightMidTireBone2") override val midRightMidTireBone2: Opaque? = null,
    @SageIniName("MidLeftFrontTireBone") override val midLeftFrontTireBone: Opaque? = null,
    @SageIniName("MidRightFrontTireBone") override val midRightFrontTireBone: Opaque? = null,
    @SageIniName("MidLeftRearTireBone") override val midLeftRearTireBone: Opaque? = null,
    @SageIniName("MidRightRearTireBone") override val midRightRearTireBone: Opaque? = null,
    @SageIniName("CabBone") override val cabBone: Opaque? = null,
    @SageIniName("TrailerBone") override val trailerBone: Opaque? = null,
    @SageIniName("CabRotationMultiplier") override val cabRotationMultiplier: Double = 0.0,
    @SageIniName("TrailerRotationMultiplier") override val trailerRotationMultiplier: Double = 0.0,
    @SageIniName("RotationDamping") override val rotationDamping: Double = 0.0,
    @SageIniName("Dust") override val dust: Opaque? = null,
    @SageIniName("DirtSpray") override val dirtSpray: Opaque? = null,
    @SageIniName("PowerslideSpray") override val powerslideSpray: Opaque? = null,
    @SageIniName("RandomTexture") override val randomTexture: List<Opaque> = emptyList(),
    @SageIniName("DefaultModelConditionState") override val defaultModelConditionState: List<DefaultModelConditionState> = emptyList(),
    @SageIniName("ModelConditionState") override val modelConditionState: List<ModelConditionState> = emptyList(),
    @SageIniName("ConditionState") override val conditionState: List<ModelConditionState> = emptyList(),
    @SageIniName("DefaultConditionState") override val defaultConditionState: List<DefaultModelConditionState> = emptyList(),
    @SageIniName("AliasConditionState") override val aliasConditionState: List<ModelConditionState> = emptyList(),
    @SageIniName("DefaultAnimationState") override val defaultAnimationState: List<DefaultAnimationState> = emptyList(),
    @SageIniName("IdleAnimationState") override val idleAnimationState: List<IdleAnimationState> = emptyList(),
    @SageIniName("AnimationState") override val animationState: List<AnimationState> = emptyList(),
    @SageIniName("TransitionState") override val transitionState: List<TransitionState> = emptyList(),
    @SageIniName("LodOptions") override val lodOptions: List<LodOptions> = emptyList(),
) : W3DTruckDraw() {

    companion object : SageIniBlockDescriptor<W3DOverlordTruckDraw>(
        name = "W3DOverlordTruckDraw",
        parent = W3DTruckDraw,
    )
}
