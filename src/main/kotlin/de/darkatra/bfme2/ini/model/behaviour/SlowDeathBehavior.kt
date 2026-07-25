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
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.PhasedReferences
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SlowDeathPhase

open class SlowDeathBehavior(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") override val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Int = 0,
    @SageIniName("SinkRate") open val sinkRate: Double = 0.0,
    @SageIniName("ProbabilityModifier") open val probabilityModifier: Int = 0,
    @SageIniName("ModifierBonusPerOverkillPercent") open val modifierBonusPerOverkillPercent: Double = 0.0,
    @SageIniName("DeathFlags") open val deathFlags: DeathFlags? = null,
    @SageIniName("FadeTime") open val fadeTime: Int = 0,
    @SageIniName("FadeDelay") open val fadeDelay: Int = 0,
    @SageIniName("ShadowWhenDead") open val shadowWhenDead: Boolean = false,
    @SageIniName("SinkDelay") open val sinkDelay: Int = 0,
    @SageIniName("SinkDelayVariance") open val sinkDelayVariance: Int = 0,
    @SageIniName("DestructionDelay") open val destructionDelay: Int = 0,
    @SageIniName("DestructionDelayVariance") open val destructionDelayVariance: Int = 0,
    @SageIniName("DecayBeginTime") open val decayBeginTime: Int = 0,
    @SageIniName("OCL") open val oCL: List<PhasedReferences<SlowDeathPhase, ObjectCreationList>> = emptyList(),
    @SageIniName("Weapon") open val weapon: List<PhasedReferences<SlowDeathPhase, Weapon>> = emptyList(),
    @SageIniName("FX") open val fX: List<PhasedReferences<SlowDeathPhase, FXList>> = emptyList(),
    @SageIniName("Sound") open val sound: List<PhasedReferences<SlowDeathPhase, AudioEvent>> = emptyList(),
    @SageIniName("FlingForce") open val flingForce: Int = 0,
    @SageIniName("FlingForceVariance") open val flingForceVariance: Int = 0,
    @SageIniName("FlingPitch") open val flingPitch: Int = 0,
    @SageIniName("FlingPitchVariance") open val flingPitchVariance: Int = 0,
    @SageIniName("DoNotRandomizeMidpoint") open val doNotRandomizeMidpoint: Boolean = false,
) : DieBehavior() {

    companion object : SageIniBlockDescriptor<SlowDeathBehavior>(
        name = "SlowDeathBehavior",
        parent = DieBehavior,
        properties = {
            property("SinkRate", FloatValue) { it.sinkRate }
            property("ProbabilityModifier", IntValue) { it.probabilityModifier }
            property("ModifierBonusPerOverkillPercent", FloatValue) { it.modifierBonusPerOverkillPercent }
            property("DeathFlags", DeathFlags.type) { it.deathFlags }
            property("FadeTime", IntValue) { it.fadeTime }
            property("FadeDelay", IntValue) { it.fadeDelay }
            property("ShadowWhenDead", BooleanValue) { it.shadowWhenDead }
            property("SinkDelay", IntValue) { it.sinkDelay }
            property("SinkDelayVariance", IntValue) { it.sinkDelayVariance }
            property("DestructionDelay", IntValue) { it.destructionDelay }
            property("DestructionDelayVariance", IntValue) { it.destructionDelayVariance }
            property("DecayBeginTime", IntValue) { it.decayBeginTime }
            property("OCL", ListValue(PhasedReferences.type(SlowDeathPhase.type, ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }))) { it.oCL }
            property("Weapon", ListValue(PhasedReferences.type(SlowDeathPhase.type, ReferenceValue<Weapon> { listOf(Weapon) }))) { it.weapon }
            property("FX", ListValue(PhasedReferences.type(SlowDeathPhase.type, ReferenceValue<FXList> { listOf(FXList) }))) { it.fX }
            property("Sound", ListValue(PhasedReferences.type(SlowDeathPhase.type, ReferenceValue<AudioEvent> { listOf(AudioEvent) }))) { it.sound }
            property("FlingForce", IntValue) { it.flingForce }
            property("FlingForceVariance", IntValue) { it.flingForceVariance }
            property("FlingPitch", IntValue) { it.flingPitch }
            property("FlingPitchVariance", IntValue) { it.flingPitchVariance }
            property("DoNotRandomizeMidpoint", BooleanValue) { it.doNotRandomizeMidpoint }
        },
    )
}
