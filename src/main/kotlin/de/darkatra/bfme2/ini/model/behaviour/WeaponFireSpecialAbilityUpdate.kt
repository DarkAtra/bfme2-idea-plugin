package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.CommandButton
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SpecialPowerUnpackConditions
import de.darkatra.bfme2.ini.model.value.Untyped

data class WeaponFireSpecialAbilityUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") override val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("StartAbilityRange") override val startAbilityRange: Double = 0.0,
    @SageIniName("AbilityAbortRange") override val abilityAbortRange: Double = 0.0,
    @SageIniName("PreparationTime") override val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") override val persistentPrepTime: Int = 0,
    @SageIniName("EffectDuration") override val effectDuration: Int = 0,
    @SageIniName("EffectValue") override val effectValue: Int = 0,
    @SageIniName("DisableFXParticleSystem") override val disableFXParticleSystem: SageReference<FXParticleSystem>? = null,
    @SageIniName("SpecialObject") override val specialObject: SageReference<Object>? = null,
    @SageIniName("SpecialObjectAttachToBone") override val specialObjectAttachToBone: Opaque? = null,
    @SageIniName("MaxSpecialObjects") override val maxSpecialObjects: Int = 0,
    @SageIniName("SpecialObjectsPersistWhenOwnerDies") override val specialObjectsPersistWhenOwnerDies: Boolean = false,
    @SageIniName("AlwaysValidateSpecialObjects") override val alwaysValidateSpecialObjects: Boolean = false,
    @SageIniName("SpecialObjectsPersistent") override val specialObjectsPersistent: Boolean = false,
    @SageIniName("UniqueSpecialObjectTargets") override val uniqueSpecialObjectTargets: Boolean = false,
    @SageIniName("UnpackTime") override val unpackTime: Int = 0,
    @SageIniName("PackTime") override val packTime: Int = 0,
    @SageIniName("DoCaptureFX") override val doCaptureFX: Boolean = false,
    @SageIniName("AwardXPForTriggering") override val awardXPForTriggering: Int = 0,
    @SageIniName("SkipPackingWithNoTarget") override val skipPackingWithNoTarget: Boolean = false,
    @SageIniName("FlipOwnerAfterUnpacking") override val flipOwnerAfterUnpacking: Boolean = false,
    @SageIniName("FleeRangeAfterCompletion") override val fleeRangeAfterCompletion: Double = 0.0,
    @SageIniName("PackSound") override val packSound: SageReference<AudioEvent>? = null,
    @SageIniName("UnpackSound") override val unpackSound: SageReference<AudioEvent>? = null,
    @SageIniName("TriggerSound") override val triggerSound: SageReference<AudioEvent>? = null,
    @SageIniName("PrepSoundLoop") override val prepSoundLoop: SageReference<AudioEvent>? = null,
    @SageIniName("LoseStealthOnTrigger") override val loseStealthOnTrigger: Boolean = false,
    @SageIniName("PreTriggerUnstealthTime") override val preTriggerUnstealthTime: Int = 0,
    @SageIniName("ApproachRequiresLOS") override val approachRequiresLOS: Boolean = false,
    @SageIniName("NeedToFaceTarget") override val needToFaceTarget: Boolean = false,
    @SageIniName("PersistenceRequiresRecharge") override val persistenceRequiresRecharge: Boolean = false,
    @SageIniName("ChargeAttackSpeedBoost") override val chargeAttackSpeedBoost: Boolean = false,
    @SageIniName("Instant") override val instant: Boolean = false,
    @SageIniName("CustomAnimAndDuration") override val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("ContactPointOverride") override val contactPointOverride: Untyped? = null,
    @SageIniName("UnpackingVariation") override val unpackingVariation: Int = 0,
    @SageIniName("TriggerAttributeModifier") override val triggerAttributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("AttributeModifierDuration") override val attributeModifierDuration: Int = 0,
    @SageIniName("KillAttributeModifierOnExit") override val killAttributeModifierOnExit: Boolean = false,
    @SageIniName("IgnoreFacingCheck") override val ignoreFacingCheck: Boolean = false,
    @SageIniName("EffectRange") override val effectRange: Double = 0.0,
    @SageIniName("GrabPassengerAnimAndDuration") override val grabPassengerAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("GrabPassengerHealGainPercent") override val grabPassengerHealGainPercent: Double = 0.0,
    @SageIniName("PersistentCount") override val persistentCount: Int = 0,
    @SageIniName("RejectedConditions") override val rejectedConditions: SpecialPowerUnpackConditions? = null,
    @SageIniName("RequiredConditions") override val requiredConditions: SpecialPowerUnpackConditions? = null,
    @SageIniName("KillAttributeModifierOnRejected") override val killAttributeModifierOnRejected: Boolean = false,
    @SageIniName("TriggerModelCondition") override val triggerModelCondition: ModelCondition? = null,
    @SageIniName("TriggerModelConditionDuration") override val triggerModelConditionDuration: Double = 0.0,
    @SageIniName("FreezeAfterTriggerDuration") override val freezeAfterTriggerDuration: Int = 0,
    @SageIniName("ChainedButton") override val chainedButton: SageReference<CommandButton>? = null,
    @SageIniName("SkillPointsForTriggering") override val skillPointsForTriggering: Int = 0,
    @SageIniName("StopUnitBeforeActivating") override val stopUnitBeforeActivating: Boolean = false,
    @SageIniName("WhichSpecialWeapon") val whichSpecialWeapon: Int = 0,
    @SageIniName("SkipContinue") val skipContinue: Boolean = false,
    @SageIniName("MustFinishAbility") val mustFinishAbility: Boolean = false,
    @SageIniName("SpecialWeapon") val specialWeapon: SageReference<Weapon>? = null,
    @SageIniName("BusyForDuration") val busyForDuration: Int = 0,
    @SageIniName("PlayWeaponPreFireFX") val playWeaponPreFireFX: Boolean = false,
    @SageIniName("ApproachUntilMembersInRange") val approachUntilMembersInRange: Boolean = false,
    @SageIniName("NeedLivingTargets") val needLivingTargets: Boolean = false,
) : SpecialAbilityUpdate() {

    companion object : SageIniBlockDescriptor<WeaponFireSpecialAbilityUpdate>(
        name = "WeaponFireSpecialAbilityUpdate",
        parent = SpecialAbilityUpdate,
        properties = {
            property("WhichSpecialWeapon", IntValue) { it.whichSpecialWeapon }
            property("SkipContinue", BooleanValue) { it.skipContinue }
            property("MustFinishAbility", BooleanValue) { it.mustFinishAbility }
            property("SpecialWeapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.specialWeapon }
            property("BusyForDuration", IntValue) { it.busyForDuration }
            property("PlayWeaponPreFireFX", BooleanValue) { it.playWeaponPreFireFX }
            property("ApproachUntilMembersInRange", BooleanValue) { it.approachUntilMembersInRange }
            property("NeedLivingTargets", BooleanValue) { it.needLivingTargets }
        },
    )
}
