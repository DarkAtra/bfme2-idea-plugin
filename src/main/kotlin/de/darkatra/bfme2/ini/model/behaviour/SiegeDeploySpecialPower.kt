package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.ModifierCategories
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class SiegeDeploySpecialPower(
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
    @SageIniName("LowerDelay") val lowerDelay: Int = 0,
    @SageIniName("RaiseDelay") val raiseDelay: Int = 0,
    @SageIniName("EvacuatePassengersOnDeploy") val evacuatePassengersOnDeploy: Boolean = false,
    @SageIniName("SkipAdjustPosition") val skipAdjustPosition: Boolean = false,
    @SageIniName("WallSearchDistance") val wallSearchDistance: Double = 0.0,
    @SageIniName("ExtraWallDistance") val extraWallDistance: Double = 0.0,
    @SageIniName("EvacuateCrewOnDeploy") val evacuateCrewOnDeploy: Boolean = false,
    @SageIniName("AwayFromWallWaitDist") val awayFromWallWaitDist: Double = 0.0,
) : SpecialPowerModuleBehavior() {

    companion object : SageIniBlockDescriptor<SiegeDeploySpecialPower>(
        name = "SiegeDeploySpecialPower",
        parent = SpecialPowerModuleBehavior,
        properties = {
            property("LowerDelay", IntValue) { it.lowerDelay }
            property("RaiseDelay", IntValue) { it.raiseDelay }
            property("EvacuatePassengersOnDeploy", BooleanValue) { it.evacuatePassengersOnDeploy }
            property("SkipAdjustPosition", BooleanValue) { it.skipAdjustPosition }
            property("WallSearchDistance", FloatValue) { it.wallSearchDistance }
            property("ExtraWallDistance", FloatValue) { it.extraWallDistance }
            property("EvacuateCrewOnDeploy", BooleanValue) { it.evacuateCrewOnDeploy }
            property("AwayFromWallWaitDist", FloatValue) { it.awayFromWallWaitDist }
        },
    )
}
