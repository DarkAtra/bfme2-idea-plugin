package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class RadarUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RadarExtendTime") val radarExtendTime: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<RadarUpdate>(
        name = "RadarUpdate",
        properties = {
            property("RadarExtendTime", IntValue) { it.radarExtendTime }
        },
    )
}
