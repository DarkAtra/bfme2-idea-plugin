package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
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

data class NeutronMissileSlowDeathBehavior(
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
    @SageIniName("ScorchMarkSize") val scorchMarkSize: Int = 0,
    @SageIniName("FXList") val fXList: SageReference<FXList>? = null,
    @SageIniName("Blast1Enabled") val blast1Enabled: Boolean = false,
    @SageIniName("Blast1Delay") val blast1Delay: Int = 0,
    @SageIniName("Blast1ScorchDelay") val blast1ScorchDelay: Int = 0,
    @SageIniName("Blast1InnerRadius") val blast1InnerRadius: Double = 0.0,
    @SageIniName("Blast1OuterRadius") val blast1OuterRadius: Double = 0.0,
    @SageIniName("Blast1MaxDamage") val blast1MaxDamage: Double = 0.0,
    @SageIniName("Blast1MinDamage") val blast1MinDamage: Double = 0.0,
    @SageIniName("Blast1ToppleSpeed") val blast1ToppleSpeed: Double = 0.0,
    @SageIniName("Blast1PushForce") val blast1PushForce: Double = 0.0,
    @SageIniName("Blast2Enabled") val blast2Enabled: Boolean = false,
    @SageIniName("Blast2Delay") val blast2Delay: Int = 0,
    @SageIniName("Blast2ScorchDelay") val blast2ScorchDelay: Int = 0,
    @SageIniName("Blast2InnerRadius") val blast2InnerRadius: Double = 0.0,
    @SageIniName("Blast2OuterRadius") val blast2OuterRadius: Double = 0.0,
    @SageIniName("Blast2MaxDamage") val blast2MaxDamage: Double = 0.0,
    @SageIniName("Blast2MinDamage") val blast2MinDamage: Double = 0.0,
    @SageIniName("Blast2ToppleSpeed") val blast2ToppleSpeed: Double = 0.0,
    @SageIniName("Blast2PushForce") val blast2PushForce: Double = 0.0,
    @SageIniName("Blast3Enabled") val blast3Enabled: Boolean = false,
    @SageIniName("Blast3Delay") val blast3Delay: Int = 0,
    @SageIniName("Blast3ScorchDelay") val blast3ScorchDelay: Int = 0,
    @SageIniName("Blast3InnerRadius") val blast3InnerRadius: Double = 0.0,
    @SageIniName("Blast3OuterRadius") val blast3OuterRadius: Double = 0.0,
    @SageIniName("Blast3MaxDamage") val blast3MaxDamage: Double = 0.0,
    @SageIniName("Blast3MinDamage") val blast3MinDamage: Double = 0.0,
    @SageIniName("Blast3ToppleSpeed") val blast3ToppleSpeed: Double = 0.0,
    @SageIniName("Blast3PushForce") val blast3PushForce: Double = 0.0,
    @SageIniName("Blast4Enabled") val blast4Enabled: Boolean = false,
    @SageIniName("Blast4Delay") val blast4Delay: Int = 0,
    @SageIniName("Blast4ScorchDelay") val blast4ScorchDelay: Int = 0,
    @SageIniName("Blast4InnerRadius") val blast4InnerRadius: Double = 0.0,
    @SageIniName("Blast4OuterRadius") val blast4OuterRadius: Double = 0.0,
    @SageIniName("Blast4MaxDamage") val blast4MaxDamage: Double = 0.0,
    @SageIniName("Blast4MinDamage") val blast4MinDamage: Double = 0.0,
    @SageIniName("Blast4ToppleSpeed") val blast4ToppleSpeed: Double = 0.0,
    @SageIniName("Blast4PushForce") val blast4PushForce: Double = 0.0,
    @SageIniName("Blast5Enabled") val blast5Enabled: Boolean = false,
    @SageIniName("Blast5Delay") val blast5Delay: Int = 0,
    @SageIniName("Blast5ScorchDelay") val blast5ScorchDelay: Int = 0,
    @SageIniName("Blast5InnerRadius") val blast5InnerRadius: Double = 0.0,
    @SageIniName("Blast5OuterRadius") val blast5OuterRadius: Double = 0.0,
    @SageIniName("Blast5MaxDamage") val blast5MaxDamage: Double = 0.0,
    @SageIniName("Blast5MinDamage") val blast5MinDamage: Double = 0.0,
    @SageIniName("Blast5ToppleSpeed") val blast5ToppleSpeed: Double = 0.0,
    @SageIniName("Blast5PushForce") val blast5PushForce: Double = 0.0,
    @SageIniName("Blast6Enabled") val blast6Enabled: Boolean = false,
    @SageIniName("Blast6Delay") val blast6Delay: Int = 0,
    @SageIniName("Blast6ScorchDelay") val blast6ScorchDelay: Int = 0,
    @SageIniName("Blast6InnerRadius") val blast6InnerRadius: Double = 0.0,
    @SageIniName("Blast6OuterRadius") val blast6OuterRadius: Double = 0.0,
    @SageIniName("Blast6MaxDamage") val blast6MaxDamage: Double = 0.0,
    @SageIniName("Blast6MinDamage") val blast6MinDamage: Double = 0.0,
    @SageIniName("Blast6ToppleSpeed") val blast6ToppleSpeed: Double = 0.0,
    @SageIniName("Blast6PushForce") val blast6PushForce: Double = 0.0,
    @SageIniName("Blast7Enabled") val blast7Enabled: Boolean = false,
    @SageIniName("Blast7Delay") val blast7Delay: Int = 0,
    @SageIniName("Blast7ScorchDelay") val blast7ScorchDelay: Int = 0,
    @SageIniName("Blast7InnerRadius") val blast7InnerRadius: Double = 0.0,
    @SageIniName("Blast7OuterRadius") val blast7OuterRadius: Double = 0.0,
    @SageIniName("Blast7MaxDamage") val blast7MaxDamage: Double = 0.0,
    @SageIniName("Blast7MinDamage") val blast7MinDamage: Double = 0.0,
    @SageIniName("Blast7ToppleSpeed") val blast7ToppleSpeed: Double = 0.0,
    @SageIniName("Blast7PushForce") val blast7PushForce: Double = 0.0,
    @SageIniName("Blast8Enabled") val blast8Enabled: Boolean = false,
    @SageIniName("Blast8Delay") val blast8Delay: Int = 0,
    @SageIniName("Blast8ScorchDelay") val blast8ScorchDelay: Int = 0,
    @SageIniName("Blast8InnerRadius") val blast8InnerRadius: Double = 0.0,
    @SageIniName("Blast8OuterRadius") val blast8OuterRadius: Double = 0.0,
    @SageIniName("Blast8MaxDamage") val blast8MaxDamage: Double = 0.0,
    @SageIniName("Blast8MinDamage") val blast8MinDamage: Double = 0.0,
    @SageIniName("Blast8ToppleSpeed") val blast8ToppleSpeed: Double = 0.0,
    @SageIniName("Blast8PushForce") val blast8PushForce: Double = 0.0,
    @SageIniName("Blast9Enabled") val blast9Enabled: Boolean = false,
    @SageIniName("Blast9Delay") val blast9Delay: Int = 0,
    @SageIniName("Blast9ScorchDelay") val blast9ScorchDelay: Int = 0,
    @SageIniName("Blast9InnerRadius") val blast9InnerRadius: Double = 0.0,
    @SageIniName("Blast9OuterRadius") val blast9OuterRadius: Double = 0.0,
    @SageIniName("Blast9MaxDamage") val blast9MaxDamage: Double = 0.0,
    @SageIniName("Blast9MinDamage") val blast9MinDamage: Double = 0.0,
    @SageIniName("Blast9ToppleSpeed") val blast9ToppleSpeed: Double = 0.0,
    @SageIniName("Blast9PushForce") val blast9PushForce: Double = 0.0,
) : SlowDeathBehavior() {

    companion object : SageIniBlockDescriptor<NeutronMissileSlowDeathBehavior>(
        name = "NeutronMissileSlowDeathBehavior",
        parent = SlowDeathBehavior,
        properties = {
            property("ScorchMarkSize", IntValue) { it.scorchMarkSize }
            property("FXList", ReferenceValue<FXList> { listOf(FXList) }) { it.fXList }
            property("Blast1Enabled", BooleanValue) { it.blast1Enabled }
            property("Blast1Delay", IntValue) { it.blast1Delay }
            property("Blast1ScorchDelay", IntValue) { it.blast1ScorchDelay }
            property("Blast1InnerRadius", FloatValue) { it.blast1InnerRadius }
            property("Blast1OuterRadius", FloatValue) { it.blast1OuterRadius }
            property("Blast1MaxDamage", FloatValue) { it.blast1MaxDamage }
            property("Blast1MinDamage", FloatValue) { it.blast1MinDamage }
            property("Blast1ToppleSpeed", FloatValue) { it.blast1ToppleSpeed }
            property("Blast1PushForce", FloatValue) { it.blast1PushForce }
            property("Blast2Enabled", BooleanValue) { it.blast2Enabled }
            property("Blast2Delay", IntValue) { it.blast2Delay }
            property("Blast2ScorchDelay", IntValue) { it.blast2ScorchDelay }
            property("Blast2InnerRadius", FloatValue) { it.blast2InnerRadius }
            property("Blast2OuterRadius", FloatValue) { it.blast2OuterRadius }
            property("Blast2MaxDamage", FloatValue) { it.blast2MaxDamage }
            property("Blast2MinDamage", FloatValue) { it.blast2MinDamage }
            property("Blast2ToppleSpeed", FloatValue) { it.blast2ToppleSpeed }
            property("Blast2PushForce", FloatValue) { it.blast2PushForce }
            property("Blast3Enabled", BooleanValue) { it.blast3Enabled }
            property("Blast3Delay", IntValue) { it.blast3Delay }
            property("Blast3ScorchDelay", IntValue) { it.blast3ScorchDelay }
            property("Blast3InnerRadius", FloatValue) { it.blast3InnerRadius }
            property("Blast3OuterRadius", FloatValue) { it.blast3OuterRadius }
            property("Blast3MaxDamage", FloatValue) { it.blast3MaxDamage }
            property("Blast3MinDamage", FloatValue) { it.blast3MinDamage }
            property("Blast3ToppleSpeed", FloatValue) { it.blast3ToppleSpeed }
            property("Blast3PushForce", FloatValue) { it.blast3PushForce }
            property("Blast4Enabled", BooleanValue) { it.blast4Enabled }
            property("Blast4Delay", IntValue) { it.blast4Delay }
            property("Blast4ScorchDelay", IntValue) { it.blast4ScorchDelay }
            property("Blast4InnerRadius", FloatValue) { it.blast4InnerRadius }
            property("Blast4OuterRadius", FloatValue) { it.blast4OuterRadius }
            property("Blast4MaxDamage", FloatValue) { it.blast4MaxDamage }
            property("Blast4MinDamage", FloatValue) { it.blast4MinDamage }
            property("Blast4ToppleSpeed", FloatValue) { it.blast4ToppleSpeed }
            property("Blast4PushForce", FloatValue) { it.blast4PushForce }
            property("Blast5Enabled", BooleanValue) { it.blast5Enabled }
            property("Blast5Delay", IntValue) { it.blast5Delay }
            property("Blast5ScorchDelay", IntValue) { it.blast5ScorchDelay }
            property("Blast5InnerRadius", FloatValue) { it.blast5InnerRadius }
            property("Blast5OuterRadius", FloatValue) { it.blast5OuterRadius }
            property("Blast5MaxDamage", FloatValue) { it.blast5MaxDamage }
            property("Blast5MinDamage", FloatValue) { it.blast5MinDamage }
            property("Blast5ToppleSpeed", FloatValue) { it.blast5ToppleSpeed }
            property("Blast5PushForce", FloatValue) { it.blast5PushForce }
            property("Blast6Enabled", BooleanValue) { it.blast6Enabled }
            property("Blast6Delay", IntValue) { it.blast6Delay }
            property("Blast6ScorchDelay", IntValue) { it.blast6ScorchDelay }
            property("Blast6InnerRadius", FloatValue) { it.blast6InnerRadius }
            property("Blast6OuterRadius", FloatValue) { it.blast6OuterRadius }
            property("Blast6MaxDamage", FloatValue) { it.blast6MaxDamage }
            property("Blast6MinDamage", FloatValue) { it.blast6MinDamage }
            property("Blast6ToppleSpeed", FloatValue) { it.blast6ToppleSpeed }
            property("Blast6PushForce", FloatValue) { it.blast6PushForce }
            property("Blast7Enabled", BooleanValue) { it.blast7Enabled }
            property("Blast7Delay", IntValue) { it.blast7Delay }
            property("Blast7ScorchDelay", IntValue) { it.blast7ScorchDelay }
            property("Blast7InnerRadius", FloatValue) { it.blast7InnerRadius }
            property("Blast7OuterRadius", FloatValue) { it.blast7OuterRadius }
            property("Blast7MaxDamage", FloatValue) { it.blast7MaxDamage }
            property("Blast7MinDamage", FloatValue) { it.blast7MinDamage }
            property("Blast7ToppleSpeed", FloatValue) { it.blast7ToppleSpeed }
            property("Blast7PushForce", FloatValue) { it.blast7PushForce }
            property("Blast8Enabled", BooleanValue) { it.blast8Enabled }
            property("Blast8Delay", IntValue) { it.blast8Delay }
            property("Blast8ScorchDelay", IntValue) { it.blast8ScorchDelay }
            property("Blast8InnerRadius", FloatValue) { it.blast8InnerRadius }
            property("Blast8OuterRadius", FloatValue) { it.blast8OuterRadius }
            property("Blast8MaxDamage", FloatValue) { it.blast8MaxDamage }
            property("Blast8MinDamage", FloatValue) { it.blast8MinDamage }
            property("Blast8ToppleSpeed", FloatValue) { it.blast8ToppleSpeed }
            property("Blast8PushForce", FloatValue) { it.blast8PushForce }
            property("Blast9Enabled", BooleanValue) { it.blast9Enabled }
            property("Blast9Delay", IntValue) { it.blast9Delay }
            property("Blast9ScorchDelay", IntValue) { it.blast9ScorchDelay }
            property("Blast9InnerRadius", FloatValue) { it.blast9InnerRadius }
            property("Blast9OuterRadius", FloatValue) { it.blast9OuterRadius }
            property("Blast9MaxDamage", FloatValue) { it.blast9MaxDamage }
            property("Blast9MinDamage", FloatValue) { it.blast9MinDamage }
            property("Blast9ToppleSpeed", FloatValue) { it.blast9ToppleSpeed }
            property("Blast9PushForce", FloatValue) { it.blast9PushForce }
        },
    )
}
