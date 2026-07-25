package de.darkatra.bfme2.ini.model.audio

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.UnitSpecificSounds
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class SoundUpgrade(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("VoiceSelect") override val voiceSelect: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectBattle") override val voiceSelectBattle: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMove") override val voiceMove: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveToCamp") override val voiceMoveToCamp: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveWhileAttacking") override val voiceMoveWhileAttacking: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttack") override val voiceAttack: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackCharge") override val voiceAttackCharge: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackMachine") override val voiceAttackMachine: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackStructure") override val voiceAttackStructure: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceGuard") override val voiceGuard: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceFear") override val voiceFear: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceRetreatToCastle") override val voiceRetreatToCastle: SageReference<AudioEvent>? = null,
    @SageIniName("SoundImpact") override val soundImpact: SageReference<AudioEvent>? = null,
    @SageIniName("VoicePriority") override val voicePriority: Int = 0,
    @SageIniName("VoiceAttackAir") val voiceAttackAir: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceCreated") val voiceCreated: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceFullyCreated") val voiceFullyCreated: SageReference<AudioEvent>? = null,
    @SageIniName("ExcludedUpgrades") val excludedUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredModelConditions") val requiredModelConditions: Untyped? = null,
    @SageIniName("UnitSpecificSounds") override val unitSpecificSounds: List<UnitSpecificSounds> = emptyList(),
) : SoundSet() {

    companion object : SageIniBlockDescriptor<SoundUpgrade>(
        name = "SoundUpgrade",
        parent = SoundSet,
        keyedByLabel = true,
        properties = {
            property("VoiceAttackAir", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackAir }
            property("VoiceCreated", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceCreated }
            property("VoiceFullyCreated", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceFullyCreated }
            property("ExcludedUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.excludedUpgrades }
            property("RequiredModelConditions", Untyped.type) { it.requiredModelConditions }
        },
    )
}
