package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.value.ModelFile
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.TextureFile

data class W3DTreeDraw(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DoShadow") val doShadow: Boolean = false,
    @SageIniName("ModelName") val modelName: ModelFile? = null,
    @SageIniName("TextureName") val textureName: TextureFile? = null,
    @SageIniName("MorphTree") val morphTree: String = "",
    @SageIniName("SinkTime") val sinkTime: Int = 0,
    @SageIniName("DoTopple") val doTopple: Boolean = false,
    @SageIniName("KillWhenFinishedToppling") val killWhenFinishedToppling: Boolean = false,
    @SageIniName("TaintedTree") val taintedTree: Boolean = false,
    @SageIniName("ToppleFX") val toppleFX: SageReference<FXList>? = null,
    @SageIniName("BounceFX") val bounceFX: SageReference<FXList>? = null,
    @SageIniName("MorphFX") val morphFX: SageReference<FXList>? = null,
    @SageIniName("DarkeningFactor") val darkeningFactor: Rgba? = null,
    @SageIniName("SinkDistance") val sinkDistance: Double = 0.0,
    @SageIniName("MoveOutwardDistanceFactor") val moveOutwardDistanceFactor: Double = 0.0,
    @SageIniName("FadeDistance") val fadeDistance: Double = 0.0,
    @SageIniName("FadeTarget") val fadeTarget: Double = 0.0,
    @SageIniName("MoveOutwardTime") val moveOutwardTime: Int = 0,
    @SageIniName("MoveInwardTime") val moveInwardTime: Int = 0,
    @SageIniName("MorphTime") val morphTime: Int = 0,
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

    companion object : SageIniBlockDescriptor<W3DTreeDraw>(
        name = "W3DTreeDraw",
        parent = Draw,
        properties = {
            property("DoShadow", BooleanValue) { it.doShadow }
            property("ModelName", ModelFile.type) { it.modelName }
            property("TextureName", TextureFile.type) { it.textureName }
            property("MorphTree", StringValue) { it.morphTree }
            property("SinkTime", IntValue) { it.sinkTime }
            property("DoTopple", BooleanValue) { it.doTopple }
            property("KillWhenFinishedToppling", BooleanValue) { it.killWhenFinishedToppling }
            property("TaintedTree", BooleanValue) { it.taintedTree }
            property("ToppleFX", ReferenceValue<FXList> { listOf(FXList) }) { it.toppleFX }
            property("BounceFX", ReferenceValue<FXList> { listOf(FXList) }) { it.bounceFX }
            property("MorphFX", ReferenceValue<FXList> { listOf(FXList) }) { it.morphFX }
            property("DarkeningFactor", Rgba.type) { it.darkeningFactor }
            property("SinkDistance", FloatValue) { it.sinkDistance }
            property("MoveOutwardDistanceFactor", FloatValue) { it.moveOutwardDistanceFactor }
            property("FadeDistance", FloatValue) { it.fadeDistance }
            property("FadeTarget", FloatValue) { it.fadeTarget }
            property("MoveOutwardTime", IntValue) { it.moveOutwardTime }
            property("MoveInwardTime", IntValue) { it.moveInwardTime }
            property("MorphTime", IntValue) { it.morphTime }
        },
    )
}
