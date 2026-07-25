package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter

data class ScoredKillEvaAnnouncer(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("EvaEvent") val evaEvent: Opaque? = null,
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("CountOnlyKillsByLocalPlayer") val countOnlyKillsByLocalPlayer: Boolean = false,
    @SageIniName("CountOnlyKillsAgainstLocalPlayer") val countOnlyKillsAgainstLocalPlayer: Boolean = false,
    @SageIniName("MinimumCountForAnnouncement") val minimumCountForAnnouncement: Int = 0,
    @SageIniName("MaximumTimeForAnnouncementMS") val maximumTimeForAnnouncementMS: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ScoredKillEvaAnnouncer>(
        name = "ScoredKillEvaAnnouncer",
        tableKey = "scoredkillevaannouncers",
        properties = {
            property("EvaEvent", Opaque.type) { it.evaEvent }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("CountOnlyKillsByLocalPlayer", BooleanValue) { it.countOnlyKillsByLocalPlayer }
            property("CountOnlyKillsAgainstLocalPlayer", BooleanValue) { it.countOnlyKillsAgainstLocalPlayer }
            property("MinimumCountForAnnouncement", IntValue) { it.minimumCountForAnnouncement }
            property("MaximumTimeForAnnouncementMS", IntValue) { it.maximumTimeForAnnouncementMS }
        },
    )
}
