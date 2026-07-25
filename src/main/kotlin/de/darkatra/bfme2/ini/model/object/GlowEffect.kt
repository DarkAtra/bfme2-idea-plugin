package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class GlowEffect(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("GlowEnabled") val glowEnabled: Boolean = false,
    @SageIniName("GlowDiameter") val glowDiameter: Int = 0,
    @SageIniName("GlowIntensity") val glowIntensity: Double = 0.0,
    @SageIniName("GlowTextureWidth") val glowTextureWidth: Int = 0,
    @SageIniName("RadiusScale1") val radiusScale1: Double = 0.0,
    @SageIniName("Amplitude1") val amplitude1: Double = 0.0,
    @SageIniName("RadiusScale2") val radiusScale2: Double = 0.0,
    @SageIniName("Amplitude2") val amplitude2: Double = 0.0,
    @SageIniName("TerrainGlow") val terrainGlow: Boolean = false,
    @SageIniName("MultipassGlowEnabled") val multipassGlowEnabled: Boolean = false,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<GlowEffect>(
        name = "GlowEffect",
        tableKey = "gloweffects",
        properties = {
            property("GlowEnabled", BooleanValue) { it.glowEnabled }
            property("GlowDiameter", IntValue) { it.glowDiameter }
            property("GlowIntensity", FloatValue) { it.glowIntensity }
            property("GlowTextureWidth", IntValue) { it.glowTextureWidth }
            property("RadiusScale1", FloatValue) { it.radiusScale1 }
            property("Amplitude1", FloatValue) { it.amplitude1 }
            property("RadiusScale2", FloatValue) { it.radiusScale2 }
            property("Amplitude2", FloatValue) { it.amplitude2 }
            property("TerrainGlow", BooleanValue) { it.terrainGlow }
            property("MultipassGlowEnabled", BooleanValue) { it.multipassGlowEnabled }
        },
    )
}
