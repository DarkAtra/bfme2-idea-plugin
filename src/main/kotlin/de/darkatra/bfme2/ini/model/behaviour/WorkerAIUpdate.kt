package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.`object`.AttackPriority
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.Turret
import de.darkatra.bfme2.ini.model.value.AutoAcquireEnemiesType
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class WorkerAIUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TurretsLinked") override val turretsLinked: Boolean = false,
    @SageIniName("AutoAcquireEnemiesWhenIdle") override val autoAcquireEnemiesWhenIdle: List<AutoAcquireEnemiesType> = emptyList(),
    @SageIniName("MoodAttackCheckRate") override val moodAttackCheckRate: Int = 0,
    @SageIniName("ForbidPlayerCommands") override val forbidPlayerCommands: Boolean = false,
    @SageIniName("AILuaEventsList") override val aILuaEventsList: Untyped? = null,
    @SageIniName("HoldGroundCloseRangeDistance") override val holdGroundCloseRangeDistance: Double = 0.0,
    @SageIniName("MinCowerTime") override val minCowerTime: Int = 0,
    @SageIniName("MaxCowerTime") override val maxCowerTime: Int = 0,
    @SageIniName("CanAttackWhileContained") override val canAttackWhileContained: Boolean = false,
    @SageIniName("RampageTime") override val rampageTime: Int = 0,
    @SageIniName("TimeToEjectPassengersOnRampage") override val timeToEjectPassengersOnRampage: Int = 0,
    @SageIniName("AttackPriority") override val attackPriority: SageReference<AttackPriority>? = null,
    @SageIniName("SpecialContactPoints") override val specialContactPoints: List<Untyped> = emptyList(),
    @SageIniName("FadeOnPortals") override val fadeOnPortals: Boolean = false,
    @SageIniName("StopChaseDistance") override val stopChaseDistance: Double = 0.0,
    @SageIniName("RampageRequiresAflame") override val rampageRequiresAflame: Boolean = false,
    @SageIniName("MoveForNoOne") override val moveForNoOne: Boolean = false,
    @SageIniName("StandGround") override val standGround: Boolean = false,
    @SageIniName("BurningDeathTime") override val burningDeathTime: Int = 0,
    @SageIniName("MaxBoxes") override val maxBoxes: Int = 0,
    @SageIniName("SupplyCenterActionDelay") override val supplyCenterActionDelay: Int = 0,
    @SageIniName("SupplyWarehouseActionDelay") override val supplyWarehouseActionDelay: Int = 0,
    @SageIniName("SupplyWarehouseScanDistance") override val supplyWarehouseScanDistance: Double = 0.0,
    @SageIniName("SuppliesDepletedVoice") override val suppliesDepletedVoice: SageReference<AudioEvent>? = null,
    @SageIniName("RepairHealthPercentPerSecond") val repairHealthPercentPerSecond: Double = 0.0,
    @SageIniName("BoredTime") val boredTime: Int = 0,
    @SageIniName("BoredRange") val boredRange: Int = 0,
    @SageIniName("UpgradedSupplyBoost") val upgradedSupplyBoost: Int = 0,
    @SageIniName("HarvestTrees") val harvestTrees: Boolean = false,
    @SageIniName("HarvestActivationRange") val harvestActivationRange: Int = 0,
    @SageIniName("HarvestPreparationTime") val harvestPreparationTime: Int = 0,
    @SageIniName("HarvestActionTime") val harvestActionTime: Int = 0,
    @SageIniName("Turret") override val turret: List<Turret> = emptyList(),
    @SageIniName("AltTurret") override val altTurret: List<Turret> = emptyList(),
) : SupplyAIUpdate() {

    companion object : SageIniBlockDescriptor<WorkerAIUpdate>(
        name = "WorkerAIUpdate",
        parent = SupplyAIUpdate,
        properties = {
            property("RepairHealthPercentPerSecond", FloatValue) { it.repairHealthPercentPerSecond }
            property("BoredTime", IntValue) { it.boredTime }
            property("BoredRange", IntValue) { it.boredRange }
            property("UpgradedSupplyBoost", IntValue) { it.upgradedSupplyBoost }
            property("HarvestTrees", BooleanValue) { it.harvestTrees }
            property("HarvestActivationRange", IntValue) { it.harvestActivationRange }
            property("HarvestPreparationTime", IntValue) { it.harvestPreparationTime }
            property("HarvestActionTime", IntValue) { it.harvestActionTime }
        },
    )
}
