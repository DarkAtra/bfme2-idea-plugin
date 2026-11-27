package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.UnsignedIntValue
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.Untyped

data class Mouse(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TooltipFontName") val tooltipFontName: Untyped? = null,
    @SageIniName("TooltipFontSize") val tooltipFontSize: Int = 0,
    @SageIniName("TooltipFontIsBold") val tooltipFontIsBold: Boolean = false,
    @SageIniName("TooltipAnimateBackground") val tooltipAnimateBackground: Boolean = false,
    @SageIniName("TooltipFillTime") val tooltipFillTime: Int = 0,
    @SageIniName("TooltipDelayTime") val tooltipDelayTime: Int = 0,
    @SageIniName("TooltipTextColor") val tooltipTextColor: Rgba? = null,
    @SageIniName("TooltipHighlightColor") val tooltipHighlightColor: Rgba? = null,
    @SageIniName("TooltipShadowColor") val tooltipShadowColor: Rgba? = null,
    @SageIniName("TooltipBorderColor") val tooltipBorderColor: Rgba? = null,
    @SageIniName("TooltipBackgroundColor") val tooltipBackgroundColor: Rgba? = null,
    @SageIniName("TooltipWidth") val tooltipWidth: Int = 0,
    @SageIniName("UseTooltipAltTextColor") val useTooltipAltTextColor: Boolean = false,
    @SageIniName("UseTooltipAltBackColor") val useTooltipAltBackColor: Boolean = false,
    @SageIniName("AdjustTooltipAltColor") val adjustTooltipAltColor: Boolean = false,
    @SageIniName("OrthoCamera") val orthoCamera: Boolean = false,
    @SageIniName("OrthoZoom") val orthoZoom: Double = 0.0,
    @SageIniName("DragTolerance") val dragTolerance: UInt = 0u,
    @SageIniName("DragTolerance3D") val dragTolerance3D: UInt = 0u,
    @SageIniName("DragToleranceMS") val dragToleranceMS: UInt = 0u,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Mouse>(
        name = "Mouse",
        tableKey = "mouses",
        properties = {
            property("TooltipFontName", Untyped.type) { it.tooltipFontName }
            property("TooltipFontSize", IntValue) { it.tooltipFontSize }
            property("TooltipFontIsBold", BooleanValue) { it.tooltipFontIsBold }
            property("TooltipAnimateBackground", BooleanValue) { it.tooltipAnimateBackground }
            property("TooltipFillTime", IntValue) { it.tooltipFillTime }
            property("TooltipDelayTime", IntValue) { it.tooltipDelayTime }
            property("TooltipTextColor", Rgba.type) { it.tooltipTextColor }
            property("TooltipHighlightColor", Rgba.type) { it.tooltipHighlightColor }
            property("TooltipShadowColor", Rgba.type) { it.tooltipShadowColor }
            property("TooltipBorderColor", Rgba.type) { it.tooltipBorderColor }
            property("TooltipBackgroundColor", Rgba.type) { it.tooltipBackgroundColor }
            property("TooltipWidth", IntValue) { it.tooltipWidth }
            property("UseTooltipAltTextColor", BooleanValue) { it.useTooltipAltTextColor }
            property("UseTooltipAltBackColor", BooleanValue) { it.useTooltipAltBackColor }
            property("AdjustTooltipAltColor", BooleanValue) { it.adjustTooltipAltColor }
            property("OrthoCamera", BooleanValue) { it.orthoCamera }
            property("OrthoZoom", FloatValue) { it.orthoZoom }
            property("DragTolerance", UnsignedIntValue) { it.dragTolerance }
            property("DragTolerance3D", UnsignedIntValue) { it.dragTolerance3D }
            property("DragToleranceMS", UnsignedIntValue) { it.dragToleranceMS }
        },
    )
}
