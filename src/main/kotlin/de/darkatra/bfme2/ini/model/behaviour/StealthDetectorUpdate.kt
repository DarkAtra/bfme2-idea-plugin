package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference

data class StealthDetectorUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DetectionRate") val detectionRate: Int = 0,
    @SageIniName("InitiallyDisabled") val initiallyDisabled: Boolean = false,
    @SageIniName("DetectionRange") val detectionRange: Double = 0.0,
    @SageIniName("CanDetectWhileGarrisoned") val canDetectWhileGarrisoned: Boolean = false,
    @SageIniName("CanDetectWhileContained") val canDetectWhileContained: Boolean = false,
    @SageIniName("ExtraRequiredKindOf") val extraRequiredKindOf: List<KindOf> = emptyList(),
    @SageIniName("PingSound") val pingSound: SageReference<AudioEvent>? = null,
    @SageIniName("LoudPingSound") val loudPingSound: SageReference<AudioEvent>? = null,
    @SageIniName("IRParticleSysName") val iRParticleSysName: SageReference<FXParticleSystem>? = null,
    @SageIniName("IRBrightParticleSysName") val iRBrightParticleSysName: SageReference<FXParticleSystem>? = null,
    @SageIniName("IRGridParticleSysName") val iRGridParticleSysName: SageReference<FXParticleSystem>? = null,
    @SageIniName("IRBeaconParticleSysName") val iRBeaconParticleSysName: SageReference<FXParticleSystem>? = null,
    @SageIniName("IRParticleSysBone") val iRParticleSysBone: Opaque? = null,
    @SageIniName("CancelOneRingEffect") val cancelOneRingEffect: Boolean = false,
    @SageIniName("RequiredUpgrade") val requiredUpgrade: SageReference<Upgrade>? = null,
    @SageIniName("ExtraForbiddenKindOf") val extraForbiddenKindOf: List<KindOf> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<StealthDetectorUpdate>(
        name = "StealthDetectorUpdate",
        properties = {
            property("DetectionRate", IntValue) { it.detectionRate }
            property("InitiallyDisabled", BooleanValue) { it.initiallyDisabled }
            property("DetectionRange", FloatValue) { it.detectionRange }
            property("CanDetectWhileGarrisoned", BooleanValue) { it.canDetectWhileGarrisoned }
            property("CanDetectWhileContained", BooleanValue) { it.canDetectWhileContained }
            property("ExtraRequiredKindOf", ListValue(KindOf.type)) { it.extraRequiredKindOf }
            property("PingSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.pingSound }
            property("LoudPingSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.loudPingSound }
            property("IRParticleSysName", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.iRParticleSysName }
            property("IRBrightParticleSysName", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.iRBrightParticleSysName }
            property("IRGridParticleSysName", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.iRGridParticleSysName }
            property("IRBeaconParticleSysName", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.iRBeaconParticleSysName }
            property("IRParticleSysBone", Opaque.type) { it.iRParticleSysBone }
            property("CancelOneRingEffect", BooleanValue) { it.cancelOneRingEffect }
            property("RequiredUpgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.requiredUpgrade }
            property("ExtraForbiddenKindOf", ListValue(KindOf.type)) { it.extraForbiddenKindOf }
        },
    )
}
