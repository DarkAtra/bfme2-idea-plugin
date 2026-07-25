package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName

data class W3DBoatWakeModelDraw(
    override val header: SageBlockHeader = SageBlockHeader(),
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

    companion object : SageIniBlockDescriptor<W3DBoatWakeModelDraw>(
        name = "W3DBoatWakeModelDraw",
        parent = Draw,
    )
}
