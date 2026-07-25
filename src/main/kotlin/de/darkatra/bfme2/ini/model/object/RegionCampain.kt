package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.livingworld.Region
import de.darkatra.bfme2.ini.model.value.Opaque

data class RegionCampain(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RegionObject") val regionObject: Opaque? = null,
    @SageIniName("Region") val region: List<Region> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<RegionCampain>(
        name = "RegionCampain",
        tableKey = "regioncampains",
        properties = {
            property("RegionObject", Opaque.type) { it.regionObject }
            property("Region", ListValue(BlockValue<Region> { listOf(Region) })) { it.region }
        },
    )
}
