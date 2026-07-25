package de.darkatra.bfme2.ini.model.particle

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class Color(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Color1") val color1: Untyped? = null,
    @SageIniName("Color2") val color2: Untyped? = null,
    @SageIniName("Color3") val color3: Untyped? = null,
    @SageIniName("Color4") val color4: Untyped? = null,
    @SageIniName("Color5") val color5: Untyped? = null,
    @SageIniName("Color6") val color6: Untyped? = null,
    @SageIniName("Color7") val color7: Untyped? = null,
    @SageIniName("Color8") val color8: Untyped? = null,
    @SageIniName("ColorScale") val colorScale: List<Double> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Color>(
        name = "Color",
        keyedByLabel = true,
        properties = {
            property("Color1", Untyped.type) { it.color1 }
            property("Color2", Untyped.type) { it.color2 }
            property("Color3", Untyped.type) { it.color3 }
            property("Color4", Untyped.type) { it.color4 }
            property("Color5", Untyped.type) { it.color5 }
            property("Color6", Untyped.type) { it.color6 }
            property("Color7", Untyped.type) { it.color7 }
            property("Color8", Untyped.type) { it.color8 }
            property("ColorScale", ListValue(FloatValue)) { it.colorScale }
        },
    )
}
