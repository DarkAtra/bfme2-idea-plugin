package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.CreateAtLocation
import de.darkatra.bfme2.ini.model.value.ModifierCategories
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped
import de.darkatra.bfme2.ini.model.value.WeatherFlag

data class OCLSpecialPower(
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
    @SageIniName("OCL") val oCL: SageReference<ObjectCreationList>? = null,
    @SageIniName("UpgradeOCL") val upgradeOCL: Untyped? = null,
    @SageIniName("CreateLocation") val createLocation: CreateAtLocation? = null,
    @SageIniName("ScriptedSpecialPowerOnly") val scriptedSpecialPowerOnly: Boolean = false,
    @SageIniName("OCLAdjustPositionToPassable") val oCLAdjustPositionToPassable: Boolean = false,
    @SageIniName("ReferenceObject") val referenceObject: SageReference<Object>? = null,
    @SageIniName("UpgradeName") val upgradeName: SageReference<Upgrade>? = null,
    @SageIniName("NearestSecondaryObjectFilter") val nearestSecondaryObjectFilter: SageFilter? = null,
    @SageIniName("ReEnableAntiCategory") val reEnableAntiCategory: Boolean = false,
    @SageIniName("WeatherDuration") val weatherDuration: Int = 0,
    @SageIniName("ChangeWeather") val changeWeather: WeatherFlag? = null,
) : SpecialPowerModuleBehavior() {

    companion object : SageIniBlockDescriptor<OCLSpecialPower>(
        name = "OCLSpecialPower",
        parent = SpecialPowerModuleBehavior,
        properties = {
            property("OCL", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCL }
            property("UpgradeOCL", Untyped.type) { it.upgradeOCL }
            property("CreateLocation", CreateAtLocation.type) { it.createLocation }
            property("ScriptedSpecialPowerOnly", BooleanValue) { it.scriptedSpecialPowerOnly }
            property("OCLAdjustPositionToPassable", BooleanValue) { it.oCLAdjustPositionToPassable }
            property("ReferenceObject", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.referenceObject }
            property("UpgradeName", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.upgradeName }
            property("NearestSecondaryObjectFilter", SageFilter.type) { it.nearestSecondaryObjectFilter }
            property("ReEnableAntiCategory", BooleanValue) { it.reEnableAntiCategory }
            property("WeatherDuration", IntValue) { it.weatherDuration }
            property("ChangeWeather", WeatherFlag.type) { it.changeWeather }
        },
    )
}
