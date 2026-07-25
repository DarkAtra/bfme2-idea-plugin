package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageDraw
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue

open class Draw(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DefaultModelConditionState") open val defaultModelConditionState: List<DefaultModelConditionState> = emptyList(),
    @SageIniName("ModelConditionState") open val modelConditionState: List<ModelConditionState> = emptyList(),
    @SageIniName("ConditionState") open val conditionState: List<ModelConditionState> = emptyList(),
    @SageIniName("DefaultConditionState") open val defaultConditionState: List<DefaultModelConditionState> = emptyList(),
    @SageIniName("AliasConditionState") open val aliasConditionState: List<ModelConditionState> = emptyList(),
    @SageIniName("DefaultAnimationState") open val defaultAnimationState: List<DefaultAnimationState> = emptyList(),
    @SageIniName("IdleAnimationState") open val idleAnimationState: List<IdleAnimationState> = emptyList(),
    @SageIniName("AnimationState") open val animationState: List<AnimationState> = emptyList(),
    @SageIniName("TransitionState") open val transitionState: List<TransitionState> = emptyList(),
    @SageIniName("LodOptions") open val lodOptions: List<LodOptions> = emptyList(),
) : SageDraw {

    companion object : SageIniBlockDescriptor<Draw>(
        name = "Draw",
        properties = {
            property(
                "DefaultModelConditionState",
                ListValue(BlockValue<DefaultModelConditionState> { listOf(DefaultModelConditionState) })
            ) { it.defaultModelConditionState }
            property(
                "ModelConditionState",
                ListValue(BlockValue<ModelConditionState> { listOf(ModelConditionState, DefaultModelConditionState) })
            ) { it.modelConditionState }
            property(
                "ConditionState",
                ListValue(BlockValue<ModelConditionState> { listOf(ModelConditionState, DefaultModelConditionState) })
            ) { it.conditionState }
            property(
                "DefaultConditionState",
                ListValue(BlockValue<DefaultModelConditionState> { listOf(DefaultModelConditionState) })
            ) { it.defaultConditionState }
            property(
                "AliasConditionState",
                ListValue(BlockValue<ModelConditionState> { listOf(ModelConditionState, DefaultModelConditionState) })
            ) { it.aliasConditionState }
            property("DefaultAnimationState", ListValue(BlockValue<DefaultAnimationState> { listOf(DefaultAnimationState) })) { it.defaultAnimationState }
            property("IdleAnimationState", ListValue(BlockValue<IdleAnimationState> { listOf(IdleAnimationState) })) { it.idleAnimationState }
            property(
                "AnimationState",
                ListValue(BlockValue<AnimationState> { listOf(AnimationState, DefaultAnimationState, IdleAnimationState, TransitionState) })
            ) { it.animationState }
            property("TransitionState", ListValue(BlockValue<TransitionState> { listOf(TransitionState) })) { it.transitionState }
            property("LodOptions", ListValue(BlockValue<LodOptions> { listOf(LodOptions) })) { it.lodOptions }
        },
    )
}
