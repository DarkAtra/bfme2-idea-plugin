package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.Untyped

data class Checklist(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ItemFont") val itemFont: Untyped? = null,
    @SageIniName("ItemNormalColor") val itemNormalColor: Rgba? = null,
    @SageIniName("ItemImportantColor") val itemImportantColor: Rgba? = null,
    @SageIniName("ItemNewColor") val itemNewColor: Rgba? = null,
    @SageIniName("ItemVerticalSpacing") val itemVerticalSpacing: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Checklist>(
        name = "Checklist",
        properties = {
            property("ItemFont", Untyped.type) { it.itemFont }
            property("ItemNormalColor", Rgba.type) { it.itemNormalColor }
            property("ItemImportantColor", Rgba.type) { it.itemImportantColor }
            property("ItemNewColor", Rgba.type) { it.itemNewColor }
            property("ItemVerticalSpacing", FloatValue) { it.itemVerticalSpacing }
        },
    )
}
