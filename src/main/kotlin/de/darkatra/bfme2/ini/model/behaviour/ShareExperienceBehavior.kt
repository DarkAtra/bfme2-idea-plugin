package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.value.SageFilter

data class ShareExperienceBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("DropOff") val dropOff: Double = 0.0,
    @SageIniName("Percentage") val percentage: Double = 0.0,
    @SageIniName("Float") val float: Double = 0.0,
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ShareExperienceBehavior>(
        name = "ShareExperienceBehavior",
        properties = {
            property("Radius", FloatValue) { it.radius }
            property("DropOff", FloatValue) { it.dropOff }
            property("Percentage", FloatValue) { it.percentage }
            property("Float", FloatValue) { it.float }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
        },
    )
}
