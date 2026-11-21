package de.darkatra.bfme2.ini.model.ui

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
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class Transition(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StartFrame") val startFrame: Int = 0,
    @SageIniName("EndFrame") val endFrame: Int = 0,
    @SageIniName("ViewsToFade") val viewsToFade: Untyped? = null,
    @SageIniName("LeaveSilent") val leaveSilent: Boolean = false,
    @SageIniName("AnimationName") val animationName: Untyped? = null,
    @SageIniName("AnimationMode") val animationMode: Untyped? = null,
    @SageIniName("AnimationBlendTime") val animationBlendTime: Int = 0,
    @SageIniName("AnimationMustCompleteBlend") val animationMustCompleteBlend: Boolean = false,
    @SageIniName("AnimationSpeedFactorRange") val animationSpeedFactorRange: List<Double> = emptyList(),
    @SageIniName("FadeColor") val fadeColor: Rgba? = null,
    @SageIniName("FadeImage") val fadeImage: SageReference<MappedImage>? = null,
    @SageIniName("CrossFadeImage") val crossFadeImage: SageReference<MappedImage>? = null,
    @SageIniName("FadeInUnfrozenSounds") val fadeInUnfrozenSounds: Boolean = false,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Transition>(
        name = "Transition",
        keyedByLabel = true,
        properties = {
            property("StartFrame", IntValue) { it.startFrame }
            property("EndFrame", IntValue) { it.endFrame }
            property("ViewsToFade", Untyped.type) { it.viewsToFade }
            property("LeaveSilent", BooleanValue) { it.leaveSilent }
            property("AnimationName", Untyped.type) { it.animationName }
            property("AnimationMode", Untyped.type) { it.animationMode }
            property("AnimationBlendTime", IntValue) { it.animationBlendTime }
            property("AnimationMustCompleteBlend", BooleanValue) { it.animationMustCompleteBlend }
            property("AnimationSpeedFactorRange", ListValue(FloatValue)) { it.animationSpeedFactorRange }
            property("FadeColor", Rgba.type) { it.fadeColor }
            property("FadeImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.fadeImage }
            property("CrossFadeImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.crossFadeImage }
            property("FadeInUnfrozenSounds", BooleanValue) { it.fadeInUnfrozenSounds }
        },
    )
}
