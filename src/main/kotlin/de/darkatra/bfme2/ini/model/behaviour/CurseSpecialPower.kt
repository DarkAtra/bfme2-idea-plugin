package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.ModifierCategories
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class CurseSpecialPower(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") override val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("StartsPaused") override val startsPaused: Boolean = false,
    @SageIniName("UpdateModuleStartsAttack") override val updateModuleStartsAttack: Boolean = false,
    @SageIniName("InitiateSound") override val initiateSound: SageReference<AudioEvent>? = null,
    @SageIniName("InitiateSound2") override val initiateSound2: SageReference<AudioEvent>? = null,
    @SageIniName("AttributeModifier") override val attributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("AttributeModifierAffectsSelf") override val attributeModifierAffectsSelf: Boolean = false,
    @SageIniName("InitiateFX") override val initiateFX: SageReference<FXList>? = null,
    @SageIniName("AntiCategory") override val antiCategory: List<ModifierCategories> = emptyList(),
    @SageIniName("AttributeModifierRange") override val attributeModifierRange: Double = 0.0,
    @SageIniName("AttributeModifierFX") override val attributeModifierFX: SageReference<FXList>? = null,
    @SageIniName("TriggerFX") override val triggerFX: SageReference<FXList>? = null,
    @SageIniName("SetModelCondition") override val setModelCondition: Map<String, String> = emptyMap(),
    @SageIniName("SetModelConditionTime") override val setModelConditionTime: Double = 0.0,
    @SageIniName("AttributeModifierAffects") override val attributeModifierAffects: SageFilter? = null,
    @SageIniName("AvailableAtStart") override val availableAtStart: Boolean = false,
    @SageIniName("TargetAllSides") override val targetAllSides: Boolean = false,
    @SageIniName("AffectAllies") override val affectAllies: Boolean = false,
    @SageIniName("AttributeModifierWeatherBased") override val attributeModifierWeatherBased: Boolean = false,
    @SageIniName("TargetEnemy") override val targetEnemy: Boolean = false,
    @SageIniName("OnTriggerRechargeSpecialPower") override val onTriggerRechargeSpecialPower: SageReference<SpecialPower>? = null,
    @SageIniName("DisableDuringAnimDuration") override val disableDuringAnimDuration: Boolean = false,
    @SageIniName("RequirementsFilterMPSkirmish") override val requirementsFilterMPSkirmish: SageFilter? = null,
    @SageIniName("RequirementsFilterStrategic") override val requirementsFilterStrategic: SageFilter? = null,
    @SageIniName("CursePercentage") val cursePercentage: Double = 0.0,
    @SageIniName("UnpackingVariation") val unpackingVariation: Int = 0,
    @SageIniName("StartAbilityRange") val startAbilityRange: Double = 0.0,
    @SageIniName("UnpackTime") val unpackTime: Int = 0,
    @SageIniName("PreparationTime") val preparationTime: Int = 0,
    @SageIniName("FreezeAfterTriggerDuration") val freezeAfterTriggerDuration: Int = 0,
    @SageIniName("CursedFX") val cursedFX: SageReference<FXList>? = null,
    @SageIniName("TriggerModelCondition") val triggerModelCondition: ModelCondition? = null,
    @SageIniName("TriggerModelConditionDuration") val triggerModelConditionDuration: Int = 0,
    @SageIniName("PackTime") val packTime: Int = 0,
    @SageIniName("CustomAnimAndDuration") val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("CurseFloat") val curseFloat: Double = 0.0,
    @SageIniName("AttributeModifierDuration") val attributeModifierDuration: Int = 0,
    @SageIniName("TriggerAttributeModifier") val triggerAttributeModifier: SageReference<ModifierList>? = null,
) : SpecialPowerModuleBehavior() {

    companion object : SageIniBlockDescriptor<CurseSpecialPower>(
        name = "CurseSpecialPower",
        parent = SpecialPowerModuleBehavior,
        properties = {
            property("CursePercentage", FloatValue) { it.cursePercentage }
            property("UnpackingVariation", IntValue) { it.unpackingVariation }
            property("StartAbilityRange", FloatValue) { it.startAbilityRange }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("PreparationTime", IntValue) { it.preparationTime }
            property("FreezeAfterTriggerDuration", IntValue) { it.freezeAfterTriggerDuration }
            property("CursedFX", ReferenceValue<FXList> { listOf(FXList) }) { it.cursedFX }
            property("TriggerModelCondition", ModelCondition.type) { it.triggerModelCondition }
            property("TriggerModelConditionDuration", IntValue) { it.triggerModelConditionDuration }
            property("PackTime", IntValue) { it.packTime }
            property("CustomAnimAndDuration", MapValue(StringValue, StringValue)) { it.customAnimAndDuration }
            property("CurseFloat", FloatValue) { it.curseFloat }
            property("AttributeModifierDuration", IntValue) { it.attributeModifierDuration }
            property("TriggerAttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.triggerAttributeModifier }
        },
    )
}
