package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AttackPriority
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Turret
import de.darkatra.bfme2.ini.model.value.AutoAcquireEnemiesType
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class MissileAIUpdate(
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
    @SageIniName("TryToFollowTarget") val tryToFollowTarget: Boolean = false,
    @SageIniName("FuelLifetime") val fuelLifetime: Int = 0,
    @SageIniName("DetonateOnNoFuel") val detonateOnNoFuel: Boolean = false,
    @SageIniName("InitialVelocity") val initialVelocity: Double = 0.0,
    @SageIniName("IgnitionDelay") val ignitionDelay: Int = 0,
    @SageIniName("DistanceToTravelBeforeTurning") val distanceToTravelBeforeTurning: Int = 0,
    @SageIniName("DistanceToTargetBeforeDiving") val distanceToTargetBeforeDiving: Int = 0,
    @SageIniName("DistanceToTargetForLock") val distanceToTargetForLock: Int = 0,
    @SageIniName("GarrisonHitKillRequiredKindOf") val garrisonHitKillRequiredKindOf: KindOf? = null,
    @SageIniName("GarrisonHitKillForbiddenKindOf") val garrisonHitKillForbiddenKindOf: KindOf? = null,
    @SageIniName("GarrisonHitKillCount") val garrisonHitKillCount: Int = 0,
    @SageIniName("GarrisonHitKillFX") val garrisonHitKillFX: SageReference<FXList>? = null,
    @SageIniName("DetonateCallsKill") val detonateCallsKill: Boolean = false,
    @SageIniName("IgnitionFX") val ignitionFX: SageReference<FXList>? = null,
    @SageIniName("KillSelfDelay") val killSelfDelay: Int = 0,
    @SageIniName("DistanceScatterWhenJammed") val distanceScatterWhenJammed: Int = 0,
    @SageIniName("Turret") override val turret: List<Turret> = emptyList(),
    @SageIniName("AltTurret") override val altTurret: List<Turret> = emptyList(),
) : AIUpdateBehavior() {

    companion object : SageIniBlockDescriptor<MissileAIUpdate>(
        name = "MissileAIUpdate",
        parent = AIUpdateBehavior,
        properties = {
            property("TryToFollowTarget", BooleanValue) { it.tryToFollowTarget }
            property("FuelLifetime", IntValue) { it.fuelLifetime }
            property("DetonateOnNoFuel", BooleanValue) { it.detonateOnNoFuel }
            property("InitialVelocity", FloatValue) { it.initialVelocity }
            property("IgnitionDelay", IntValue) { it.ignitionDelay }
            property("DistanceToTravelBeforeTurning", IntValue) { it.distanceToTravelBeforeTurning }
            property("DistanceToTargetBeforeDiving", IntValue) { it.distanceToTargetBeforeDiving }
            property("DistanceToTargetForLock", IntValue) { it.distanceToTargetForLock }
            property("GarrisonHitKillRequiredKindOf", KindOf.type) { it.garrisonHitKillRequiredKindOf }
            property("GarrisonHitKillForbiddenKindOf", KindOf.type) { it.garrisonHitKillForbiddenKindOf }
            property("GarrisonHitKillCount", IntValue) { it.garrisonHitKillCount }
            property("GarrisonHitKillFX", ReferenceValue<FXList> { listOf(FXList) }) { it.garrisonHitKillFX }
            property("DetonateCallsKill", BooleanValue) { it.detonateCallsKill }
            property("IgnitionFX", ReferenceValue<FXList> { listOf(FXList) }) { it.ignitionFX }
            property("KillSelfDelay", IntValue) { it.killSelfDelay }
            property("DistanceScatterWhenJammed", IntValue) { it.distanceScatterWhenJammed }
        },
    )
}
