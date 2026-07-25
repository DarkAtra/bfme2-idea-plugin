package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Opaque

data class GpuDraw(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("FramesPerRow") val framesPerRow: Int = 0,
    @SageIniName("TotalFrames") val totalFrames: Int = 0,
    @SageIniName("SpeedMultiplier") val speedMultiplier: Double = 0.0,
    @SageIniName("DetailTexture") val detailTexture: Opaque? = null,
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

    companion object : SageIniBlockDescriptor<GpuDraw>(
        name = "GpuDraw",
        parent = Draw,
        properties = {
            property("FramesPerRow", IntValue) { it.framesPerRow }
            property("TotalFrames", IntValue) { it.totalFrames }
            property("SpeedMultiplier", FloatValue) { it.speedMultiplier }
            property("DetailTexture", Opaque.type) { it.detailTexture }
        },
    )
}
