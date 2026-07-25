package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class DeliverPayload(
    val header: SageBlockHeader = SageBlockHeader(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<DeliverPayload>(
        name = "DeliverPayload",
    )
}
