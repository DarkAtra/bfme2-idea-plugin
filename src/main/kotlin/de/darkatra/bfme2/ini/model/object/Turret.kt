package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class Turret(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TurretTurnRate") val turretTurnRate: Int = 0,
    @SageIniName("TurretPitchRate") val turretPitchRate: Int = 0,
    @SageIniName("ControlledWeaponSlots") val controlledWeaponSlots: Untyped? = null,
    @SageIniName("AllowsPitch") val allowsPitch: Boolean = false,
    @SageIniName("RecenterTime") val recenterTime: Int = 0,
    @SageIniName("InitialDirection") val initialDirection: Untyped? = null,
    @SageIniName("FiresWhileTurning") val firesWhileTurning: Boolean = false,
    @SageIniName("MinIdleScanInterval") val minIdleScanInterval: Int = 0,
    @SageIniName("MaxIdleScanInterval") val maxIdleScanInterval: Int = 0,
    @SageIniName("NaturalTurretAngle") val naturalTurretAngle: Int = 0,
    @SageIniName("TurretMaxDeflectionCW") val turretMaxDeflectionCW: Int = 0,
    @SageIniName("TurretMaxDeflectionACW") val turretMaxDeflectionACW: Int = 0,
    @SageIniName("FirePitch") val firePitch: Double = 0.0,
    @SageIniName("GroundUnitPitch") val groundUnitPitch: Double = 0.0,
    @SageIniName("InitiallyDisabled") val initiallyDisabled: Boolean = false,
    @SageIniName("MinIdleScanAngle") val minIdleScanAngle: Double = 0.0,
    @SageIniName("MaxIdleScanAngle") val maxIdleScanAngle: Double = 0.0,
    @SageIniName("MinPhysicalPitch") val minPhysicalPitch: Double = 0.0,
    @SageIniName("NaturalTurretPitch") val naturalTurretPitch: Double = 0.0,
    @SageIniName("TurretFireAngleSweep") val turretFireAngleSweep: Untyped? = null,
    @SageIniName("TurretSweepSpeedModifier") val turretSweepSpeedModifier: Untyped? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Turret>(
        name = "Turret",
        properties = {
            property("TurretTurnRate", IntValue) { it.turretTurnRate }
            property("TurretPitchRate", IntValue) { it.turretPitchRate }
            property("ControlledWeaponSlots", Untyped.type) { it.controlledWeaponSlots }
            property("AllowsPitch", BooleanValue) { it.allowsPitch }
            property("RecenterTime", IntValue) { it.recenterTime }
            property("InitialDirection", Untyped.type) { it.initialDirection }
            property("FiresWhileTurning", BooleanValue) { it.firesWhileTurning }
            property("MinIdleScanInterval", IntValue) { it.minIdleScanInterval }
            property("MaxIdleScanInterval", IntValue) { it.maxIdleScanInterval }
            property("NaturalTurretAngle", IntValue) { it.naturalTurretAngle }
            property("TurretMaxDeflectionCW", IntValue) { it.turretMaxDeflectionCW }
            property("TurretMaxDeflectionACW", IntValue) { it.turretMaxDeflectionACW }
            property("FirePitch", FloatValue) { it.firePitch }
            property("GroundUnitPitch", FloatValue) { it.groundUnitPitch }
            property("InitiallyDisabled", BooleanValue) { it.initiallyDisabled }
            property("MinIdleScanAngle", FloatValue) { it.minIdleScanAngle }
            property("MaxIdleScanAngle", FloatValue) { it.maxIdleScanAngle }
            property("MinPhysicalPitch", FloatValue) { it.minPhysicalPitch }
            property("NaturalTurretPitch", FloatValue) { it.naturalTurretPitch }
            property("TurretFireAngleSweep", Untyped.type) { it.turretFireAngleSweep }
            property("TurretSweepSpeedModifier", Untyped.type) { it.turretSweepSpeedModifier }
        },
    )
}
