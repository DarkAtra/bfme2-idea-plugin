package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.value.Untyped

data class ButtonSet(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Mode") val mode: Untyped? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ButtonSet>(
        name = "ButtonSet",
        tableKey = "buttonsets",
        properties = {
            property("Mode", Untyped.type) { it.mode }
        },
    )
}
