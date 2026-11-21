package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

data class Weather(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SnowEnabled") val snowEnabled: Boolean = false,
    @SageIniName("IsSnowing") val isSnowing: Boolean = false,
    @SageIniName("SnowTexture") val snowTexture: TextureFile? = null,
    @SageIniName("SnowBoxHeight") val snowBoxHeight: Double = 0.0,
    @SageIniName("SnowSpacing") val snowSpacing: Double = 0.0,
    @SageIniName("NumberTiles") val numberTiles: Int = 0,
    @SageIniName("SnowAmplitude") val snowAmplitude: Double = 0.0,
    @SageIniName("SnowFrequencyScaleX") val snowFrequencyScaleX: Double = 0.0,
    @SageIniName("SnowFrequencyScaleY") val snowFrequencyScaleY: Double = 0.0,
    @SageIniName("SnowSpeed") val snowSpeed: Double = 0.0,
    @SageIniName("SnowPointSize") val snowPointSize: Double = 0.0,
    @SageIniName("SnowMinPointSize") val snowMinPointSize: Double = 0.0,
    @SageIniName("SnowMaxPointSize") val snowMaxPointSize: Double = 0.0,
    @SageIniName("SnowPointSprites") val snowPointSprites: Boolean = false,
    @SageIniName("SnowQuadSize") val snowQuadSize: Double = 0.0,
    @SageIniName("LightningEnabled") val lightningEnabled: Boolean = false,
    @SageIniName("LightningFactor") val lightningFactor: Untyped? = null,
    @SageIniName("LightningDuration") val lightningDuration: Int = 0,
    @SageIniName("LightningChance") val lightningChance: Double = 0.0,
    @SageIniName("SpellEnabled") val spellEnabled: Boolean = false,
    @SageIniName("SpellDuration") val spellDuration: Int = 0,
    @SageIniName("RampControl") val rampControl: Untyped? = null,
    @SageIniName("RampSpeed") val rampSpeed: Untyped? = null,
    @SageIniName("RampSpacing") val rampSpacing: Untyped? = null,
    @SageIniName("CloudTextureSize") val cloudTextureSize: Untyped? = null,
    @SageIniName("CloudOffsetPerSecond") val cloudOffsetPerSecond: Untyped? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Weather>(
        name = "Weather",
        properties = {
            property("SnowEnabled", BooleanValue) { it.snowEnabled }
            property("IsSnowing", BooleanValue) { it.isSnowing }
            property("SnowTexture", TextureFile.type) { it.snowTexture }
            property("SnowBoxHeight", FloatValue) { it.snowBoxHeight }
            property("SnowSpacing", FloatValue) { it.snowSpacing }
            property("NumberTiles", IntValue) { it.numberTiles }
            property("SnowAmplitude", FloatValue) { it.snowAmplitude }
            property("SnowFrequencyScaleX", FloatValue) { it.snowFrequencyScaleX }
            property("SnowFrequencyScaleY", FloatValue) { it.snowFrequencyScaleY }
            property("SnowSpeed", FloatValue) { it.snowSpeed }
            property("SnowPointSize", FloatValue) { it.snowPointSize }
            property("SnowMinPointSize", FloatValue) { it.snowMinPointSize }
            property("SnowMaxPointSize", FloatValue) { it.snowMaxPointSize }
            property("SnowPointSprites", BooleanValue) { it.snowPointSprites }
            property("SnowQuadSize", FloatValue) { it.snowQuadSize }
            property("LightningEnabled", BooleanValue) { it.lightningEnabled }
            property("LightningFactor", Untyped.type) { it.lightningFactor }
            property("LightningDuration", IntValue) { it.lightningDuration }
            property("LightningChance", FloatValue) { it.lightningChance }
            property("SpellEnabled", BooleanValue) { it.spellEnabled }
            property("SpellDuration", IntValue) { it.spellDuration }
            property("RampControl", Untyped.type) { it.rampControl }
            property("RampSpeed", Untyped.type) { it.rampSpeed }
            property("RampSpacing", Untyped.type) { it.rampSpacing }
            property("CloudTextureSize", Untyped.type) { it.cloudTextureSize }
            property("CloudOffsetPerSecond", Untyped.type) { it.cloudOffsetPerSecond }
        },
    )
}
