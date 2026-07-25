package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class Trigger(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StatName") val statName: Untyped? = null,
    @SageIniName("Stat") val stat: String = "",
    @SageIniName("Threshold") val threshold: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Trigger>(
        name = "Trigger",
        properties = {
            property("StatName", Untyped.type) { it.statName }
            property("Stat", StringValue) { it.stat }
            property("Threshold", IntValue) { it.threshold }
        },
    )
}
