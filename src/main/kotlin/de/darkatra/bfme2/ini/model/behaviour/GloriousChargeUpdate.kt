package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.CommandButton
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SpecialPowerUnpackConditions
import de.darkatra.bfme2.ini.model.value.Untyped

data class GloriousChargeUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") override val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("StartAbilityRange") override val startAbilityRange: Double = 0.0,
    @SageIniName("AbilityAbortRange") override val abilityAbortRange: Double = 0.0,
    @SageIniName("PreparationTime") override val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") override val persistentPrepTime: Int = 0,
    @SageIniName("PersistentCount") override val persistentCount: Int = 0,
    @SageIniName("PackTime") override val packTime: Int = 0,
    @SageIniName("UnpackTime") override val unpackTime: Int = 0,
    @SageIniName("PreTriggerUnstealthTime") override val preTriggerUnstealthTime: Int = 0,
    @SageIniName("SkipPackingWithNoTarget") override val skipPackingWithNoTarget: Boolean = false,
    @SageIniName("PackUnpackVariationFactor") override val packUnpackVariationFactor: Double = 0.0,
    @SageIniName("ParalyzeDurationWhenCompleted") override val paralyzeDurationWhenCompleted: Int = 0,
    @SageIniName("ParalyzeDurationWhenAborted") override val paralyzeDurationWhenAborted: Int = 0,
    @SageIniName("SpecialObject") override val specialObject: SageReference<Object>? = null,
    @SageIniName("SpecialObjectAttachToBone") override val specialObjectAttachToBone: SageReference<Object>? = null,
    @SageIniName("MaxSpecialObjects") override val maxSpecialObjects: Int = 0,
    @SageIniName("SpecialObjectsPersistent") override val specialObjectsPersistent: Boolean = false,
    @SageIniName("EffectDuration") override val effectDuration: Int = 0,
    @SageIniName("EffectValue") override val effectValue: Int = 0,
    @SageIniName("EffectRange") override val effectRange: Double = 0.0,
    @SageIniName("UniqueSpecialObjectTargets") override val uniqueSpecialObjectTargets: Boolean = false,
    @SageIniName("SpecialObjectsPersistWhenOwnerDies") override val specialObjectsPersistWhenOwnerDies: Boolean = false,
    @SageIniName("AlwaysValidateSpecialObjects") override val alwaysValidateSpecialObjects: Boolean = false,
    @SageIniName("FlipOwnerAfterPacking") override val flipOwnerAfterPacking: Boolean = false,
    @SageIniName("FlipOwnerAfterUnpacking") override val flipOwnerAfterUnpacking: Boolean = false,
    @SageIniName("FleeRangeAfterCompletion") override val fleeRangeAfterCompletion: Double = 0.0,
    @SageIniName("DisableFXParticleSystem") override val disableFXParticleSystem: SageReference<FXParticleSystem>? = null,
    @SageIniName("DoCaptureFX") override val doCaptureFX: Boolean = false,
    @SageIniName("PackSound") override val packSound: SageReference<AudioEvent>? = null,
    @SageIniName("UnpackSound") override val unpackSound: SageReference<AudioEvent>? = null,
    @SageIniName("PrepSoundLoop") override val prepSoundLoop: SageReference<AudioEvent>? = null,
    @SageIniName("TriggerSound") override val triggerSound: SageReference<AudioEvent>? = null,
    @SageIniName("ActiveLoopSound") override val activeLoopSound: SageReference<AudioEvent>? = null,
    @SageIniName("LoseStealthOnTrigger") override val loseStealthOnTrigger: Boolean = false,
    @SageIniName("AwardXPForTriggering") override val awardXPForTriggering: Int = 0,
    @SageIniName("SkillPointsForTriggering") override val skillPointsForTriggering: Int = 0,
    @SageIniName("ApproachRequiresLOS") override val approachRequiresLOS: Boolean = false,
    @SageIniName("ChargeAttackSpeedBoost") override val chargeAttackSpeedBoost: Boolean = false,
    @SageIniName("CustomAnimAndDuration") override val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("GrabPassengerAnimAndDuration") override val grabPassengerAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("GrabPassengerHealGainPercent") override val grabPassengerHealGainPercent: Double = 0.0,
    @SageIniName("UnpackingVariation") override val unpackingVariation: Int = 0,
    @SageIniName("MustFinishAbility") override val mustFinishAbility: Boolean = false,
    @SageIniName("FreezeAfterTriggerDuration") override val freezeAfterTriggerDuration: Int = 0,
    @SageIniName("DisableWhenWearingTheRing") override val disableWhenWearingTheRing: Boolean = false,
    @SageIniName("RequiredConditions") override val requiredConditions: SpecialPowerUnpackConditions? = null,
    @SageIniName("RejectedConditions") override val rejectedConditions: SpecialPowerUnpackConditions? = null,
    @SageIniName("ContactPointOverride") override val contactPointOverride: Untyped? = null,
    @SageIniName("TriggerAttributeModifier") override val triggerAttributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("AttributeModifierDuration") override val attributeModifierDuration: Int = 0,
    @SageIniName("KillAttributeModifierOnExit") override val killAttributeModifierOnExit: Boolean = false,
    @SageIniName("KillAttributeModifierOnRejected") override val killAttributeModifierOnRejected: Boolean = false,
    @SageIniName("Instant") override val instant: Boolean = false,
    @SageIniName("NeedCollisionBeforeTrigger") override val needCollisionBeforeTrigger: Boolean = false,
    @SageIniName("ChainedButton") override val chainedButton: SageReference<CommandButton>? = null,
    @SageIniName("SuppressForHordes") override val suppressForHordes: Boolean = false,
    @SageIniName("ApproachUntilMembersInRange") override val approachUntilMembersInRange: Boolean = false,
    @SageIniName("IgnoreFacingCheck") override val ignoreFacingCheck: Boolean = false,
    @SageIniName("TriggerModelCondition") override val triggerModelCondition: ModelCondition? = null,
    @SageIniName("TriggerModelConditionDuration") override val triggerModelConditionDuration: Double = 0.0,
    @SageIniName("BonusRadius") val bonusRadius: Double = 0.0,
    @SageIniName("SpeechDuration") val speechDuration: Int = 0,
    @SageIniName("UpdateInterval") val updateInterval: Int = 0,
) : SpecialPowerBehavior() {

    companion object : SageIniBlockDescriptor<GloriousChargeUpdate>(
        name = "GloriousChargeUpdate",
        parent = SpecialPowerBehavior,
        properties = {
            property("BonusRadius", FloatValue) { it.bonusRadius }
            property("SpeechDuration", IntValue) { it.speechDuration }
            property("UpdateInterval", IntValue) { it.updateInterval }
        },
    )
}
