package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.audio.SoundSet
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.UnitSpecificSounds
import de.darkatra.bfme2.ini.model.value.SageReference

data class SoundState(
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
    @SageIniName("VoiceEnterStateMove") val voiceEnterStateMove: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMoveToCamp") val voiceEnterStateMoveToCamp: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMoveWhileAttacking") val voiceEnterStateMoveWhileAttacking: SageReference<AudioEvent>? = null,
    @SageIniName("SoundMoveLoop") val soundMoveLoop: SageReference<AudioEvent>? = null,
    @SageIniName("SoundMoveStart") val soundMoveStart: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceCreated") val voiceCreated: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateAttackCharge") val voiceEnterStateAttackCharge: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceFullyCreated") val voiceFullyCreated: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMove2") val voiceMove2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelect2") val voiceSelect2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectBattle2") val voiceSelectBattle2: SageReference<AudioEvent>? = null,
    @SageIniName("UnitSpecificSounds") override val unitSpecificSounds: List<UnitSpecificSounds> = emptyList(),
) : SoundSet() {

    companion object : SageIniBlockDescriptor<SoundState>(
        name = "SoundState",
        parent = SoundSet,
        keyedByLabel = true,
        properties = {
            property("VoiceEnterStateMove", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMove }
            property("VoiceEnterStateMoveToCamp", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMoveToCamp }
            property("VoiceEnterStateMoveWhileAttacking", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMoveWhileAttacking }
            property("SoundMoveLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundMoveLoop }
            property("SoundMoveStart", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundMoveStart }
            property("VoiceCreated", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceCreated }
            property("VoiceEnterStateAttackCharge", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateAttackCharge }
            property("VoiceFullyCreated", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceFullyCreated }
            property("VoiceMove2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMove2 }
            property("VoiceSelect2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceSelect2 }
            property("VoiceSelectBattle2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceSelectBattle2 }
        },
    )
}
