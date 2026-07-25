package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.Untyped

data class Credits(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ScrollRate") val scrollRate: Int = 0,
    @SageIniName("ScrollRateEveryFrames") val scrollRateEveryFrames: Int = 0,
    @SageIniName("ScrollDown") val scrollDown: Boolean = false,
    @SageIniName("TitleColor") val titleColor: Rgba? = null,
    @SageIniName("MinorTitleColor") val minorTitleColor: Rgba? = null,
    @SageIniName("NormalColor") val normalColor: Rgba? = null,
    @SageIniName("Style") val style: List<Untyped> = emptyList(),
    @SageIniName("Text") val text: List<Untyped> = emptyList(),
    @SageIniName("Blank") val blank: List<Opaque> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Credits>(
        name = "Credits",
        tableKey = "credits",
        properties = {
            property("ScrollRate", IntValue) { it.scrollRate }
            property("ScrollRateEveryFrames", IntValue) { it.scrollRateEveryFrames }
            property("ScrollDown", BooleanValue) { it.scrollDown }
            property("TitleColor", Rgba.type) { it.titleColor }
            property("MinorTitleColor", Rgba.type) { it.minorTitleColor }
            property("NormalColor", Rgba.type) { it.normalColor }
            property("Style", ListValue(Untyped.type)) { it.style }
            property("Text", ListValue(Untyped.type)) { it.text }
            property("Blank", ListValue(Opaque.type)) { it.blank }
        },
    )
}
