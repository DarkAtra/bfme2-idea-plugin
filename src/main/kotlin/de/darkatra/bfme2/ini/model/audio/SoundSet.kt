package de.darkatra.bfme2.ini.model.audio

import de.darkatra.bfme2.ini.model.common.SageAudio
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.Multisound
import de.darkatra.bfme2.ini.model.`object`.UnitSpecificSounds
import de.darkatra.bfme2.ini.model.value.SageReference

@SageIniName("_SoundSet")
open class SoundSet(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("VoiceSelect") open val voiceSelect: SageReference<SageAudio>? = null,
    @SageIniName("VoiceSelectBattle") open val voiceSelectBattle: SageReference<SageAudio>? = null,
    @SageIniName("VoiceMove") open val voiceMove: SageReference<SageAudio>? = null,
    @SageIniName("VoiceMoveToCamp") open val voiceMoveToCamp: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveWhileAttacking") open val voiceMoveWhileAttacking: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttack") open val voiceAttack: SageReference<SageAudio>? = null,
    @SageIniName("VoiceAttackCharge") open val voiceAttackCharge: SageReference<SageAudio>? = null,
    @SageIniName("VoiceAttackMachine") open val voiceAttackMachine: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackStructure") open val voiceAttackStructure: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceGuard") open val voiceGuard: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceFear") open val voiceFear: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceRetreatToCastle") open val voiceRetreatToCastle: SageReference<AudioEvent>? = null,
    @SageIniName("SoundImpact") open val soundImpact: SageReference<AudioEvent>? = null,
    @SageIniName("VoicePriority") open val voicePriority: Int = 0,
    @SageIniName("UnitSpecificSounds") open val unitSpecificSounds: List<UnitSpecificSounds> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<SoundSet>(
        name = "_SoundSet",
        properties = {
            property("VoiceSelect", ReferenceValue<SageAudio> { listOf(AudioEvent, Multisound) }) { it.voiceSelect }
            property("VoiceSelectBattle", ReferenceValue<SageAudio> { listOf(AudioEvent, Multisound) }) { it.voiceSelectBattle }
            property("VoiceMove", ReferenceValue<SageAudio> { listOf(AudioEvent, Multisound) }) { it.voiceMove }
            property("VoiceMoveToCamp", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMoveToCamp }
            property("VoiceMoveWhileAttacking", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMoveWhileAttacking }
            property("VoiceAttack", ReferenceValue<SageAudio> { listOf(AudioEvent, Multisound) }) { it.voiceAttack }
            property("VoiceAttackCharge", ReferenceValue<SageAudio> { listOf(AudioEvent, Multisound) }) { it.voiceAttackCharge }
            property("VoiceAttackMachine", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackMachine }
            property("VoiceAttackStructure", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackStructure }
            property("VoiceGuard", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceGuard }
            property("VoiceFear", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceFear }
            property("VoiceRetreatToCastle", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceRetreatToCastle }
            property("SoundImpact", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundImpact }
            property("VoicePriority", IntValue) { it.voicePriority }
            property("UnitSpecificSounds", ListValue(BlockValue<UnitSpecificSounds> { listOf(UnitSpecificSounds) })) { it.unitSpecificSounds }
        },
    )
}
