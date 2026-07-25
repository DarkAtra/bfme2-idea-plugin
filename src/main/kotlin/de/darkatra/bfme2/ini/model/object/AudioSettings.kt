package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgba

data class AudioSettings(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AudioRoot") val audioRoot: String = "",
    @SageIniName("SoundsFolder") val soundsFolder: String = "",
    @SageIniName("MusicFolder") val musicFolder: String = "",
    @SageIniName("StreamingFolder") val streamingFolder: String = "",
    @SageIniName("AmbientStreamFolder") val ambientStreamFolder: String = "",
    @SageIniName("SoundsExtension") val soundsExtension: String = "",
    @SageIniName("MusicScriptLibraryName") val musicScriptLibraryName: Opaque? = null,
    @SageIniName("UseDigital") val useDigital: Boolean = false,
    @SageIniName("UseMidi") val useMidi: Boolean = false,
    @SageIniName("OutputRate") val outputRate: Int = 0,
    @SageIniName("OutputBits") val outputBits: Int = 0,
    @SageIniName("OutputChannels") val outputChannels: Int = 0,
    @SageIniName("MixaheadLatency") val mixaheadLatency: Int = 0,
    @SageIniName("MixaheadLatencyDuringMovies") val mixaheadLatencyDuringMovies: Int = 0,
    @SageIniName("LoopBufferLengthMS") val loopBufferLengthMS: Int = 0,
    @SageIniName("LoopBufferCallbackCallsPerBufferLength") val loopBufferCallbackCallsPerBufferLength: Int = 0,
    @SageIniName("ForceResetTimeSeconds") val forceResetTimeSeconds: Int = 0,
    @SageIniName("EmergencyResetTimeSeconds") val emergencyResetTimeSeconds: Int = 0,
    @SageIniName("AutomaticSubtitleDurationMS") val automaticSubtitleDurationMS: Int = 0,
    @SageIniName("AutomaticSubtitleWindowWidth") val automaticSubtitleWindowWidth: Int = 0,
    @SageIniName("AutomaticSubtitleLines") val automaticSubtitleLines: Int = 0,
    @SageIniName("AutomaticSubtitleWindowColor") val automaticSubtitleWindowColor: Rgba? = null,
    @SageIniName("AutomaticSubtitleTextColor") val automaticSubtitleTextColor: Rgba? = null,
    @SageIniName("PositionDeltaForReverbRecheck") val positionDeltaForReverbRecheck: Int = 0,
    @SageIniName("SampleCount2D") val sampleCount2D: Int = 0,
    @SageIniName("SampleCount3D") val sampleCount3D: Int = 0,
    @SageIniName("StreamCount") val streamCount: Int = 0,
    @SageIniName("GlobalMinRange") val globalMinRange: Int = 0,
    @SageIniName("GlobalMaxRange") val globalMaxRange: Int = 0,
    @SageIniName("TimeToFadeAudio") val timeToFadeAudio: Int = 0,
    @SageIniName("AudioFootprintInBytes") val audioFootprintInBytes: Int = 0,
    @SageIniName("MinSampleVolume") val minSampleVolume: Int = 0,
    @SageIniName("AmbientStreamHysteresisVolume") val ambientStreamHysteresisVolume: Int = 0,
    @SageIniName("MillisecondsPriorToPlayingToReadSoundFile") val millisecondsPriorToPlayingToReadSoundFile: Int = 0,
    @SageIniName("SuppressOcclusion") val suppressOcclusion: Boolean = false,
    @SageIniName("MinOcclusion") val minOcclusion: Double = 0.0,
    @SageIniName("DefaultSoundVolume") val defaultSoundVolume: Double = 0.0,
    @SageIniName("DefaultAmbientVolume") val defaultAmbientVolume: Double = 0.0,
    @SageIniName("DefaultMovieVolume") val defaultMovieVolume: Double = 0.0,
    @SageIniName("DefaultVoiceVolume") val defaultVoiceVolume: Double = 0.0,
    @SageIniName("DefaultMusicVolume") val defaultMusicVolume: Double = 0.0,
    @SageIniName("ZoomFadeDistanceForMaxEffect") val zoomFadeDistanceForMaxEffect: Int = 0,
    @SageIniName("ZoomFadeZeroEffectEdgeLength") val zoomFadeZeroEffectEdgeLength: Int = 0,
    @SageIniName("ZoomFadeFullEffectEdgeLength") val zoomFadeFullEffectEdgeLength: Int = 0,
    @SageIniName("ZoomMinDistance") val zoomMinDistance: Double = 0.0,
    @SageIniName("ZoomMaxDistance") val zoomMaxDistance: Double = 0.0,
    @SageIniName("ZoomSoundVolumePercentageAmount") val zoomSoundVolumePercentageAmount: Double = 0.0,
    @SageIniName("GlobalPaddedCellReverbMultiplier") val globalPaddedCellReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalRoomReverbMultiplier") val globalRoomReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalBathroomReverbMultiplier") val globalBathroomReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalLivingRoomReverbMultiplier") val globalLivingRoomReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalStoneRoomReverbMultiplier") val globalStoneRoomReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalAuditoriumReverbMultiplier") val globalAuditoriumReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalConcertHallReverbMultiplier") val globalConcertHallReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalCaveReverbMultiplier") val globalCaveReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalArenaReverbMultiplier") val globalArenaReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalHangarReverbMultiplier") val globalHangarReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalCarpetedHallwayReverbMultiplier") val globalCarpetedHallwayReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalHallwayReverbMultiplier") val globalHallwayReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalStoneCorridorReverbMultiplier") val globalStoneCorridorReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalAlleyReverbMultiplier") val globalAlleyReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalForestReverbMultiplier") val globalForestReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalCityReverbMultiplier") val globalCityReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalMountainsReverbMultiplier") val globalMountainsReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalQuarryReverbMultiplier") val globalQuarryReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalPlainReverbMultiplier") val globalPlainReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalParkingLotReverbMultiplier") val globalParkingLotReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalSewerPipeReverbMultiplier") val globalSewerPipeReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalUnderwaterReverbMultiplier") val globalUnderwaterReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalDruggedReverbMultiplier") val globalDruggedReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalDizzyReverbMultiplier") val globalDizzyReverbMultiplier: Double = 0.0,
    @SageIniName("GlobalPsychoticReverbMultiplier") val globalPsychoticReverbMultiplier: Double = 0.0,
    @SageIniName("MicrophonePreferredFractionCameraToGround") val microphonePreferredFractionCameraToGround: Double = 0.0,
    @SageIniName("MicrophoneMinDistanceToCamera") val microphoneMinDistanceToCamera: Int = 0,
    @SageIniName("MicrophoneMaxDistanceToCamera") val microphoneMaxDistanceToCamera: Int = 0,
    @SageIniName("MicrophonePullTowardsTerrainLookAtPointPercent") val microphonePullTowardsTerrainLookAtPointPercent: Double = 0.0,
    @SageIniName("LivingWorldMicrophonePreferredFractionCameraToGround") val livingWorldMicrophonePreferredFractionCameraToGround: Double = 0.0,
    @SageIniName("LivingWorldMicrophoneMaxDistanceToCamera") val livingWorldMicrophoneMaxDistanceToCamera: Int = 0,
    @SageIniName("LivingWorldZoomMaxDistance") val livingWorldZoomMaxDistance: Double = 0.0,
    @SageIniName("VoiceMoveToCampMaxCampnessAtStartPoint") val voiceMoveToCampMaxCampnessAtStartPoint: Int = 0,
    @SageIniName("VoiceMoveToCampMinCampnessAtEndPoint") val voiceMoveToCampMinCampnessAtEndPoint: Int = 0,
    @SageIniName("MinDelayBetweenEnterStateVoiceMS") val minDelayBetweenEnterStateVoiceMS: Int = 0,
    @SageIniName("Default2DSpeakerType") val default2DSpeakerType: String = "",
    @SageIniName("Default3DSoundVolume") val default3DSoundVolume: Double = 0.0,
    @SageIniName("Default3DSpeakerType") val default3DSpeakerType: String = "",
    @SageIniName("DefaultSpeechVolume") val defaultSpeechVolume: Double = 0.0,
    @SageIniName("MicrophoneDesiredHeightAboveTerrain") val microphoneDesiredHeightAboveTerrain: Double = 0.0,
    @SageIniName("MicrophoneMaxPercentageBetweenGroundAndCamera") val microphoneMaxPercentageBetweenGroundAndCamera: Double = 0.0,
    @SageIniName("Preferred3DHW1") val preferred3DHW1: String = "",
    @SageIniName("Preferred3DHW2") val preferred3DHW2: String = "",
    @SageIniName("Preferred3DSW") val preferred3DSW: String = "",
    @SageIniName("Relative2DVolume") val relative2DVolume: Double = 0.0,
    @SageIniName("TimeBetweenDrawableSounds") val timeBetweenDrawableSounds: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AudioSettings>(
        name = "AudioSettings",
        tableKey = "audiosettings",
        properties = {
            property("AudioRoot", StringValue) { it.audioRoot }
            property("SoundsFolder", StringValue) { it.soundsFolder }
            property("MusicFolder", StringValue) { it.musicFolder }
            property("StreamingFolder", StringValue) { it.streamingFolder }
            property("AmbientStreamFolder", StringValue) { it.ambientStreamFolder }
            property("SoundsExtension", StringValue) { it.soundsExtension }
            property("MusicScriptLibraryName", Opaque.type) { it.musicScriptLibraryName }
            property("UseDigital", BooleanValue) { it.useDigital }
            property("UseMidi", BooleanValue) { it.useMidi }
            property("OutputRate", IntValue) { it.outputRate }
            property("OutputBits", IntValue) { it.outputBits }
            property("OutputChannels", IntValue) { it.outputChannels }
            property("MixaheadLatency", IntValue) { it.mixaheadLatency }
            property("MixaheadLatencyDuringMovies", IntValue) { it.mixaheadLatencyDuringMovies }
            property("LoopBufferLengthMS", IntValue) { it.loopBufferLengthMS }
            property("LoopBufferCallbackCallsPerBufferLength", IntValue) { it.loopBufferCallbackCallsPerBufferLength }
            property("ForceResetTimeSeconds", IntValue) { it.forceResetTimeSeconds }
            property("EmergencyResetTimeSeconds", IntValue) { it.emergencyResetTimeSeconds }
            property("AutomaticSubtitleDurationMS", IntValue) { it.automaticSubtitleDurationMS }
            property("AutomaticSubtitleWindowWidth", IntValue) { it.automaticSubtitleWindowWidth }
            property("AutomaticSubtitleLines", IntValue) { it.automaticSubtitleLines }
            property("AutomaticSubtitleWindowColor", Rgba.type) { it.automaticSubtitleWindowColor }
            property("AutomaticSubtitleTextColor", Rgba.type) { it.automaticSubtitleTextColor }
            property("PositionDeltaForReverbRecheck", IntValue) { it.positionDeltaForReverbRecheck }
            property("SampleCount2D", IntValue) { it.sampleCount2D }
            property("SampleCount3D", IntValue) { it.sampleCount3D }
            property("StreamCount", IntValue) { it.streamCount }
            property("GlobalMinRange", IntValue) { it.globalMinRange }
            property("GlobalMaxRange", IntValue) { it.globalMaxRange }
            property("TimeToFadeAudio", IntValue) { it.timeToFadeAudio }
            property("AudioFootprintInBytes", IntValue) { it.audioFootprintInBytes }
            property("MinSampleVolume", IntValue) { it.minSampleVolume }
            property("AmbientStreamHysteresisVolume", IntValue) { it.ambientStreamHysteresisVolume }
            property("MillisecondsPriorToPlayingToReadSoundFile", IntValue) { it.millisecondsPriorToPlayingToReadSoundFile }
            property("SuppressOcclusion", BooleanValue) { it.suppressOcclusion }
            property("MinOcclusion", FloatValue) { it.minOcclusion }
            property("DefaultSoundVolume", FloatValue) { it.defaultSoundVolume }
            property("DefaultAmbientVolume", FloatValue) { it.defaultAmbientVolume }
            property("DefaultMovieVolume", FloatValue) { it.defaultMovieVolume }
            property("DefaultVoiceVolume", FloatValue) { it.defaultVoiceVolume }
            property("DefaultMusicVolume", FloatValue) { it.defaultMusicVolume }
            property("ZoomFadeDistanceForMaxEffect", IntValue) { it.zoomFadeDistanceForMaxEffect }
            property("ZoomFadeZeroEffectEdgeLength", IntValue) { it.zoomFadeZeroEffectEdgeLength }
            property("ZoomFadeFullEffectEdgeLength", IntValue) { it.zoomFadeFullEffectEdgeLength }
            property("ZoomMinDistance", FloatValue) { it.zoomMinDistance }
            property("ZoomMaxDistance", FloatValue) { it.zoomMaxDistance }
            property("ZoomSoundVolumePercentageAmount", FloatValue) { it.zoomSoundVolumePercentageAmount }
            property("GlobalPaddedCellReverbMultiplier", FloatValue) { it.globalPaddedCellReverbMultiplier }
            property("GlobalRoomReverbMultiplier", FloatValue) { it.globalRoomReverbMultiplier }
            property("GlobalBathroomReverbMultiplier", FloatValue) { it.globalBathroomReverbMultiplier }
            property("GlobalLivingRoomReverbMultiplier", FloatValue) { it.globalLivingRoomReverbMultiplier }
            property("GlobalStoneRoomReverbMultiplier", FloatValue) { it.globalStoneRoomReverbMultiplier }
            property("GlobalAuditoriumReverbMultiplier", FloatValue) { it.globalAuditoriumReverbMultiplier }
            property("GlobalConcertHallReverbMultiplier", FloatValue) { it.globalConcertHallReverbMultiplier }
            property("GlobalCaveReverbMultiplier", FloatValue) { it.globalCaveReverbMultiplier }
            property("GlobalArenaReverbMultiplier", FloatValue) { it.globalArenaReverbMultiplier }
            property("GlobalHangarReverbMultiplier", FloatValue) { it.globalHangarReverbMultiplier }
            property("GlobalCarpetedHallwayReverbMultiplier", FloatValue) { it.globalCarpetedHallwayReverbMultiplier }
            property("GlobalHallwayReverbMultiplier", FloatValue) { it.globalHallwayReverbMultiplier }
            property("GlobalStoneCorridorReverbMultiplier", FloatValue) { it.globalStoneCorridorReverbMultiplier }
            property("GlobalAlleyReverbMultiplier", FloatValue) { it.globalAlleyReverbMultiplier }
            property("GlobalForestReverbMultiplier", FloatValue) { it.globalForestReverbMultiplier }
            property("GlobalCityReverbMultiplier", FloatValue) { it.globalCityReverbMultiplier }
            property("GlobalMountainsReverbMultiplier", FloatValue) { it.globalMountainsReverbMultiplier }
            property("GlobalQuarryReverbMultiplier", FloatValue) { it.globalQuarryReverbMultiplier }
            property("GlobalPlainReverbMultiplier", FloatValue) { it.globalPlainReverbMultiplier }
            property("GlobalParkingLotReverbMultiplier", FloatValue) { it.globalParkingLotReverbMultiplier }
            property("GlobalSewerPipeReverbMultiplier", FloatValue) { it.globalSewerPipeReverbMultiplier }
            property("GlobalUnderwaterReverbMultiplier", FloatValue) { it.globalUnderwaterReverbMultiplier }
            property("GlobalDruggedReverbMultiplier", FloatValue) { it.globalDruggedReverbMultiplier }
            property("GlobalDizzyReverbMultiplier", FloatValue) { it.globalDizzyReverbMultiplier }
            property("GlobalPsychoticReverbMultiplier", FloatValue) { it.globalPsychoticReverbMultiplier }
            property("MicrophonePreferredFractionCameraToGround", FloatValue) { it.microphonePreferredFractionCameraToGround }
            property("MicrophoneMinDistanceToCamera", IntValue) { it.microphoneMinDistanceToCamera }
            property("MicrophoneMaxDistanceToCamera", IntValue) { it.microphoneMaxDistanceToCamera }
            property("MicrophonePullTowardsTerrainLookAtPointPercent", FloatValue) { it.microphonePullTowardsTerrainLookAtPointPercent }
            property("LivingWorldMicrophonePreferredFractionCameraToGround", FloatValue) { it.livingWorldMicrophonePreferredFractionCameraToGround }
            property("LivingWorldMicrophoneMaxDistanceToCamera", IntValue) { it.livingWorldMicrophoneMaxDistanceToCamera }
            property("LivingWorldZoomMaxDistance", FloatValue) { it.livingWorldZoomMaxDistance }
            property("VoiceMoveToCampMaxCampnessAtStartPoint", IntValue) { it.voiceMoveToCampMaxCampnessAtStartPoint }
            property("VoiceMoveToCampMinCampnessAtEndPoint", IntValue) { it.voiceMoveToCampMinCampnessAtEndPoint }
            property("MinDelayBetweenEnterStateVoiceMS", IntValue) { it.minDelayBetweenEnterStateVoiceMS }
            property("Default2DSpeakerType", StringValue) { it.default2DSpeakerType }
            property("Default3DSoundVolume", FloatValue) { it.default3DSoundVolume }
            property("Default3DSpeakerType", StringValue) { it.default3DSpeakerType }
            property("DefaultSpeechVolume", FloatValue) { it.defaultSpeechVolume }
            property("MicrophoneDesiredHeightAboveTerrain", FloatValue) { it.microphoneDesiredHeightAboveTerrain }
            property("MicrophoneMaxPercentageBetweenGroundAndCamera", FloatValue) { it.microphoneMaxPercentageBetweenGroundAndCamera }
            property("Preferred3DHW1", StringValue) { it.preferred3DHW1 }
            property("Preferred3DHW2", StringValue) { it.preferred3DHW2 }
            property("Preferred3DSW", StringValue) { it.preferred3DSW }
            property("Relative2DVolume", FloatValue) { it.relative2DVolume }
            property("TimeBetweenDrawableSounds", IntValue) { it.timeBetweenDrawableSounds }
        },
    )
}
