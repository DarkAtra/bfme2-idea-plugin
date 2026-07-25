package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.Untyped

data class MultiplayerColor(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RGBColor") val rGBColor: Rgba? = null,
    @SageIniName("RGBNightColor") val rGBNightColor: Rgba? = null,
    @SageIniName("LivingWorldColor") val livingWorldColor: Rgba? = null,
    @SageIniName("LivingWorldBannerColor") val livingWorldBannerColor: Rgba? = null,
    @SageIniName("TooltipName") val tooltipName: Untyped? = null,
    @SageIniName("AvailableInWotR") val availableInWotR: Boolean = false,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<MultiplayerColor>(
        name = "MultiplayerColor",
        tableKey = "multiplayercolors",
        properties = {
            property("RGBColor", Rgba.type) { it.rGBColor }
            property("RGBNightColor", Rgba.type) { it.rGBNightColor }
            property("LivingWorldColor", Rgba.type) { it.livingWorldColor }
            property("LivingWorldBannerColor", Rgba.type) { it.livingWorldBannerColor }
            property("TooltipName", Untyped.type) { it.tooltipName }
            property("AvailableInWotR", BooleanValue) { it.availableInWotR }
        },
    )
}
