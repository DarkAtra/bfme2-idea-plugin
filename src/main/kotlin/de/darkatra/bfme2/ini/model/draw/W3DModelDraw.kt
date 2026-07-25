package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

open class W3DModelDraw(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("IgnoreConditionStates") open val ignoreConditionStates: Untyped? = null,
    @SageIniName("OkToChangeModelColor") open val okToChangeModelColor: Boolean = false,
    @SageIniName("ReceivesDynamicLights") open val receivesDynamicLights: Boolean = false,
    @SageIniName("ProjectileBoneFeedbackEnabledSlots") open val projectileBoneFeedbackEnabledSlots: Untyped? = null,
    @SageIniName("AnimationsRequirePower") open val animationsRequirePower: Boolean = false,
    @SageIniName("ParticlesAttachedToAnimatedBones") open val particlesAttachedToAnimatedBones: Boolean = false,
    @SageIniName("MinLODRequired") open val minLODRequired: Untyped? = null,
    @SageIniName("ExtraPublicBone") open val extraPublicBone: List<Opaque> = emptyList(),
    @SageIniName("AttachToBoneInAnotherModule") open val attachToBoneInAnotherModule: Opaque? = null,
    @SageIniName("TrackMarks") open val trackMarks: TextureFile? = null,
    @SageIniName("TrackMarksLeftBone") open val trackMarksLeftBone: Opaque? = null,
    @SageIniName("TrackMarksRightBone") open val trackMarksRightBone: Opaque? = null,
    @SageIniName("InitialRecoilSpeed") open val initialRecoilSpeed: Double = 0.0,
    @SageIniName("MaxRecoilDistance") open val maxRecoilDistance: Double = 0.0,
    @SageIniName("RecoilSettleSpeed") open val recoilSettleSpeed: Double = 0.0,
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
) : Draw() {

    companion object : SageIniBlockDescriptor<W3DModelDraw>(
        name = "W3DModelDraw",
        parent = Draw,
        properties = {
            property("IgnoreConditionStates", Untyped.type) { it.ignoreConditionStates }
            property("OkToChangeModelColor", BooleanValue) { it.okToChangeModelColor }
            property("ReceivesDynamicLights", BooleanValue) { it.receivesDynamicLights }
            property("ProjectileBoneFeedbackEnabledSlots", Untyped.type) { it.projectileBoneFeedbackEnabledSlots }
            property("AnimationsRequirePower", BooleanValue) { it.animationsRequirePower }
            property("ParticlesAttachedToAnimatedBones", BooleanValue) { it.particlesAttachedToAnimatedBones }
            property("MinLODRequired", Untyped.type) { it.minLODRequired }
            property("ExtraPublicBone", ListValue(Opaque.type)) { it.extraPublicBone }
            property("AttachToBoneInAnotherModule", Opaque.type) { it.attachToBoneInAnotherModule }
            property("TrackMarks", TextureFile.type) { it.trackMarks }
            property("TrackMarksLeftBone", Opaque.type) { it.trackMarksLeftBone }
            property("TrackMarksRightBone", Opaque.type) { it.trackMarksRightBone }
            property("InitialRecoilSpeed", FloatValue) { it.initialRecoilSpeed }
            property("MaxRecoilDistance", FloatValue) { it.maxRecoilDistance }
            property("RecoilSettleSpeed", FloatValue) { it.recoilSettleSpeed }
        },
    )
}
