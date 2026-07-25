package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.value.SageReference

data class PhysicsBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Mass") val mass: Double = 0.0,
    @SageIniName("AerodynamicFriction") val aerodynamicFriction: Double = 0.0,
    @SageIniName("ForwardFriction") val forwardFriction: Double = 0.0,
    @SageIniName("LateralFriction") val lateralFriction: Double = 0.0,
    @SageIniName("ZFriction") val zFriction: Double = 0.0,
    @SageIniName("CenterOfMassOffset") val centerOfMassOffset: Double = 0.0,
    @SageIniName("AllowCollideForce") val allowCollideForce: Boolean = false,
    @SageIniName("PitchRollYawFactor") val pitchRollYawFactor: Double = 0.0,
    @SageIniName("ShockResistance") val shockResistance: Double = 0.0,
    @SageIniName("ShockMaxYaw") val shockMaxYaw: Double = 0.0,
    @SageIniName("ShockMaxPitch") val shockMaxPitch: Double = 0.0,
    @SageIniName("ShockMaxRoll") val shockMaxRoll: Double = 0.0,
    @SageIniName("MinFallHeightForDamage") val minFallHeightForDamage: Double = 0.0,
    @SageIniName("FallHeightDamageFactor") val fallHeightDamageFactor: Double = 0.0,
    @SageIniName("TumbleRandomly") val tumbleRandomly: Boolean = false,
    @SageIniName("AllowBouncing") val allowBouncing: Boolean = false,
    @SageIniName("KillWhenRestingOnGround") val killWhenRestingOnGround: Boolean = false,
    @SageIniName("GravityMult") val gravityMult: Double = 0.0,
    @SageIniName("OrientToFlightPath") val orientToFlightPath: Boolean = false,
    @SageIniName("ShockStunnedTimeLow") val shockStunnedTimeLow: Int = 0,
    @SageIniName("ShockStunnedTimeHigh") val shockStunnedTimeHigh: Int = 0,
    @SageIniName("ShockStandingTime") val shockStandingTime: Int = 0,
    @SageIniName("FirstHeight") val firstHeight: Double = 0.0,
    @SageIniName("SecondHeight") val secondHeight: Double = 0.0,
    @SageIniName("FirstPercentIndent") val firstPercentIndent: Double = 0.0,
    @SageIniName("SecondPercentIndent") val secondPercentIndent: Double = 0.0,
    @SageIniName("BounceCount") val bounceCount: Int = 0,
    @SageIniName("BounceFirstHeight") val bounceFirstHeight: Double = 0.0,
    @SageIniName("BounceSecondHeight") val bounceSecondHeight: Double = 0.0,
    @SageIniName("BounceFirstPercentIndent") val bounceFirstPercentIndent: Double = 0.0,
    @SageIniName("BounceSecondPercentIndent") val bounceSecondPercentIndent: Double = 0.0,
    @SageIniName("IgnoreTerrainHeight") val ignoreTerrainHeight: Boolean = false,
    @SageIniName("FirstPercentHeight") val firstPercentHeight: Double = 0.0,
    @SageIniName("SecondPercentHeight") val secondPercentHeight: Double = 0.0,
    @SageIniName("CurveFlattenMinDist") val curveFlattenMinDist: Double = 0.0,
    @SageIniName("GroundHitFX") val groundHitFX: SageReference<FXList>? = null,
    @SageIniName("GroundBounceFX") val groundBounceFX: SageReference<FXList>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<PhysicsBehavior>(
        name = "PhysicsBehavior",
        properties = {
            property("Mass", FloatValue) { it.mass }
            property("AerodynamicFriction", FloatValue) { it.aerodynamicFriction }
            property("ForwardFriction", FloatValue) { it.forwardFriction }
            property("LateralFriction", FloatValue) { it.lateralFriction }
            property("ZFriction", FloatValue) { it.zFriction }
            property("CenterOfMassOffset", FloatValue) { it.centerOfMassOffset }
            property("AllowCollideForce", BooleanValue) { it.allowCollideForce }
            property("PitchRollYawFactor", FloatValue) { it.pitchRollYawFactor }
            property("ShockResistance", FloatValue) { it.shockResistance }
            property("ShockMaxYaw", FloatValue) { it.shockMaxYaw }
            property("ShockMaxPitch", FloatValue) { it.shockMaxPitch }
            property("ShockMaxRoll", FloatValue) { it.shockMaxRoll }
            property("MinFallHeightForDamage", FloatValue) { it.minFallHeightForDamage }
            property("FallHeightDamageFactor", FloatValue) { it.fallHeightDamageFactor }
            property("TumbleRandomly", BooleanValue) { it.tumbleRandomly }
            property("AllowBouncing", BooleanValue) { it.allowBouncing }
            property("KillWhenRestingOnGround", BooleanValue) { it.killWhenRestingOnGround }
            property("GravityMult", FloatValue) { it.gravityMult }
            property("OrientToFlightPath", BooleanValue) { it.orientToFlightPath }
            property("ShockStunnedTimeLow", IntValue) { it.shockStunnedTimeLow }
            property("ShockStunnedTimeHigh", IntValue) { it.shockStunnedTimeHigh }
            property("ShockStandingTime", IntValue) { it.shockStandingTime }
            property("FirstHeight", FloatValue) { it.firstHeight }
            property("SecondHeight", FloatValue) { it.secondHeight }
            property("FirstPercentIndent", FloatValue) { it.firstPercentIndent }
            property("SecondPercentIndent", FloatValue) { it.secondPercentIndent }
            property("BounceCount", IntValue) { it.bounceCount }
            property("BounceFirstHeight", FloatValue) { it.bounceFirstHeight }
            property("BounceSecondHeight", FloatValue) { it.bounceSecondHeight }
            property("BounceFirstPercentIndent", FloatValue) { it.bounceFirstPercentIndent }
            property("BounceSecondPercentIndent", FloatValue) { it.bounceSecondPercentIndent }
            property("IgnoreTerrainHeight", BooleanValue) { it.ignoreTerrainHeight }
            property("FirstPercentHeight", FloatValue) { it.firstPercentHeight }
            property("SecondPercentHeight", FloatValue) { it.secondPercentHeight }
            property("CurveFlattenMinDist", FloatValue) { it.curveFlattenMinDist }
            property("GroundHitFX", ReferenceValue<FXList> { listOf(FXList) }) { it.groundHitFX }
            property("GroundBounceFX", ReferenceValue<FXList> { listOf(FXList) }) { it.groundBounceFX }
        },
    )
}
