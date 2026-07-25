package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageDraw
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

/** Split section 3 of [Object] (JVM 254-parameter constructor limit). */
data class ObjectSection3(
    @SageIniName("VoiceFear2") val voiceFear2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceFullyCreated2") val voiceFullyCreated2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceGarrison") val voiceGarrison: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceGroupSelect") val voiceGroupSelect: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceGuard2") val voiceGuard2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceGuardGroup") val voiceGuardGroup: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceGuardGroup2") val voiceGuardGroup2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMeetEnemy") val voiceMeetEnemy: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMove2") val voiceMove2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveGroup") val voiceMoveGroup: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveGroup2") val voiceMoveGroup2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveToCamp2") val voiceMoveToCamp2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveToCampGroup") val voiceMoveToCampGroup: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveToCampGroup2") val voiceMoveToCampGroup2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveWhileAttacking2") val voiceMoveWhileAttacking2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveWhileAttackingGroup") val voiceMoveWhileAttackingGroup: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveWhileAttackingGroup2") val voiceMoveWhileAttackingGroup2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceRetreatToCastle2") val voiceRetreatToCastle2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceRetreatToCastleGroup") val voiceRetreatToCastleGroup: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceRetreatToCastleGroup2") val voiceRetreatToCastleGroup2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelect2") val voiceSelect2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectBattle2") val voiceSelectBattle2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectBattleGroup") val voiceSelectBattleGroup: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectBattleGroup2") val voiceSelectBattleGroup2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectElite") val voiceSelectElite: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectGroup") val voiceSelectGroup: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectGroup2") val voiceSelectGroup2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceTaskComplete2") val voiceTaskComplete2: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceTaskUnable") val voiceTaskUnable: SageReference<AudioEvent>? = null,
    @SageIniName("WeaponSet") val weaponSet: List<WeaponSet> = emptyList(),
    @SageIniName("ArmorSet") val armorSet: List<ArmorSet> = emptyList(),
    @SageIniName("AutoResolve") val autoResolve: List<AutoResolveEntry> = emptyList(),
    @SageIniName("UnitSpecificSounds") val unitSpecificSounds: List<UnitSpecificSounds> = emptyList(),
    @SageIniName("LocomotorSet") val locomotorSet: List<LocomotorSet> = emptyList(),
    @SageIniName("Draw") val draw: List<SageDraw> = emptyList(),
    @SageIniName("AddModule") val addModule: List<AddModule> = emptyList(),
    @SageIniName("ReplaceModule") val replaceModule: List<ReplaceModule> = emptyList(),
    @SageIniName("InheritableModule") val inheritableModule: List<InheritableModule> = emptyList(),
    val geometry: List<GeometryShape> = emptyList(),
    @SageIniName("RemoveModule") val removeModule: List<Untyped> = emptyList(),
    @SageIniName("ThreatBreakdown") val threatBreakdown: List<ThreatBreakdown> = emptyList(),
    @SageIniName("Flammability") val flammability: List<Flammability> = emptyList(),
    @SageIniName("FormationPreviewDecal") val formationPreviewDecal: List<FormationPreviewDecal> = emptyList(),
    @SageIniName("FormationPreviewItemDecal") val formationPreviewItemDecal: List<FormationPreviewItemDecal> = emptyList(),
    @SageIniName("Behavior") val behavior: List<SageBehavior> = emptyList(),
    @SageIniName("Body") val body: List<SageBehavior> = emptyList(),
    @SageIniName("ClientUpdate") val clientUpdate: List<SageBehavior> = emptyList(),
    @SageIniName("ClientBehavior") val clientBehavior: List<SageBehavior> = emptyList(),
)
