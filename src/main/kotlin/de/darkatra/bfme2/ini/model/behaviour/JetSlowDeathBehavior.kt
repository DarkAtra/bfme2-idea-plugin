package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.DeathFlags
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.PhasedReferences
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SlowDeathPhase

data class JetSlowDeathBehavior(
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
    @SageIniName("FXOnGroundDeath") val fXOnGroundDeath: SageReference<FXList>? = null,
    @SageIniName("OCLOnGroundDeath") val oCLOnGroundDeath: SageReference<ObjectCreationList>? = null,
    @SageIniName("RollRate") val rollRate: Double = 0.0,
    @SageIniName("RollRateDelta") val rollRateDelta: Double = 0.0,
    @SageIniName("PitchRate") val pitchRate: Double = 0.0,
    @SageIniName("FallHowFast") val fallHowFast: Double = 0.0,
    @SageIniName("FXInitialDeath") val fXInitialDeath: SageReference<FXList>? = null,
    @SageIniName("OCLInitialDeath") val oCLInitialDeath: SageReference<ObjectCreationList>? = null,
    @SageIniName("DelaySecondaryFromInitialDeath") val delaySecondaryFromInitialDeath: Int = 0,
    @SageIniName("FXSecondary") val fXSecondary: SageReference<FXList>? = null,
    @SageIniName("OCLSecondary") val oCLSecondary: SageReference<ObjectCreationList>? = null,
    @SageIniName("FXHitGround") val fXHitGround: SageReference<FXList>? = null,
    @SageIniName("OCLHitGround") val oCLHitGround: SageReference<ObjectCreationList>? = null,
    @SageIniName("DelayFinalBlowUpFromHitGround") val delayFinalBlowUpFromHitGround: Int = 0,
    @SageIniName("FXFinalBlowUp") val fXFinalBlowUp: SageReference<FXList>? = null,
    @SageIniName("OCLFinalBlowUp") val oCLFinalBlowUp: SageReference<ObjectCreationList>? = null,
) : SlowDeathBehavior() {

    companion object : SageIniBlockDescriptor<JetSlowDeathBehavior>(
        name = "JetSlowDeathBehavior",
        parent = SlowDeathBehavior,
        properties = {
            property("FXOnGroundDeath", ReferenceValue<FXList> { listOf(FXList) }) { it.fXOnGroundDeath }
            property("OCLOnGroundDeath", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCLOnGroundDeath }
            property("RollRate", FloatValue) { it.rollRate }
            property("RollRateDelta", FloatValue) { it.rollRateDelta }
            property("PitchRate", FloatValue) { it.pitchRate }
            property("FallHowFast", FloatValue) { it.fallHowFast }
            property("FXInitialDeath", ReferenceValue<FXList> { listOf(FXList) }) { it.fXInitialDeath }
            property("OCLInitialDeath", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCLInitialDeath }
            property("DelaySecondaryFromInitialDeath", IntValue) { it.delaySecondaryFromInitialDeath }
            property("FXSecondary", ReferenceValue<FXList> { listOf(FXList) }) { it.fXSecondary }
            property("OCLSecondary", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCLSecondary }
            property("FXHitGround", ReferenceValue<FXList> { listOf(FXList) }) { it.fXHitGround }
            property("OCLHitGround", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCLHitGround }
            property("DelayFinalBlowUpFromHitGround", IntValue) { it.delayFinalBlowUpFromHitGround }
            property("FXFinalBlowUp", ReferenceValue<FXList> { listOf(FXList) }) { it.fXFinalBlowUp }
            property("OCLFinalBlowUp", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCLFinalBlowUp }
        },
    )
}
