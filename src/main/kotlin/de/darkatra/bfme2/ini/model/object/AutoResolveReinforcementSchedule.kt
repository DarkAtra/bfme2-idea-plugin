package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniNumberedSlots
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class AutoResolveReinforcementSchedule(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("EachRemaining") val eachRemaining: Double = 0.0,
    val slots: Map<Int, Int> = emptyMap(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AutoResolveReinforcementSchedule>(
        name = "AutoResolveReinforcementSchedule",
        tableKey = "autoresolvereinforcementschedules",
        numberedSlots = SageIniNumberedSlots(IntValue) { it.slots },
        properties = {
            property("EachRemaining", FloatValue) { it.eachRemaining }
        },
    )
}
