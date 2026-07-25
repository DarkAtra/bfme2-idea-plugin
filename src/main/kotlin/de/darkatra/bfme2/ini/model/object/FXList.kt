package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.fx.AttachedModel
import de.darkatra.bfme2.ini.model.fx.BuffNugget
import de.darkatra.bfme2.ini.model.fx.CameraShakerVolume
import de.darkatra.bfme2.ini.model.fx.DynamicDecal
import de.darkatra.bfme2.ini.model.fx.EvaEvent
import de.darkatra.bfme2.ini.model.fx.FXListAtBonePos
import de.darkatra.bfme2.ini.model.fx.LightPulse
import de.darkatra.bfme2.ini.model.fx.Sound
import de.darkatra.bfme2.ini.model.fx.TerrainScorch
import de.darkatra.bfme2.ini.model.fx.TintDrawable
import de.darkatra.bfme2.ini.model.fx.ViewShake
import de.darkatra.bfme2.ini.model.particle.ParticleSystem
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.ParticleSysBone
import de.darkatra.bfme2.ini.model.value.Untyped

data class FXList(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PlayEvenIfShrouded") val playEvenIfShrouded: Boolean = false,
    @SageIniName("ParticleSysBone") val particleSysBone: List<ParticleSysBone> = emptyList(),
    @SageIniName("CullingInfo") val cullingInfo: Untyped? = null,
    @SageIniName("CursorParticleSystem") val cursorParticleSystem: Opaque? = null,
    @SageIniName("Tracer") val tracer: Opaque? = null,
    @SageIniName("ParticleSystem") val particleSystem: List<ParticleSystem> = emptyList(),
    @SageIniName("Sound") val sound: List<Sound> = emptyList(),
    @SageIniName("EvaEvent") val evaEvent: List<EvaEvent> = emptyList(),
    @SageIniName("DynamicDecal") val dynamicDecal: List<DynamicDecal> = emptyList(),
    @SageIniName("FXListAtBonePos") val fxListAtBonePos: List<FXListAtBonePos> = emptyList(),
    @SageIniName("TerrainScorch") val terrainScorch: List<TerrainScorch> = emptyList(),
    @SageIniName("CameraShakerVolume") val cameraShakerVolume: List<CameraShakerVolume> = emptyList(),
    @SageIniName("BuffNugget") val buffNugget: List<BuffNugget> = emptyList(),
    @SageIniName("ViewShake") val viewShake: List<ViewShake> = emptyList(),
    @SageIniName("TintDrawable") val tintDrawable: List<TintDrawable> = emptyList(),
    @SageIniName("LightPulse") val lightPulse: List<LightPulse> = emptyList(),
    @SageIniName("AttachedModel") val attachedModel: List<AttachedModel> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<FXList>(
        name = "FXList",
        tableKey = "fxlists",
        properties = {
            property("PlayEvenIfShrouded", BooleanValue) { it.playEvenIfShrouded }
            property("ParticleSysBone", ListValue(ParticleSysBone.type)) { it.particleSysBone }
            property("CullingInfo", Untyped.type) { it.cullingInfo }
            property("CursorParticleSystem", Opaque.type) { it.cursorParticleSystem }
            property("Tracer", Opaque.type) { it.tracer }
            property("ParticleSystem", ListValue(BlockValue<ParticleSystem> { listOf(ParticleSystem) })) { it.particleSystem }
            property("Sound", ListValue(BlockValue<Sound> { listOf(Sound) })) { it.sound }
            property("EvaEvent", ListValue(BlockValue<EvaEvent> { listOf(EvaEvent) })) { it.evaEvent }
            property("DynamicDecal", ListValue(BlockValue<DynamicDecal> { listOf(DynamicDecal) })) { it.dynamicDecal }
            property("FXListAtBonePos", ListValue(BlockValue<FXListAtBonePos> { listOf(FXListAtBonePos) })) { it.fxListAtBonePos }
            property("TerrainScorch", ListValue(BlockValue<TerrainScorch> { listOf(TerrainScorch) })) { it.terrainScorch }
            property("CameraShakerVolume", ListValue(BlockValue<CameraShakerVolume> { listOf(CameraShakerVolume) })) { it.cameraShakerVolume }
            property("BuffNugget", ListValue(BlockValue<BuffNugget> { listOf(BuffNugget) })) { it.buffNugget }
            property("ViewShake", ListValue(BlockValue<ViewShake> { listOf(ViewShake) })) { it.viewShake }
            property("TintDrawable", ListValue(BlockValue<TintDrawable> { listOf(TintDrawable) })) { it.tintDrawable }
            property("LightPulse", ListValue(BlockValue<LightPulse> { listOf(LightPulse) })) { it.lightPulse }
            property("AttachedModel", ListValue(BlockValue<AttachedModel> { listOf(AttachedModel) })) { it.attachedModel }
        },
    )
}
