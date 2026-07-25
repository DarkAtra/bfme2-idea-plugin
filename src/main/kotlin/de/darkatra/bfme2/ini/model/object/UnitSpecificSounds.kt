package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.SageReference

data class UnitSpecificSounds(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("UnderConstruction") val underConstruction: SageReference<AudioEvent>? = null,
    @SageIniName("UnderRepairFromRubble") val underRepairFromRubble: SageReference<AudioEvent>? = null,
    @SageIniName("UnderRepairFromDamage") val underRepairFromDamage: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceGarrison") val voiceGarrison: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceInitiateCaptureBuilding") val voiceInitiateCaptureBuilding: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterUnitElvenTransportShip") val voiceEnterUnitElvenTransportShip: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterUnitSlaughterHouse") val voiceEnterUnitSlaughterHouse: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterUnitMordorMumakil") val voiceEnterUnitMordorMumakil: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterUnitEvilMenTransportShip") val voiceEnterUnitEvilMenTransportShip: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterUnitTransportShip") val voiceEnterUnitTransportShip: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnter") val voiceEnter: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterHostile") val voiceEnterHostile: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceGetHealed") val voiceGetHealed: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceMoveToTrees") val voiceMoveToTrees: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceDesperateAttack") val voiceDesperateAttack: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateMoveToTrees") val voiceEnterStateMoveToTrees: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceBuildResponse") val voiceBuildResponse: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceExtinguishFireAtLocation") val voiceExtinguishFireAtLocation: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceNoBuild") val voiceNoBuild: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSelectIdleWorker") val voiceSelectIdleWorker: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceCreatedFromInn") val voiceCreatedFromInn: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceFullyCreatedFromInn") val voiceFullyCreatedFromInn: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackUnitWebbedHumanoidWithGondorFighterInside") val voiceAttackUnitWebbedHumanoidWithGondorFighterInside: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackUnitWebbedHumanoidWithGondorArcherInside") val voiceAttackUnitWebbedHumanoidWithGondorArcherInside: SageReference<AudioEvent>? = null,
    @SageIniName("VoicePrimaryWeaponMode") val voicePrimaryWeaponMode: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSecondaryWeaponMode") val voiceSecondaryWeaponMode: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceEnterStateInitiateCaptureBuilding") val voiceEnterStateInitiateCaptureBuilding: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceRepair") val voiceRepair: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackFireball") val voiceAttackFireball: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackUnitRohanEntBirch") val voiceAttackUnitRohanEntBirch: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackUnitRohanEntFir") val voiceAttackUnitRohanEntFir: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackUnitRohanTreeBerd") val voiceAttackUnitRohanTreeBerd: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceAttackUnitRohanEntAsh") val voiceAttackUnitRohanEntAsh: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSupply") val voiceSupply: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceStartCharging") val voiceStartCharging: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceInitiateBarbedArrowAttack") val voiceInitiateBarbedArrowAttack: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceSpecialAbilityCurseEnemy") val voiceSpecialAbilityCurseEnemy: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceInitiatePoisonArrowAttack") val voiceInitiatePoisonArrowAttack: SageReference<AudioEvent>? = null,
    @SageIniName("VoiceInitiateBlackArrowsAttack") val voiceInitiateBlackArrowsAttack: SageReference<AudioEvent>? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<UnitSpecificSounds>(
        name = "UnitSpecificSounds",
        properties = {
            property("UnderConstruction", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.underConstruction }
            property("UnderRepairFromRubble", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.underRepairFromRubble }
            property("UnderRepairFromDamage", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.underRepairFromDamage }
            property("VoiceGarrison", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceGarrison }
            property("VoiceInitiateCaptureBuilding", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceInitiateCaptureBuilding }
            property("VoiceEnterUnitElvenTransportShip", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterUnitElvenTransportShip }
            property("VoiceEnterUnitSlaughterHouse", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterUnitSlaughterHouse }
            property("VoiceEnterUnitMordorMumakil", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterUnitMordorMumakil }
            property("VoiceEnterUnitEvilMenTransportShip", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterUnitEvilMenTransportShip }
            property("VoiceEnterUnitTransportShip", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterUnitTransportShip }
            property("VoiceEnter", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnter }
            property("VoiceEnterHostile", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterHostile }
            property("VoiceGetHealed", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceGetHealed }
            property("VoiceMoveToTrees", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceMoveToTrees }
            property("VoiceDesperateAttack", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceDesperateAttack }
            property("VoiceEnterStateMoveToTrees", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateMoveToTrees }
            property("VoiceBuildResponse", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceBuildResponse }
            property("VoiceExtinguishFireAtLocation", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceExtinguishFireAtLocation }
            property("VoiceNoBuild", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceNoBuild }
            property("VoiceSelectIdleWorker", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceSelectIdleWorker }
            property("VoiceCreatedFromInn", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceCreatedFromInn }
            property("VoiceFullyCreatedFromInn", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceFullyCreatedFromInn }
            property(
                "VoiceAttackUnitWebbedHumanoidWithGondorFighterInside",
                ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackUnitWebbedHumanoidWithGondorFighterInside }
            property(
                "VoiceAttackUnitWebbedHumanoidWithGondorArcherInside",
                ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackUnitWebbedHumanoidWithGondorArcherInside }
            property("VoicePrimaryWeaponMode", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voicePrimaryWeaponMode }
            property("VoiceSecondaryWeaponMode", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceSecondaryWeaponMode }
            property("VoiceEnterStateInitiateCaptureBuilding", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceEnterStateInitiateCaptureBuilding }
            property("VoiceRepair", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceRepair }
            property("VoiceAttackFireball", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackFireball }
            property("VoiceAttackUnitRohanEntBirch", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackUnitRohanEntBirch }
            property("VoiceAttackUnitRohanEntFir", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackUnitRohanEntFir }
            property("VoiceAttackUnitRohanTreeBerd", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackUnitRohanTreeBerd }
            property("VoiceAttackUnitRohanEntAsh", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceAttackUnitRohanEntAsh }
            property("VoiceSupply", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceSupply }
            property("VoiceStartCharging", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceStartCharging }
            property("VoiceInitiateBarbedArrowAttack", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceInitiateBarbedArrowAttack }
            property("VoiceSpecialAbilityCurseEnemy", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceSpecialAbilityCurseEnemy }
            property("VoiceInitiatePoisonArrowAttack", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceInitiatePoisonArrowAttack }
            property("VoiceInitiateBlackArrowsAttack", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.voiceInitiateBlackArrowsAttack }
        },
    )
}
