package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue

data class AutoResolveBody(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("HitpointsAtLevel") val hitpointsAtLevel: Map<String, String> = emptyMap(),
    @SageIniName("LeaveInArmySummary") val leaveInArmySummary: Boolean = false,
    @SageIniName("CanBeAttacked") val canBeAttacked: Boolean = false,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AutoResolveBody>(
        name = "AutoResolveBody",
        tableKey = "autoresolvebodys",
        properties = {
            property("HitpointsAtLevel", MapValue(StringValue, StringValue)) { it.hitpointsAtLevel }
            property("LeaveInArmySummary", BooleanValue) { it.leaveInArmySummary }
            property("CanBeAttacked", BooleanValue) { it.canBeAttacked }
        },
    )
}
