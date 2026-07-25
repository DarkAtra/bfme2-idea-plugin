package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue

data class FireLogicSystem(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MaxCellsBurning") val maxCellsBurning: Int = 0,
    @SageIniName("TerrainCellType") val terrainCellType: List<TerrainCellType> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<FireLogicSystem>(
        name = "FireLogicSystem",
        tableKey = "firelogicsystems",
        properties = {
            property("MaxCellsBurning", IntValue) { it.maxCellsBurning }
            property("TerrainCellType", ListValue(BlockValue<TerrainCellType> { listOf(TerrainCellType) })) { it.terrainCellType }
        },
    )
}
