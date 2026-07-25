package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.livingworld.ArmyMemberDefinition
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class ArmyDefinition(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Side") val side: FakeToken? = null,
    @SageIniName("MustUseCommandPointPercentage_Phase1") val mustUseCommandPointPercentagePhase1: Double = 0.0,
    @SageIniName("MustUseCommandPointPercentage_Phase2") val mustUseCommandPointPercentagePhase2: Double = 0.0,
    @SageIniName("MustUseCommandPointPercentage_Phase3") val mustUseCommandPointPercentagePhase3: Double = 0.0,
    @SageIniName("StructureRebuildPriorityModifier") val structureRebuildPriorityModifier: Double = 0.0,
    @SageIniName("DefaultUnitPriority") val defaultUnitPriority: Double = 0.0,
    @SageIniName("FortressRebuildPriority") val fortressRebuildPriority: Double = 0.0,
    @SageIniName("LowUnitPriorityModifier_Rush") val lowUnitPriorityModifierRush: Double = 0.0,
    @SageIniName("LowUnitPriorityModifier_MidGame") val lowUnitPriorityModifierMidGame: Double = 0.0,
    @SageIniName("LowUnitPriorityModifier_EndGame") val lowUnitPriorityModifierEndGame: Double = 0.0,
    @SageIniName("PhaseDuration_Rush") val phaseDurationRush: Double = 0.0,
    @SageIniName("PhaseDuration_MidGame") val phaseDurationMidGame: Double = 0.0,
    @SageIniName("EconomyBuilderMinFarmsOwned") val economyBuilderMinFarmsOwned: Int = 0,
    @SageIniName("EconomyBuilderMinMoney") val economyBuilderMinMoney: Int = 0,
    @SageIniName("EconomyBuilderPerFarmValue") val economyBuilderPerFarmValue: Int = 0,
    @SageIniName("EconomyBuilderPerSecPriorityIncreaseBase") val economyBuilderPerSecPriorityIncreaseBase: Double = 0.0,
    @SageIniName("EconomyBuilderMinTimeBetweenFarms_Rush") val economyBuilderMinTimeBetweenFarmsRush: Double = 0.0,
    @SageIniName("PercentToSave_Rush") val percentToSaveRush: Double = 0.0,
    @SageIniName("PercentToSave_MidGame") val percentToSaveMidGame: Double = 0.0,
    @SageIniName("PercentToSave_EndGame") val percentToSaveEndGame: Double = 0.0,
    @SageIniName("ChanceForUnitsToUpgrade") val chanceForUnitsToUpgrade: Double = 0.0,
    @SageIniName("UpgradeSciencePriorityNormalLow") val upgradeSciencePriorityNormalLow: Double = 0.0,
    @SageIniName("UpgradeSciencePriorityNormalHigh") val upgradeSciencePriorityNormalHigh: Double = 0.0,
    @SageIniName("UpgradeSciencePriorityImportantLow") val upgradeSciencePriorityImportantLow: Double = 0.0,
    @SageIniName("UpgradeSciencePriorityImportantHigh") val upgradeSciencePriorityImportantHigh: Double = 0.0,
    @SageIniName("UnitUpgradePriorityLow") val unitUpgradePriorityLow: Double = 0.0,
    @SageIniName("UnitUpgradePriorityHigh") val unitUpgradePriorityHigh: Double = 0.0,
    @SageIniName("MaxThreatForOpportunityTargets") val maxThreatForOpportunityTargets: Double = 0.0,
    @SageIniName("ValueToSetForMaxOnDefenseTeam") val valueToSetForMaxOnDefenseTeam: Int = 0,
    @SageIniName("CombatChainSearchDepthForTeamRecruits_AttackTeams") val combatChainSearchDepthForTeamRecruitsAttackTeams: Int = 0,
    @SageIniName("CombatChainSearchDepthForTeamRecruits_DefenseTeams") val combatChainSearchDepthForTeamRecruitsDefenseTeams: Int = 0,
    @SageIniName("CombatChainSearchDepthForTeamRecruits_ExploreTeams") val combatChainSearchDepthForTeamRecruitsExploreTeams: Int = 0,
    @SageIniName("TacticalAITargets") val tacticalAITargets: Untyped? = null,
    @SageIniName("MaxTeamsPerTarget") val maxTeamsPerTarget: Untyped? = null,
    @SageIniName("SecondsTillTargetsCanExpire") val secondsTillTargetsCanExpire: Double = 0.0,
    @SageIniName("ChanceForTargetToExpire") val chanceForTargetToExpire: Double = 0.0,
    @SageIniName("MaxBuildingsToBeDefensiveTarget_Small") val maxBuildingsToBeDefensiveTargetSmall: Int = 0,
    @SageIniName("MaxBuildingsToBeDefensiveTarget_Med") val maxBuildingsToBeDefensiveTargetMed: Int = 0,
    @SageIniName("ChanceToUseAllUnitsForDefenseTarget_Small") val chanceToUseAllUnitsForDefenseTargetSmall: Double = 0.0,
    @SageIniName("ChanceToUseAllUnitsForDefenseTarget_Med") val chanceToUseAllUnitsForDefenseTargetMed: Double = 0.0,
    @SageIniName("ChanceToUseAllUnitsForDefenseTarget_Large") val chanceToUseAllUnitsForDefenseTargetLarge: Double = 0.0,
    @SageIniName("HeroBuildOrder") val heroBuildOrder: List<SageReference<Object>> = emptyList(),
    @SageIniName("OffensiveBuildings") val offensiveBuildings: List<SageReference<Object>> = emptyList(),
    @SageIniName("ScavangedResourceBuildings") val scavangedResourceBuildings: Opaque? = null,
    @SageIniName("ArmyMemberDefinition") val armyMemberDefinition: List<ArmyMemberDefinition> = emptyList(),
    @SageIniName("AIEconomyAssigment") val aiEconomyAssigment: List<AIEconomyAssigment> = emptyList(),
    @SageIniName("AIWallNodeAssignment") val aiWallNodeAssignment: List<AIWallNodeAssignment> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ArmyDefinition>(
        name = "ArmyDefinition",
        tableKey = "armydefinitions",
        properties = {
            property("Side", FakeToken.type) { it.side }
            property("MustUseCommandPointPercentage_Phase1", FloatValue) { it.mustUseCommandPointPercentagePhase1 }
            property("MustUseCommandPointPercentage_Phase2", FloatValue) { it.mustUseCommandPointPercentagePhase2 }
            property("MustUseCommandPointPercentage_Phase3", FloatValue) { it.mustUseCommandPointPercentagePhase3 }
            property("StructureRebuildPriorityModifier", FloatValue) { it.structureRebuildPriorityModifier }
            property("DefaultUnitPriority", FloatValue) { it.defaultUnitPriority }
            property("FortressRebuildPriority", FloatValue) { it.fortressRebuildPriority }
            property("LowUnitPriorityModifier_Rush", FloatValue) { it.lowUnitPriorityModifierRush }
            property("LowUnitPriorityModifier_MidGame", FloatValue) { it.lowUnitPriorityModifierMidGame }
            property("LowUnitPriorityModifier_EndGame", FloatValue) { it.lowUnitPriorityModifierEndGame }
            property("PhaseDuration_Rush", FloatValue) { it.phaseDurationRush }
            property("PhaseDuration_MidGame", FloatValue) { it.phaseDurationMidGame }
            property("EconomyBuilderMinFarmsOwned", IntValue) { it.economyBuilderMinFarmsOwned }
            property("EconomyBuilderMinMoney", IntValue) { it.economyBuilderMinMoney }
            property("EconomyBuilderPerFarmValue", IntValue) { it.economyBuilderPerFarmValue }
            property("EconomyBuilderPerSecPriorityIncreaseBase", FloatValue) { it.economyBuilderPerSecPriorityIncreaseBase }
            property("EconomyBuilderMinTimeBetweenFarms_Rush", FloatValue) { it.economyBuilderMinTimeBetweenFarmsRush }
            property("PercentToSave_Rush", FloatValue) { it.percentToSaveRush }
            property("PercentToSave_MidGame", FloatValue) { it.percentToSaveMidGame }
            property("PercentToSave_EndGame", FloatValue) { it.percentToSaveEndGame }
            property("ChanceForUnitsToUpgrade", FloatValue) { it.chanceForUnitsToUpgrade }
            property("UpgradeSciencePriorityNormalLow", FloatValue) { it.upgradeSciencePriorityNormalLow }
            property("UpgradeSciencePriorityNormalHigh", FloatValue) { it.upgradeSciencePriorityNormalHigh }
            property("UpgradeSciencePriorityImportantLow", FloatValue) { it.upgradeSciencePriorityImportantLow }
            property("UpgradeSciencePriorityImportantHigh", FloatValue) { it.upgradeSciencePriorityImportantHigh }
            property("UnitUpgradePriorityLow", FloatValue) { it.unitUpgradePriorityLow }
            property("UnitUpgradePriorityHigh", FloatValue) { it.unitUpgradePriorityHigh }
            property("MaxThreatForOpportunityTargets", FloatValue) { it.maxThreatForOpportunityTargets }
            property("ValueToSetForMaxOnDefenseTeam", IntValue) { it.valueToSetForMaxOnDefenseTeam }
            property("CombatChainSearchDepthForTeamRecruits_AttackTeams", IntValue) { it.combatChainSearchDepthForTeamRecruitsAttackTeams }
            property("CombatChainSearchDepthForTeamRecruits_DefenseTeams", IntValue) { it.combatChainSearchDepthForTeamRecruitsDefenseTeams }
            property("CombatChainSearchDepthForTeamRecruits_ExploreTeams", IntValue) { it.combatChainSearchDepthForTeamRecruitsExploreTeams }
            property("TacticalAITargets", Untyped.type) { it.tacticalAITargets }
            property("MaxTeamsPerTarget", Untyped.type) { it.maxTeamsPerTarget }
            property("SecondsTillTargetsCanExpire", FloatValue) { it.secondsTillTargetsCanExpire }
            property("ChanceForTargetToExpire", FloatValue) { it.chanceForTargetToExpire }
            property("MaxBuildingsToBeDefensiveTarget_Small", IntValue) { it.maxBuildingsToBeDefensiveTargetSmall }
            property("MaxBuildingsToBeDefensiveTarget_Med", IntValue) { it.maxBuildingsToBeDefensiveTargetMed }
            property("ChanceToUseAllUnitsForDefenseTarget_Small", FloatValue) { it.chanceToUseAllUnitsForDefenseTargetSmall }
            property("ChanceToUseAllUnitsForDefenseTarget_Med", FloatValue) { it.chanceToUseAllUnitsForDefenseTargetMed }
            property("ChanceToUseAllUnitsForDefenseTarget_Large", FloatValue) { it.chanceToUseAllUnitsForDefenseTargetLarge }
            property("HeroBuildOrder", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.heroBuildOrder }
            property("OffensiveBuildings", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.offensiveBuildings }
            property("ScavangedResourceBuildings", Opaque.type) { it.scavangedResourceBuildings }
            property("ArmyMemberDefinition", ListValue(BlockValue<ArmyMemberDefinition> { listOf(ArmyMemberDefinition) })) { it.armyMemberDefinition }
            property("AIEconomyAssigment", ListValue(BlockValue<AIEconomyAssigment> { listOf(AIEconomyAssigment) })) { it.aiEconomyAssigment }
            property("AIWallNodeAssignment", ListValue(BlockValue<AIWallNodeAssignment> { listOf(AIWallNodeAssignment) })) { it.aiWallNodeAssignment }
        },
    )
}
