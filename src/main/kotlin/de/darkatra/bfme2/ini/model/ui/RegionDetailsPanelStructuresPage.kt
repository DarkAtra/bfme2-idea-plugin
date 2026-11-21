package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Rgba

data class RegionDetailsPanelStructuresPage(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ProgressOverlayColor") val progressOverlayColor: Rgba? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<RegionDetailsPanelStructuresPage>(
        name = "RegionDetailsPanelStructuresPage",
        properties = {
            property("ProgressOverlayColor", Rgba.type) { it.progressOverlayColor }
        },
    )
}
