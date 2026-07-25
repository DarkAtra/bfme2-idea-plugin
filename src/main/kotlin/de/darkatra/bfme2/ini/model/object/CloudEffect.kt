package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class CloudEffect(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("CloudTexture") val cloudTexture: Opaque? = null,
    @SageIniName("DarkCloudTexture") val darkCloudTexture: Opaque? = null,
    @SageIniName("AlphaTexture") val alphaTexture: Opaque? = null,
    @SageIniName("DissipateTexture") val dissipateTexture: Opaque? = null,
    @SageIniName("PropagateSpeed") val propagateSpeed: Double = 0.0,
    @SageIniName("Angle") val angle: Double = 0.0,
    @SageIniName("CloudScrollSpeed") val cloudScrollSpeed: Double = 0.0,
    @SageIniName("DarkeningFactor") val darkeningFactor: Rgba? = null,
    @SageIniName("DarkeningRate") val darkeningRate: Int = 0,
    @SageIniName("LighteningRate") val lighteningRate: Int = 0,
    @SageIniName("DissipateStartLevel") val dissipateStartLevel: Double = 0.0,
    @SageIniName("DissipateSpeed") val dissipateSpeed: Double = 0.0,
    @SageIniName("DissipateRateScale") val dissipateRateScale: Double = 0.0,
    @SageIniName("LightningShadows") val lightningShadows: Boolean = false,
    @SageIniName("JitterLightningLightIntensity") val jitterLightningLightIntensity: Boolean = false,
    @SageIniName("JitterLightningLightPosition") val jitterLightningLightPosition: Boolean = false,
    @SageIniName("LightningChance") val lightningChance: Double = 0.0,
    @SageIniName("LightningDuration") val lightningDuration: Untyped? = null,
    @SageIniName("LightningFrequency") val lightningFrequency: Double = 0.0,
    @SageIniName("LightningIntensity") val lightningIntensity: Untyped? = null,
    @SageIniName("LightningShadowColor") val lightningShadowColor: Rgba? = null,
    @SageIniName("LightningShadowIntensity") val lightningShadowIntensity: Double = 0.0,
    @SageIniName("LightningLightPosition1") val lightningLightPosition1: Coords? = null,
    @SageIniName("LightningLightPosition2") val lightningLightPosition2: Coords? = null,
    @SageIniName("LightningLightPosition3") val lightningLightPosition3: Coords? = null,
    @SageIniName("LightningFX") val lightningFX: SageReference<FXList>? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<CloudEffect>(
        name = "CloudEffect",
        tableKey = "cloudeffects",
        properties = {
            property("CloudTexture", Opaque.type) { it.cloudTexture }
            property("DarkCloudTexture", Opaque.type) { it.darkCloudTexture }
            property("AlphaTexture", Opaque.type) { it.alphaTexture }
            property("DissipateTexture", Opaque.type) { it.dissipateTexture }
            property("PropagateSpeed", FloatValue) { it.propagateSpeed }
            property("Angle", FloatValue) { it.angle }
            property("CloudScrollSpeed", FloatValue) { it.cloudScrollSpeed }
            property("DarkeningFactor", Rgba.type) { it.darkeningFactor }
            property("DarkeningRate", IntValue) { it.darkeningRate }
            property("LighteningRate", IntValue) { it.lighteningRate }
            property("DissipateStartLevel", FloatValue) { it.dissipateStartLevel }
            property("DissipateSpeed", FloatValue) { it.dissipateSpeed }
            property("DissipateRateScale", FloatValue) { it.dissipateRateScale }
            property("LightningShadows", BooleanValue) { it.lightningShadows }
            property("JitterLightningLightIntensity", BooleanValue) { it.jitterLightningLightIntensity }
            property("JitterLightningLightPosition", BooleanValue) { it.jitterLightningLightPosition }
            property("LightningChance", FloatValue) { it.lightningChance }
            property("LightningDuration", Untyped.type) { it.lightningDuration }
            property("LightningFrequency", FloatValue) { it.lightningFrequency }
            property("LightningIntensity", Untyped.type) { it.lightningIntensity }
            property("LightningShadowColor", Rgba.type) { it.lightningShadowColor }
            property("LightningShadowIntensity", FloatValue) { it.lightningShadowIntensity }
            property("LightningLightPosition1", Coords.type) { it.lightningLightPosition1 }
            property("LightningLightPosition2", Coords.type) { it.lightningLightPosition2 }
            property("LightningLightPosition3", Coords.type) { it.lightningLightPosition3 }
            property("LightningFX", ReferenceValue<FXList> { listOf(FXList) }) { it.lightningFX }
        },
    )
}
