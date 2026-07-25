package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class ShadowMap(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MapSize") val mapSize: Int = 0,
    @SageIniName("MaxViewDistance") val maxViewDistance: Double = 0.0,
    @SageIniName("MinShadowedTerrainHeight") val minShadowedTerrainHeight: Double = 0.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ShadowMap>(
        name = "ShadowMap",
        tableKey = "shadowmaps",
        properties = {
            property("MapSize", IntValue) { it.mapSize }
            property("MaxViewDistance", FloatValue) { it.maxViewDistance }
            property("MinShadowedTerrainHeight", FloatValue) { it.minShadowedTerrainHeight }
        },
    )
}
