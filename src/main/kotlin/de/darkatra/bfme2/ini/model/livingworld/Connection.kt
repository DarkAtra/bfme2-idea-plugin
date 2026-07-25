package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class Connection(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Region") val region: Untyped? = null,
    @SageIniName("DetourPoint") val detourPoint: List<Untyped> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Connection>(
        name = "Connection",
        properties = {
            property("Region", Untyped.type) { it.region }
            property("DetourPoint", ListValue(Untyped.type)) { it.detourPoint }
        },
    )
}
