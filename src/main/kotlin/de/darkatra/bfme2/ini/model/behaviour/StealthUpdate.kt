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
import de.darkatra.bfme2.ini.model.`object`.EvaEventBase
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.NewEvaEvent
import de.darkatra.bfme2.ini.model.`object`.PredefinedEvaEvent
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.WeaponSetConditions

data class StealthUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StealthDelay") val stealthDelay: Int = 0,
    @SageIniName("StealthForbiddenConditions") val stealthForbiddenConditions: List<ModelCondition> = emptyList(),
    @SageIniName("HintDetectableConditions") val hintDetectableConditions: ObjectStatus? = null,
    @SageIniName("FriendlyOpacityMin") val friendlyOpacityMin: Double = 0.0,
    @SageIniName("FriendlyOpacityMax") val friendlyOpacityMax: Double = 0.0,
    @SageIniName("PulseFrequency") val pulseFrequency: Int = 0,
    @SageIniName("MoveThresholdSpeed") val moveThresholdSpeed: Double = 0.0,
    @SageIniName("InnateStealth") val innateStealth: Boolean = false,
    @SageIniName("OrderIdleEnemiesToAttackMeUponReveal") val orderIdleEnemiesToAttackMeUponReveal: Boolean = false,
    @SageIniName("DisguisesAsTeam") val disguisesAsTeam: Boolean = false,
    @SageIniName("RevealDistanceFromTarget") val revealDistanceFromTarget: Double = 0.0,
    @SageIniName("DisguiseFX") val disguiseFX: SageReference<FXList>? = null,
    @SageIniName("DisguiseRevealFX") val disguiseRevealFX: SageReference<FXList>? = null,
    @SageIniName("DisguiseTransitionTime") val disguiseTransitionTime: Int = 0,
    @SageIniName("DisguiseRevealTransitionTime") val disguiseRevealTransitionTime: Int = 0,
    @SageIniName("GrantedBySpecialPower") val grantedBySpecialPower: Boolean = false,
    @SageIniName("EnemyDetectionEvaEvent") val enemyDetectionEvaEvent: Opaque? = null,
    @SageIniName("OwnDetectionEvaEvent") val ownDetectionEvaEvent: Opaque? = null,
    @SageIniName("UseRiderStealth") val useRiderStealth: Boolean = false,
    @SageIniName("DetectedByAnyoneRange") val detectedByAnyoneRange: Double = 0.0,
    @SageIniName("RemoveTerrainRestrictionOnUpgrade") val removeTerrainRestrictionOnUpgrade: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RevealWeaponSets") val revealWeaponSets: List<WeaponSetConditions> = emptyList(),
    @SageIniName("StartsActive") val startsActive: Boolean = false,
    @SageIniName("DetectedByFriendliesOnly") val detectedByFriendliesOnly: Boolean = false,
    @SageIniName("VoiceMoveToStealthyArea") val voiceMoveToStealthyArea: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMoveToStealthyArea") val voiceEnterStateMoveToStealthyArea: SageReference<AudioEvent>? = null,
    @SageIniName("OneRingDelayOn") val oneRingDelayOn: Int = 0,
    @SageIniName("OneRingDelayOff") val oneRingDelayOff: Int = 0,
    @SageIniName("RingAnimTimeOn") val ringAnimTimeOn: Int = 0,
    @SageIniName("RingAnimTimeOff") val ringAnimTimeOff: Int = 0,
    @SageIniName("RingDelayAfterRemoving") val ringDelayAfterRemoving: Int = 0,
    @SageIniName("BecomeStealthedFX") val becomeStealthedFX: SageReference<FXList>? = null,
    @SageIniName("ExitStealthFX") val exitStealthFX: SageReference<FXList>? = null,
    @SageIniName("BecomeStealthedOneRingFX") val becomeStealthedOneRingFX: SageReference<FXList>? = null,
    @SageIniName("ExitStealthOneRingFX") val exitStealthOneRingFX: SageReference<FXList>? = null,
    @SageIniName("RequiredUpgradeNames") val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("EvaEventDetectedEnemy") val evaEventDetectedEnemy: SageReference<EvaEventBase>? = null,
    @SageIniName("EvaEventDetectedAlly") val evaEventDetectedAlly: SageReference<EvaEventBase>? = null,
    @SageIniName("EvaEventDetectedOwner") val evaEventDetectedOwner: SageReference<EvaEventBase>? = null,
    @SageIniName("ForbiddenUpgradeNames") val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<StealthUpdate>(
        name = "StealthUpdate",
        properties = {
            property("StealthDelay", IntValue) { it.stealthDelay }
            property("StealthForbiddenConditions", ListValue(ModelCondition.type)) { it.stealthForbiddenConditions }
            property("HintDetectableConditions", ObjectStatus.type) { it.hintDetectableConditions }
            property("FriendlyOpacityMin", FloatValue) { it.friendlyOpacityMin }
            property("FriendlyOpacityMax", FloatValue) { it.friendlyOpacityMax }
            property("PulseFrequency", IntValue) { it.pulseFrequency }
            property("MoveThresholdSpeed", FloatValue) { it.moveThresholdSpeed }
            property("InnateStealth", BooleanValue) { it.innateStealth }
            property("OrderIdleEnemiesToAttackMeUponReveal", BooleanValue) { it.orderIdleEnemiesToAttackMeUponReveal }
            property("DisguisesAsTeam", BooleanValue) { it.disguisesAsTeam }
            property("RevealDistanceFromTarget", FloatValue) { it.revealDistanceFromTarget }
            property("DisguiseFX", ReferenceValue<FXList> { listOf(FXList) }) { it.disguiseFX }
            property("DisguiseRevealFX", ReferenceValue<FXList> { listOf(FXList) }) { it.disguiseRevealFX }
            property("DisguiseTransitionTime", IntValue) { it.disguiseTransitionTime }
            property("DisguiseRevealTransitionTime", IntValue) { it.disguiseRevealTransitionTime }
            property("GrantedBySpecialPower", BooleanValue) { it.grantedBySpecialPower }
            property("EnemyDetectionEvaEvent", Opaque.type) { it.enemyDetectionEvaEvent }
            property("OwnDetectionEvaEvent", Opaque.type) { it.ownDetectionEvaEvent }
            property("UseRiderStealth", BooleanValue) { it.useRiderStealth }
            property("DetectedByAnyoneRange", FloatValue) { it.detectedByAnyoneRange }
            property("RemoveTerrainRestrictionOnUpgrade", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.removeTerrainRestrictionOnUpgrade }
            property("RevealWeaponSets", ListValue(WeaponSetConditions.type)) { it.revealWeaponSets }
            property("StartsActive", BooleanValue) { it.startsActive }
            property("DetectedByFriendliesOnly", BooleanValue) { it.detectedByFriendliesOnly }
            property("VoiceMoveToStealthyArea", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMoveToStealthyArea }
            property("VoiceEnterStateMoveToStealthyArea", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMoveToStealthyArea }
            property("OneRingDelayOn", IntValue) { it.oneRingDelayOn }
            property("OneRingDelayOff", IntValue) { it.oneRingDelayOff }
            property("RingAnimTimeOn", IntValue) { it.ringAnimTimeOn }
            property("RingAnimTimeOff", IntValue) { it.ringAnimTimeOff }
            property("RingDelayAfterRemoving", IntValue) { it.ringDelayAfterRemoving }
            property("BecomeStealthedFX", ReferenceValue<FXList> { listOf(FXList) }) { it.becomeStealthedFX }
            property("ExitStealthFX", ReferenceValue<FXList> { listOf(FXList) }) { it.exitStealthFX }
            property("BecomeStealthedOneRingFX", ReferenceValue<FXList> { listOf(FXList) }) { it.becomeStealthedOneRingFX }
            property("ExitStealthOneRingFX", ReferenceValue<FXList> { listOf(FXList) }) { it.exitStealthOneRingFX }
            property("RequiredUpgradeNames", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.requiredUpgradeNames }
            property("EvaEventDetectedEnemy", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.evaEventDetectedEnemy }
            property("EvaEventDetectedAlly", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.evaEventDetectedAlly }
            property("EvaEventDetectedOwner", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.evaEventDetectedOwner }
            property("ForbiddenUpgradeNames", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.forbiddenUpgradeNames }
        },
    )
}
