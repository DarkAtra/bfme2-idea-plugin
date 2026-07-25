package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.MappedImage
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class Animation(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AnimationName") val animationName: Untyped? = null,
    @SageIniName("AnimationMode") val animationMode: Untyped? = null,
    @SageIniName("AnimationBlendTime") val animationBlendTime: Int = 0,
    @SageIniName("AnimationPriority") val animationPriority: Int = 0,
    @SageIniName("AnimationSpeedFactorRange") val animationSpeedFactorRange: List<Double> = emptyList(),
    @SageIniName("AnimationMustCompleteCount") val animationMustCompleteCount: Int = 0,
    @SageIniName("UseWeaponTiming") val useWeaponTiming: Boolean = false,
    @SageIniName("DistanceCovered") val distanceCovered: Double = 0.0,
    @SageIniName("Distance") val distance: Double = 0.0,
    @SageIniName("AnimationMustCompleteBlend") val animationMustCompleteBlend: Boolean = false,
    @SageIniName("FadeBeginFrame") val fadeBeginFrame: Double = 0.0,
    @SageIniName("FadeEndFrame") val fadeEndFrame: Double = 0.0,
    @SageIniName("FadingIn") val fadingIn: Boolean = false,
    @SageIniName("AnimationDelay") val animationDelay: Int = 0,
    @SageIniName("Image") val image: SageReference<MappedImage>? = null,
    @SageIniName("NumberImages") val numberImages: Int = 0,
    @SageIniName("RandomizeStartFrame") val randomizeStartFrame: Boolean = false,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Animation>(
        name = "Animation",
        keyedByLabel = true,
        properties = {
            property("AnimationName", Untyped.type) { it.animationName }
            property("AnimationMode", Untyped.type) { it.animationMode }
            property("AnimationBlendTime", IntValue) { it.animationBlendTime }
            property("AnimationPriority", IntValue) { it.animationPriority }
            property("AnimationSpeedFactorRange", ListValue(FloatValue)) { it.animationSpeedFactorRange }
            property("AnimationMustCompleteCount", IntValue) { it.animationMustCompleteCount }
            property("UseWeaponTiming", BooleanValue) { it.useWeaponTiming }
            property("DistanceCovered", FloatValue) { it.distanceCovered }
            property("Distance", FloatValue) { it.distance }
            property("AnimationMustCompleteBlend", BooleanValue) { it.animationMustCompleteBlend }
            property("FadeBeginFrame", FloatValue) { it.fadeBeginFrame }
            property("FadeEndFrame", FloatValue) { it.fadeEndFrame }
            property("FadingIn", BooleanValue) { it.fadingIn }
            property("AnimationDelay", IntValue) { it.animationDelay }
            property("Image", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.image }
            property("NumberImages", IntValue) { it.numberImages }
            property("RandomizeStartFrame", BooleanValue) { it.randomizeStartFrame }
        },
    )
}
