package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.nugget.InvisibilityNugget
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class InvisibilityUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("UpdatePeriod") val updatePeriod: Int = 0,
    @SageIniName("RequiredUpgrades") val requiredUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("ForbiddenUpgrades") val forbiddenUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("Broadcast") val broadcast: Boolean = false,
    @SageIniName("BroadcastObjectFilter") val broadcastObjectFilter: SageFilter? = null,
    @SageIniName("BroadcastRange") val broadcastRange: Double = 0.0,
    @SageIniName("StartsActive") val startsActive: Boolean = false,
    @SageIniName("UnitSpecificSoundNameToUseAsVoiceMoveToStealthyArea") val unitSpecificSoundNameToUseAsVoiceMoveToStealthyArea: SageReference<AudioEvent>? = null,
    @SageIniName("UnitSpecificSoundNameToUseAsVoiceEnterStateMoveToStealthyArea") val unitSpecificSoundNameToUseAsVoiceEnterStateMoveToStealthyArea: SageReference<AudioEvent>? = null,
    @SageIniName("InvisibilityNugget") val invisibilityNugget: List<InvisibilityNugget> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<InvisibilityUpdate>(
        name = "InvisibilityUpdate",
        properties = {
            property("UpdatePeriod", IntValue) { it.updatePeriod }
            property("RequiredUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.requiredUpgrades }
            property("ForbiddenUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.forbiddenUpgrades }
            property("Broadcast", BooleanValue) { it.broadcast }
            property("BroadcastObjectFilter", SageFilter.type) { it.broadcastObjectFilter }
            property("BroadcastRange", FloatValue) { it.broadcastRange }
            property("StartsActive", BooleanValue) { it.startsActive }
            property(
                "UnitSpecificSoundNameToUseAsVoiceMoveToStealthyArea",
                ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.unitSpecificSoundNameToUseAsVoiceMoveToStealthyArea }
            property(
                "UnitSpecificSoundNameToUseAsVoiceEnterStateMoveToStealthyArea",
                ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.unitSpecificSoundNameToUseAsVoiceEnterStateMoveToStealthyArea }
            property("InvisibilityNugget", ListValue(BlockValue<InvisibilityNugget> { listOf(InvisibilityNugget) })) { it.invisibilityNugget }
        },
    )
}
