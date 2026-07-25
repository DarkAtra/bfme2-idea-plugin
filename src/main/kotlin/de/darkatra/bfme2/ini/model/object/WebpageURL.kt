package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.value.Opaque

data class WebpageURL(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("URL") val uRL: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<WebpageURL>(
        name = "WebpageURL",
        tableKey = "webpageurls",
        properties = {
            property("URL", Opaque.type) { it.uRL }
        },
    )
}
