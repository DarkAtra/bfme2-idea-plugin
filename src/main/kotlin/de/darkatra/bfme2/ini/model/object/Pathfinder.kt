package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue

data class Pathfinder(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SlopeLimits") val slopeLimits: List<Double> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Pathfinder>(
        name = "Pathfinder",
        tableKey = "pathfinders",
        properties = {
            property("SlopeLimits", ListValue(FloatValue)) { it.slopeLimits }
        },
    )
}
