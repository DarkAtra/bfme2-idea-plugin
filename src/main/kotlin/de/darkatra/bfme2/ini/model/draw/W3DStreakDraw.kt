package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

data class W3DStreakDraw(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Length") val length: Double = 0.0,
    @SageIniName("Width") val width: Double = 0.0,
    @SageIniName("NumSegments") val numSegments: Int = 0,
    @SageIniName("Color") val color: Rgba? = null,
    @SageIniName("Texture") val texture: TextureFile? = null,
    @SageIniName("Additive") val additive: Boolean = false,
    @SageIniName("WeatherTexture") val weatherTexture: List<Untyped> = emptyList(),
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

    companion object : SageIniBlockDescriptor<W3DStreakDraw>(
        name = "W3DStreakDraw",
        parent = Draw,
        properties = {
            property("Length", FloatValue) { it.length }
            property("Width", FloatValue) { it.width }
            property("NumSegments", IntValue) { it.numSegments }
            property("Color", Rgba.type) { it.color }
            property("Texture", TextureFile.type) { it.texture }
            property("Additive", BooleanValue) { it.additive }
            property("WeatherTexture", ListValue(Untyped.type)) { it.weatherTexture }
        },
    )
}
