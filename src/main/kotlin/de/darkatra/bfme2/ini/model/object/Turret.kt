package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
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
        },
    )
}
