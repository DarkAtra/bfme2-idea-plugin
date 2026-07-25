package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.Untyped

data class Locomotor(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Surfaces") val surfaces: Untyped? = null,
    @SageIniName("ZAxisBehavior") val zAxisBehavior: Untyped? = null,
    @SageIniName("Appearance") val appearance: Untyped? = null,
    @SageIniName("FormationPriority") val formationPriority: Untyped? = null,
    @SageIniName("Speed") val speed: Double = 0.0,
    @SageIniName("SpeedDamaged") val speedDamaged: Double = 0.0,
    @SageIniName("MinSpeed") val minSpeed: Double = 0.0,
    @SageIniName("MinTurnSpeed") val minTurnSpeed: Double = 0.0,
    @SageIniName("Acceleration") val acceleration: Double = 0.0,
    @SageIniName("Braking") val braking: Double = 0.0,
    @SageIniName("TurnTime") val turnTime: Double = 0.0,
    @SageIniName("TurnTimeDamaged") val turnTimeDamaged: Double = 0.0,
    @SageIniName("FastTurnRadius") val fastTurnRadius: Double = 0.0,
    @SageIniName("SlowTurnRadius") val slowTurnRadius: Double = 0.0,
    @SageIniName("TurnThreshold") val turnThreshold: Double = 0.0,
    @SageIniName("TurnThresholdHS") val turnThresholdHS: Double = 0.0,
    @SageIniName("TurnPivotOffset") val turnPivotOffset: Double = 0.0,
    @SageIniName("MaxTurnWithoutReform") val maxTurnWithoutReform: Double = 0.0,
    @SageIniName("CirclingRadius") val circlingRadius: Double = 0.0,
    @SageIniName("WalkDistance") val walkDistance: Double = 0.0,
    @SageIniName("LookAheadMult") val lookAheadMult: Double = 0.0,
    @SageIniName("CloseEnoughDist") val closeEnoughDist: Double = 0.0,
    @SageIniName("PreferredHeight") val preferredHeight: Double = 0.0,
    @SageIniName("PreferredAttackHeight") val preferredAttackHeight: Double = 0.0,
    @SageIniName("AirborneTargetingHeight") val airborneTargetingHeight: Double = 0.0,
    @SageIniName("MaxOverlappedHeight") val maxOverlappedHeight: Double = 0.0,
    @SageIniName("Lift") val lift: Double = 0.0,
    @SageIniName("LiftDamaged") val liftDamaged: Double = 0.0,
    @SageIniName("MaxThrustAngle") val maxThrustAngle: Double = 0.0,
    @SageIniName("AllowAirborneMotiveForce") val allowAirborneMotiveForce: Boolean = false,
    @SageIniName("Apply2DFrictionWhenAirborne") val apply2DFrictionWhenAirborne: Boolean = false,
    @SageIniName("ForwardAccelerationPitchFactor") val forwardAccelerationPitchFactor: Double = 0.0,
    @SageIniName("ForwardVelocityPitchFactor") val forwardVelocityPitchFactor: Double = 0.0,
    @SageIniName("LateralAccelerationRollFactor") val lateralAccelerationRollFactor: Double = 0.0,
    @SageIniName("LateralVelocityRollFactor") val lateralVelocityRollFactor: Double = 0.0,
    @SageIniName("PitchInDirectionOfZVelFactor") val pitchInDirectionOfZVelFactor: Double = 0.0,
    @SageIniName("PitchStiffness") val pitchStiffness: Double = 0.0,
    @SageIniName("RollStiffness") val rollStiffness: Double = 0.0,
    @SageIniName("PitchDamping") val pitchDamping: Double = 0.0,
    @SageIniName("RollDamping") val rollDamping: Double = 0.0,
    @SageIniName("AccelerationPitchLimit") val accelerationPitchLimit: Double = 0.0,
    @SageIniName("BounceAmount") val bounceAmount: Double = 0.0,
    @SageIniName("UseTerrainSmoothing") val useTerrainSmoothing: Boolean = false,
    @SageIniName("HasSuspension") val hasSuspension: Boolean = false,
    @SageIniName("MaximumWheelExtension") val maximumWheelExtension: Double = 0.0,
    @SageIniName("MaximumWheelCompression") val maximumWheelCompression: Double = 0.0,
    @SageIniName("FrontWheelTurnAngle") val frontWheelTurnAngle: Double = 0.0,
    @SageIniName("ElevatorCorrectionDegree") val elevatorCorrectionDegree: Double = 0.0,
    @SageIniName("ElevatorCorrectionRate") val elevatorCorrectionRate: Double = 0.0,
    @SageIniName("AeleronCorrectionDegree") val aeleronCorrectionDegree: Double = 0.0,
    @SageIniName("AeleronCorrectionRate") val aeleronCorrectionRate: Double = 0.0,
    @SageIniName("RudderCorrectionDegree") val rudderCorrectionDegree: Double = 0.0,
    @SageIniName("RudderCorrectionRate") val rudderCorrectionRate: Double = 0.0,
    @SageIniName("SwoopStandoffRadius") val swoopStandoffRadius: Double = 0.0,
    @SageIniName("SwoopStandoffHeight") val swoopStandoffHeight: Double = 0.0,
    @SageIniName("SwoopTerminalVelocity") val swoopTerminalVelocity: Double = 0.0,
    @SageIniName("SwoopAccelerationRate") val swoopAccelerationRate: Double = 0.0,
    @SageIniName("CanMoveBackwards") val canMoveBackwards: Boolean = false,
    @SageIniName("BackingUpSpeed") val backingUpSpeed: Double = 0.0,
    @SageIniName("BackingUpStopWhenTurning") val backingUpStopWhenTurning: Boolean = false,
    @SageIniName("BackingUpDistanceMin") val backingUpDistanceMin: Double = 0.0,
    @SageIniName("BackingUpDistanceMax") val backingUpDistanceMax: Double = 0.0,
    @SageIniName("BackingUpAngle") val backingUpAngle: Double = 0.0,
    @SageIniName("ChargeSpeed") val chargeSpeed: Double = 0.0,
    @SageIniName("ChargeAvailable") val chargeAvailable: Boolean = false,
    @SageIniName("ChargeIgnoresCondition") val chargeIgnoresCondition: Boolean = false,
    @SageIniName("WanderWidthFactor") val wanderWidthFactor: Double = 0.0,
    @SageIniName("WanderLengthFactor") val wanderLengthFactor: Double = 0.0,
    @SageIniName("WanderAboutPointRadius") val wanderAboutPointRadius: Double = 0.0,
    @SageIniName("AccDecTrigger") val accDecTrigger: Double = 0.0,
    @SageIniName("SlideIntoPlaceTime") val slideIntoPlaceTime: Double = 0.0,
    @SageIniName("RiverModifier") val riverModifier: Double = 0.0,
    @SageIniName("StickToGround") val stickToGround: Boolean = false,
    @SageIniName("ScalesWalls") val scalesWalls: Boolean = false,
    @SageIniName("CrewPowered") val crewPowered: Boolean = false,
    @SageIniName("TurnWhileMoving") val turnWhileMoving: Boolean = false,
    @SageIniName("WaitForFormation") val waitForFormation: Boolean = false,
    @SageIniName("NonDirtyTransform") val nonDirtyTransform: Boolean = false,
    @SageIniName("LocomotorWorksWhenDead") val locomotorWorksWhenDead: Boolean = false,
    @SageIniName("EnableHighSpeedTurnModelconditions") val enableHighSpeedTurnModelconditions: Boolean = false,
    @SageIniName("BurningDeathRadius") val burningDeathRadius: Double = 0.0,
    @SageIniName("BurningDeathIsCavalry") val burningDeathIsCavalry: Boolean = false,
    @SageIniName("AccelerationDamaged") val accelerationDamaged: Double = 0.0,
    @SageIniName("TurnRate") val turnRate: Double = 0.0,
    @SageIniName("TurnRateDamaged") val turnRateDamaged: Double = 0.0,
    @SageIniName("Extra2DFriction") val extra2DFriction: Double = 0.0,
    @SageIniName("SpeedLimitZ") val speedLimitZ: Double = 0.0,
    @SageIniName("PreferredHeightDamping") val preferredHeightDamping: Double = 0.0,
    @SageIniName("CloseEnoughDist3D") val closeEnoughDist3D: Boolean = false,
    @SageIniName("DownhillOnly") val downhillOnly: Boolean = false,
    @SageIniName("UniformAxialDamping") val uniformAxialDamping: Double = 0.0,
    @SageIniName("DecelerationPitchLimit") val decelerationPitchLimit: Double = 0.0,
    @SageIniName("GroupMovementPriority") val groupMovementPriority: FakeToken? = null,
    @SageIniName("ThrustRoll") val thrustRoll: Double = 0.0,
    @SageIniName("ThrustWobbleRate") val thrustWobbleRate: Double = 0.0,
    @SageIniName("ThrustMinWobble") val thrustMinWobble: Double = 0.0,
    @SageIniName("ThrustMaxWobble") val thrustMaxWobble: Double = 0.0,
    @SageIniName("SwoopSpeedTuningFactor") val swoopSpeedTuningFactor: Double = 0.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Locomotor>(
        name = "Locomotor",
        tableKey = "locomotors",
        properties = {
            property("Surfaces", Untyped.type) { it.surfaces }
            property("ZAxisBehavior", Untyped.type) { it.zAxisBehavior }
            property("Appearance", Untyped.type) { it.appearance }
            property("FormationPriority", Untyped.type) { it.formationPriority }
            property("Speed", FloatValue) { it.speed }
            property("SpeedDamaged", FloatValue) { it.speedDamaged }
            property("MinSpeed", FloatValue) { it.minSpeed }
            property("MinTurnSpeed", FloatValue) { it.minTurnSpeed }
            property("Acceleration", FloatValue) { it.acceleration }
            property("Braking", FloatValue) { it.braking }
            property("TurnTime", FloatValue) { it.turnTime }
            property("TurnTimeDamaged", FloatValue) { it.turnTimeDamaged }
            property("FastTurnRadius", FloatValue) { it.fastTurnRadius }
            property("SlowTurnRadius", FloatValue) { it.slowTurnRadius }
            property("TurnThreshold", FloatValue) { it.turnThreshold }
            property("TurnThresholdHS", FloatValue) { it.turnThresholdHS }
            property("TurnPivotOffset", FloatValue) { it.turnPivotOffset }
            property("MaxTurnWithoutReform", FloatValue) { it.maxTurnWithoutReform }
            property("CirclingRadius", FloatValue) { it.circlingRadius }
            property("WalkDistance", FloatValue) { it.walkDistance }
            property("LookAheadMult", FloatValue) { it.lookAheadMult }
            property("CloseEnoughDist", FloatValue) { it.closeEnoughDist }
            property("PreferredHeight", FloatValue) { it.preferredHeight }
            property("PreferredAttackHeight", FloatValue) { it.preferredAttackHeight }
            property("AirborneTargetingHeight", FloatValue) { it.airborneTargetingHeight }
            property("MaxOverlappedHeight", FloatValue) { it.maxOverlappedHeight }
            property("Lift", FloatValue) { it.lift }
            property("LiftDamaged", FloatValue) { it.liftDamaged }
            property("MaxThrustAngle", FloatValue) { it.maxThrustAngle }
            property("AllowAirborneMotiveForce", BooleanValue) { it.allowAirborneMotiveForce }
            property("Apply2DFrictionWhenAirborne", BooleanValue) { it.apply2DFrictionWhenAirborne }
            property("ForwardAccelerationPitchFactor", FloatValue) { it.forwardAccelerationPitchFactor }
            property("ForwardVelocityPitchFactor", FloatValue) { it.forwardVelocityPitchFactor }
            property("LateralAccelerationRollFactor", FloatValue) { it.lateralAccelerationRollFactor }
            property("LateralVelocityRollFactor", FloatValue) { it.lateralVelocityRollFactor }
            property("PitchInDirectionOfZVelFactor", FloatValue) { it.pitchInDirectionOfZVelFactor }
            property("PitchStiffness", FloatValue) { it.pitchStiffness }
            property("RollStiffness", FloatValue) { it.rollStiffness }
            property("PitchDamping", FloatValue) { it.pitchDamping }
            property("RollDamping", FloatValue) { it.rollDamping }
            property("AccelerationPitchLimit", FloatValue) { it.accelerationPitchLimit }
            property("BounceAmount", FloatValue) { it.bounceAmount }
            property("UseTerrainSmoothing", BooleanValue) { it.useTerrainSmoothing }
            property("HasSuspension", BooleanValue) { it.hasSuspension }
            property("MaximumWheelExtension", FloatValue) { it.maximumWheelExtension }
            property("MaximumWheelCompression", FloatValue) { it.maximumWheelCompression }
            property("FrontWheelTurnAngle", FloatValue) { it.frontWheelTurnAngle }
            property("ElevatorCorrectionDegree", FloatValue) { it.elevatorCorrectionDegree }
            property("ElevatorCorrectionRate", FloatValue) { it.elevatorCorrectionRate }
            property("AeleronCorrectionDegree", FloatValue) { it.aeleronCorrectionDegree }
            property("AeleronCorrectionRate", FloatValue) { it.aeleronCorrectionRate }
            property("RudderCorrectionDegree", FloatValue) { it.rudderCorrectionDegree }
            property("RudderCorrectionRate", FloatValue) { it.rudderCorrectionRate }
            property("SwoopStandoffRadius", FloatValue) { it.swoopStandoffRadius }
            property("SwoopStandoffHeight", FloatValue) { it.swoopStandoffHeight }
            property("SwoopTerminalVelocity", FloatValue) { it.swoopTerminalVelocity }
            property("SwoopAccelerationRate", FloatValue) { it.swoopAccelerationRate }
            property("CanMoveBackwards", BooleanValue) { it.canMoveBackwards }
            property("BackingUpSpeed", FloatValue) { it.backingUpSpeed }
            property("BackingUpStopWhenTurning", BooleanValue) { it.backingUpStopWhenTurning }
            property("BackingUpDistanceMin", FloatValue) { it.backingUpDistanceMin }
            property("BackingUpDistanceMax", FloatValue) { it.backingUpDistanceMax }
            property("BackingUpAngle", FloatValue) { it.backingUpAngle }
            property("ChargeSpeed", FloatValue) { it.chargeSpeed }
            property("ChargeAvailable", BooleanValue) { it.chargeAvailable }
            property("ChargeIgnoresCondition", BooleanValue) { it.chargeIgnoresCondition }
            property("WanderWidthFactor", FloatValue) { it.wanderWidthFactor }
            property("WanderLengthFactor", FloatValue) { it.wanderLengthFactor }
            property("WanderAboutPointRadius", FloatValue) { it.wanderAboutPointRadius }
            property("AccDecTrigger", FloatValue) { it.accDecTrigger }
            property("SlideIntoPlaceTime", FloatValue) { it.slideIntoPlaceTime }
            property("RiverModifier", FloatValue) { it.riverModifier }
            property("StickToGround", BooleanValue) { it.stickToGround }
            property("ScalesWalls", BooleanValue) { it.scalesWalls }
            property("CrewPowered", BooleanValue) { it.crewPowered }
            property("TurnWhileMoving", BooleanValue) { it.turnWhileMoving }
            property("WaitForFormation", BooleanValue) { it.waitForFormation }
            property("NonDirtyTransform", BooleanValue) { it.nonDirtyTransform }
            property("LocomotorWorksWhenDead", BooleanValue) { it.locomotorWorksWhenDead }
            property("EnableHighSpeedTurnModelconditions", BooleanValue) { it.enableHighSpeedTurnModelconditions }
            property("BurningDeathRadius", FloatValue) { it.burningDeathRadius }
            property("BurningDeathIsCavalry", BooleanValue) { it.burningDeathIsCavalry }
            property("AccelerationDamaged", FloatValue) { it.accelerationDamaged }
            property("TurnRate", FloatValue) { it.turnRate }
            property("TurnRateDamaged", FloatValue) { it.turnRateDamaged }
            property("Extra2DFriction", FloatValue) { it.extra2DFriction }
            property("SpeedLimitZ", FloatValue) { it.speedLimitZ }
            property("PreferredHeightDamping", FloatValue) { it.preferredHeightDamping }
            property("CloseEnoughDist3D", BooleanValue) { it.closeEnoughDist3D }
            property("DownhillOnly", BooleanValue) { it.downhillOnly }
            property("UniformAxialDamping", FloatValue) { it.uniformAxialDamping }
            property("DecelerationPitchLimit", FloatValue) { it.decelerationPitchLimit }
            property("GroupMovementPriority", FakeToken.type) { it.groupMovementPriority }
            property("ThrustRoll", FloatValue) { it.thrustRoll }
            property("ThrustWobbleRate", FloatValue) { it.thrustWobbleRate }
            property("ThrustMinWobble", FloatValue) { it.thrustMinWobble }
            property("ThrustMaxWobble", FloatValue) { it.thrustMaxWobble }
            property("SwoopSpeedTuningFactor", FloatValue) { it.swoopSpeedTuningFactor }
        },
    )
}
