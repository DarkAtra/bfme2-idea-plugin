package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AttackPriority
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Turret
import de.darkatra.bfme2.ini.model.value.AutoAcquireEnemiesType
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class GiantBirdAIUpdate(
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
    @SageIniName("FollowThroughDistance") val followThroughDistance: Int = 0,
    @SageIniName("FollowThroughCheckStep") val followThroughCheckStep: Int = 0,
    @SageIniName("FollowThroughGradient") val followThroughGradient: Double = 0.0,
    @SageIniName("GrabTossTimeTrigger") val grabTossTimeTrigger: Double = 0.0,
    @SageIniName("GrabTossHeightTrigger") val grabTossHeightTrigger: Double = 0.0,
    @SageIniName("TossFX") val tossFX: SageReference<FXList>? = null,
    @SageIniName("Turret") override val turret: List<Turret> = emptyList(),
    @SageIniName("AltTurret") override val altTurret: List<Turret> = emptyList(),
) : AIUpdateBehavior() {

    companion object : SageIniBlockDescriptor<GiantBirdAIUpdate>(
        name = "GiantBirdAIUpdate",
        parent = AIUpdateBehavior,
        properties = {
            property("FollowThroughDistance", IntValue) { it.followThroughDistance }
            property("FollowThroughCheckStep", IntValue) { it.followThroughCheckStep }
            property("FollowThroughGradient", FloatValue) { it.followThroughGradient }
            property("GrabTossTimeTrigger", FloatValue) { it.grabTossTimeTrigger }
            property("GrabTossHeightTrigger", FloatValue) { it.grabTossHeightTrigger }
            property("TossFX", ReferenceValue<FXList> { listOf(FXList) }) { it.tossFX }
        },
    )
}
