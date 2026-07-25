package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.AudioPriority
import de.darkatra.bfme2.ini.model.value.AudioVolumeSlider
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFloatRange
import de.darkatra.bfme2.ini.model.value.SageIntRange
import de.darkatra.bfme2.ini.model.value.Untyped
import de.darkatra.bfme2.ini.model.value.VolumeSliderMultiplier

data class StreamedSound(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Control") val control: Untyped? = null,
    @SageIniName("Filename") val filename: Opaque? = null,
    @SageIniName("Priority") val priority: AudioPriority? = null,
    @SageIniName("Limit") val limit: Int = 0,
    @SageIniName("Volume") val volume: Double = 0.0,
    @SageIniName("Type") val type: Untyped? = null,
    @SageIniName("SubmixSlider") val submixSlider: AudioVolumeSlider? = null,
    @SageIniName("Delay") val delay: SageIntRange? = null,
    @SageIniName("DryLevel") val dryLevel: Double = 0.0,
    @SageIniName("LowPassCutoff") val lowPassCutoff: Double = 0.0,
    @SageIniName("MaxRange") val maxRange: Double = 0.0,
    @SageIniName("MinRange") val minRange: Double = 0.0,
    @SageIniName("MinVolume") val minVolume: Double = 0.0,
    @SageIniName("PerFilePitchShift") val perFilePitchShift: SageFloatRange? = null,
    @SageIniName("PerFileVolumeShift") val perFileVolumeShift: Double = 0.0,
    @SageIniName("PitchShift") val pitchShift: SageFloatRange? = null,
    @SageIniName("PlayPercent") val playPercent: Double = 0.0,
    @SageIniName("ReverbEffectLevel") val reverbEffectLevel: Double = 0.0,
    @SageIniName("VolumeShift") val volumeShift: Double = 0.0,
    @SageIniName("VolumeSliderMultiplier") val volumeSliderMultiplier: List<VolumeSliderMultiplier> = emptyList(),
    @SageIniName("ZoomedInOffscreenMinVolumePercent") val zoomedInOffscreenMinVolumePercent: Double = 0.0,
    @SageIniName("ZoomedInOffscreenOcclusionPercent") val zoomedInOffscreenOcclusionPercent: Double = 0.0,
    @SageIniName("ZoomedInOffscreenVolumePercent") val zoomedInOffscreenVolumePercent: Double = 0.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<StreamedSound>(
        name = "StreamedSound",
        tableKey = "streamedsounds",
        properties = {
            property("Control", Untyped.type) { it.control }
            property("Filename", Opaque.type) { it.filename }
            property("Priority", AudioPriority.type) { it.priority }
            property("Limit", IntValue) { it.limit }
            property("Volume", FloatValue) { it.volume }
            property("Type", Untyped.type) { it.type }
            property("SubmixSlider", AudioVolumeSlider.type) { it.submixSlider }
            property("Delay", SageIntRange.type) { it.delay }
            property("DryLevel", FloatValue) { it.dryLevel }
            property("LowPassCutoff", FloatValue) { it.lowPassCutoff }
            property("MaxRange", FloatValue) { it.maxRange }
            property("MinRange", FloatValue) { it.minRange }
            property("MinVolume", FloatValue) { it.minVolume }
            property("PerFilePitchShift", SageFloatRange.type) { it.perFilePitchShift }
            property("PerFileVolumeShift", FloatValue) { it.perFileVolumeShift }
            property("PitchShift", SageFloatRange.type) { it.pitchShift }
            property("PlayPercent", FloatValue) { it.playPercent }
            property("ReverbEffectLevel", FloatValue) { it.reverbEffectLevel }
            property("VolumeShift", FloatValue) { it.volumeShift }
            property("VolumeSliderMultiplier", ListValue(VolumeSliderMultiplier.type)) { it.volumeSliderMultiplier }
            property("ZoomedInOffscreenMinVolumePercent", FloatValue) { it.zoomedInOffscreenMinVolumePercent }
            property("ZoomedInOffscreenOcclusionPercent", FloatValue) { it.zoomedInOffscreenOcclusionPercent }
            property("ZoomedInOffscreenVolumePercent", FloatValue) { it.zoomedInOffscreenVolumePercent }
        },
    )
}
