package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.UnsignedIntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Rgb
import de.darkatra.bfme2.ini.model.value.Untyped

data class TerrainCellType(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Name") val name: Untyped? = null,
    @SageIniName("Color") val color: Rgb? = null,
    @SageIniName("Fuel") val fuel: UInt = 0u,
    @SageIniName("MaxBurnRate") val maxBurnRate: UInt = 0u,
    @SageIniName("Decay") val decay: UInt = 0u,
    @SageIniName("Resistance") val resistance: UInt = 0u,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<TerrainCellType>(
        name = "TerrainCellType",
        properties = {
            property("Name", Untyped.type) { it.name }
            property("Color", Rgb.type) { it.color }
            property("Fuel", UnsignedIntValue) { it.fuel }
            property("MaxBurnRate", UnsignedIntValue) { it.maxBurnRate }
            property("Decay", UnsignedIntValue) { it.decay }
            property("Resistance", UnsignedIntValue) { it.resistance }
        },
    )
}
