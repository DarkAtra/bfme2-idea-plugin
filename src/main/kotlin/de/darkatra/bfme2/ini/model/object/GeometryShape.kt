package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.GeometryType
import de.darkatra.bfme2.ini.model.value.Opaque

data class GeometryShape(
    val header: SageBlockHeader = SageBlockHeader(),
    val type: GeometryType? = null,
    @SageIniName("GeometryName") val geometryName: Opaque? = null,
    @SageIniName("GeometryMajorRadius") val geometryMajorRadius: Double = 0.0,
    @SageIniName("GeometryMinorRadius") val geometryMinorRadius: Double = 0.0,
    @SageIniName("GeometryHeight") val geometryHeight: Double = 0.0,
    @SageIniName("GeometryFrontAngle") val geometryFrontAngle: Double = 0.0,
    @SageIniName("GeometryActive") val geometryActive: Boolean = false,
    @SageIniName("GeometryIsSmall") val geometryIsSmall: Boolean = false,
    @SageIniName("GeometryOffset") val geometryOffset: Coords? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<GeometryShape>(
        name = "GeometryShape",
        properties = {
            property("GeometryName", Opaque.type) { it.geometryName }
            property("GeometryMajorRadius", FloatValue) { it.geometryMajorRadius }
            property("GeometryMinorRadius", FloatValue) { it.geometryMinorRadius }
            property("GeometryHeight", FloatValue) { it.geometryHeight }
            property("GeometryFrontAngle", FloatValue) { it.geometryFrontAngle }
            property("GeometryActive", BooleanValue) { it.geometryActive }
            property("GeometryIsSmall", BooleanValue) { it.geometryIsSmall }
            property("GeometryOffset", Coords.type) { it.geometryOffset }
        },
    )
}
