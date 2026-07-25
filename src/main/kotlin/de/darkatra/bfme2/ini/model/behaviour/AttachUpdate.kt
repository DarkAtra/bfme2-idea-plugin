package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.EvaEventBase
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.NewEvaEvent
import de.darkatra.bfme2.ini.model.`object`.PredefinedEvaEvent
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class AttachUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("ScanRange") val scanRange: Double = 0.0,
    @SageIniName("ParentStatus") val parentStatus: ObjectStatus? = null,
    @SageIniName("ParentOwnerAttachmentEvaEvent") val parentOwnerAttachmentEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("ParentEnemyAttachmentEvaEvent") val parentEnemyAttachmentEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("ParentOwnerDiedEvaEvent") val parentOwnerDiedEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("AlwaysTeleport") val alwaysTeleport: Boolean = false,
    @SageIniName("AnchorToTopOfGeometry") val anchorToTopOfGeometry: Boolean = false,
    @SageIniName("ParentAllyAttachmentEvaEvent") val parentAllyAttachmentEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("AttachFX") val attachFX: SageReference<FXList>? = null,
    @SageIniName("ParentAllyDiedEvaEvent") val parentAllyDiedEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("ParentEnemyDiedtEvaEvent") val parentEnemyDiedtEvaEvent: SageReference<EvaEventBase>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<AttachUpdate>(
        name = "AttachUpdate",
        properties = {
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("ScanRange", FloatValue) { it.scanRange }
            property("ParentStatus", ObjectStatus.type) { it.parentStatus }
            property(
                "ParentOwnerAttachmentEvaEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.parentOwnerAttachmentEvaEvent }
            property(
                "ParentEnemyAttachmentEvaEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.parentEnemyAttachmentEvaEvent }
            property("ParentOwnerDiedEvaEvent", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.parentOwnerDiedEvaEvent }
            property("AlwaysTeleport", BooleanValue) { it.alwaysTeleport }
            property("AnchorToTopOfGeometry", BooleanValue) { it.anchorToTopOfGeometry }
            property(
                "ParentAllyAttachmentEvaEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.parentAllyAttachmentEvaEvent }
            property("AttachFX", ReferenceValue<FXList> { listOf(FXList) }) { it.attachFX }
            property("ParentAllyDiedEvaEvent", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.parentAllyDiedEvaEvent }
            property("ParentEnemyDiedtEvaEvent", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.parentEnemyDiedtEvaEvent }
        },
    )
}
