package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.audio.SoundSet
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.SageReference

data class Threshold(
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
    @SageIniName("UnitSpecificSounds") override val unitSpecificSounds: List<UnitSpecificSounds> = emptyList(),
) : SoundSet() {

    companion object : SageIniBlockDescriptor<Threshold>(
        name = "Threshold",
        parent = SoundSet,
    )
}
