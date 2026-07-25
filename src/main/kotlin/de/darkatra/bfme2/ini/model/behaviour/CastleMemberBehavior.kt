package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.EvaEventBase
import de.darkatra.bfme2.ini.model.`object`.NewEvaEvent
import de.darkatra.bfme2.ini.model.`object`.PredefinedEvaEvent
import de.darkatra.bfme2.ini.model.value.SageReference

data class CastleMemberBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("UnderAttackEvaEventIfKeep") val underAttackEvaEventIfKeep: SageReference<EvaEventBase>? = null,
    @SageIniName("UnderAttackAllyEvaEventIfKeep") val underAttackAllyEvaEventIfKeep: SageReference<EvaEventBase>? = null,
    @SageIniName("StoreUpgradePrice") val storeUpgradePrice: Boolean = false,
    @SageIniName("CountsForEvaCastleBreached") val countsForEvaCastleBreached: Boolean = false,
    @SageIniName("CampDestroyedOwnerEvaEvent") val campDestroyedOwnerEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("CampDestroyedAllyEvaEvent") val campDestroyedAllyEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("CampDestroyedAttackerEvaEvent") val campDestroyedAttackerEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("BeingBuiltSound") val beingBuiltSound: SageReference<AudioEvent>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<CastleMemberBehavior>(
        name = "CastleMemberBehavior",
        properties = {
            property("UnderAttackEvaEventIfKeep", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.underAttackEvaEventIfKeep }
            property(
                "UnderAttackAllyEvaEventIfKeep",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.underAttackAllyEvaEventIfKeep }
            property("StoreUpgradePrice", BooleanValue) { it.storeUpgradePrice }
            property("CountsForEvaCastleBreached", BooleanValue) { it.countsForEvaCastleBreached }
            property("CampDestroyedOwnerEvaEvent", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.campDestroyedOwnerEvaEvent }
            property("CampDestroyedAllyEvaEvent", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.campDestroyedAllyEvaEvent }
            property(
                "CampDestroyedAttackerEvaEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.campDestroyedAttackerEvaEvent }
            property("BeingBuiltSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.beingBuiltSound }
        },
    )
}
