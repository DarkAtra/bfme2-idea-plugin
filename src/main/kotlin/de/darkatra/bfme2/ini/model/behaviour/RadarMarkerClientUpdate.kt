package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.Untyped

data class RadarMarkerClientUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MarkerType") val markerType: Untyped? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<RadarMarkerClientUpdate>(
        name = "RadarMarkerClientUpdate",
        properties = {
            property("MarkerType", Untyped.type) { it.markerType }
        },
    )
}
