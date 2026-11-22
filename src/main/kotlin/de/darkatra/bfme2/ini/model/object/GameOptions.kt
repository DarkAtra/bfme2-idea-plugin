package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.Resolution

/**
 * The game settings in `Options.ini`, which consists of properties only.
 */
data class GameOptions(
    @SageIniName("AllHealthBars") val allHealthBars: Boolean = false,
    @SageIniName("AmbientVolume") val ambientVolume: Double = 0.0,
    @SageIniName("AnimationLOD") val animationLod: String = "",
    @SageIniName("AudioLOD") val audioLod: String = "",
    @SageIniName("Brightness") val brightness: Int = 0,
    @SageIniName("DecalLOD") val decalLod: String = "",
    @SageIniName("EffectsLOD") val effectsLod: String = "",
    @SageIniName("FirewallBehavior") val firewallBehavior: Int = 0,
    @SageIniName("FirewallNeedToRefresh") val firewallNeedToRefresh: Boolean = false,
    @SageIniName("FirewallPortAllocationDelta") val firewallPortAllocationDelta: Int = 0,
    @SageIniName("FlashTutorial") val flashTutorial: Int = 0,
    @SageIniName("GameSpyIPAddress") val gameSpyIpAddress: String = "",
    @SageIniName("HasGotOnline") val hasGotOnline: Boolean = false,
    @SageIniName("HasSeenLogoMovies") val hasSeenLogoMovies: Boolean = false,
    @SageIniName("IdealStaticGameLOD") val idealStaticGameLod: String = "",
    @SageIniName("ModelLOD") val modelLod: String = "",
    @SageIniName("MovieVolume") val movieVolume: Double = 0.0,
    @SageIniName("MusicVolume") val musicVolume: Double = 0.0,
    @SageIniName("Resolution") val resolution: Resolution? = null,
    @SageIniName("SFXVolume") val sfxVolume: Double = 0.0,
    @SageIniName("ScrollFactor") val scrollFactor: Int = 0,
    @SageIniName("SendDelay") val sendDelay: Boolean = false,
    @SageIniName("ShaderLOD") val shaderLod: String = "",
    @SageIniName("ShadowLOD") val shadowLod: String = "",
    @SageIniName("StaticGameLOD") val staticGameLod: String = "",
    @SageIniName("SuppressCahPromo") val suppressCahPromo: Boolean = false,
    @SageIniName("TerrainLOD") val terrainLod: String = "",
    @SageIniName("TextureQualityLOD") val textureQualityLod: String = "",
    @SageIniName("TimesInGame") val timesInGame: Int = 0,
    @SageIniName("UseEAX3") val useEax3: Boolean = false,
    @SageIniName("VoiceVolume") val voiceVolume: Double = 0.0,
    @SageIniName("WaterLOD") val waterLod: String = "",
) : SageIniObject {

    companion object : SageIniBlockDescriptor<GameOptions>(
        name = "Options.ini",
        properties = {
            property("AllHealthBars", BooleanValue) { it.allHealthBars }
            property("AmbientVolume", FloatValue) { it.ambientVolume }
            property("AnimationLOD", StringValue) { it.animationLod }
            property("AudioLOD", StringValue) { it.audioLod }
            property("Brightness", IntValue) { it.brightness }
            property("DecalLOD", StringValue) { it.decalLod }
            property("EffectsLOD", StringValue) { it.effectsLod }
            property("FirewallBehavior", IntValue) { it.firewallBehavior }
            property("FirewallNeedToRefresh", BooleanValue) { it.firewallNeedToRefresh }
            property("FirewallPortAllocationDelta", IntValue) { it.firewallPortAllocationDelta }
            property("FlashTutorial", IntValue) { it.flashTutorial }
            property("GameSpyIPAddress", StringValue) { it.gameSpyIpAddress }
            property("HasGotOnline", BooleanValue) { it.hasGotOnline }
            property("HasSeenLogoMovies", BooleanValue) { it.hasSeenLogoMovies }
            property("IdealStaticGameLOD", StringValue) { it.idealStaticGameLod }
            property("ModelLOD", StringValue) { it.modelLod }
            property("MovieVolume", FloatValue) { it.movieVolume }
            property("MusicVolume", FloatValue) { it.musicVolume }
            property("Resolution", Resolution.type) { it.resolution }
            property("SFXVolume", FloatValue) { it.sfxVolume }
            property("ScrollFactor", IntValue) { it.scrollFactor }
            property("SendDelay", BooleanValue) { it.sendDelay }
            property("ShaderLOD", StringValue) { it.shaderLod }
            property("ShadowLOD", StringValue) { it.shadowLod }
            property("StaticGameLOD", StringValue) { it.staticGameLod }
            property("SuppressCahPromo", BooleanValue) { it.suppressCahPromo }
            property("TerrainLOD", StringValue) { it.terrainLod }
            property("TextureQualityLOD", StringValue) { it.textureQualityLod }
            property("TimesInGame", IntValue) { it.timesInGame }
            property("UseEAX3", BooleanValue) { it.useEax3 }
            property("VoiceVolume", FloatValue) { it.voiceVolume }
            property("WaterLOD", StringValue) { it.waterLod }
        },
    )
}
