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
import de.darkatra.bfme2.ini.model.livingworld.SideInfo
import de.darkatra.bfme2.ini.model.value.Opaque

data class AIData(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("UseLowLODTrees") val useLowLODTrees: Boolean = false,
    @SageIniName("LowLodTreeScale") val lowLodTreeScale: Double = 0.0,
    @SageIniName("LowLodTreeName") val lowLodTreeName: Opaque? = null,
    @SageIniName("LowLodTreeNameNoGrab") val lowLodTreeNameNoGrab: Opaque? = null,
    @SageIniName("LowLodTreeNameNoHarvest") val lowLodTreeNameNoHarvest: Opaque? = null,
    @SageIniName("StructureSeconds") val structureSeconds: Double = 0.0,
    @SageIniName("TeamSeconds") val teamSeconds: Double = 0.0,
    @SageIniName("Wealthy") val wealthy: Double = 0.0,
    @SageIniName("Poor") val poor: Double = 0.0,
    @SageIniName("StructuresWealthyRate") val structuresWealthyRate: Double = 0.0,
    @SageIniName("StructuresPoorRate") val structuresPoorRate: Double = 0.0,
    @SageIniName("TeamsWealthyRate") val teamsWealthyRate: Double = 0.0,
    @SageIniName("TeamsPoorRate") val teamsPoorRate: Double = 0.0,
    @SageIniName("TeamResourcesToStart") val teamResourcesToStart: Double = 0.0,
    @SageIniName("GuardInnerModifierAI") val guardInnerModifierAI: Double = 0.0,
    @SageIniName("GuardOuterModifierAI") val guardOuterModifierAI: Double = 0.0,
    @SageIniName("GuardInnerModifierHuman") val guardInnerModifierHuman: Double = 0.0,
    @SageIniName("GuardOuterModifierHuman") val guardOuterModifierHuman: Double = 0.0,
    @SageIniName("GuardChaseUnitsDuration") val guardChaseUnitsDuration: Double = 0.0,
    @SageIniName("GuardEnemyScanRate") val guardEnemyScanRate: Double = 0.0,
    @SageIniName("GuardEnemyReturnScanRate") val guardEnemyReturnScanRate: Double = 0.0,
    @SageIniName("AlertRangeModifier") val alertRangeModifier: Double = 0.0,
    @SageIniName("AggressiveRangeModifier") val aggressiveRangeModifier: Double = 0.0,
    @SageIniName("AttackPriorityDistanceModifier") val attackPriorityDistanceModifier: Double = 0.0,
    @SageIniName("MaxRecruitRadius") val maxRecruitRadius: Double = 0.0,
    @SageIniName("ForceIdleMSEC") val forceIdleMSEC: Double = 0.0,
    @SageIniName("ForceSkirmishAI") val forceSkirmishAI: Boolean = false,
    @SageIniName("RotateSkirmishBases") val rotateSkirmishBases: Boolean = false,
    @SageIniName("AttackUsesLineOfSight") val attackUsesLineOfSight: Boolean = false,
    @SageIniName("AttackIgnoreInsignificantBuildings") val attackIgnoreInsignificantBuildings: Boolean = false,
    @SageIniName("AICrushesInfantry") val aICrushesInfantry: Boolean = false,
    @SageIniName("MaxRetaliateDistance") val maxRetaliateDistance: Double = 0.0,
    @SageIniName("RetaliateFriendsRadius") val retaliateFriendsRadius: Double = 0.0,
    @SageIniName("ChaseFromBehindLimit") val chaseFromBehindLimit: Double = 0.0,
    @SageIniName("EnableRepulsors") val enableRepulsors: Boolean = false,
    @SageIniName("RepulsedDistance") val repulsedDistance: Double = 0.0,
    @SageIniName("WallHeight") val wallHeight: Double = 0.0,
    @SageIniName("SkirmishGroupFudgeDistance") val skirmishGroupFudgeDistance: Double = 0.0,
    @SageIniName("InfantryPathfindDiameter") val infantryPathfindDiameter: Double = 0.0,
    @SageIniName("VehiclePathfindDiameter") val vehiclePathfindDiameter: Double = 0.0,
    @SageIniName("SupplyCenterSafeRadius") val supplyCenterSafeRadius: Double = 0.0,
    @SageIniName("RebuildDelayTimeSeconds") val rebuildDelayTimeSeconds: Double = 0.0,
    @SageIniName("AIDozerBoredRadiusModifier") val aIDozerBoredRadiusModifier: Double = 0.0,
    @SageIniName("MeleeApproachDist") val meleeApproachDist: Double = 0.0,
    @SageIniName("MeleeApproachTolerance") val meleeApproachTolerance: Double = 0.0,
    @SageIniName("WadeWaterDepth") val wadeWaterDepth: Double = 0.0,
    @SageIniName("DeepWaterDepth") val deepWaterDepth: Double = 0.0,
    @SageIniName("NarrowPassageScale") val narrowPassageScale: Double = 0.0,
    @SageIniName("MinDistanceForGroup") val minDistanceForGroup: Double = 0.0,
    @SageIniName("FormationEnemyDistance") val formationEnemyDistance: Double = 0.0,
    @SageIniName("FormationColumnWidth") val formationColumnWidth: Double = 0.0,
    @SageIniName("FormationRowDepth") val formationRowDepth: Double = 0.0,
    @SageIniName("FormationSquadSpacing") val formationSquadSpacing: Double = 0.0,
    @SageIniName("FormationColumns") val formationColumns: Double = 0.0,
    @SageIniName("UseFormations") val useFormations: Boolean = false,
    @SageIniName("WaitForOthers") val waitForOthers: Boolean = false,
    @SageIniName("HordesWaitForHordes") val hordesWaitForHordes: Boolean = false,
    @SageIniName("AttackMoveUsesFormations") val attackMoveUsesFormations: Boolean = false,
    @SageIniName("ForceHordesToLowLOD") val forceHordesToLowLOD: Boolean = false,
    @SageIniName("AllowForestFires") val allowForestFires: Boolean = false,
    @SageIniName("CastleSiegeStandBackDistance") val castleSiegeStandBackDistance: Double = 0.0,
    @SageIniName("BuildPhase1_PerSecondPriorityModifier") val buildPhase1PerSecondPriorityModifier: Double = 0.0,
    @SageIniName("BuildPhase2_PerSecondPriorityModifier") val buildPhase2PerSecondPriorityModifier: Double = 0.0,
    @SageIniName("BuildPhase3_PerSecondPriorityModifier") val buildPhase3PerSecondPriorityModifier: Double = 0.0,
    @SageIniName("BuildPhaseN_PerSecondPriorityModifier") val buildPhaseNPerSecondPriorityModifier: Double = 0.0,
    @SageIniName("AltCameraPitchOverride") val altCameraPitchOverride: Double = 0.0,
    @SageIniName("AltCameraZoomOverride") val altCameraZoomOverride: Double = 0.0,
    @SageIniName("AttackPriority") val attackPriority: Opaque? = null,
    @SageIniName("DistanceRequiresGroup") val distanceRequiresGroup: Double = 0.0,
    @SageIniName("MaxRetaliationDistance") val maxRetaliationDistance: Double = 0.0,
    @SageIniName("MeleeAcquireLimitDist") val meleeAcquireLimitDist: Double = 0.0,
    @SageIniName("MinClumpDensity") val minClumpDensity: Int = 0,
    @SageIniName("MinFlightHeight") val minFlightHeight: Int = 0,
    @SageIniName("MinInfantryForGroup") val minInfantryForGroup: Int = 0,
    @SageIniName("MinVehiclesForGroup") val minVehiclesForGroup: Int = 0,
    @SageIniName("RetaliationFriendsRadius") val retaliationFriendsRadius: Double = 0.0,
    @SageIniName("SkirmishBaseDefenseExtraDistance") val skirmishBaseDefenseExtraDistance: Double = 0.0,
    @SageIniName("SkirmishBuildList") val skirmishBuildList: Opaque? = null,
    @SageIniName("SideInfo") val sideInfo: List<SideInfo> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AIData>(
        name = "AIData",
        tableKey = "aidatas",
        properties = {
            property("UseLowLODTrees", BooleanValue) { it.useLowLODTrees }
            property("LowLodTreeScale", FloatValue) { it.lowLodTreeScale }
            property("LowLodTreeName", Opaque.type) { it.lowLodTreeName }
            property("LowLodTreeNameNoGrab", Opaque.type) { it.lowLodTreeNameNoGrab }
            property("LowLodTreeNameNoHarvest", Opaque.type) { it.lowLodTreeNameNoHarvest }
            property("StructureSeconds", FloatValue) { it.structureSeconds }
            property("TeamSeconds", FloatValue) { it.teamSeconds }
            property("Wealthy", FloatValue) { it.wealthy }
            property("Poor", FloatValue) { it.poor }
            property("StructuresWealthyRate", FloatValue) { it.structuresWealthyRate }
            property("StructuresPoorRate", FloatValue) { it.structuresPoorRate }
            property("TeamsWealthyRate", FloatValue) { it.teamsWealthyRate }
            property("TeamsPoorRate", FloatValue) { it.teamsPoorRate }
            property("TeamResourcesToStart", FloatValue) { it.teamResourcesToStart }
            property("GuardInnerModifierAI", FloatValue) { it.guardInnerModifierAI }
            property("GuardOuterModifierAI", FloatValue) { it.guardOuterModifierAI }
            property("GuardInnerModifierHuman", FloatValue) { it.guardInnerModifierHuman }
            property("GuardOuterModifierHuman", FloatValue) { it.guardOuterModifierHuman }
            property("GuardChaseUnitsDuration", FloatValue) { it.guardChaseUnitsDuration }
            property("GuardEnemyScanRate", FloatValue) { it.guardEnemyScanRate }
            property("GuardEnemyReturnScanRate", FloatValue) { it.guardEnemyReturnScanRate }
            property("AlertRangeModifier", FloatValue) { it.alertRangeModifier }
            property("AggressiveRangeModifier", FloatValue) { it.aggressiveRangeModifier }
            property("AttackPriorityDistanceModifier", FloatValue) { it.attackPriorityDistanceModifier }
            property("MaxRecruitRadius", FloatValue) { it.maxRecruitRadius }
            property("ForceIdleMSEC", FloatValue) { it.forceIdleMSEC }
            property("ForceSkirmishAI", BooleanValue) { it.forceSkirmishAI }
            property("RotateSkirmishBases", BooleanValue) { it.rotateSkirmishBases }
            property("AttackUsesLineOfSight", BooleanValue) { it.attackUsesLineOfSight }
            property("AttackIgnoreInsignificantBuildings", BooleanValue) { it.attackIgnoreInsignificantBuildings }
            property("AICrushesInfantry", BooleanValue) { it.aICrushesInfantry }
            property("MaxRetaliateDistance", FloatValue) { it.maxRetaliateDistance }
            property("RetaliateFriendsRadius", FloatValue) { it.retaliateFriendsRadius }
            property("ChaseFromBehindLimit", FloatValue) { it.chaseFromBehindLimit }
            property("EnableRepulsors", BooleanValue) { it.enableRepulsors }
            property("RepulsedDistance", FloatValue) { it.repulsedDistance }
            property("WallHeight", FloatValue) { it.wallHeight }
            property("SkirmishGroupFudgeDistance", FloatValue) { it.skirmishGroupFudgeDistance }
            property("InfantryPathfindDiameter", FloatValue) { it.infantryPathfindDiameter }
            property("VehiclePathfindDiameter", FloatValue) { it.vehiclePathfindDiameter }
            property("SupplyCenterSafeRadius", FloatValue) { it.supplyCenterSafeRadius }
            property("RebuildDelayTimeSeconds", FloatValue) { it.rebuildDelayTimeSeconds }
            property("AIDozerBoredRadiusModifier", FloatValue) { it.aIDozerBoredRadiusModifier }
            property("MeleeApproachDist", FloatValue) { it.meleeApproachDist }
            property("MeleeApproachTolerance", FloatValue) { it.meleeApproachTolerance }
            property("WadeWaterDepth", FloatValue) { it.wadeWaterDepth }
            property("DeepWaterDepth", FloatValue) { it.deepWaterDepth }
            property("NarrowPassageScale", FloatValue) { it.narrowPassageScale }
            property("MinDistanceForGroup", FloatValue) { it.minDistanceForGroup }
            property("FormationEnemyDistance", FloatValue) { it.formationEnemyDistance }
            property("FormationColumnWidth", FloatValue) { it.formationColumnWidth }
            property("FormationRowDepth", FloatValue) { it.formationRowDepth }
            property("FormationSquadSpacing", FloatValue) { it.formationSquadSpacing }
            property("FormationColumns", FloatValue) { it.formationColumns }
            property("UseFormations", BooleanValue) { it.useFormations }
            property("WaitForOthers", BooleanValue) { it.waitForOthers }
            property("HordesWaitForHordes", BooleanValue) { it.hordesWaitForHordes }
            property("AttackMoveUsesFormations", BooleanValue) { it.attackMoveUsesFormations }
            property("ForceHordesToLowLOD", BooleanValue) { it.forceHordesToLowLOD }
            property("AllowForestFires", BooleanValue) { it.allowForestFires }
            property("CastleSiegeStandBackDistance", FloatValue) { it.castleSiegeStandBackDistance }
            property("BuildPhase1_PerSecondPriorityModifier", FloatValue) { it.buildPhase1PerSecondPriorityModifier }
            property("BuildPhase2_PerSecondPriorityModifier", FloatValue) { it.buildPhase2PerSecondPriorityModifier }
            property("BuildPhase3_PerSecondPriorityModifier", FloatValue) { it.buildPhase3PerSecondPriorityModifier }
            property("BuildPhaseN_PerSecondPriorityModifier", FloatValue) { it.buildPhaseNPerSecondPriorityModifier }
            property("AltCameraPitchOverride", FloatValue) { it.altCameraPitchOverride }
            property("AltCameraZoomOverride", FloatValue) { it.altCameraZoomOverride }
            property("AttackPriority", Opaque.type) { it.attackPriority }
            property("DistanceRequiresGroup", FloatValue) { it.distanceRequiresGroup }
            property("MaxRetaliationDistance", FloatValue) { it.maxRetaliationDistance }
            property("MeleeAcquireLimitDist", FloatValue) { it.meleeAcquireLimitDist }
            property("MinClumpDensity", IntValue) { it.minClumpDensity }
            property("MinFlightHeight", IntValue) { it.minFlightHeight }
            property("MinInfantryForGroup", IntValue) { it.minInfantryForGroup }
            property("MinVehiclesForGroup", IntValue) { it.minVehiclesForGroup }
            property("RetaliationFriendsRadius", FloatValue) { it.retaliationFriendsRadius }
            property("SkirmishBaseDefenseExtraDistance", FloatValue) { it.skirmishBaseDefenseExtraDistance }
            property("SkirmishBuildList", Opaque.type) { it.skirmishBuildList }
            property("SideInfo", ListValue(BlockValue<SideInfo> { listOf(SideInfo) })) { it.sideInfo }
        },
    )
}
