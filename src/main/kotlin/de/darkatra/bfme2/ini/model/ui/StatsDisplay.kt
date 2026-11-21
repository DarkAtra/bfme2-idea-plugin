package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class StatsDisplay(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("CommandPointsRowTitle") val commandPointsRowTitle: String = "",
    @SageIniName("CommandPointsRowHelp") val commandPointsRowHelp: String = "",
    @SageIniName("AttackBonusRowTitle") val attackBonusRowTitle: String = "",
    @SageIniName("AttackBonusRowHelp") val attackBonusRowHelp: String = "",
    @SageIniName("DefenseBonusRowTitle") val defenseBonusRowTitle: String = "",
    @SageIniName("DefenseBonusRowHelp") val defenseBonusRowHelp: String = "",
    @SageIniName("ExperienceBonusRowTitle") val experienceBonusRowTitle: String = "",
    @SageIniName("ExperienceBonusRowHelp") val experienceBonusRowHelp: String = "",
    @SageIniName("ResourceMultiplierRowTitle") val resourceMultiplierRowTitle: String = "",
    @SageIniName("ResourceMultiplierRowHelp") val resourceMultiplierRowHelp: String = "",
    @SageIniName("PowerPointsRowTitle") val powerPointsRowTitle: String = "",
    @SageIniName("PowerPointsRowHelp") val powerPointsRowHelp: String = "",
    @SageIniName("TreasuryIncomeRowTitle") val treasuryIncomeRowTitle: String = "",
    @SageIniName("TreasuryIncomeRowHelp") val treasuryIncomeRowHelp: String = "",
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<StatsDisplay>(
        name = "StatsDisplay",
        properties = {
            property("CommandPointsRowTitle", StringValue) { it.commandPointsRowTitle }
            property("CommandPointsRowHelp", StringValue) { it.commandPointsRowHelp }
            property("AttackBonusRowTitle", StringValue) { it.attackBonusRowTitle }
            property("AttackBonusRowHelp", StringValue) { it.attackBonusRowHelp }
            property("DefenseBonusRowTitle", StringValue) { it.defenseBonusRowTitle }
            property("DefenseBonusRowHelp", StringValue) { it.defenseBonusRowHelp }
            property("ExperienceBonusRowTitle", StringValue) { it.experienceBonusRowTitle }
            property("ExperienceBonusRowHelp", StringValue) { it.experienceBonusRowHelp }
            property("ResourceMultiplierRowTitle", StringValue) { it.resourceMultiplierRowTitle }
            property("ResourceMultiplierRowHelp", StringValue) { it.resourceMultiplierRowHelp }
            property("PowerPointsRowTitle", StringValue) { it.powerPointsRowTitle }
            property("PowerPointsRowHelp", StringValue) { it.powerPointsRowHelp }
            property("TreasuryIncomeRowTitle", StringValue) { it.treasuryIncomeRowTitle }
            property("TreasuryIncomeRowHelp", StringValue) { it.treasuryIncomeRowHelp }
        },
    )
}
