package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.ModelFile
import de.darkatra.bfme2.ini.model.value.Untyped

data class W3DFloorDraw(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("FloorFadeRateOnObjectDeath") val floorFadeRateOnObjectDeath: Double = 0.0,
    @SageIniName("ModelName") val modelName: ModelFile? = null,
    @SageIniName("HideIfModelConditions") val hideIfModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("WeatherTexture") val weatherTexture: List<Untyped> = emptyList(),
    @SageIniName("StaticModelLODMode") val staticModelLODMode: Boolean = false,
    @SageIniName("StartHidden") val startHidden: Boolean = false,
    @SageIniName("ForceToBack") val forceToBack: Boolean = false,
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

    companion object : SageIniBlockDescriptor<W3DFloorDraw>(
        name = "W3DFloorDraw",
        parent = Draw,
        properties = {
            property("FloorFadeRateOnObjectDeath", FloatValue) { it.floorFadeRateOnObjectDeath }
            property("ModelName", ModelFile.type) { it.modelName }
            property("HideIfModelConditions", ListValue(ModelCondition.type)) { it.hideIfModelConditions }
            property("WeatherTexture", ListValue(Untyped.type)) { it.weatherTexture }
            property("StaticModelLODMode", BooleanValue) { it.staticModelLODMode }
            property("StartHidden", BooleanValue) { it.startHidden }
            property("ForceToBack", BooleanValue) { it.forceToBack }
        },
    )
}
