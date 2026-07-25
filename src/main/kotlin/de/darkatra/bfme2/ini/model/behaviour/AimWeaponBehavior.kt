package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue

data class AimWeaponBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AimLowThreshold") val aimLowThreshold: Double = 0.0,
    @SageIniName("AimHighThreshold") val aimHighThreshold: Double = 0.0,
    @SageIniName("AimNearDistance") val aimNearDistance: Double = 0.0,
    @SageIniName("AimFarDistance") val aimFarDistance: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<AimWeaponBehavior>(
        name = "AimWeaponBehavior",
        properties = {
            property("AimLowThreshold", FloatValue) { it.aimLowThreshold }
            property("AimHighThreshold", FloatValue) { it.aimHighThreshold }
            property("AimNearDistance", FloatValue) { it.aimNearDistance }
            property("AimFarDistance", FloatValue) { it.aimFarDistance }
        },
    )
}
