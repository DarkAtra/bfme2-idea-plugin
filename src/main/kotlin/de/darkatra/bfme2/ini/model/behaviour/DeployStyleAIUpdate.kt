package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AttackPriority
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Turret
import de.darkatra.bfme2.ini.model.value.AutoAcquireEnemiesType
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class DeployStyleAIUpdate(
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
    @SageIniName("PackTime") val packTime: Int = 0,
    @SageIniName("UnpackTime") val unpackTime: Int = 0,
    @SageIniName("TurretsFunctionOnlyWhenDeployed") val turretsFunctionOnlyWhenDeployed: Boolean = false,
    @SageIniName("TurretsMustCenterBeforePacking") val turretsMustCenterBeforePacking: Boolean = false,
    @SageIniName("ManualDeployAnimations") val manualDeployAnimations: Boolean = false,
    @SageIniName("MustDeployToAttack") val mustDeployToAttack: Boolean = false,
    @SageIniName("DeployedAttributeModifier") val deployedAttributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("Turret") override val turret: List<Turret> = emptyList(),
    @SageIniName("AltTurret") override val altTurret: List<Turret> = emptyList(),
) : AIUpdateBehavior() {

    companion object : SageIniBlockDescriptor<DeployStyleAIUpdate>(
        name = "DeployStyleAIUpdate",
        parent = AIUpdateBehavior,
        properties = {
            property("PackTime", IntValue) { it.packTime }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("TurretsFunctionOnlyWhenDeployed", BooleanValue) { it.turretsFunctionOnlyWhenDeployed }
            property("TurretsMustCenterBeforePacking", BooleanValue) { it.turretsMustCenterBeforePacking }
            property("ManualDeployAnimations", BooleanValue) { it.manualDeployAnimations }
            property("MustDeployToAttack", BooleanValue) { it.mustDeployToAttack }
            property("DeployedAttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.deployedAttributeModifier }
        },
    )
}
