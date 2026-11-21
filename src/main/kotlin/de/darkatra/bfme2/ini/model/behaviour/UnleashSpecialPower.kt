package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageAudio
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.ModifierCategories
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class UnleashSpecialPower(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") override val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("StartsPaused") val startsPaused: Boolean = false,
    @SageIniName("UpdateModuleStartsAttack") val updateModuleStartsAttack: Boolean = false,
    @SageIniName("InitiateSound") val initiateSound: SageReference<SageAudio>? = null,
    @SageIniName("InitiateSound2") val initiateSound2: SageReference<AudioEvent>? = null,
    @SageIniName("AttributeModifier") val attributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("AttributeModifierAffectsSelf") val attributeModifierAffectsSelf: Boolean = false,
    @SageIniName("InitiateFX") val initiateFX: SageReference<FXList>? = null,
    @SageIniName("AntiCategory") val antiCategory: List<ModifierCategories> = emptyList(),
    @SageIniName("AttributeModifierRange") val attributeModifierRange: Double = 0.0,
    @SageIniName("AttributeModifierFX") val attributeModifierFX: SageReference<FXList>? = null,
    @SageIniName("TriggerFX") val triggerFX: SageReference<FXList>? = null,
    @SageIniName("SetModelCondition") val setModelCondition: Map<String, String> = emptyMap(),
    @SageIniName("SetModelConditionTime") val setModelConditionTime: Double = 0.0,
    @SageIniName("AttributeModifierAffects") val attributeModifierAffects: SageFilter? = null,
    @SageIniName("AvailableAtStart") val availableAtStart: Boolean = false,
    @SageIniName("TargetAllSides") val targetAllSides: Boolean = false,
    @SageIniName("AffectAllies") val affectAllies: Boolean = false,
    @SageIniName("AttributeModifierWeatherBased") val attributeModifierWeatherBased: Boolean = false,
    @SageIniName("TargetEnemy") val targetEnemy: Boolean = false,
    @SageIniName("OnTriggerRechargeSpecialPower") val onTriggerRechargeSpecialPower: SageReference<SpecialPower>? = null,
    @SageIniName("DisableDuringAnimDuration") val disableDuringAnimDuration: Boolean = false,
    @SageIniName("RequirementsFilterMPSkirmish") val requirementsFilterMPSkirmish: SageFilter? = null,
    @SageIniName("RequirementsFilterStrategic") val requirementsFilterStrategic: SageFilter? = null,
) : SpecialAbilityUpdate() {

    companion object : SageIniBlockDescriptor<UnleashSpecialPower>(
        name = "UnleashSpecialPower",
        parent = SpecialAbilityUpdate,
        properties = {
        },
    )
}
