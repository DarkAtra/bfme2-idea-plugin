package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

open class W3DScriptedModelDraw(
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
    @SageIniName("UseStandardModelNames") open val useStandardModelNames: Boolean = false,
    @SageIniName("StaticModelLODMode") open val staticModelLODMode: Boolean = false,
    @SageIniName("MultiPlayerOnly") open val multiPlayerOnly: Boolean = false,
    @SageIniName("AffectedByStealth") open val affectedByStealth: Boolean = false,
    @SageIniName("GlowEnabled") open val glowEnabled: Boolean = false,
    @SageIniName("GlowEmissive") open val glowEmissive: Boolean = false,
    @SageIniName("ShowShadowWhileContained") open val showShadowWhileContained: Boolean = false,
    @SageIniName("UseProducerTexture") open val useProducerTexture: Boolean = false,
    @SageIniName("UseDefaultAnimation") open val useDefaultAnimation: Boolean = false,
    @SageIniName("NoRotate") open val noRotate: Boolean = false,
    @SageIniName("RandomTextureFixedRandomIndex") open val randomTextureFixedRandomIndex: Boolean = false,
    @SageIniName("HighDetailOnly") open val highDetailOnly: Boolean = false,
    @SageIniName("ShadowForceDisable") open val shadowForceDisable: Boolean = false,
    @SageIniName("RandomTexture") open val randomTexture: List<Opaque> = emptyList(),
    @SageIniName("WallBoundsMesh") open val wallBoundsMesh: Opaque? = null,
    @SageIniName("RaisedWallMesh") open val raisedWallMesh: Opaque? = null,
    @SageIniName("RampMesh1") open val rampMesh1: Opaque? = null,
    @SageIniName("RampMesh2") open val rampMesh2: Opaque? = null,
    @SageIniName("WadingParticleSys") open val wadingParticleSys: Opaque? = null,
    @SageIniName("DependencySharedModelFlags") open val dependencySharedModelFlags: Untyped? = null,
    @SageIniName("AlphaCameraFadeOuterRadius") open val alphaCameraFadeOuterRadius: Int = 0,
    @SageIniName("AlphaCameraFadeInnerRadius") open val alphaCameraFadeInnerRadius: Int = 0,
    @SageIniName("AlphaCameraAtInnerRadius") open val alphaCameraAtInnerRadius: Double = 0.0,
    @SageIniName("StaticSortLevelWhileFading") open val staticSortLevelWhileFading: Int = 0,
    @SageIniName("BirthFadeAdditive") open val birthFadeAdditive: Boolean = false,
    @SageIniName("BirthFadeTime") open val birthFadeTime: Int = 0,
    @SageIniName("TimeOfDayTexture") open val timeOfDayTexture: List<Untyped> = emptyList(),
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

    companion object : SageIniBlockDescriptor<W3DScriptedModelDraw>(
        name = "W3DScriptedModelDraw",
        parent = W3DModelDraw,
        properties = {
            property("UseStandardModelNames", BooleanValue) { it.useStandardModelNames }
            property("StaticModelLODMode", BooleanValue) { it.staticModelLODMode }
            property("MultiPlayerOnly", BooleanValue) { it.multiPlayerOnly }
            property("AffectedByStealth", BooleanValue) { it.affectedByStealth }
            property("GlowEnabled", BooleanValue) { it.glowEnabled }
            property("GlowEmissive", BooleanValue) { it.glowEmissive }
            property("ShowShadowWhileContained", BooleanValue) { it.showShadowWhileContained }
            property("UseProducerTexture", BooleanValue) { it.useProducerTexture }
            property("UseDefaultAnimation", BooleanValue) { it.useDefaultAnimation }
            property("NoRotate", BooleanValue) { it.noRotate }
            property("RandomTextureFixedRandomIndex", BooleanValue) { it.randomTextureFixedRandomIndex }
            property("HighDetailOnly", BooleanValue) { it.highDetailOnly }
            property("ShadowForceDisable", BooleanValue) { it.shadowForceDisable }
            property("RandomTexture", ListValue(Opaque.type)) { it.randomTexture }
            property("WallBoundsMesh", Opaque.type) { it.wallBoundsMesh }
            property("RaisedWallMesh", Opaque.type) { it.raisedWallMesh }
            property("RampMesh1", Opaque.type) { it.rampMesh1 }
            property("RampMesh2", Opaque.type) { it.rampMesh2 }
            property("WadingParticleSys", Opaque.type) { it.wadingParticleSys }
            property("DependencySharedModelFlags", Untyped.type) { it.dependencySharedModelFlags }
            property("AlphaCameraFadeOuterRadius", IntValue) { it.alphaCameraFadeOuterRadius }
            property("AlphaCameraFadeInnerRadius", IntValue) { it.alphaCameraFadeInnerRadius }
            property("AlphaCameraAtInnerRadius", FloatValue) { it.alphaCameraAtInnerRadius }
            property("StaticSortLevelWhileFading", IntValue) { it.staticSortLevelWhileFading }
            property("BirthFadeAdditive", BooleanValue) { it.birthFadeAdditive }
            property("BirthFadeTime", IntValue) { it.birthFadeTime }
            property("TimeOfDayTexture", ListValue(Untyped.type)) { it.timeOfDayTexture }
        },
    )
}
