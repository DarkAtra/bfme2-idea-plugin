package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.audio.SoundSet
import de.darkatra.bfme2.ini.model.common.SageAudio
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.SageReference

data class Threshold(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("VoiceSelect") override val voiceSelect: SageReference<SageAudio>? = null,
    @SageIniName("VoiceSelectBattle") override val voiceSelectBattle: SageReference<SageAudio>? = null,
    @SageIniName("VoiceMove") override val voiceMove: SageReference<SageAudio>? = null,
    @SageIniName("VoiceMoveToCamp") override val voiceMoveToCamp: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveWhileAttacking") override val voiceMoveWhileAttacking: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttack") override val voiceAttack: SageReference<SageAudio>? = null,
    @SageIniName("VoiceAttackCharge") override val voiceAttackCharge: SageReference<SageAudio>? = null,
    @SageIniName("VoiceAttackMachine") override val voiceAttackMachine: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackStructure") override val voiceAttackStructure: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceGuard") override val voiceGuard: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceFear") override val voiceFear: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceRetreatToCastle") override val voiceRetreatToCastle: SageReference<AudioEvent>? = null,
    @SageIniName("SoundImpact") override val soundImpact: SageReference<AudioEvent>? = null,
    @SageIniName("VoicePriority") override val voicePriority: Int = 0,
    @SageIniName("UnitSpecificSounds") override val unitSpecificSounds: List<UnitSpecificSounds> = emptyList(),
    @SageIniName("SoundAmbient") val soundAmbient: SageReference<AudioEvent>? = null,
    @SageIniName("SoundAmbientBattle") val soundAmbientBattle: SageReference<AudioEvent>? = null,
    @SageIniName("SoundAmbientDamaged") val soundAmbientDamaged: SageReference<AudioEvent>? = null,
    @SageIniName("SoundAmbientReallyDamaged") val soundAmbientReallyDamaged: SageReference<AudioEvent>? = null,
    @SageIniName("SoundAmbientRubble") val soundAmbientRubble: SageReference<AudioEvent>? = null,
    @SageIniName("SoundCreated") val soundCreated: SageReference<AudioEvent>? = null,
    @SageIniName("SoundCrushing") val soundCrushing: SageReference<AudioEvent>? = null,
    @SageIniName("SoundEnter") val soundEnter: SageReference<AudioEvent>? = null,
    @SageIniName("SoundExit") val soundExit: SageReference<AudioEvent>? = null,
    @SageIniName("SoundFallingFromPlane") val soundFallingFromPlane: SageReference<AudioEvent>? = null,
    @SageIniName("SoundImpactCyclonic") val soundImpactCyclonic: SageReference<AudioEvent>? = null,
    @SageIniName("SoundMoveLoop") val soundMoveLoop: SageReference<AudioEvent>? = null,
    @SageIniName("SoundMoveLoopDamaged") val soundMoveLoopDamaged: SageReference<AudioEvent>? = null,
    @SageIniName("SoundMoveStart") val soundMoveStart: SageReference<AudioEvent>? = null,
    @SageIniName("SoundMoveStartDamaged") val soundMoveStartDamaged: SageReference<AudioEvent>? = null,
    @SageIniName("SoundOnDamaged") val soundOnDamaged: SageReference<AudioEvent>? = null,
    @SageIniName("SoundOnReallyDamaged") val soundOnReallyDamaged: SageReference<AudioEvent>? = null,
    @SageIniName("SoundPromotedElite") val soundPromotedElite: SageReference<AudioEvent>? = null,
    @SageIniName("SoundPromotedHero") val soundPromotedHero: SageReference<AudioEvent>? = null,
    @SageIniName("SoundPromotedVeteran") val soundPromotedVeteran: SageReference<AudioEvent>? = null,
    @SageIniName("SoundStealthOff") val soundStealthOff: SageReference<AudioEvent>? = null,
    @SageIniName("SoundStealthOn") val soundStealthOn: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAlert") val voiceAlert: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackAir") val voiceAttackAir: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceCombineWithHorde") val voiceCombineWithHorde: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceCreated") val voiceCreated: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceDefect") val voiceDefect: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateAttackAir") val voiceEnterStateAttackAir: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateAttackCharge") val voiceEnterStateAttackCharge: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMove") val voiceEnterStateMove: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMoveOverWalls") val voiceEnterStateMoveOverWalls: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMoveToCamp") val voiceEnterStateMoveToCamp: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMoveToHigherGround") val voiceEnterStateMoveToHigherGround: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMoveWhileAttacking") val voiceEnterStateMoveWhileAttacking: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceFullyCreated") val voiceFullyCreated: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveOverWalls") val voiceMoveOverWalls: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveToHigherGround") val voiceMoveToHigherGround: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectUnderConstruction") val voiceSelectUnderConstruction: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceTaskComplete") val voiceTaskComplete: SageReference<AudioEvent>? = null,
) : SoundSet() {

    companion object : SageIniBlockDescriptor<Threshold>(
        name = "Threshold",
        parent = SoundSet,
        properties = {
            property("SoundAmbient", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundAmbient }
            property("SoundAmbientBattle", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundAmbientBattle }
            property("SoundAmbientDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundAmbientDamaged }
            property("SoundAmbientReallyDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundAmbientReallyDamaged }
            property("SoundAmbientRubble", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundAmbientRubble }
            property("SoundCreated", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundCreated }
            property("SoundCrushing", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundCrushing }
            property("SoundEnter", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundEnter }
            property("SoundExit", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundExit }
            property("SoundFallingFromPlane", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundFallingFromPlane }
            property("SoundImpactCyclonic", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundImpactCyclonic }
            property("SoundMoveLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundMoveLoop }
            property("SoundMoveLoopDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundMoveLoopDamaged }
            property("SoundMoveStart", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundMoveStart }
            property("SoundMoveStartDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundMoveStartDamaged }
            property("SoundOnDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundOnDamaged }
            property("SoundOnReallyDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundOnReallyDamaged }
            property("SoundPromotedElite", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundPromotedElite }
            property("SoundPromotedHero", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundPromotedHero }
            property("SoundPromotedVeteran", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundPromotedVeteran }
            property("SoundStealthOff", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundStealthOff }
            property("SoundStealthOn", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundStealthOn }
            property("VoiceAlert", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAlert }
            property("VoiceAttackAir", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackAir }
            property("VoiceCombineWithHorde", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceCombineWithHorde }
            property("VoiceCreated", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceCreated }
            property("VoiceDefect", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceDefect }
            property("VoiceEnterStateAttackAir", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateAttackAir }
            property("VoiceEnterStateAttackCharge", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateAttackCharge }
            property("VoiceEnterStateMove", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMove }
            property("VoiceEnterStateMoveOverWalls", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMoveOverWalls }
            property("VoiceEnterStateMoveToCamp", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMoveToCamp }
            property("VoiceEnterStateMoveToHigherGround", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMoveToHigherGround }
            property("VoiceEnterStateMoveWhileAttacking", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMoveWhileAttacking }
            property("VoiceFullyCreated", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceFullyCreated }
            property("VoiceMoveOverWalls", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMoveOverWalls }
            property("VoiceMoveToHigherGround", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMoveToHigherGround }
            property("VoiceSelectUnderConstruction", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceSelectUnderConstruction }
            property("VoiceTaskComplete", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceTaskComplete }
        },
    )
}
