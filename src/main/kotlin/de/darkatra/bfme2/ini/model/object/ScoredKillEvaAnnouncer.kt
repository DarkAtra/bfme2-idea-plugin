package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.UnsignedIntValue
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class ScoredKillEvaAnnouncer(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("EvaEvent") val evaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("CountOnlyKillsByLocalPlayer") val countOnlyKillsByLocalPlayer: Boolean = false,
    @SageIniName("CountOnlyKillsAgainstLocalPlayer") val countOnlyKillsAgainstLocalPlayer: Boolean = false,
    @SageIniName("MinimumCountForAnnouncement") val minimumCountForAnnouncement: UInt = 0u,
    @SageIniName("MaximumTimeForAnnouncementMS") val maximumTimeForAnnouncementMS: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ScoredKillEvaAnnouncer>(
        name = "ScoredKillEvaAnnouncer",
        tableKey = "scoredkillevaannouncers",
        properties = {
            property("EvaEvent", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.evaEvent }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("CountOnlyKillsByLocalPlayer", BooleanValue) { it.countOnlyKillsByLocalPlayer }
            property("CountOnlyKillsAgainstLocalPlayer", BooleanValue) { it.countOnlyKillsAgainstLocalPlayer }
            property("MinimumCountForAnnouncement", UnsignedIntValue) { it.minimumCountForAnnouncement }
            property("MaximumTimeForAnnouncementMS", IntValue) { it.maximumTimeForAnnouncementMS }
        },
    )
}
