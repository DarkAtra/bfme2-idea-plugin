package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.`object`.AttackPriority
import de.darkatra.bfme2.ini.model.`object`.Turret
import de.darkatra.bfme2.ini.model.value.AutoAcquireEnemiesType
import de.darkatra.bfme2.ini.model.value.LocomotorSetType
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class JetAIUpdate(
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
    @SageIniName("OutOfAmmoDamagePerSecond") val outOfAmmoDamagePerSecond: Double = 0.0,
    @SageIniName("TakeoffSpeedForMaxLift") val takeoffSpeedForMaxLift: Double = 0.0,
    @SageIniName("TakeoffDistForMaxLift") val takeoffDistForMaxLift: Double = 0.0,
    @SageIniName("TakeoffPause") val takeoffPause: Int = 0,
    @SageIniName("MinHeight") val minHeight: Int = 0,
    @SageIniName("NeedsRunway") val needsRunway: Boolean = false,
    @SageIniName("KeepsParkingSpaceWhenAirborne") val keepsParkingSpaceWhenAirborne: Boolean = false,
    @SageIniName("SneakyOffsetWhenAttacking") val sneakyOffsetWhenAttacking: Double = 0.0,
    @SageIniName("AttackLocomotorType") val attackLocomotorType: LocomotorSetType? = null,
    @SageIniName("AttackLocomotorPersistTime") val attackLocomotorPersistTime: Int = 0,
    @SageIniName("AttackersMissPersistTime") val attackersMissPersistTime: Int = 0,
    @SageIniName("ReturnForAmmoLocomotorType") val returnForAmmoLocomotorType: LocomotorSetType? = null,
    @SageIniName("ParkingOffset") val parkingOffset: Int = 0,
    @SageIniName("ReturnToBaseIdleTime") val returnToBaseIdleTime: Int = 0,
    @SageIniName("Turret") override val turret: List<Turret> = emptyList(),
    @SageIniName("AltTurret") override val altTurret: List<Turret> = emptyList(),
) : AIUpdateBehavior() {

    companion object : SageIniBlockDescriptor<JetAIUpdate>(
        name = "JetAIUpdate",
        parent = AIUpdateBehavior,
        properties = {
            property("OutOfAmmoDamagePerSecond", FloatValue) { it.outOfAmmoDamagePerSecond }
            property("TakeoffSpeedForMaxLift", FloatValue) { it.takeoffSpeedForMaxLift }
            property("TakeoffDistForMaxLift", FloatValue) { it.takeoffDistForMaxLift }
            property("TakeoffPause", IntValue) { it.takeoffPause }
            property("MinHeight", IntValue) { it.minHeight }
            property("NeedsRunway", BooleanValue) { it.needsRunway }
            property("KeepsParkingSpaceWhenAirborne", BooleanValue) { it.keepsParkingSpaceWhenAirborne }
            property("SneakyOffsetWhenAttacking", FloatValue) { it.sneakyOffsetWhenAttacking }
            property("AttackLocomotorType", LocomotorSetType.type) { it.attackLocomotorType }
            property("AttackLocomotorPersistTime", IntValue) { it.attackLocomotorPersistTime }
            property("AttackersMissPersistTime", IntValue) { it.attackersMissPersistTime }
            property("ReturnForAmmoLocomotorType", LocomotorSetType.type) { it.returnForAmmoLocomotorType }
            property("ParkingOffset", IntValue) { it.parkingOffset }
            property("ReturnToBaseIdleTime", IntValue) { it.returnToBaseIdleTime }
        },
    )
}
