package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.CommandButton
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SpecialPowerUnpackConditions
import de.darkatra.bfme2.ini.model.value.Untyped

open class SpecialPowerBehavior(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") open val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("StartAbilityRange") open val startAbilityRange: Double = 0.0,
    @SageIniName("AbilityAbortRange") open val abilityAbortRange: Double = 0.0,
    @SageIniName("PreparationTime") open val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") open val persistentPrepTime: Int = 0,
    @SageIniName("PersistentCount") open val persistentCount: Int = 0,
    @SageIniName("PackTime") open val packTime: Int = 0,
    @SageIniName("UnpackTime") open val unpackTime: Int = 0,
    @SageIniName("PreTriggerUnstealthTime") open val preTriggerUnstealthTime: Int = 0,
    @SageIniName("SkipPackingWithNoTarget") open val skipPackingWithNoTarget: Boolean = false,
    @SageIniName("PackUnpackVariationFactor") open val packUnpackVariationFactor: Double = 0.0,
    @SageIniName("ParalyzeDurationWhenCompleted") open val paralyzeDurationWhenCompleted: Int = 0,
    @SageIniName("ParalyzeDurationWhenAborted") open val paralyzeDurationWhenAborted: Int = 0,
    @SageIniName("SpecialObject") open val specialObject: SageReference<Object>? = null,
    @SageIniName("SpecialObjectAttachToBone") open val specialObjectAttachToBone: SageReference<Object>? = null,
    @SageIniName("MaxSpecialObjects") open val maxSpecialObjects: Int = 0,
    @SageIniName("SpecialObjectsPersistent") open val specialObjectsPersistent: Boolean = false,
    @SageIniName("EffectDuration") open val effectDuration: Int = 0,
    @SageIniName("EffectValue") open val effectValue: Int = 0,
    @SageIniName("EffectRange") open val effectRange: Double = 0.0,
    @SageIniName("UniqueSpecialObjectTargets") open val uniqueSpecialObjectTargets: Boolean = false,
    @SageIniName("SpecialObjectsPersistWhenOwnerDies") open val specialObjectsPersistWhenOwnerDies: Boolean = false,
    @SageIniName("AlwaysValidateSpecialObjects") open val alwaysValidateSpecialObjects: Boolean = false,
    @SageIniName("FlipOwnerAfterPacking") open val flipOwnerAfterPacking: Boolean = false,
    @SageIniName("FlipOwnerAfterUnpacking") open val flipOwnerAfterUnpacking: Boolean = false,
    @SageIniName("FleeRangeAfterCompletion") open val fleeRangeAfterCompletion: Double = 0.0,
    @SageIniName("DisableFXParticleSystem") open val disableFXParticleSystem: SageReference<FXParticleSystem>? = null,
    @SageIniName("DoCaptureFX") open val doCaptureFX: Boolean = false,
    @SageIniName("PackSound") open val packSound: SageReference<AudioEvent>? = null,
    @SageIniName("UnpackSound") open val unpackSound: SageReference<AudioEvent>? = null,
    @SageIniName("PrepSoundLoop") open val prepSoundLoop: SageReference<AudioEvent>? = null,
    @SageIniName("TriggerSound") open val triggerSound: SageReference<AudioEvent>? = null,
    @SageIniName("ActiveLoopSound") open val activeLoopSound: SageReference<AudioEvent>? = null,
    @SageIniName("LoseStealthOnTrigger") open val loseStealthOnTrigger: Boolean = false,
    @SageIniName("AwardXPForTriggering") open val awardXPForTriggering: Int = 0,
    @SageIniName("SkillPointsForTriggering") open val skillPointsForTriggering: Int = 0,
    @SageIniName("ApproachRequiresLOS") open val approachRequiresLOS: Boolean = false,
    @SageIniName("ChargeAttackSpeedBoost") open val chargeAttackSpeedBoost: Boolean = false,
    @SageIniName("CustomAnimAndDuration") open val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("GrabPassengerAnimAndDuration") open val grabPassengerAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("GrabPassengerHealGainPercent") open val grabPassengerHealGainPercent: Double = 0.0,
    @SageIniName("UnpackingVariation") open val unpackingVariation: Int = 0,
    @SageIniName("MustFinishAbility") open val mustFinishAbility: Boolean = false,
    @SageIniName("FreezeAfterTriggerDuration") open val freezeAfterTriggerDuration: Int = 0,
    @SageIniName("DisableWhenWearingTheRing") open val disableWhenWearingTheRing: Boolean = false,
    @SageIniName("RequiredConditions") open val requiredConditions: SpecialPowerUnpackConditions? = null,
    @SageIniName("RejectedConditions") open val rejectedConditions: SpecialPowerUnpackConditions? = null,
    @SageIniName("ContactPointOverride") open val contactPointOverride: Untyped? = null,
    @SageIniName("TriggerAttributeModifier") open val triggerAttributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("AttributeModifierDuration") open val attributeModifierDuration: Int = 0,
    @SageIniName("KillAttributeModifierOnExit") open val killAttributeModifierOnExit: Boolean = false,
    @SageIniName("KillAttributeModifierOnRejected") open val killAttributeModifierOnRejected: Boolean = false,
    @SageIniName("Instant") open val instant: Boolean = false,
    @SageIniName("NeedCollisionBeforeTrigger") open val needCollisionBeforeTrigger: Boolean = false,
    @SageIniName("ChainedButton") open val chainedButton: SageReference<CommandButton>? = null,
    @SageIniName("SuppressForHordes") open val suppressForHordes: Boolean = false,
    @SageIniName("ApproachUntilMembersInRange") open val approachUntilMembersInRange: Boolean = false,
    @SageIniName("IgnoreFacingCheck") open val ignoreFacingCheck: Boolean = false,
    @SageIniName("TriggerModelCondition") open val triggerModelCondition: ModelCondition? = null,
    @SageIniName("TriggerModelConditionDuration") open val triggerModelConditionDuration: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SpecialPowerBehavior>(
        name = "SpecialPowerBehavior",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("StartAbilityRange", FloatValue) { it.startAbilityRange }
            property("AbilityAbortRange", FloatValue) { it.abilityAbortRange }
            property("PreparationTime", IntValue) { it.preparationTime }
            property("PersistentPrepTime", IntValue) { it.persistentPrepTime }
            property("PersistentCount", IntValue) { it.persistentCount }
            property("PackTime", IntValue) { it.packTime }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("PreTriggerUnstealthTime", IntValue) { it.preTriggerUnstealthTime }
            property("SkipPackingWithNoTarget", BooleanValue) { it.skipPackingWithNoTarget }
            property("PackUnpackVariationFactor", FloatValue) { it.packUnpackVariationFactor }
            property("ParalyzeDurationWhenCompleted", IntValue) { it.paralyzeDurationWhenCompleted }
            property("ParalyzeDurationWhenAborted", IntValue) { it.paralyzeDurationWhenAborted }
            property("SpecialObject", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.specialObject }
            property("SpecialObjectAttachToBone", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.specialObjectAttachToBone }
            property("MaxSpecialObjects", IntValue) { it.maxSpecialObjects }
            property("SpecialObjectsPersistent", BooleanValue) { it.specialObjectsPersistent }
            property("EffectDuration", IntValue) { it.effectDuration }
            property("EffectValue", IntValue) { it.effectValue }
            property("EffectRange", FloatValue) { it.effectRange }
            property("UniqueSpecialObjectTargets", BooleanValue) { it.uniqueSpecialObjectTargets }
            property("SpecialObjectsPersistWhenOwnerDies", BooleanValue) { it.specialObjectsPersistWhenOwnerDies }
            property("AlwaysValidateSpecialObjects", BooleanValue) { it.alwaysValidateSpecialObjects }
            property("FlipOwnerAfterPacking", BooleanValue) { it.flipOwnerAfterPacking }
            property("FlipOwnerAfterUnpacking", BooleanValue) { it.flipOwnerAfterUnpacking }
            property("FleeRangeAfterCompletion", FloatValue) { it.fleeRangeAfterCompletion }
            property("DisableFXParticleSystem", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.disableFXParticleSystem }
            property("DoCaptureFX", BooleanValue) { it.doCaptureFX }
            property("PackSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.packSound }
            property("UnpackSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.unpackSound }
            property("PrepSoundLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.prepSoundLoop }
            property("TriggerSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.triggerSound }
            property("ActiveLoopSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.activeLoopSound }
            property("LoseStealthOnTrigger", BooleanValue) { it.loseStealthOnTrigger }
            property("AwardXPForTriggering", IntValue) { it.awardXPForTriggering }
            property("SkillPointsForTriggering", IntValue) { it.skillPointsForTriggering }
            property("ApproachRequiresLOS", BooleanValue) { it.approachRequiresLOS }
            property("ChargeAttackSpeedBoost", BooleanValue) { it.chargeAttackSpeedBoost }
            property("CustomAnimAndDuration", MapValue(StringValue, StringValue)) { it.customAnimAndDuration }
            property("GrabPassengerAnimAndDuration", MapValue(StringValue, StringValue)) { it.grabPassengerAnimAndDuration }
            property("GrabPassengerHealGainPercent", FloatValue) { it.grabPassengerHealGainPercent }
            property("UnpackingVariation", IntValue) { it.unpackingVariation }
            property("MustFinishAbility", BooleanValue) { it.mustFinishAbility }
            property("FreezeAfterTriggerDuration", IntValue) { it.freezeAfterTriggerDuration }
            property("DisableWhenWearingTheRing", BooleanValue) { it.disableWhenWearingTheRing }
            property("RequiredConditions", SpecialPowerUnpackConditions.type) { it.requiredConditions }
            property("RejectedConditions", SpecialPowerUnpackConditions.type) { it.rejectedConditions }
            property("ContactPointOverride", Untyped.type) { it.contactPointOverride }
            property("TriggerAttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.triggerAttributeModifier }
            property("AttributeModifierDuration", IntValue) { it.attributeModifierDuration }
            property("KillAttributeModifierOnExit", BooleanValue) { it.killAttributeModifierOnExit }
            property("KillAttributeModifierOnRejected", BooleanValue) { it.killAttributeModifierOnRejected }
            property("Instant", BooleanValue) { it.instant }
            property("NeedCollisionBeforeTrigger", BooleanValue) { it.needCollisionBeforeTrigger }
            property("ChainedButton", ReferenceValue<CommandButton> { listOf(CommandButton) }) { it.chainedButton }
            property("SuppressForHordes", BooleanValue) { it.suppressForHordes }
            property("ApproachUntilMembersInRange", BooleanValue) { it.approachUntilMembersInRange }
            property("IgnoreFacingCheck", BooleanValue) { it.ignoreFacingCheck }
            property("TriggerModelCondition", ModelCondition.type) { it.triggerModelCondition }
            property("TriggerModelConditionDuration", FloatValue) { it.triggerModelConditionDuration }
        },
    )
}
