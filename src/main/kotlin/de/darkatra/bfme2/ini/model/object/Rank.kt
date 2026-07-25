package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.Opaque

data class Rank(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SkillPointsNeededDefault") val skillPointsNeededDefault: Int = 0,
    @SageIniName("SkillPointsNeededCampaign") val skillPointsNeededCampaign: Int = 0,
    @SageIniName("SciencePurchasePointsGranted") val sciencePurchasePointsGranted: Int = 0,
    @SageIniName("RankName") val rankName: String = "",
    @SageIniName("SciencesGranted") val sciencesGranted: Opaque? = null,
    @SageIniName("SkillPointsNeeded") val skillPointsNeeded: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Rank>(
        name = "Rank",
        tableKey = "ranks",
        properties = {
            property("SkillPointsNeededDefault", IntValue) { it.skillPointsNeededDefault }
            property("SkillPointsNeededCampaign", IntValue) { it.skillPointsNeededCampaign }
            property("SciencePurchasePointsGranted", IntValue) { it.sciencePurchasePointsGranted }
            property("RankName", StringValue) { it.rankName }
            property("SciencesGranted", Opaque.type) { it.sciencesGranted }
            property("SkillPointsNeeded", IntValue) { it.skillPointsNeeded }
        },
    )
}
