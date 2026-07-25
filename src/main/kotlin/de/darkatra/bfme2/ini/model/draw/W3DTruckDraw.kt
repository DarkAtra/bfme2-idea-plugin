package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

open class W3DTruckDraw(
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
    @SageIniName("StaticModelLODMode") open val staticModelLODMode: Boolean = false,
    @SageIniName("TireRotationMultiplier") open val tireRotationMultiplier: Double = 0.0,
    @SageIniName("PowerslideRotationAddition") open val powerslideRotationAddition: Double = 0.0,
    @SageIniName("WadingParticleSys") open val wadingParticleSys: String = "",
    @SageIniName("DependencySharedModelFlags") open val dependencySharedModelFlags: Untyped? = null,
    @SageIniName("LeftFrontTireBone") open val leftFrontTireBone: Opaque? = null,
    @SageIniName("RightFrontTireBone") open val rightFrontTireBone: Opaque? = null,
    @SageIniName("LeftRearTireBone") open val leftRearTireBone: Opaque? = null,
    @SageIniName("RightRearTireBone") open val rightRearTireBone: Opaque? = null,
    @SageIniName("LeftFrontTireBone2") open val leftFrontTireBone2: Opaque? = null,
    @SageIniName("RightFrontTireBone2") open val rightFrontTireBone2: Opaque? = null,
    @SageIniName("LeftRearTireBone2") open val leftRearTireBone2: Opaque? = null,
    @SageIniName("RightRearTireBone2") open val rightRearTireBone2: Opaque? = null,
    @SageIniName("MidLeftMidTireBone") open val midLeftMidTireBone: Opaque? = null,
    @SageIniName("MidLeftMidTireBone2") open val midLeftMidTireBone2: Opaque? = null,
    @SageIniName("MidRightMidTireBone") open val midRightMidTireBone: Opaque? = null,
    @SageIniName("MidRightMidTireBone2") open val midRightMidTireBone2: Opaque? = null,
    @SageIniName("MidLeftFrontTireBone") open val midLeftFrontTireBone: Opaque? = null,
    @SageIniName("MidRightFrontTireBone") open val midRightFrontTireBone: Opaque? = null,
    @SageIniName("MidLeftRearTireBone") open val midLeftRearTireBone: Opaque? = null,
    @SageIniName("MidRightRearTireBone") open val midRightRearTireBone: Opaque? = null,
    @SageIniName("CabBone") open val cabBone: Opaque? = null,
    @SageIniName("TrailerBone") open val trailerBone: Opaque? = null,
    @SageIniName("CabRotationMultiplier") open val cabRotationMultiplier: Double = 0.0,
    @SageIniName("TrailerRotationMultiplier") open val trailerRotationMultiplier: Double = 0.0,
    @SageIniName("RotationDamping") open val rotationDamping: Double = 0.0,
    @SageIniName("Dust") open val dust: Opaque? = null,
    @SageIniName("DirtSpray") open val dirtSpray: Opaque? = null,
    @SageIniName("PowerslideSpray") open val powerslideSpray: Opaque? = null,
    @SageIniName("RandomTexture") open val randomTexture: List<Opaque> = emptyList(),
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
) : W3DModelDraw() {

    companion object : SageIniBlockDescriptor<W3DTruckDraw>(
        name = "W3DTruckDraw",
        parent = W3DModelDraw,
        properties = {
            property("StaticModelLODMode", BooleanValue) { it.staticModelLODMode }
            property("TireRotationMultiplier", FloatValue) { it.tireRotationMultiplier }
            property("PowerslideRotationAddition", FloatValue) { it.powerslideRotationAddition }
            property("WadingParticleSys", StringValue) { it.wadingParticleSys }
            property("DependencySharedModelFlags", Untyped.type) { it.dependencySharedModelFlags }
            property("LeftFrontTireBone", Opaque.type) { it.leftFrontTireBone }
            property("RightFrontTireBone", Opaque.type) { it.rightFrontTireBone }
            property("LeftRearTireBone", Opaque.type) { it.leftRearTireBone }
            property("RightRearTireBone", Opaque.type) { it.rightRearTireBone }
            property("LeftFrontTireBone2", Opaque.type) { it.leftFrontTireBone2 }
            property("RightFrontTireBone2", Opaque.type) { it.rightFrontTireBone2 }
            property("LeftRearTireBone2", Opaque.type) { it.leftRearTireBone2 }
            property("RightRearTireBone2", Opaque.type) { it.rightRearTireBone2 }
            property("MidLeftMidTireBone", Opaque.type) { it.midLeftMidTireBone }
            property("MidLeftMidTireBone2", Opaque.type) { it.midLeftMidTireBone2 }
            property("MidRightMidTireBone", Opaque.type) { it.midRightMidTireBone }
            property("MidRightMidTireBone2", Opaque.type) { it.midRightMidTireBone2 }
            property("MidLeftFrontTireBone", Opaque.type) { it.midLeftFrontTireBone }
            property("MidRightFrontTireBone", Opaque.type) { it.midRightFrontTireBone }
            property("MidLeftRearTireBone", Opaque.type) { it.midLeftRearTireBone }
            property("MidRightRearTireBone", Opaque.type) { it.midRightRearTireBone }
            property("CabBone", Opaque.type) { it.cabBone }
            property("TrailerBone", Opaque.type) { it.trailerBone }
            property("CabRotationMultiplier", FloatValue) { it.cabRotationMultiplier }
            property("TrailerRotationMultiplier", FloatValue) { it.trailerRotationMultiplier }
            property("RotationDamping", FloatValue) { it.rotationDamping }
            property("Dust", Opaque.type) { it.dust }
            property("DirtSpray", Opaque.type) { it.dirtSpray }
            property("PowerslideSpray", Opaque.type) { it.powerslideSpray }
            property("RandomTexture", ListValue(Opaque.type)) { it.randomTexture }
        },
    )
}
