package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class RegionDisplay(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BuildPlotsTitle") val buildPlotsTitle: String = "",
    @SageIniName("BuildPlotsHelp") val buildPlotsHelp: String = "",
    @SageIniName("ArmoryPointsTitle") val armoryPointsTitle: String = "",
    @SageIniName("ArmoryPointsHelp") val armoryPointsHelp: String = "",
    @SageIniName("CommandPointsTitle") val commandPointsTitle: String = "",
    @SageIniName("CommandPointsHelp") val commandPointsHelp: String = "",
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<RegionDisplay>(
        name = "RegionDisplay",
        properties = {
            property("BuildPlotsTitle", StringValue) { it.buildPlotsTitle }
            property("BuildPlotsHelp", StringValue) { it.buildPlotsHelp }
            property("ArmoryPointsTitle", StringValue) { it.armoryPointsTitle }
            property("ArmoryPointsHelp", StringValue) { it.armoryPointsHelp }
            property("CommandPointsTitle", StringValue) { it.commandPointsTitle }
            property("CommandPointsHelp", StringValue) { it.commandPointsHelp }
        },
    )
}
