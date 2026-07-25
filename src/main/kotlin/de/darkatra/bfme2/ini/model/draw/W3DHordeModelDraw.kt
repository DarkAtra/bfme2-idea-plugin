package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

data class W3DHordeModelDraw(
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
    @SageIniName("UseStandardModelNames") override val useStandardModelNames: Boolean = false,
    @SageIniName("StaticModelLODMode") override val staticModelLODMode: Boolean = false,
    @SageIniName("MultiPlayerOnly") override val multiPlayerOnly: Boolean = false,
    @SageIniName("AffectedByStealth") override val affectedByStealth: Boolean = false,
    @SageIniName("GlowEnabled") override val glowEnabled: Boolean = false,
    @SageIniName("GlowEmissive") override val glowEmissive: Boolean = false,
    @SageIniName("ShowShadowWhileContained") override val showShadowWhileContained: Boolean = false,
    @SageIniName("UseProducerTexture") override val useProducerTexture: Boolean = false,
    @SageIniName("UseDefaultAnimation") override val useDefaultAnimation: Boolean = false,
    @SageIniName("NoRotate") override val noRotate: Boolean = false,
    @SageIniName("RandomTextureFixedRandomIndex") override val randomTextureFixedRandomIndex: Boolean = false,
    @SageIniName("HighDetailOnly") override val highDetailOnly: Boolean = false,
    @SageIniName("ShadowForceDisable") override val shadowForceDisable: Boolean = false,
    @SageIniName("RandomTexture") override val randomTexture: List<Opaque> = emptyList(),
    @SageIniName("WallBoundsMesh") override val wallBoundsMesh: Opaque? = null,
    @SageIniName("RaisedWallMesh") override val raisedWallMesh: Opaque? = null,
    @SageIniName("RampMesh1") override val rampMesh1: Opaque? = null,
    @SageIniName("RampMesh2") override val rampMesh2: Opaque? = null,
    @SageIniName("WadingParticleSys") override val wadingParticleSys: Opaque? = null,
    @SageIniName("DependencySharedModelFlags") override val dependencySharedModelFlags: Untyped? = null,
    @SageIniName("AlphaCameraFadeOuterRadius") override val alphaCameraFadeOuterRadius: Int = 0,
    @SageIniName("AlphaCameraFadeInnerRadius") override val alphaCameraFadeInnerRadius: Int = 0,
    @SageIniName("AlphaCameraAtInnerRadius") override val alphaCameraAtInnerRadius: Double = 0.0,
    @SageIniName("StaticSortLevelWhileFading") override val staticSortLevelWhileFading: Int = 0,
    @SageIniName("BirthFadeAdditive") override val birthFadeAdditive: Boolean = false,
    @SageIniName("BirthFadeTime") override val birthFadeTime: Int = 0,
    @SageIniName("TimeOfDayTexture") override val timeOfDayTexture: List<Untyped> = emptyList(),
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
) : W3DScriptedModelDraw() {

    companion object : SageIniBlockDescriptor<W3DHordeModelDraw>(
        name = "W3DHordeModelDraw",
        parent = W3DScriptedModelDraw,
    )
}
