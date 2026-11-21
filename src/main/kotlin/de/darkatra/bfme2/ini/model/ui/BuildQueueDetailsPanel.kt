package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Rgba

data class BuildQueueDetailsPanel(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BackButtonTooltip") val backButtonTooltip: String = "",
    @SageIniName("ProgressOverlayColor") val progressOverlayColor: Rgba? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<BuildQueueDetailsPanel>(
        name = "BuildQueueDetailsPanel",
        properties = {
            property("BackButtonTooltip", StringValue) { it.backButtonTooltip }
            property("ProgressOverlayColor", Rgba.type) { it.progressOverlayColor }
        },
    )
}
