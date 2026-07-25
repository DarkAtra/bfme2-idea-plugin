package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Untyped

data class StaticGameLOD(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ModelLOD") val modelLOD: Untyped? = null,
    @SageIniName("EffectsLOD") val effectsLOD: Untyped? = null,
    @SageIniName("ShadowLOD") val shadowLOD: Untyped? = null,
    @SageIniName("WaterLOD") val waterLOD: Untyped? = null,
    @SageIniName("AnimationDetail") val animationDetail: Untyped? = null,
    @SageIniName("ShaderLOD") val shaderLOD: Untyped? = null,
    @SageIniName("DecalLOD") val decalLOD: Untyped? = null,
    @SageIniName("MinParticlePriority") val minParticlePriority: Untyped? = null,
    @SageIniName("MinParticleSkipPriority") val minParticleSkipPriority: Untyped? = null,
    @SageIniName("MaxParticleCount") val maxParticleCount: Int = 0,
    @SageIniName("MaxTankTrackEdges") val maxTankTrackEdges: Int = 0,
    @SageIniName("MaxTankTrackOpaqueEdges") val maxTankTrackOpaqueEdges: Int = 0,
    @SageIniName("MaxTankTrackFadeDelay") val maxTankTrackFadeDelay: Int = 0,
    @SageIniName("TextureReductionFactor") val textureReductionFactor: Int = 0,
    @SageIniName("UseShadowVolumes") val useShadowVolumes: Boolean = false,
    @SageIniName("UseShadowDecals") val useShadowDecals: Boolean = false,
    @SageIniName("UseShadowMapping") val useShadowMapping: Boolean = false,
    @SageIniName("UseTerrainNormalMap") val useTerrainNormalMap: Boolean = false,
    @SageIniName("UseDistanceDependantTerrainTextures") val useDistanceDependantTerrainTextures: Boolean = false,
    @SageIniName("ShowSoftWaterEdge") val showSoftWaterEdge: Boolean = false,
    @SageIniName("ShowProps") val showProps: Boolean = false,
    @SageIniName("ShaderMaterialReplacement") val shaderMaterialReplacement: Boolean = false,
    @SageIniName("UseHeatEffects") val useHeatEffects: Boolean = false,
    @SageIniName("MinimumFPS") val minimumFPS: Int = 0,
    @SageIniName("MinimumProcessorFps") val minimumProcessorFps: Int = 0,
    @SageIniName("SampleCount2D") val sampleCount2D: Int = 0,
    @SageIniName("SampleCount3D") val sampleCount3D: Int = 0,
    @SageIniName("StreamCount") val streamCount: Int = 0,
    @SageIniName("UseAnisotropic") val useAnisotropic: Boolean = false,
    @SageIniName("UseBuildupScaffolds") val useBuildupScaffolds: Boolean = false,
    @SageIniName("UseCloudMap") val useCloudMap: Boolean = false,
    @SageIniName("UseEmissiveNightMaterials") val useEmissiveNightMaterials: Boolean = false,
    @SageIniName("UseHighQualityVideo") val useHighQualityVideo: Boolean = false,
    @SageIniName("UseLightMap") val useLightMap: Boolean = false,
    @SageIniName("UsePixelShaders") val usePixelShaders: Boolean = false,
    @SageIniName("UseTreeSway") val useTreeSway: Boolean = false,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<StaticGameLOD>(
        name = "StaticGameLOD",
        tableKey = "staticgamelods",
        properties = {
            property("ModelLOD", Untyped.type) { it.modelLOD }
            property("EffectsLOD", Untyped.type) { it.effectsLOD }
            property("ShadowLOD", Untyped.type) { it.shadowLOD }
            property("WaterLOD", Untyped.type) { it.waterLOD }
            property("AnimationDetail", Untyped.type) { it.animationDetail }
            property("ShaderLOD", Untyped.type) { it.shaderLOD }
            property("DecalLOD", Untyped.type) { it.decalLOD }
            property("MinParticlePriority", Untyped.type) { it.minParticlePriority }
            property("MinParticleSkipPriority", Untyped.type) { it.minParticleSkipPriority }
            property("MaxParticleCount", IntValue) { it.maxParticleCount }
            property("MaxTankTrackEdges", IntValue) { it.maxTankTrackEdges }
            property("MaxTankTrackOpaqueEdges", IntValue) { it.maxTankTrackOpaqueEdges }
            property("MaxTankTrackFadeDelay", IntValue) { it.maxTankTrackFadeDelay }
            property("TextureReductionFactor", IntValue) { it.textureReductionFactor }
            property("UseShadowVolumes", BooleanValue) { it.useShadowVolumes }
            property("UseShadowDecals", BooleanValue) { it.useShadowDecals }
            property("UseShadowMapping", BooleanValue) { it.useShadowMapping }
            property("UseTerrainNormalMap", BooleanValue) { it.useTerrainNormalMap }
            property("UseDistanceDependantTerrainTextures", BooleanValue) { it.useDistanceDependantTerrainTextures }
            property("ShowSoftWaterEdge", BooleanValue) { it.showSoftWaterEdge }
            property("ShowProps", BooleanValue) { it.showProps }
            property("ShaderMaterialReplacement", BooleanValue) { it.shaderMaterialReplacement }
            property("UseHeatEffects", BooleanValue) { it.useHeatEffects }
            property("MinimumFPS", IntValue) { it.minimumFPS }
            property("MinimumProcessorFps", IntValue) { it.minimumProcessorFps }
            property("SampleCount2D", IntValue) { it.sampleCount2D }
            property("SampleCount3D", IntValue) { it.sampleCount3D }
            property("StreamCount", IntValue) { it.streamCount }
            property("UseAnisotropic", BooleanValue) { it.useAnisotropic }
            property("UseBuildupScaffolds", BooleanValue) { it.useBuildupScaffolds }
            property("UseCloudMap", BooleanValue) { it.useCloudMap }
            property("UseEmissiveNightMaterials", BooleanValue) { it.useEmissiveNightMaterials }
            property("UseHighQualityVideo", BooleanValue) { it.useHighQualityVideo }
            property("UseLightMap", BooleanValue) { it.useLightMap }
            property("UsePixelShaders", BooleanValue) { it.usePixelShaders }
            property("UseTreeSway", BooleanValue) { it.useTreeSway }
        },
    )
}
