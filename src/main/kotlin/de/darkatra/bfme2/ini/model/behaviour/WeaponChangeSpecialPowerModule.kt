package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.ModifierCategories
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.WeaponSetConditions

data class WeaponChangeSpecialPowerModule(
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
    @SageIniName("FlagsUsedForToggle") val flagsUsedForToggle: List<WeaponSetConditions> = emptyList(),
    @SageIniName("ToggleOnSleepFrames") val toggleOnSleepFrames: Int = 0,
    @SageIniName("ToggleOffSleepFrames") val toggleOffSleepFrames: Int = 0,
    @SageIniName("ToggleOnAttributeModifier") val toggleOnAttributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("ToggleOffAttributeModifier") val toggleOffAttributeModifier: SageReference<ModifierList>? = null,
) : SpecialPowerModuleBehavior() {

    companion object : SageIniBlockDescriptor<WeaponChangeSpecialPowerModule>(
        name = "WeaponChangeSpecialPowerModule",
        parent = SpecialPowerModuleBehavior,
        properties = {
            property("FlagsUsedForToggle", ListValue(WeaponSetConditions.type)) { it.flagsUsedForToggle }
            property("ToggleOnSleepFrames", IntValue) { it.toggleOnSleepFrames }
            property("ToggleOffSleepFrames", IntValue) { it.toggleOffSleepFrames }
            property("ToggleOnAttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.toggleOnAttributeModifier }
            property("ToggleOffAttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.toggleOffAttributeModifier }
        },
    )
}
