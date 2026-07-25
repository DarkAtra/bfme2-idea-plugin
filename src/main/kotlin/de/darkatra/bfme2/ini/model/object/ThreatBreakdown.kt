package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class ThreatBreakdown(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AIKindOf") val aIKindOf: Untyped? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ThreatBreakdown>(
        name = "ThreatBreakdown",
        keyedByLabel = true,
        equalsIsSpurious = true,
        properties = {
            property("AIKindOf", Untyped.type) { it.aIKindOf }
        },
    )
}
