package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgba

data class GridDecalTemplate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") val texture: Opaque? = null,
    @SageIniName("Style") val style: Opaque? = null,
    @SageIniName("OpacityMin") val opacityMin: Double = 0.0,
    @SageIniName("OpacityMax") val opacityMax: Double = 0.0,
    @SageIniName("OpacityThrobTime") val opacityThrobTime: Int = 0,
    @SageIniName("Color") val color: Rgba? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<GridDecalTemplate>(
        name = "GridDecalTemplate",
        properties = {
            property("Texture", Opaque.type) { it.texture }
            property("Style", Opaque.type) { it.style }
            property("OpacityMin", FloatValue) { it.opacityMin }
            property("OpacityMax", FloatValue) { it.opacityMax }
            property("OpacityThrobTime", IntValue) { it.opacityThrobTime }
            property("Color", Rgba.type) { it.color }
        },
    )
}
