package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue

data class MissionObjectiveList(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MissionObjectiveTag") val missionObjectiveTag: List<String> = emptyList(),
    @SageIniName("BonusMissionObjectiveTag") val bonusMissionObjectiveTag: List<String> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<MissionObjectiveList>(
        name = "MissionObjectiveList",
        fileName = "map.ini",
        properties = {
            property("MissionObjectiveTag", ListValue(StringValue)) { it.missionObjectiveTag }
            property("BonusMissionObjectiveTag", ListValue(StringValue)) { it.bonusMissionObjectiveTag }
        },
    )
}
