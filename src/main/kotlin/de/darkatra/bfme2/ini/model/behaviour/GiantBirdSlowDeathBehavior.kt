package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.DeathFlags
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.PhasedReferences
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SlowDeathPhase

data class GiantBirdSlowDeathBehavior(
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
    @SageIniName("OCLHitGround") val oCLHitGround: SageReference<ObjectCreationList>? = null,
    @SageIniName("DelayFromGroundToFinalDeath") val delayFromGroundToFinalDeath: Int = 0,
    @SageIniName("CrashAvoidKindOfs") val crashAvoidKindOfs: List<KindOf> = emptyList(),
    @SageIniName("CrashAvoidRadius") val crashAvoidRadius: Double = 0.0,
    @SageIniName("CrashAvoidStrength") val crashAvoidStrength: Double = 0.0,
    @SageIniName("NeedToMaintainFlailingHeight") val needToMaintainFlailingHeight: Boolean = false,
    @SageIniName("FXHitGround") val fXHitGround: SageReference<FXList>? = null,
) : SlowDeathBehavior() {

    companion object : SageIniBlockDescriptor<GiantBirdSlowDeathBehavior>(
        name = "GiantBirdSlowDeathBehavior",
        parent = SlowDeathBehavior,
        properties = {
            property("OCLHitGround", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCLHitGround }
            property("DelayFromGroundToFinalDeath", IntValue) { it.delayFromGroundToFinalDeath }
            property("CrashAvoidKindOfs", ListValue(KindOf.type)) { it.crashAvoidKindOfs }
            property("CrashAvoidRadius", FloatValue) { it.crashAvoidRadius }
            property("CrashAvoidStrength", FloatValue) { it.crashAvoidStrength }
            property("NeedToMaintainFlailingHeight", BooleanValue) { it.needToMaintainFlailingHeight }
            property("FXHitGround", ReferenceValue<FXList> { listOf(FXList) }) { it.fXHitGround }
        },
    )
}
