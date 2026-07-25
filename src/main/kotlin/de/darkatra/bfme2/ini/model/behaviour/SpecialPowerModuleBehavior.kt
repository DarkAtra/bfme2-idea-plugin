package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.ModifierCategories
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

open class SpecialPowerModuleBehavior(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") open val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("StartsPaused") open val startsPaused: Boolean = false,
    @SageIniName("UpdateModuleStartsAttack") open val updateModuleStartsAttack: Boolean = false,
    @SageIniName("InitiateSound") open val initiateSound: SageReference<AudioEvent>? = null,
    @SageIniName("InitiateSound2") open val initiateSound2: SageReference<AudioEvent>? = null,
    @SageIniName("AttributeModifier") open val attributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("AttributeModifierAffectsSelf") open val attributeModifierAffectsSelf: Boolean = false,
    @SageIniName("InitiateFX") open val initiateFX: SageReference<FXList>? = null,
    @SageIniName("AntiCategory") open val antiCategory: List<ModifierCategories> = emptyList(),
    @SageIniName("AttributeModifierRange") open val attributeModifierRange: Double = 0.0,
    @SageIniName("AttributeModifierFX") open val attributeModifierFX: SageReference<FXList>? = null,
    @SageIniName("TriggerFX") open val triggerFX: SageReference<FXList>? = null,
    @SageIniName("SetModelCondition") open val setModelCondition: Map<String, String> = emptyMap(),
    @SageIniName("SetModelConditionTime") open val setModelConditionTime: Double = 0.0,
    @SageIniName("AttributeModifierAffects") open val attributeModifierAffects: SageFilter? = null,
    @SageIniName("AvailableAtStart") open val availableAtStart: Boolean = false,
    @SageIniName("TargetAllSides") open val targetAllSides: Boolean = false,
    @SageIniName("AffectAllies") open val affectAllies: Boolean = false,
    @SageIniName("AttributeModifierWeatherBased") open val attributeModifierWeatherBased: Boolean = false,
    @SageIniName("TargetEnemy") open val targetEnemy: Boolean = false,
    @SageIniName("OnTriggerRechargeSpecialPower") open val onTriggerRechargeSpecialPower: SageReference<SpecialPower>? = null,
    @SageIniName("DisableDuringAnimDuration") open val disableDuringAnimDuration: Boolean = false,
    @SageIniName("RequirementsFilterMPSkirmish") open val requirementsFilterMPSkirmish: SageFilter? = null,
    @SageIniName("RequirementsFilterStrategic") open val requirementsFilterStrategic: SageFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SpecialPowerModuleBehavior>(
        name = "SpecialPowerModuleBehavior",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("StartsPaused", BooleanValue) { it.startsPaused }
            property("UpdateModuleStartsAttack", BooleanValue) { it.updateModuleStartsAttack }
            property("InitiateSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.initiateSound }
            property("InitiateSound2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.initiateSound2 }
            property("AttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.attributeModifier }
            property("AttributeModifierAffectsSelf", BooleanValue) { it.attributeModifierAffectsSelf }
            property("InitiateFX", ReferenceValue<FXList> { listOf(FXList) }) { it.initiateFX }
            property("AntiCategory", ListValue(ModifierCategories.type)) { it.antiCategory }
            property("AttributeModifierRange", FloatValue) { it.attributeModifierRange }
            property("AttributeModifierFX", ReferenceValue<FXList> { listOf(FXList) }) { it.attributeModifierFX }
            property("TriggerFX", ReferenceValue<FXList> { listOf(FXList) }) { it.triggerFX }
            property("SetModelCondition", MapValue(StringValue, StringValue)) { it.setModelCondition }
            property("SetModelConditionTime", FloatValue) { it.setModelConditionTime }
            property("AttributeModifierAffects", SageFilter.type) { it.attributeModifierAffects }
            property("AvailableAtStart", BooleanValue) { it.availableAtStart }
            property("TargetAllSides", BooleanValue) { it.targetAllSides }
            property("AffectAllies", BooleanValue) { it.affectAllies }
            property("AttributeModifierWeatherBased", BooleanValue) { it.attributeModifierWeatherBased }
            property("TargetEnemy", BooleanValue) { it.targetEnemy }
            property("OnTriggerRechargeSpecialPower", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.onTriggerRechargeSpecialPower }
            property("DisableDuringAnimDuration", BooleanValue) { it.disableDuringAnimDuration }
            property("RequirementsFilterMPSkirmish", SageFilter.type) { it.requirementsFilterMPSkirmish }
            property("RequirementsFilterStrategic", SageFilter.type) { it.requirementsFilterStrategic }
        },
    )
}
