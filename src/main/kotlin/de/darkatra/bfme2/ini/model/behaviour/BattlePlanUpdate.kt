package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.HealthRatioType
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class BattlePlanUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("BombardmentPlanAnimationTime") val bombardmentPlanAnimationTime: Int = 0,
    @SageIniName("HoldTheLinePlanAnimationTime") val holdTheLinePlanAnimationTime: Int = 0,
    @SageIniName("SearchAndDestroyPlanAnimationTime") val searchAndDestroyPlanAnimationTime: Int = 0,
    @SageIniName("TransitionIdleTime") val transitionIdleTime: Int = 0,
    @SageIniName("ValidMemberKindOf") val validMemberKindOf: List<KindOf> = emptyList(),
    @SageIniName("InvalidMemberKindOf") val invalidMemberKindOf: List<KindOf> = emptyList(),
    @SageIniName("BattlePlanChangeParalyzeTime") val battlePlanChangeParalyzeTime: Int = 0,
    @SageIniName("HoldTheLinePlanArmorDamageScalar") val holdTheLinePlanArmorDamageScalar: Double = 0.0,
    @SageIniName("SearchAndDestroyPlanSightRangeScalar") val searchAndDestroyPlanSightRangeScalar: Double = 0.0,
    @SageIniName("StrategyCenterSearchAndDestroySightRangeScalar") val strategyCenterSearchAndDestroySightRangeScalar: Double = 0.0,
    @SageIniName("StrategyCenterSearchAndDestroyDetectsStealth") val strategyCenterSearchAndDestroyDetectsStealth: Boolean = false,
    @SageIniName("StrategyCenterHoldTheLineMaxHealthScalar") val strategyCenterHoldTheLineMaxHealthScalar: Double = 0.0,
    @SageIniName("StrategyCenterHoldTheLineMaxHealthChangeType") val strategyCenterHoldTheLineMaxHealthChangeType: HealthRatioType? = null,
    @SageIniName("VisionObjectName") val visionObjectName: SageReference<Object>? = null,
    @SageIniName("BombardmentPlanUnpackSoundName") val bombardmentPlanUnpackSoundName: SageReference<AudioEvent>? = null,
    @SageIniName("BombardmentPlanPackSoundName") val bombardmentPlanPackSoundName: SageReference<AudioEvent>? = null,
    @SageIniName("BombardmentMessageLabel") val bombardmentMessageLabel: Untyped? = null,
    @SageIniName("BombardmentAnnouncementName") val bombardmentAnnouncementName: SageReference<AudioEvent>? = null,
    @SageIniName("SearchAndDestroyPlanUnpackSoundName") val searchAndDestroyPlanUnpackSoundName: SageReference<AudioEvent>? = null,
    @SageIniName("SearchAndDestroyPlanIdleLoopSoundName") val searchAndDestroyPlanIdleLoopSoundName: SageReference<AudioEvent>? = null,
    @SageIniName("SearchAndDestroyPlanPackSoundName") val searchAndDestroyPlanPackSoundName: SageReference<AudioEvent>? = null,
    @SageIniName("SearchAndDestroyMessageLabel") val searchAndDestroyMessageLabel: Untyped? = null,
    @SageIniName("SearchAndDestroyAnnouncementName") val searchAndDestroyAnnouncementName: SageReference<AudioEvent>? = null,
    @SageIniName("HoldTheLinePlanUnpackSoundName") val holdTheLinePlanUnpackSoundName: SageReference<AudioEvent>? = null,
    @SageIniName("HoldTheLinePlanPackSoundName") val holdTheLinePlanPackSoundName: SageReference<AudioEvent>? = null,
    @SageIniName("HoldTheLineMessageLabel") val holdTheLineMessageLabel: Untyped? = null,
    @SageIniName("HoldTheLineAnnouncementName") val holdTheLineAnnouncementName: SageReference<AudioEvent>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<BattlePlanUpdate>(
        name = "BattlePlanUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("BombardmentPlanAnimationTime", IntValue) { it.bombardmentPlanAnimationTime }
            property("HoldTheLinePlanAnimationTime", IntValue) { it.holdTheLinePlanAnimationTime }
            property("SearchAndDestroyPlanAnimationTime", IntValue) { it.searchAndDestroyPlanAnimationTime }
            property("TransitionIdleTime", IntValue) { it.transitionIdleTime }
            property("ValidMemberKindOf", ListValue(KindOf.type)) { it.validMemberKindOf }
            property("InvalidMemberKindOf", ListValue(KindOf.type)) { it.invalidMemberKindOf }
            property("BattlePlanChangeParalyzeTime", IntValue) { it.battlePlanChangeParalyzeTime }
            property("HoldTheLinePlanArmorDamageScalar", FloatValue) { it.holdTheLinePlanArmorDamageScalar }
            property("SearchAndDestroyPlanSightRangeScalar", FloatValue) { it.searchAndDestroyPlanSightRangeScalar }
            property("StrategyCenterSearchAndDestroySightRangeScalar", FloatValue) { it.strategyCenterSearchAndDestroySightRangeScalar }
            property("StrategyCenterSearchAndDestroyDetectsStealth", BooleanValue) { it.strategyCenterSearchAndDestroyDetectsStealth }
            property("StrategyCenterHoldTheLineMaxHealthScalar", FloatValue) { it.strategyCenterHoldTheLineMaxHealthScalar }
            property("StrategyCenterHoldTheLineMaxHealthChangeType", HealthRatioType.type) { it.strategyCenterHoldTheLineMaxHealthChangeType }
            property("VisionObjectName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.visionObjectName }
            property("BombardmentPlanUnpackSoundName", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.bombardmentPlanUnpackSoundName }
            property("BombardmentPlanPackSoundName", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.bombardmentPlanPackSoundName }
            property("BombardmentMessageLabel", Untyped.type) { it.bombardmentMessageLabel }
            property("BombardmentAnnouncementName", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.bombardmentAnnouncementName }
            property("SearchAndDestroyPlanUnpackSoundName", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.searchAndDestroyPlanUnpackSoundName }
            property("SearchAndDestroyPlanIdleLoopSoundName", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.searchAndDestroyPlanIdleLoopSoundName }
            property("SearchAndDestroyPlanPackSoundName", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.searchAndDestroyPlanPackSoundName }
            property("SearchAndDestroyMessageLabel", Untyped.type) { it.searchAndDestroyMessageLabel }
            property("SearchAndDestroyAnnouncementName", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.searchAndDestroyAnnouncementName }
            property("HoldTheLinePlanUnpackSoundName", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.holdTheLinePlanUnpackSoundName }
            property("HoldTheLinePlanPackSoundName", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.holdTheLinePlanPackSoundName }
            property("HoldTheLineMessageLabel", Untyped.type) { it.holdTheLineMessageLabel }
            property("HoldTheLineAnnouncementName", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.holdTheLineAnnouncementName }
        },
    )
}
