package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class DualWeaponBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SwitchWeaponOnCloseRangeDistance") val switchWeaponOnCloseRangeDistance: Double = 0.0,
    @SageIniName("UseCloseRangeWhileMounted") val useCloseRangeWhileMounted: Boolean = false,
    @SageIniName("MinimumSwitchTime") val minimumSwitchTime: Int = 0,
    @SageIniName("UseHordeRangeWeapon") val useHordeRangeWeapon: Boolean = false,
    @SageIniName("UseRealVictimRange") val useRealVictimRange: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<DualWeaponBehavior>(
        name = "DualWeaponBehavior",
        properties = {
            property("SwitchWeaponOnCloseRangeDistance", FloatValue) { it.switchWeaponOnCloseRangeDistance }
            property("UseCloseRangeWhileMounted", BooleanValue) { it.useCloseRangeWhileMounted }
            property("MinimumSwitchTime", IntValue) { it.minimumSwitchTime }
            property("UseHordeRangeWeapon", BooleanValue) { it.useHordeRangeWeapon }
            property("UseRealVictimRange", BooleanValue) { it.useRealVictimRange }
        },
    )
}
