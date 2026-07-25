package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AttackPriority
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.`object`.Turret
import de.darkatra.bfme2.ini.model.value.AutoAcquireEnemiesType
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class ChinookAIUpdate(
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
    @SageIniName("NumRopes") val numRopes: Int = 0,
    @SageIniName("PerRopeDelayMin") val perRopeDelayMin: Int = 0,
    @SageIniName("PerRopeDelayMax") val perRopeDelayMax: Int = 0,
    @SageIniName("RopeWidth") val ropeWidth: Double = 0.0,
    @SageIniName("RopeColor") val ropeColor: Untyped? = null,
    @SageIniName("RopeWobbleLen") val ropeWobbleLen: Int = 0,
    @SageIniName("RopeWobbleAmplitude") val ropeWobbleAmplitude: Double = 0.0,
    @SageIniName("RopeWobbleRate") val ropeWobbleRate: Int = 0,
    @SageIniName("RopeFinalHeight") val ropeFinalHeight: Int = 0,
    @SageIniName("RappelSpeed") val rappelSpeed: Int = 0,
    @SageIniName("MinDropHeight") val minDropHeight: Int = 0,
    @SageIniName("UpgradedSupplyBoost") val upgradedSupplyBoost: Int = 0,
    @SageIniName("RotorWashParticleSystem") val rotorWashParticleSystem: SageReference<FXParticleSystem>? = null,
    @SageIniName("Turret") override val turret: List<Turret> = emptyList(),
    @SageIniName("AltTurret") override val altTurret: List<Turret> = emptyList(),
) : SupplyTruckAIUpdate() {

    companion object : SageIniBlockDescriptor<ChinookAIUpdate>(
        name = "ChinookAIUpdate",
        parent = SupplyTruckAIUpdate,
        properties = {
            property("NumRopes", IntValue) { it.numRopes }
            property("PerRopeDelayMin", IntValue) { it.perRopeDelayMin }
            property("PerRopeDelayMax", IntValue) { it.perRopeDelayMax }
            property("RopeWidth", FloatValue) { it.ropeWidth }
            property("RopeColor", Untyped.type) { it.ropeColor }
            property("RopeWobbleLen", IntValue) { it.ropeWobbleLen }
            property("RopeWobbleAmplitude", FloatValue) { it.ropeWobbleAmplitude }
            property("RopeWobbleRate", IntValue) { it.ropeWobbleRate }
            property("RopeFinalHeight", IntValue) { it.ropeFinalHeight }
            property("RappelSpeed", IntValue) { it.rappelSpeed }
            property("MinDropHeight", IntValue) { it.minDropHeight }
            property("UpgradedSupplyBoost", IntValue) { it.upgradedSupplyBoost }
            property("RotorWashParticleSystem", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rotorWashParticleSystem }
        },
    )
}
