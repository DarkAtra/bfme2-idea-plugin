package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.livingworld.BrutalDifficultyCheats
import de.darkatra.bfme2.ini.model.livingworld.DifficultyTuning

data class SkirmishAIData(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DefaultTargetThreatRadius") val defaultTargetThreatRadius: Double = 0.0,
    @SageIniName("TeamIdleCheckRadius") val teamIdleCheckRadius: Double = 0.0,
    @SageIniName("TeamTimeUntilConsideredIdle") val teamTimeUntilConsideredIdle: Double = 0.0,
    @SageIniName("DefenseTreeNodeRadius") val defenseTreeNodeRadius: Double = 0.0,
    @SageIniName("DisableBaseBuilding") val disableBaseBuilding: Boolean = false,
    @SageIniName("DisableEconomyBuilding") val disableEconomyBuilding: Boolean = false,
    @SageIniName("DisableUnitBuilding") val disableUnitBuilding: Boolean = false,
    @SageIniName("DisableScienceUpgrading") val disableScienceUpgrading: Boolean = false,
    @SageIniName("DisableUnitUpgrading") val disableUnitUpgrading: Boolean = false,
    @SageIniName("DisableTacticalAI") val disableTacticalAI: Boolean = false,
    @SageIniName("DisableTeamBuilding") val disableTeamBuilding: Boolean = false,
    @SageIniName("DisableWallBuilding") val disableWallBuilding: Boolean = false,
    @SageIniName("MakeAllSkirmishSidesAIControlled") val makeAllSkirmishSidesAIControlled: Boolean = false,
    @SageIniName("AnyTypeTemplateDisabledSlots") val anyTypeTemplateDisabledSlots: Int = 0,
    @SageIniName("ArmyQualityBias") val armyQualityBias: Int = 0,
    @SageIniName("ArmyQuantityBias") val armyQuantityBias: Int = 0,
    @SageIniName("BaseStrengthBias") val baseStrengthBias: Int = 0,
    @SageIniName("BrutalDifficultyCheats") val brutalDifficultyCheats: List<BrutalDifficultyCheats> = emptyList(),
    @SageIniName("DifficultyTuning") val difficultyTuning: List<DifficultyTuning> = emptyList(),
    @SageIniName("FarmingThreshold") val farmingThreshold: Int = 0,
    @SageIniName("HeroQualityBias") val heroQualityBias: Int = 0,
    @SageIniName("LogicFrameBetweenRetreatChecks") val logicFrameBetweenRetreatChecks: Int = 0,
    @SageIniName("LogicFramesTillAISelfDestructs") val logicFramesTillAISelfDestructs: Int = 0,
    @SageIniName("LogicFramesTillRetreatChecksStart") val logicFramesTillRetreatChecksStart: Int = 0,
    @SageIniName("MapControlBias") val mapControlBias: Int = 0,
    @SageIniName("RingOwnershipBias") val ringOwnershipBias: Int = 0,
    @SageIniName("CombatChainDefinition") val combatChainDefinition: List<CombatChainDefinition> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<SkirmishAIData>(
        name = "SkirmishAIData",
        tableKey = "skirmishaidatas",
        properties = {
            property("DefaultTargetThreatRadius", FloatValue) { it.defaultTargetThreatRadius }
            property("TeamIdleCheckRadius", FloatValue) { it.teamIdleCheckRadius }
            property("TeamTimeUntilConsideredIdle", FloatValue) { it.teamTimeUntilConsideredIdle }
            property("DefenseTreeNodeRadius", FloatValue) { it.defenseTreeNodeRadius }
            property("DisableBaseBuilding", BooleanValue) { it.disableBaseBuilding }
            property("DisableEconomyBuilding", BooleanValue) { it.disableEconomyBuilding }
            property("DisableUnitBuilding", BooleanValue) { it.disableUnitBuilding }
            property("DisableScienceUpgrading", BooleanValue) { it.disableScienceUpgrading }
            property("DisableUnitUpgrading", BooleanValue) { it.disableUnitUpgrading }
            property("DisableTacticalAI", BooleanValue) { it.disableTacticalAI }
            property("DisableTeamBuilding", BooleanValue) { it.disableTeamBuilding }
            property("DisableWallBuilding", BooleanValue) { it.disableWallBuilding }
            property("MakeAllSkirmishSidesAIControlled", BooleanValue) { it.makeAllSkirmishSidesAIControlled }
            property("AnyTypeTemplateDisabledSlots", IntValue) { it.anyTypeTemplateDisabledSlots }
            property("ArmyQualityBias", IntValue) { it.armyQualityBias }
            property("ArmyQuantityBias", IntValue) { it.armyQuantityBias }
            property("BaseStrengthBias", IntValue) { it.baseStrengthBias }
            property("BrutalDifficultyCheats", ListValue(BlockValue<BrutalDifficultyCheats> { listOf(BrutalDifficultyCheats) })) { it.brutalDifficultyCheats }
            property("DifficultyTuning", ListValue(BlockValue<DifficultyTuning> { listOf(DifficultyTuning) })) { it.difficultyTuning }
            property("FarmingThreshold", IntValue) { it.farmingThreshold }
            property("HeroQualityBias", IntValue) { it.heroQualityBias }
            property("LogicFrameBetweenRetreatChecks", IntValue) { it.logicFrameBetweenRetreatChecks }
            property("LogicFramesTillAISelfDestructs", IntValue) { it.logicFramesTillAISelfDestructs }
            property("LogicFramesTillRetreatChecksStart", IntValue) { it.logicFramesTillRetreatChecksStart }
            property("MapControlBias", IntValue) { it.mapControlBias }
            property("RingOwnershipBias", IntValue) { it.ringOwnershipBias }
            property("CombatChainDefinition", ListValue(BlockValue<CombatChainDefinition> { listOf(CombatChainDefinition) })) { it.combatChainDefinition }
        },
    )
}
