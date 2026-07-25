package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.livingworld.Mission
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference

data class LinearCampaign(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("CampaignDisplayNameLabel") val campaignDisplayNameLabel: String = "",
    @SageIniName("CarryoverUnit") val carryoverUnit: SageReference<Object>? = null,
    @SageIniName("OverallCampaignIntroMovie") val overallCampaignIntroMovie: Opaque? = null,
    @SageIniName("Mission") val mission: List<Mission> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LinearCampaign>(
        name = "LinearCampaign",
        tableKey = "linearcampaigns",
        properties = {
            property("CampaignDisplayNameLabel", StringValue) { it.campaignDisplayNameLabel }
            property("CarryoverUnit", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.carryoverUnit }
            property("OverallCampaignIntroMovie", Opaque.type) { it.overallCampaignIntroMovie }
            property("Mission", ListValue(BlockValue<Mission> { listOf(Mission) })) { it.mission }
        },
    )
}
