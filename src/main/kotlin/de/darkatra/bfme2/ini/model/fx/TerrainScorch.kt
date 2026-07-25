package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Untyped

data class TerrainScorch(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Type") val type: Untyped? = null,
    @SageIniName("Weather") val weather: Untyped? = null,
    @SageIniName("RandomRange") val randomRange: Coords? = null,
    @SageIniName("Radius") val radius: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<TerrainScorch>(
        name = "TerrainScorch",
        properties = {
            property("Type", Untyped.type) { it.type }
            property("Weather", Untyped.type) { it.weather }
            property("RandomRange", Coords.type) { it.randomRange }
            property("Radius", FloatValue) { it.radius }
        },
    )
}
