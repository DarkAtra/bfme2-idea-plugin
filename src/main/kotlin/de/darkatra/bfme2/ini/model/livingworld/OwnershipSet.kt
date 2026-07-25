package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class OwnershipSet(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Regions") val regions: List<Untyped> = emptyList(),
    @SageIniName("StartRegion") val startRegion: Untyped? = null,
    @SageIniName("SpawnArmies") val spawnArmies: List<SpawnArmies> = emptyList(),
    @SageIniName("SpawnBuildings") val spawnBuildings: List<SpawnBuildings> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<OwnershipSet>(
        name = "OwnershipSet",
        properties = {
            property("Regions", ListValue(Untyped.type)) { it.regions }
            property("StartRegion", Untyped.type) { it.startRegion }
            property("SpawnArmies", ListValue(BlockValue<SpawnArmies> { listOf(SpawnArmies) })) { it.spawnArmies }
            property("SpawnBuildings", ListValue(BlockValue<SpawnBuildings> { listOf(SpawnBuildings) })) { it.spawnBuildings }
        },
    )
}
