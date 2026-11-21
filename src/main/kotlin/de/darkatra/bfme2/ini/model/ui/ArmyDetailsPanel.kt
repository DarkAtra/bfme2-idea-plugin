package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class ArmyDetailsPanel(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BackButtonTooltip") val backButtonTooltip: String = "",
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ArmyDetailsPanel>(
        name = "ArmyDetailsPanel",
        properties = {
            property("BackButtonTooltip", StringValue) { it.backButtonTooltip }
        },
    )
}
