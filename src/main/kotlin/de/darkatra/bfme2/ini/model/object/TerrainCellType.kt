package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Rgb
import de.darkatra.bfme2.ini.model.value.Untyped

data class TerrainCellType(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Name") val name: Untyped? = null,
    @SageIniName("Color") val color: Rgb? = null,
    @SageIniName("Fuel") val fuel: Int = 0,
    @SageIniName("MaxBurnRate") val maxBurnRate: Int = 0,
    @SageIniName("Decay") val decay: Int = 0,
    @SageIniName("Resistance") val resistance: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<TerrainCellType>(
        name = "TerrainCellType",
        properties = {
            property("Name", Untyped.type) { it.name }
            property("Color", Rgb.type) { it.color }
            property("Fuel", IntValue) { it.fuel }
            property("MaxBurnRate", IntValue) { it.maxBurnRate }
            property("Decay", IntValue) { it.decay }
            property("Resistance", IntValue) { it.resistance }
        },
    )
}
