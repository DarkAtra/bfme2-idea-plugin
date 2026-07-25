package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.EvaEventBase
import de.darkatra.bfme2.ini.model.`object`.NewEvaEvent
import de.darkatra.bfme2.ini.model.`object`.PredefinedEvaEvent
import de.darkatra.bfme2.ini.model.value.SageReference

data class EvaAnnounceClientCreate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DelayBeforeAnnouncementMS") val delayBeforeAnnouncementMS: Int = 0,
    @SageIniName("OnlyIfVisible") val onlyIfVisible: Boolean = false,
    @SageIniName("CountAsFirstSightedAnnoucement") val countAsFirstSightedAnnoucement: Boolean = false,
    @SageIniName("UseObjectsPosition") val useObjectsPosition: Boolean = false,
    @SageIniName("CreateFakeRadarEvent") val createFakeRadarEvent: Boolean = false,
    @SageIniName("AnnouncementEventEnemy") val announcementEventEnemy: SageReference<EvaEventBase>? = null,
    @SageIniName("AnnouncementEventAlly") val announcementEventAlly: SageReference<EvaEventBase>? = null,
    @SageIniName("AnnouncementEventOwner") val announcementEventOwner: SageReference<EvaEventBase>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<EvaAnnounceClientCreate>(
        name = "EvaAnnounceClientCreate",
        properties = {
            property("DelayBeforeAnnouncementMS", IntValue) { it.delayBeforeAnnouncementMS }
            property("OnlyIfVisible", BooleanValue) { it.onlyIfVisible }
            property("CountAsFirstSightedAnnoucement", BooleanValue) { it.countAsFirstSightedAnnoucement }
            property("UseObjectsPosition", BooleanValue) { it.useObjectsPosition }
            property("CreateFakeRadarEvent", BooleanValue) { it.createFakeRadarEvent }
            property("AnnouncementEventEnemy", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.announcementEventEnemy }
            property("AnnouncementEventAlly", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.announcementEventAlly }
            property("AnnouncementEventOwner", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.announcementEventOwner }
        },
    )
}
