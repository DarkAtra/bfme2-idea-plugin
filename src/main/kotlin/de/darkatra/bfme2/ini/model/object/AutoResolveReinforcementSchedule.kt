package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue

data class AutoResolveReinforcementSchedule(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("EachRemaining") val eachRemaining: Double = 0.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AutoResolveReinforcementSchedule>(
        name = "AutoResolveReinforcementSchedule",
        tableKey = "autoresolvereinforcementschedules",
        properties = {
            property("EachRemaining", FloatValue) { it.eachRemaining }
        },
    )
}
