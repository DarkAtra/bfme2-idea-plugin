package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.DeathFlags
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.PhasedReferences
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SlowDeathPhase

data class HelicopterSlowDeathBehavior(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") override val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Int = 0,
    @SageIniName("SinkRate") override val sinkRate: Double = 0.0,
    @SageIniName("ProbabilityModifier") override val probabilityModifier: Int = 0,
    @SageIniName("ModifierBonusPerOverkillPercent") override val modifierBonusPerOverkillPercent: Double = 0.0,
    @SageIniName("DeathFlags") override val deathFlags: DeathFlags? = null,
    @SageIniName("FadeTime") override val fadeTime: Int = 0,
    @SageIniName("FadeDelay") override val fadeDelay: Int = 0,
    @SageIniName("ShadowWhenDead") override val shadowWhenDead: Boolean = false,
    @SageIniName("SinkDelay") override val sinkDelay: Int = 0,
    @SageIniName("SinkDelayVariance") override val sinkDelayVariance: Int = 0,
    @SageIniName("DestructionDelay") override val destructionDelay: Int = 0,
    @SageIniName("DestructionDelayVariance") override val destructionDelayVariance: Int = 0,
    @SageIniName("DecayBeginTime") override val decayBeginTime: Int = 0,
    @SageIniName("OCL") override val oCL: List<PhasedReferences<SlowDeathPhase, ObjectCreationList>> = emptyList(),
    @SageIniName("Weapon") override val weapon: List<PhasedReferences<SlowDeathPhase, Weapon>> = emptyList(),
    @SageIniName("FX") override val fX: List<PhasedReferences<SlowDeathPhase, FXList>> = emptyList(),
    @SageIniName("Sound") override val sound: List<PhasedReferences<SlowDeathPhase, AudioEvent>> = emptyList(),
    @SageIniName("FlingForce") override val flingForce: Int = 0,
    @SageIniName("FlingForceVariance") override val flingForceVariance: Int = 0,
    @SageIniName("FlingPitch") override val flingPitch: Int = 0,
    @SageIniName("FlingPitchVariance") override val flingPitchVariance: Int = 0,
    @SageIniName("DoNotRandomizeMidpoint") override val doNotRandomizeMidpoint: Boolean = false,
    @SageIniName("SpiralOrbitTurnRate") val spiralOrbitTurnRate: Double = 0.0,
    @SageIniName("SpiralOrbitForwardSpeed") val spiralOrbitForwardSpeed: Double = 0.0,
    @SageIniName("SpiralOrbitForwardSpeedDamping") val spiralOrbitForwardSpeedDamping: Double = 0.0,
    @SageIniName("MaxBraking") val maxBraking: Int = 0,
    @SageIniName("SoundDeathLoop") val soundDeathLoop: SageReference<AudioEvent>? = null,
    @SageIniName("MinSelfSpin") val minSelfSpin: Int = 0,
    @SageIniName("MaxSelfSpin") val maxSelfSpin: Int = 0,
    @SageIniName("SelfSpinUpdateDelay") val selfSpinUpdateDelay: Int = 0,
    @SageIniName("SelfSpinUpdateAmount") val selfSpinUpdateAmount: Int = 0,
    @SageIniName("FallHowFast") val fallHowFast: Double = 0.0,
    @SageIniName("MinBladeFlyOffDelay") val minBladeFlyOffDelay: Int = 0,
    @SageIniName("MaxBladeFlyOffDelay") val maxBladeFlyOffDelay: Int = 0,
    @SageIniName("AttachParticle") val attachParticle: SageReference<FXParticleSystem>? = null,
    @SageIniName("AttachParticleBone") val attachParticleBone: Opaque? = null,
    @SageIniName("BladeObjectName") val bladeObjectName: SageReference<Object>? = null,
    @SageIniName("BladeBoneName") val bladeBoneName: Opaque? = null,
    @SageIniName("OCLEjectPilot") val oCLEjectPilot: SageReference<ObjectCreationList>? = null,
    @SageIniName("FXBlade") val fXBlade: SageReference<FXList>? = null,
    @SageIniName("OCLBlade") val oCLBlade: SageReference<ObjectCreationList>? = null,
    @SageIniName("FXHitGround") val fXHitGround: SageReference<FXList>? = null,
    @SageIniName("OCLHitGround") val oCLHitGround: SageReference<ObjectCreationList>? = null,
    @SageIniName("FXFinalBlowUp") val fXFinalBlowUp: SageReference<FXList>? = null,
    @SageIniName("OCLFinalBlowUp") val oCLFinalBlowUp: SageReference<ObjectCreationList>? = null,
    @SageIniName("DelayFromGroundToFinalDeath") val delayFromGroundToFinalDeath: Int = 0,
    @SageIniName("FinalRubbleObject") val finalRubbleObject: SageReference<Object>? = null,
) : SlowDeathBehavior() {

    companion object : SageIniBlockDescriptor<HelicopterSlowDeathBehavior>(
        name = "HelicopterSlowDeathBehavior",
        parent = SlowDeathBehavior,
        properties = {
            property("SpiralOrbitTurnRate", FloatValue) { it.spiralOrbitTurnRate }
            property("SpiralOrbitForwardSpeed", FloatValue) { it.spiralOrbitForwardSpeed }
            property("SpiralOrbitForwardSpeedDamping", FloatValue) { it.spiralOrbitForwardSpeedDamping }
            property("MaxBraking", IntValue) { it.maxBraking }
            property("SoundDeathLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundDeathLoop }
            property("MinSelfSpin", IntValue) { it.minSelfSpin }
            property("MaxSelfSpin", IntValue) { it.maxSelfSpin }
            property("SelfSpinUpdateDelay", IntValue) { it.selfSpinUpdateDelay }
            property("SelfSpinUpdateAmount", IntValue) { it.selfSpinUpdateAmount }
            property("FallHowFast", FloatValue) { it.fallHowFast }
            property("MinBladeFlyOffDelay", IntValue) { it.minBladeFlyOffDelay }
            property("MaxBladeFlyOffDelay", IntValue) { it.maxBladeFlyOffDelay }
            property("AttachParticle", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.attachParticle }
            property("AttachParticleBone", Opaque.type) { it.attachParticleBone }
            property("BladeObjectName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.bladeObjectName }
            property("BladeBoneName", Opaque.type) { it.bladeBoneName }
            property("OCLEjectPilot", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCLEjectPilot }
            property("FXBlade", ReferenceValue<FXList> { listOf(FXList) }) { it.fXBlade }
            property("OCLBlade", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCLBlade }
            property("FXHitGround", ReferenceValue<FXList> { listOf(FXList) }) { it.fXHitGround }
            property("OCLHitGround", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCLHitGround }
            property("FXFinalBlowUp", ReferenceValue<FXList> { listOf(FXList) }) { it.fXFinalBlowUp }
            property("OCLFinalBlowUp", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCLFinalBlowUp }
            property("DelayFromGroundToFinalDeath", IntValue) { it.delayFromGroundToFinalDeath }
            property("FinalRubbleObject", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.finalRubbleObject }
        },
    )
}
