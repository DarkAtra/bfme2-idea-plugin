package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Untyped

data class RunOffMapBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RunToLocation") val runToLocation: Coords? = null,
    @SageIniName("RequiresSpecificTrigger") val requiresSpecificTrigger: Boolean = false,
    @SageIniName("RunOffMapWaypointName") val runOffMapWaypointName: Untyped? = null,
    @SageIniName("DieOnMap") val dieOnMap: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<RunOffMapBehavior>(
        name = "RunOffMapBehavior",
        properties = {
            property("RunToLocation", Coords.type) { it.runToLocation }
            property("RequiresSpecificTrigger", BooleanValue) { it.requiresSpecificTrigger }
            property("RunOffMapWaypointName", Untyped.type) { it.runOffMapWaypointName }
            property("DieOnMap", BooleanValue) { it.dieOnMap }
        },
    )
}
