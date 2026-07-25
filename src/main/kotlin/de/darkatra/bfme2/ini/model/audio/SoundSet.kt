package de.darkatra.bfme2.ini.model.audio

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.UnitSpecificSounds
import de.darkatra.bfme2.ini.model.value.SageReference

@SageIniName("_SoundSet")
open class SoundSet(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("VoiceSelect") open val voiceSelect: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectBattle") open val voiceSelectBattle: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMove") open val voiceMove: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveToCamp") open val voiceMoveToCamp: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveWhileAttacking") open val voiceMoveWhileAttacking: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttack") open val voiceAttack: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackCharge") open val voiceAttackCharge: SageReference<AudioEvent>? = null,
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
            property("VoiceSelect", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceSelect }
            property("VoiceSelectBattle", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceSelectBattle }
            property("VoiceMove", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMove }
            property("VoiceMoveToCamp", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMoveToCamp }
            property("VoiceMoveWhileAttacking", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMoveWhileAttacking }
            property("VoiceAttack", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttack }
            property("VoiceAttackCharge", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackCharge }
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
