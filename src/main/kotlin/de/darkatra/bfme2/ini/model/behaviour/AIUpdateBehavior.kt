package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AttackPriority
import de.darkatra.bfme2.ini.model.`object`.Turret
import de.darkatra.bfme2.ini.model.value.AutoAcquireEnemiesType
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

open class AIUpdateBehavior(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TurretsLinked") open val turretsLinked: Boolean = false,
    @SageIniName("AutoAcquireEnemiesWhenIdle") open val autoAcquireEnemiesWhenIdle: List<AutoAcquireEnemiesType> = emptyList(),
    @SageIniName("MoodAttackCheckRate") open val moodAttackCheckRate: Int = 0,
    @SageIniName("ForbidPlayerCommands") open val forbidPlayerCommands: Boolean = false,
    @SageIniName("AILuaEventsList") open val aILuaEventsList: Untyped? = null,
    @SageIniName("HoldGroundCloseRangeDistance") open val holdGroundCloseRangeDistance: Double = 0.0,
    @SageIniName("MinCowerTime") open val minCowerTime: Int = 0,
    @SageIniName("MaxCowerTime") open val maxCowerTime: Int = 0,
    @SageIniName("CanAttackWhileContained") open val canAttackWhileContained: Boolean = false,
    @SageIniName("RampageTime") open val rampageTime: Int = 0,
    @SageIniName("TimeToEjectPassengersOnRampage") open val timeToEjectPassengersOnRampage: Int = 0,
    @SageIniName("AttackPriority") open val attackPriority: SageReference<AttackPriority>? = null,
    @SageIniName("SpecialContactPoints") open val specialContactPoints: List<Untyped> = emptyList(),
    @SageIniName("FadeOnPortals") open val fadeOnPortals: Boolean = false,
    @SageIniName("StopChaseDistance") open val stopChaseDistance: Double = 0.0,
    @SageIniName("RampageRequiresAflame") open val rampageRequiresAflame: Boolean = false,
    @SageIniName("MoveForNoOne") open val moveForNoOne: Boolean = false,
    @SageIniName("StandGround") open val standGround: Boolean = false,
    @SageIniName("BurningDeathTime") open val burningDeathTime: Int = 0,
    @SageIniName("Turret") open val turret: List<Turret> = emptyList(),
    @SageIniName("AltTurret") open val altTurret: List<Turret> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<AIUpdateBehavior>(
        name = "AIUpdateBehavior",
        properties = {
            property("TurretsLinked", BooleanValue) { it.turretsLinked }
            property("AutoAcquireEnemiesWhenIdle", ListValue(AutoAcquireEnemiesType.type)) { it.autoAcquireEnemiesWhenIdle }
            property("MoodAttackCheckRate", IntValue) { it.moodAttackCheckRate }
            property("ForbidPlayerCommands", BooleanValue) { it.forbidPlayerCommands }
            property("AILuaEventsList", Untyped.type) { it.aILuaEventsList }
            property("HoldGroundCloseRangeDistance", FloatValue) { it.holdGroundCloseRangeDistance }
            property("MinCowerTime", IntValue) { it.minCowerTime }
            property("MaxCowerTime", IntValue) { it.maxCowerTime }
            property("CanAttackWhileContained", BooleanValue) { it.canAttackWhileContained }
            property("RampageTime", IntValue) { it.rampageTime }
            property("TimeToEjectPassengersOnRampage", IntValue) { it.timeToEjectPassengersOnRampage }
            property("AttackPriority", ReferenceValue<AttackPriority> { listOf(AttackPriority) }) { it.attackPriority }
            property("SpecialContactPoints", ListValue(Untyped.type)) { it.specialContactPoints }
            property("FadeOnPortals", BooleanValue) { it.fadeOnPortals }
            property("StopChaseDistance", FloatValue) { it.stopChaseDistance }
            property("RampageRequiresAflame", BooleanValue) { it.rampageRequiresAflame }
            property("MoveForNoOne", BooleanValue) { it.moveForNoOne }
            property("StandGround", BooleanValue) { it.standGround }
            property("BurningDeathTime", IntValue) { it.burningDeathTime }
            property("Turret", ListValue(BlockValue<Turret> { listOf(Turret) })) { it.turret }
            property("AltTurret", ListValue(BlockValue<Turret> { listOf(Turret) })) { it.altTurret }
        },
    )
}
