package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

data class W3DScienceModelDraw(
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
    @SageIniName("RequiredScience") val requiredScience: SageReference<Science>? = null,
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

    companion object : SageIniBlockDescriptor<W3DScienceModelDraw>(
        name = "W3DScienceModelDraw",
        parent = W3DModelDraw,
        properties = {
            property("RequiredScience", ReferenceValue<Science> { listOf(Science) }) { it.requiredScience }
        },
    )
}
