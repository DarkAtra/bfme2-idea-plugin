package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.AudioControlFlags
import de.darkatra.bfme2.ini.model.value.AudioPriority
import de.darkatra.bfme2.ini.model.value.AudioTypeFlags
import de.darkatra.bfme2.ini.model.value.AudioVolumeSlider
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Untyped
import de.darkatra.bfme2.ini.model.value.VolumeSliderMultiplier

data class AudioEvent(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Volume") val volume: Double = 0.0,
    @SageIniName("MinVolume") val minVolume: Double = 0.0,
    @SageIniName("Limit") val limit: Int = 0,
    @SageIniName("MinRange") val minRange: Double = 0.0,
    @SageIniName("MaxRange") val maxRange: Double = 0.0,
    @SageIniName("Priority") val priority: AudioPriority? = null,
    @SageIniName("PlayPercent") val playPercent: Int = 0,
    @SageIniName("Type") val type: List<AudioTypeFlags> = emptyList(),
    @SageIniName("SubmixSlider") val submixSlider: AudioVolumeSlider? = null,
    @SageIniName("Control") val control: List<AudioControlFlags> = emptyList(),
    @SageIniName("Sounds") val sounds: List<Opaque> = emptyList(),
    @SageIniName("Attack") val attack: List<Opaque> = emptyList(),
    @SageIniName("Decay") val decay: List<Opaque> = emptyList(),
    @SageIniName("PitchShift") val pitchShift: Untyped? = null,
    @SageIniName("PerFilePitchShift") val perFilePitchShift: Untyped? = null,
    @SageIniName("VolumeShift") val volumeShift: Untyped? = null,
    @SageIniName("PerFileVolumeShift") val perFileVolumeShift: Untyped? = null,
    @SageIniName("Delay") val delay: Untyped? = null,
    @SageIniName("VolumeSliderMultiplier") val volumeSliderMultiplier: List<VolumeSliderMultiplier> = emptyList(),
    @SageIniName("ReverbEffectLevel") val reverbEffectLevel: Double = 0.0,
    @SageIniName("DryLevel") val dryLevel: Double = 0.0,
    @SageIniName("LowPassCutoff") val lowPassCutoff: Double = 0.0,
    @SageIniName("ZoomedInOffscreenVolumePercent") val zoomedInOffscreenVolumePercent: Double = 0.0,
    @SageIniName("ZoomedInOffscreenMinVolumePercent") val zoomedInOffscreenMinVolumePercent: Double = 0.0,
    @SageIniName("ZoomedInOffscreenOcclusionPercent") val zoomedInOffscreenOcclusionPercent: Double = 0.0,
    @SageIniName("LoopCount") val loopCount: Int = 0,
    @SageIniName("Sound") val sound: Opaque? = null,
    @SageIniName("DelayFromActStart") val delayFromActStart: Double = 0.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AudioEvent>(
        name = "AudioEvent",
        tableKey = "audioevents",
        properties = {
            property("Volume", FloatValue) { it.volume }
            property("MinVolume", FloatValue) { it.minVolume }
            property("Limit", IntValue) { it.limit }
            property("MinRange", FloatValue) { it.minRange }
            property("MaxRange", FloatValue) { it.maxRange }
            property("Priority", AudioPriority.type) { it.priority }
            property("PlayPercent", IntValue) { it.playPercent }
            property("Type", ListValue(AudioTypeFlags.type)) { it.type }
            property("SubmixSlider", AudioVolumeSlider.type) { it.submixSlider }
            property("Control", ListValue(AudioControlFlags.type)) { it.control }
            property("Sounds", ListValue(Opaque.type)) { it.sounds }
            property("Attack", ListValue(Opaque.type)) { it.attack }
            property("Decay", ListValue(Opaque.type)) { it.decay }
            property("PitchShift", Untyped.type) { it.pitchShift }
            property("PerFilePitchShift", Untyped.type) { it.perFilePitchShift }
            property("VolumeShift", Untyped.type) { it.volumeShift }
            property("PerFileVolumeShift", Untyped.type) { it.perFileVolumeShift }
            property("Delay", Untyped.type) { it.delay }
            property("VolumeSliderMultiplier", ListValue(VolumeSliderMultiplier.type)) { it.volumeSliderMultiplier }
            property("ReverbEffectLevel", FloatValue) { it.reverbEffectLevel }
            property("DryLevel", FloatValue) { it.dryLevel }
            property("LowPassCutoff", FloatValue) { it.lowPassCutoff }
            property("ZoomedInOffscreenVolumePercent", FloatValue) { it.zoomedInOffscreenVolumePercent }
            property("ZoomedInOffscreenMinVolumePercent", FloatValue) { it.zoomedInOffscreenMinVolumePercent }
            property("ZoomedInOffscreenOcclusionPercent", FloatValue) { it.zoomedInOffscreenOcclusionPercent }
            property("LoopCount", IntValue) { it.loopCount }
            property("Sound", Opaque.type) { it.sound }
            property("DelayFromActStart", FloatValue) { it.delayFromActStart }
        },
    )
}
