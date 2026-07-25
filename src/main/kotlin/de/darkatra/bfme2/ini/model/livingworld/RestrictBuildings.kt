package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class RestrictBuildings(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Buildings") val buildings: Untyped? = null,
    @SageIniName("NumberAllowed") val numberAllowed: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<RestrictBuildings>(
        name = "RestrictBuildings",
        properties = {
            property("Buildings", Untyped.type) { it.buildings }
            property("NumberAllowed", IntValue) { it.numberAllowed }
        },
    )
}
