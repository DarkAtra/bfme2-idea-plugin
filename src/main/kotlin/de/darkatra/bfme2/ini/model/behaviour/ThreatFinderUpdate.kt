package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue

data class ThreatFinderUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DefaultRadius") val defaultRadius: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ThreatFinderUpdate>(
        name = "ThreatFinderUpdate",
        properties = {
            property("DefaultRadius", FloatValue) { it.defaultRadius }
        },
    )
}
