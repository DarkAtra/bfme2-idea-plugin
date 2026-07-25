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
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SpecialPowerUnpackConditions
import de.darkatra.bfme2.ini.model.value.Untyped

open class SpecialAbilityUpdate(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") open val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("StartAbilityRange") open val startAbilityRange: Double = 0.0,
    @SageIniName("AbilityAbortRange") open val abilityAbortRange: Double = 0.0,
    @SageIniName("PreparationTime") open val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") open val persistentPrepTime: Int = 0,
    @SageIniName("EffectDuration") open val effectDuration: Int = 0,
    @SageIniName("EffectValue") open val effectValue: Int = 0,
    @SageIniName("DisableFXParticleSystem") open val disableFXParticleSystem: SageReference<FXParticleSystem>? = null,
    @SageIniName("SpecialObject") open val specialObject: SageReference<Object>? = null,
    @SageIniName("SpecialObjectAttachToBone") open val specialObjectAttachToBone: Opaque? = null,
    @SageIniName("MaxSpecialObjects") open val maxSpecialObjects: Int = 0,
    @SageIniName("SpecialObjectsPersistWhenOwnerDies") open val specialObjectsPersistWhenOwnerDies: Boolean = false,
    @SageIniName("AlwaysValidateSpecialObjects") open val alwaysValidateSpecialObjects: Boolean = false,
    @SageIniName("SpecialObjectsPersistent") open val specialObjectsPersistent: Boolean = false,
    @SageIniName("UniqueSpecialObjectTargets") open val uniqueSpecialObjectTargets: Boolean = false,
    @SageIniName("UnpackTime") open val unpackTime: Int = 0,
    @SageIniName("PackTime") open val packTime: Int = 0,
    @SageIniName("DoCaptureFX") open val doCaptureFX: Boolean = false,
    @SageIniName("AwardXPForTriggering") open val awardXPForTriggering: Int = 0,
    @SageIniName("SkipPackingWithNoTarget") open val skipPackingWithNoTarget: Boolean = false,
    @SageIniName("FlipOwnerAfterUnpacking") open val flipOwnerAfterUnpacking: Boolean = false,
    @SageIniName("FleeRangeAfterCompletion") open val fleeRangeAfterCompletion: Double = 0.0,
    @SageIniName("PackSound") open val packSound: SageReference<AudioEvent>? = null,
    @SageIniName("UnpackSound") open val unpackSound: SageReference<AudioEvent>? = null,
    @SageIniName("TriggerSound") open val triggerSound: SageReference<AudioEvent>? = null,
    @SageIniName("PrepSoundLoop") open val prepSoundLoop: SageReference<AudioEvent>? = null,
    @SageIniName("LoseStealthOnTrigger") open val loseStealthOnTrigger: Boolean = false,
    @SageIniName("PreTriggerUnstealthTime") open val preTriggerUnstealthTime: Int = 0,
    @SageIniName("ApproachRequiresLOS") open val approachRequiresLOS: Boolean = false,
    @SageIniName("NeedToFaceTarget") open val needToFaceTarget: Boolean = false,
    @SageIniName("PersistenceRequiresRecharge") open val persistenceRequiresRecharge: Boolean = false,
    @SageIniName("ChargeAttackSpeedBoost") open val chargeAttackSpeedBoost: Boolean = false,
    @SageIniName("Instant") open val instant: Boolean = false,
    @SageIniName("CustomAnimAndDuration") open val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("ContactPointOverride") open val contactPointOverride: Untyped? = null,
    @SageIniName("UnpackingVariation") open val unpackingVariation: Int = 0,
    @SageIniName("TriggerAttributeModifier") open val triggerAttributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("AttributeModifierDuration") open val attributeModifierDuration: Int = 0,
    @SageIniName("KillAttributeModifierOnExit") open val killAttributeModifierOnExit: Boolean = false,
    @SageIniName("IgnoreFacingCheck") open val ignoreFacingCheck: Boolean = false,
    @SageIniName("EffectRange") open val effectRange: Double = 0.0,
    @SageIniName("GrabPassengerAnimAndDuration") open val grabPassengerAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("GrabPassengerHealGainPercent") open val grabPassengerHealGainPercent: Double = 0.0,
    @SageIniName("PersistentCount") open val persistentCount: Int = 0,
    @SageIniName("RejectedConditions") open val rejectedConditions: SpecialPowerUnpackConditions? = null,
    @SageIniName("RequiredConditions") open val requiredConditions: SpecialPowerUnpackConditions? = null,
    @SageIniName("KillAttributeModifierOnRejected") open val killAttributeModifierOnRejected: Boolean = false,
    @SageIniName("TriggerModelCondition") open val triggerModelCondition: ModelCondition? = null,
    @SageIniName("TriggerModelConditionDuration") open val triggerModelConditionDuration: Double = 0.0,
    @SageIniName("FreezeAfterTriggerDuration") open val freezeAfterTriggerDuration: Int = 0,
    @SageIniName("ChainedButton") open val chainedButton: SageReference<CommandButton>? = null,
    @SageIniName("SkillPointsForTriggering") open val skillPointsForTriggering: Int = 0,
    @SageIniName("StopUnitBeforeActivating") open val stopUnitBeforeActivating: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SpecialAbilityUpdate>(
        name = "SpecialAbilityUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("StartAbilityRange", FloatValue) { it.startAbilityRange }
            property("AbilityAbortRange", FloatValue) { it.abilityAbortRange }
            property("PreparationTime", IntValue) { it.preparationTime }
            property("PersistentPrepTime", IntValue) { it.persistentPrepTime }
            property("EffectDuration", IntValue) { it.effectDuration }
            property("EffectValue", IntValue) { it.effectValue }
            property("DisableFXParticleSystem", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.disableFXParticleSystem }
            property("SpecialObject", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.specialObject }
            property("SpecialObjectAttachToBone", Opaque.type) { it.specialObjectAttachToBone }
            property("MaxSpecialObjects", IntValue) { it.maxSpecialObjects }
            property("SpecialObjectsPersistWhenOwnerDies", BooleanValue) { it.specialObjectsPersistWhenOwnerDies }
            property("AlwaysValidateSpecialObjects", BooleanValue) { it.alwaysValidateSpecialObjects }
            property("SpecialObjectsPersistent", BooleanValue) { it.specialObjectsPersistent }
            property("UniqueSpecialObjectTargets", BooleanValue) { it.uniqueSpecialObjectTargets }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("PackTime", IntValue) { it.packTime }
            property("DoCaptureFX", BooleanValue) { it.doCaptureFX }
            property("AwardXPForTriggering", IntValue) { it.awardXPForTriggering }
            property("SkipPackingWithNoTarget", BooleanValue) { it.skipPackingWithNoTarget }
            property("FlipOwnerAfterUnpacking", BooleanValue) { it.flipOwnerAfterUnpacking }
            property("FleeRangeAfterCompletion", FloatValue) { it.fleeRangeAfterCompletion }
            property("PackSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.packSound }
            property("UnpackSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.unpackSound }
            property("TriggerSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.triggerSound }
            property("PrepSoundLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.prepSoundLoop }
            property("LoseStealthOnTrigger", BooleanValue) { it.loseStealthOnTrigger }
            property("PreTriggerUnstealthTime", IntValue) { it.preTriggerUnstealthTime }
            property("ApproachRequiresLOS", BooleanValue) { it.approachRequiresLOS }
            property("NeedToFaceTarget", BooleanValue) { it.needToFaceTarget }
            property("PersistenceRequiresRecharge", BooleanValue) { it.persistenceRequiresRecharge }
            property("ChargeAttackSpeedBoost", BooleanValue) { it.chargeAttackSpeedBoost }
            property("Instant", BooleanValue) { it.instant }
            property("CustomAnimAndDuration", MapValue(StringValue, StringValue)) { it.customAnimAndDuration }
            property("ContactPointOverride", Untyped.type) { it.contactPointOverride }
            property("UnpackingVariation", IntValue) { it.unpackingVariation }
            property("TriggerAttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.triggerAttributeModifier }
            property("AttributeModifierDuration", IntValue) { it.attributeModifierDuration }
            property("KillAttributeModifierOnExit", BooleanValue) { it.killAttributeModifierOnExit }
            property("IgnoreFacingCheck", BooleanValue) { it.ignoreFacingCheck }
            property("EffectRange", FloatValue) { it.effectRange }
            property("GrabPassengerAnimAndDuration", MapValue(StringValue, StringValue)) { it.grabPassengerAnimAndDuration }
            property("GrabPassengerHealGainPercent", FloatValue) { it.grabPassengerHealGainPercent }
            property("PersistentCount", IntValue) { it.persistentCount }
            property("RejectedConditions", SpecialPowerUnpackConditions.type) { it.rejectedConditions }
            property("RequiredConditions", SpecialPowerUnpackConditions.type) { it.requiredConditions }
            property("KillAttributeModifierOnRejected", BooleanValue) { it.killAttributeModifierOnRejected }
            property("TriggerModelCondition", ModelCondition.type) { it.triggerModelCondition }
            property("TriggerModelConditionDuration", FloatValue) { it.triggerModelConditionDuration }
            property("FreezeAfterTriggerDuration", IntValue) { it.freezeAfterTriggerDuration }
            property("ChainedButton", ReferenceValue<CommandButton> { listOf(CommandButton) }) { it.chainedButton }
            property("SkillPointsForTriggering", IntValue) { it.skillPointsForTriggering }
            property("StopUnitBeforeActivating", BooleanValue) { it.stopUnitBeforeActivating }
        },
    )
}
