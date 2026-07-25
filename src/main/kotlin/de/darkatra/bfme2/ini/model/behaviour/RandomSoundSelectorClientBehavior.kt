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
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class RandomSoundSelectorClientBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Chance") val chance: Double = 0.0,
    @SageIniName("RerollOnEveryFrame") val rerollOnEveryFrame: Boolean = false,
    @SageIniName("UnitSpecificSounds") val unitSpecificSounds: Untyped? = null,
    @SageIniName("VoicePriority") val voicePriority: Int = 0,
    @SageIniName("VoiceSelect") val voiceSelect: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectUnderConstruction") val voiceSelectUnderConstruction: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectBattle") val voiceSelectBattle: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMove") val voiceMove: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveToHigherGround") val voiceMoveToHigherGround: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveOverWalls") val voiceMoveOverWalls: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttack") val voiceAttack: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackCharge") val voiceAttackCharge: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceFear") val voiceFear: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceCreated") val voiceCreated: List<SageReference<AudioEvent>> = emptyList(),
    @SageIniName("VoiceTaskComplete") val voiceTaskComplete: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceDefect") val voiceDefect: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackAir") val voiceAttackAir: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceGuard") val voiceGuard: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAlert") val voiceAlert: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceFullyCreated") val voiceFullyCreated: List<SageReference<AudioEvent>> = emptyList(),
    @SageIniName("VoiceRetreatToCastle") val voiceRetreatToCastle: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveToCamp") val voiceMoveToCamp: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackStructure") val voiceAttackStructure: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackMachine") val voiceAttackMachine: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveWhileAttacking") val voiceMoveWhileAttacking: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceCombineWithHorde") val voiceCombineWithHorde: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateAttack") val voiceEnterStateAttack: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateAttackCharge") val voiceEnterStateAttackCharge: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateAttackAir") val voiceEnterStateAttackAir: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateAttackStructure") val voiceEnterStateAttackStructure: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateAttackMachine") val voiceEnterStateAttackMachine: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMove") val voiceEnterStateMove: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMoveToHigherGround") val voiceEnterStateMoveToHigherGround: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMoveOverWalls") val voiceEnterStateMoveOverWalls: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateRetreatToCastle") val voiceEnterStateRetreatToCastle: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMoveToCamp") val voiceEnterStateMoveToCamp: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMoveWhileAttacking") val voiceEnterStateMoveWhileAttacking: SageReference<AudioEvent>? = null,
    @SageIniName("SoundMoveStart") val soundMoveStart: SageReference<AudioEvent>? = null,
    @SageIniName("SoundMoveStartDamaged") val soundMoveStartDamaged: SageReference<AudioEvent>? = null,
    @SageIniName("SoundMoveLoop") val soundMoveLoop: SageReference<AudioEvent>? = null,
    @SageIniName("SoundMoveLoopDamaged") val soundMoveLoopDamaged: SageReference<AudioEvent>? = null,
    @SageIniName("SoundAmbient") val soundAmbient: SageReference<AudioEvent>? = null,
    @SageIniName("SoundAmbientDamaged") val soundAmbientDamaged: SageReference<AudioEvent>? = null,
    @SageIniName("SoundAmbientReallyDamaged") val soundAmbientReallyDamaged: SageReference<AudioEvent>? = null,
    @SageIniName("SoundAmbientRubble") val soundAmbientRubble: SageReference<AudioEvent>? = null,
    @SageIniName("SoundAmbientBattle") val soundAmbientBattle: SageReference<AudioEvent>? = null,
    @SageIniName("SoundStealthOn") val soundStealthOn: SageReference<AudioEvent>? = null,
    @SageIniName("SoundStealthOff") val soundStealthOff: SageReference<AudioEvent>? = null,
    @SageIniName("SoundCreated") val soundCreated: SageReference<AudioEvent>? = null,
    @SageIniName("SoundOnDamaged") val soundOnDamaged: SageReference<AudioEvent>? = null,
    @SageIniName("SoundOnReallyDamaged") val soundOnReallyDamaged: SageReference<AudioEvent>? = null,
    @SageIniName("SoundEnter") val soundEnter: SageReference<AudioEvent>? = null,
    @SageIniName("SoundExit") val soundExit: SageReference<AudioEvent>? = null,
    @SageIniName("SoundPromotedVeteran") val soundPromotedVeteran: SageReference<AudioEvent>? = null,
    @SageIniName("SoundPromotedElite") val soundPromotedElite: SageReference<AudioEvent>? = null,
    @SageIniName("SoundPromotedHero") val soundPromotedHero: SageReference<AudioEvent>? = null,
    @SageIniName("SoundFallingFromPlane") val soundFallingFromPlane: SageReference<AudioEvent>? = null,
    @SageIniName("SoundImpact") val soundImpact: SageReference<AudioEvent>? = null,
    @SageIniName("SoundImpactCyclonic") val soundImpactCyclonic: SageReference<AudioEvent>? = null,
    @SageIniName("SoundCrushing") val soundCrushing: SageReference<AudioEvent>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<RandomSoundSelectorClientBehavior>(
        name = "RandomSoundSelectorClientBehavior",
        properties = {
            property("Chance", FloatValue) { it.chance }
            property("RerollOnEveryFrame", BooleanValue) { it.rerollOnEveryFrame }
            property("UnitSpecificSounds", Untyped.type) { it.unitSpecificSounds }
            property("VoicePriority", IntValue) { it.voicePriority }
            property("VoiceSelect", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceSelect }
            property("VoiceSelectUnderConstruction", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceSelectUnderConstruction }
            property("VoiceSelectBattle", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceSelectBattle }
            property("VoiceMove", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMove }
            property("VoiceMoveToHigherGround", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMoveToHigherGround }
            property("VoiceMoveOverWalls", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMoveOverWalls }
            property("VoiceAttack", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttack }
            property("VoiceAttackCharge", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackCharge }
            property("VoiceFear", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceFear }
            property("VoiceCreated", ListValue(ReferenceValue<AudioEvent> { listOf(AudioEvent) })) { it.voiceCreated }
            property("VoiceTaskComplete", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceTaskComplete }
            property("VoiceDefect", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceDefect }
            property("VoiceAttackAir", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackAir }
            property("VoiceGuard", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceGuard }
            property("VoiceAlert", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAlert }
            property("VoiceFullyCreated", ListValue(ReferenceValue<AudioEvent> { listOf(AudioEvent) })) { it.voiceFullyCreated }
            property("VoiceRetreatToCastle", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceRetreatToCastle }
            property("VoiceMoveToCamp", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMoveToCamp }
            property("VoiceAttackStructure", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackStructure }
            property("VoiceAttackMachine", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackMachine }
            property("VoiceMoveWhileAttacking", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMoveWhileAttacking }
            property("VoiceCombineWithHorde", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceCombineWithHorde }
            property("VoiceEnterStateAttack", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateAttack }
            property("VoiceEnterStateAttackCharge", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateAttackCharge }
            property("VoiceEnterStateAttackAir", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateAttackAir }
            property("VoiceEnterStateAttackStructure", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateAttackStructure }
            property("VoiceEnterStateAttackMachine", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateAttackMachine }
            property("VoiceEnterStateMove", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMove }
            property("VoiceEnterStateMoveToHigherGround", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMoveToHigherGround }
            property("VoiceEnterStateMoveOverWalls", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMoveOverWalls }
            property("VoiceEnterStateRetreatToCastle", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateRetreatToCastle }
            property("VoiceEnterStateMoveToCamp", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMoveToCamp }
            property("VoiceEnterStateMoveWhileAttacking", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMoveWhileAttacking }
            property("SoundMoveStart", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundMoveStart }
            property("SoundMoveStartDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundMoveStartDamaged }
            property("SoundMoveLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundMoveLoop }
            property("SoundMoveLoopDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundMoveLoopDamaged }
            property("SoundAmbient", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundAmbient }
            property("SoundAmbientDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundAmbientDamaged }
            property("SoundAmbientReallyDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundAmbientReallyDamaged }
            property("SoundAmbientRubble", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundAmbientRubble }
            property("SoundAmbientBattle", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundAmbientBattle }
            property("SoundStealthOn", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundStealthOn }
            property("SoundStealthOff", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundStealthOff }
            property("SoundCreated", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundCreated }
            property("SoundOnDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundOnDamaged }
            property("SoundOnReallyDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundOnReallyDamaged }
            property("SoundEnter", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundEnter }
            property("SoundExit", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundExit }
            property("SoundPromotedVeteran", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundPromotedVeteran }
            property("SoundPromotedElite", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundPromotedElite }
            property("SoundPromotedHero", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundPromotedHero }
            property("SoundFallingFromPlane", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundFallingFromPlane }
            property("SoundImpact", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundImpact }
            property("SoundImpactCyclonic", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundImpactCyclonic }
            property("SoundCrushing", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundCrushing }
        },
    )
}
