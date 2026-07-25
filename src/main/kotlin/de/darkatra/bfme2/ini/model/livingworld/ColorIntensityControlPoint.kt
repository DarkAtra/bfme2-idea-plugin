package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Rgb
import de.darkatra.bfme2.ini.model.value.Untyped

data class ColorIntensityControlPoint(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Value") val value: Untyped? = null,
    @SageIniName("Color") val color: Rgb? = null,
    @SageIniName("Intensity") val intensity: Double = 0.0,
    @SageIniName("Time") val time: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ColorIntensityControlPoint>(
        name = "ColorIntensityControlPoint",
        properties = {
            property("Value", Untyped.type) { it.value }
            property("Color", Rgb.type) { it.color }
            property("Intensity", FloatValue) { it.intensity }
            property("Time", FloatValue) { it.time }
        },
    )
}
