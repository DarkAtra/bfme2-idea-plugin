package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgba

data class WaterTransparency(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TransparentWaterMinOpacity") val transparentWaterMinOpacity: Double = 0.0,
    @SageIniName("TransparentWaterDepth") val transparentWaterDepth: Double = 0.0,
    @SageIniName("RiverTransparencyMultiplier") val riverTransparencyMultiplier: Double = 0.0,
    @SageIniName("StandingWaterColor") val standingWaterColor: Rgba? = null,
    @SageIniName("StandingWaterTexture") val standingWaterTexture: Opaque? = null,
    @SageIniName("AdditiveBlending") val additiveBlending: Boolean = false,
    @SageIniName("RadarWaterColor") val radarWaterColor: Rgba? = null,
    @SageIniName("ReflectionPlaneZ") val reflectionPlaneZ: Double = 0.0,
    @SageIniName("ReflectionOn") val reflectionOn: Boolean = false,
    @SageIniName("ReflectionGuard") val reflectionGuard: Coords? = null,
    @SageIniName("SkyboxTextureE") val skyboxTextureE: Opaque? = null,
    @SageIniName("SkyboxTextureN") val skyboxTextureN: Opaque? = null,
    @SageIniName("SkyboxTextureS") val skyboxTextureS: Opaque? = null,
    @SageIniName("SkyboxTextureT") val skyboxTextureT: Opaque? = null,
    @SageIniName("SkyboxTextureW") val skyboxTextureW: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<WaterTransparency>(
        name = "WaterTransparency",
        tableKey = "watertransparencys",
        properties = {
            property("TransparentWaterMinOpacity", FloatValue) { it.transparentWaterMinOpacity }
            property("TransparentWaterDepth", FloatValue) { it.transparentWaterDepth }
            property("RiverTransparencyMultiplier", FloatValue) { it.riverTransparencyMultiplier }
            property("StandingWaterColor", Rgba.type) { it.standingWaterColor }
            property("StandingWaterTexture", Opaque.type) { it.standingWaterTexture }
            property("AdditiveBlending", BooleanValue) { it.additiveBlending }
            property("RadarWaterColor", Rgba.type) { it.radarWaterColor }
            property("ReflectionPlaneZ", FloatValue) { it.reflectionPlaneZ }
            property("ReflectionOn", BooleanValue) { it.reflectionOn }
            property("ReflectionGuard", Coords.type) { it.reflectionGuard }
            property("SkyboxTextureE", Opaque.type) { it.skyboxTextureE }
            property("SkyboxTextureN", Opaque.type) { it.skyboxTextureN }
            property("SkyboxTextureS", Opaque.type) { it.skyboxTextureS }
            property("SkyboxTextureT", Opaque.type) { it.skyboxTextureT }
            property("SkyboxTextureW", Opaque.type) { it.skyboxTextureW }
        },
    )
}
