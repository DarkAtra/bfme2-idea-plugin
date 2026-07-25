package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class SideInfo(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ResourceGatherersEasy") val resourceGatherersEasy: Int = 0,
    @SageIniName("ResourceGatherersNormal") val resourceGatherersNormal: Int = 0,
    @SageIniName("ResourceGatherersHard") val resourceGatherersHard: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<SideInfo>(
        name = "SideInfo",
        properties = {
            property("ResourceGatherersEasy", IntValue) { it.resourceGatherersEasy }
            property("ResourceGatherersNormal", IntValue) { it.resourceGatherersNormal }
            property("ResourceGatherersHard", IntValue) { it.resourceGatherersHard }
        },
    )
}
