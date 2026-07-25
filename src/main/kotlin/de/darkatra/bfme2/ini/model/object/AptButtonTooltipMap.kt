package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.value.Opaque

data class AptButtonTooltipMap(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ButtonMap") val buttonMap: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AptButtonTooltipMap>(
        name = "AptButtonTooltipMap",
        tableKey = "aptbuttontooltipmaps",
        properties = {
            property("ButtonMap", Opaque.type) { it.buttonMap }
        },
    )
}
