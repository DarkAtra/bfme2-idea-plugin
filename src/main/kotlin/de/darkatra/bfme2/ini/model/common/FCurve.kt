package de.darkatra.bfme2.ini.model.common

import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.FCurveKey
import de.darkatra.bfme2.ini.model.value.Untyped

data class FCurve(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("InPadding") val inPadding: Untyped? = null,
    @SageIniName("OutPadding") val outPadding: Untyped? = null,
    @SageIniName("Key") val key: List<FCurveKey> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<FCurve>(
        name = "FCurve",
        properties = {
            property("InPadding", Untyped.type) { it.inPadding }
            property("OutPadding", Untyped.type) { it.outPadding }
            property("Key", ListValue(FCurveKey.type)) { it.key }
        },
    )
}
