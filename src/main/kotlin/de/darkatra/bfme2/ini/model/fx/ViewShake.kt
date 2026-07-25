package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.SageFilter

data class ViewShake(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Type") val type: String = "",
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ViewShake>(
        name = "ViewShake",
        properties = {
            property("Type", StringValue) { it.type }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
        },
    )
}
