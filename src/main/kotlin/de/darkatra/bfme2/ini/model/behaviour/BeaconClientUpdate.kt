package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class BeaconClientUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RadarPulseFrequency") val radarPulseFrequency: Int = 0,
    @SageIniName("RadarPulseDuration") val radarPulseDuration: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<BeaconClientUpdate>(
        name = "BeaconClientUpdate",
        properties = {
            property("RadarPulseFrequency", IntValue) { it.radarPulseFrequency }
            property("RadarPulseDuration", IntValue) { it.radarPulseDuration }
        },
    )
}
