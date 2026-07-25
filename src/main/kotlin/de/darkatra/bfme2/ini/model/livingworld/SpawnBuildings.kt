package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Untyped

data class SpawnBuildings(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Player") val player: Untyped? = null,
    @SageIniName("Building") val building: List<Untyped> = emptyList(),
    @SageIniName("Region") val region: Opaque? = null,
    @SageIniName("Buildings") val buildings: List<Opaque> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<SpawnBuildings>(
        name = "SpawnBuildings",
        properties = {
            property("Player", Untyped.type) { it.player }
            property("Building", ListValue(Untyped.type)) { it.building }
            property("Region", Opaque.type) { it.region }
            property("Buildings", ListValue(Opaque.type)) { it.buildings }
        },
    )
}
