package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Rgba

data class RingEffect(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Scale") val scale: Double = 0.0,
    @SageIniName("Blend") val blend: Double = 0.0,
    @SageIniName("BaseColor") val baseColor: Rgba? = null,
    @SageIniName("EffectColor") val effectColor: Rgba? = null,
    @SageIniName("EffectSaturation") val effectSaturation: Double = 0.0,
    @SageIniName("BaseSaturation") val baseSaturation: Double = 0.0,
    @SageIniName("Velocity") val velocity: Double = 0.0,
    @SageIniName("TextureCross") val textureCross: Int = 0,
    @SageIniName("TextureRepeatCount") val textureRepeatCount: Int = 0,
    @SageIniName("EffectBlurDiameter") val effectBlurDiameter: Int = 0,
    @SageIniName("BaseBlurDiameter") val baseBlurDiameter: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<RingEffect>(
        name = "RingEffect",
        tableKey = "ringeffects",
        properties = {
            property("Scale", FloatValue) { it.scale }
            property("Blend", FloatValue) { it.blend }
            property("BaseColor", Rgba.type) { it.baseColor }
            property("EffectColor", Rgba.type) { it.effectColor }
            property("EffectSaturation", FloatValue) { it.effectSaturation }
            property("BaseSaturation", FloatValue) { it.baseSaturation }
            property("Velocity", FloatValue) { it.velocity }
            property("TextureCross", IntValue) { it.textureCross }
            property("TextureRepeatCount", IntValue) { it.textureRepeatCount }
            property("EffectBlurDiameter", IntValue) { it.effectBlurDiameter }
            property("BaseBlurDiameter", IntValue) { it.baseBlurDiameter }
        },
    )
}
