package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.ModelFile
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.RandomVariable
import de.darkatra.bfme2.ini.model.value.Rgb
import de.darkatra.bfme2.ini.model.value.Untyped

data class Fire(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AnimationName") val animationName: ModelFile? = null,
    @SageIniName("AnimationMode") val animationMode: Untyped? = null,
    @SageIniName("AnimationSpeedFactorRange") val animationSpeedFactorRange: List<Double> = emptyList(),
    @SageIniName("BurntTerrainColor") val burntTerrainColor: Rgb? = null,
    @SageIniName("EnableScorches") val enableScorches: Boolean = false,
    @SageIniName("FuelIndicatorColor") val fuelIndicatorColor: Rgb? = null,
    @SageIniName("ScorchFrequency") val scorchFrequency: RandomVariable? = null,
    @SageIniName("ScorchIntensity") val scorchIntensity: Double = 0.0,
    @SageIniName("ScorchSize") val scorchSize: Double = 0.0,
    @SageIniName("TerrainFireSystem") val terrainFireSystem: Opaque? = null,
    @SageIniName("TerrainSmokeSystem") val terrainSmokeSystem: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Fire>(
        name = "Fire",
        tableKey = "fires",
        properties = {
            property("AnimationName", ModelFile.type) { it.animationName }
            property("AnimationMode", Untyped.type) { it.animationMode }
            property("AnimationSpeedFactorRange", ListValue(FloatValue)) { it.animationSpeedFactorRange }
            property("BurntTerrainColor", Rgb.type) { it.burntTerrainColor }
            property("EnableScorches", BooleanValue) { it.enableScorches }
            property("FuelIndicatorColor", Rgb.type) { it.fuelIndicatorColor }
            property("ScorchFrequency", RandomVariable.type) { it.scorchFrequency }
            property("ScorchIntensity", FloatValue) { it.scorchIntensity }
            property("ScorchSize", FloatValue) { it.scorchSize }
            property("TerrainFireSystem", Opaque.type) { it.terrainFireSystem }
            property("TerrainSmokeSystem", Opaque.type) { it.terrainSmokeSystem }
        },
    )
}
