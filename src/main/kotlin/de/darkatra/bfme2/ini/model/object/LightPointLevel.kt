package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.Opaque

data class LightPointLevel(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Name") val name: String = "",
    @SageIniName("SpecialAbilities") val specialAbilities: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LightPointLevel>(
        name = "LightPointLevel",
        tableKey = "lightpointlevels",
        properties = {
            property("Name", StringValue) { it.name }
            property("SpecialAbilities", Opaque.type) { it.specialAbilities }
        },
    )
}
