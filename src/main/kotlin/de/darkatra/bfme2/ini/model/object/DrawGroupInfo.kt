package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.Untyped

data class DrawGroupInfo(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("UsePlayerColor") val usePlayerColor: Boolean = false,
    @SageIniName("ColorForText") val colorForText: Rgba? = null,
    @SageIniName("ColorForTextDropShadow") val colorForTextDropShadow: Rgba? = null,
    @SageIniName("DropShadowOffsetX") val dropShadowOffsetX: Int = 0,
    @SageIniName("DropShadowOffsetY") val dropShadowOffsetY: Int = 0,
    @SageIniName("FontName") val fontName: Untyped? = null,
    @SageIniName("FontSize") val fontSize: Int = 0,
    @SageIniName("FontIsBold") val fontIsBold: Boolean = false,
    @SageIniName("DrawPositionXPercent") val drawPositionXPercent: Double = 0.0,
    @SageIniName("DrawPositionYPixel") val drawPositionYPixel: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<DrawGroupInfo>(
        name = "DrawGroupInfo",
        tableKey = "drawgroupinfos",
        properties = {
            property("UsePlayerColor", BooleanValue) { it.usePlayerColor }
            property("ColorForText", Rgba.type) { it.colorForText }
            property("ColorForTextDropShadow", Rgba.type) { it.colorForTextDropShadow }
            property("DropShadowOffsetX", IntValue) { it.dropShadowOffsetX }
            property("DropShadowOffsetY", IntValue) { it.dropShadowOffsetY }
            property("FontName", Untyped.type) { it.fontName }
            property("FontSize", IntValue) { it.fontSize }
            property("FontIsBold", BooleanValue) { it.fontIsBold }
            property("DrawPositionXPercent", FloatValue) { it.drawPositionXPercent }
            property("DrawPositionYPixel", IntValue) { it.drawPositionYPixel }
        },
    )
}
