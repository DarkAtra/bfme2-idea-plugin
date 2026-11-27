package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Coord2DInt
import de.darkatra.bfme2.ini.model.value.Rgba

data class LinePart(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StartPosition") val startPosition: Coord2DInt? = null,
    @SageIniName("EndPosition") val endPosition: Coord2DInt? = null,
    @SageIniName("Color") val color: Rgba? = null,
    @SageIniName("Width") val width: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<LinePart>(
        name = "LinePart",
        properties = {
            property("StartPosition", Coord2DInt.type) { it.startPosition }
            property("EndPosition", Coord2DInt.type) { it.endPosition }
            property("Color", Rgba.type) { it.color }
            property("Width", IntValue) { it.width }
        },
    )
}
