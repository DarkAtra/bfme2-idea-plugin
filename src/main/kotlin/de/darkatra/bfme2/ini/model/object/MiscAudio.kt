package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference

data class MiscAudio(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RadarNotifyHarvesterUnderAttackSound") val radarNotifyHarvesterUnderAttackSound: SageReference<AudioEvent>? = null,
    @SageIniName("RadarNotifyStructureUnderAttackSound") val radarNotifyStructureUnderAttackSound: SageReference<AudioEvent>? = null,
    @SageIniName("RadarNotifyInfiltrationSound") val radarNotifyInfiltrationSound: SageReference<AudioEvent>? = null,
    @SageIniName("RadarNotifyOnlineSound") val radarNotifyOnlineSound: SageReference<AudioEvent>? = null,
    @SageIniName("RadarNotifyOfflineSound") val radarNotifyOfflineSound: SageReference<AudioEvent>? = null,
    @SageIniName("GenericRadarEvent") val genericRadarEvent: SageReference<AudioEvent>? = null,
    @SageIniName("BeaconPlacedSound") val beaconPlacedSound: SageReference<AudioEvent>? = null,
    @SageIniName("BeaconPlacementFailed") val beaconPlacementFailed: SageReference<AudioEvent>? = null,
    @SageIniName("DefectorTimerTickSound") val defectorTimerTickSound: SageReference<AudioEvent>? = null,
    @SageIniName("DefectorTimerDingSound") val defectorTimerDingSound: SageReference<AudioEvent>? = null,
    @SageIniName("AllCheerSound") val allCheerSound: SageReference<AudioEvent>? = null,
    @SageIniName("NoCanDoSound") val noCanDoSound: SageReference<AudioEvent>? = null,
    @SageIniName("StealthDiscoveredSound") val stealthDiscoveredSound: SageReference<AudioEvent>? = null,
    @SageIniName("StealthNeutralizedSound") val stealthNeutralizedSound: SageReference<AudioEvent>? = null,
    @SageIniName("MoneyDepositSound") val moneyDepositSound: SageReference<AudioEvent>? = null,
    @SageIniName("MoneyWithdrawSound") val moneyWithdrawSound: SageReference<AudioEvent>? = null,
    @SageIniName("BuildingDisabled") val buildingDisabled: SageReference<AudioEvent>? = null,
    @SageIniName("BuildingReenabled") val buildingReenabled: SageReference<AudioEvent>? = null,
    @SageIniName("VehicleDisabled") val vehicleDisabled: SageReference<AudioEvent>? = null,
    @SageIniName("VehicleReenabled") val vehicleReenabled: SageReference<AudioEvent>? = null,
    @SageIniName("SplatterVehiclePilotsBrain") val splatterVehiclePilotsBrain: SageReference<AudioEvent>? = null,
    @SageIniName("CrateHeal") val crateHeal: SageReference<AudioEvent>? = null,
    @SageIniName("CrateShroud") val crateShroud: SageReference<AudioEvent>? = null,
    @SageIniName("CrateFreeUnit") val crateFreeUnit: SageReference<AudioEvent>? = null,
    @SageIniName("CrateMoney") val crateMoney: SageReference<AudioEvent>? = null,
    @SageIniName("UnitPromoted") val unitPromoted: SageReference<AudioEvent>? = null,
    @SageIniName("RepairSparks") val repairSparks: SageReference<AudioEvent>? = null,
    @SageIniName("EnterCloseCombat") val enterCloseCombat: SageReference<AudioEvent>? = null,
    @SageIniName("ExitCloseCombat") val exitCloseCombat: SageReference<AudioEvent>? = null,
    @SageIniName("IncomingChatNotification") val incomingChatNotification: SageReference<AudioEvent>? = null,
    @SageIniName("PrivateMessageNotification") val privateMessageNotification: SageReference<AudioEvent>? = null,
    @SageIniName("BuddyMessageNotification") val buddyMessageNotification: SageReference<AudioEvent>? = null,
    @SageIniName("GameSpyCommunicatorOpen") val gameSpyCommunicatorOpen: SageReference<AudioEvent>? = null,
    @SageIniName("EnabledHotKeyPressed") val enabledHotKeyPressed: SageReference<AudioEvent>? = null,
    @SageIniName("DisabledHotKeyPressed") val disabledHotKeyPressed: SageReference<AudioEvent>? = null,
    @SageIniName("DisabledButtonClicked") val disabledButtonClicked: SageReference<AudioEvent>? = null,
    @SageIniName("LowLODShellMusic") val lowLODShellMusic: SageReference<AudioEvent>? = null,
    @SageIniName("HighLODShellMusic") val highLODShellMusic: SageReference<AudioEvent>? = null,
    @SageIniName("ScoreScreenMusic") val scoreScreenMusic: SageReference<AudioEvent>? = null,
    @SageIniName("ShellMapLoadMusic") val shellMapLoadMusic: SageReference<AudioEvent>? = null,
    @SageIniName("FullScreenSubMenuMusic") val fullScreenSubMenuMusic: SageReference<AudioEvent>? = null,
    @SageIniName("SaveFileLoadMusic") val saveFileLoadMusic: SageReference<AudioEvent>? = null,
    @SageIniName("CreditsMusic") val creditsMusic: SageReference<AudioEvent>? = null,
    @SageIniName("VolumeSampleMusic") val volumeSampleMusic: SageReference<AudioEvent>? = null,
    @SageIniName("VolumeSampleSoundFX") val volumeSampleSoundFX: SageReference<AudioEvent>? = null,
    @SageIniName("VolumeSampleVoice") val volumeSampleVoice: SageReference<AudioEvent>? = null,
    @SageIniName("VolumeSampleAmbient") val volumeSampleAmbient: SageReference<AudioEvent>? = null,
    @SageIniName("VolumeSampleMovie") val volumeSampleMovie: SageReference<AudioEvent>? = null,
    @SageIniName("MissionBriefingCharacterClick") val missionBriefingCharacterClick: SageReference<AudioEvent>? = null,
    @SageIniName("ComboBoxClick") val comboBoxClick: SageReference<AudioEvent>? = null,
    @SageIniName("RIFThingTemplateReloadedSound") val rIFThingTemplateReloadedSound: SageReference<AudioEvent>? = null,
    @SageIniName("RIFObjectsRefreshedSound") val rIFObjectsRefreshedSound: SageReference<AudioEvent>? = null,
    @SageIniName("FastForwardModeOn") val fastForwardModeOn: SageReference<AudioEvent>? = null,
    @SageIniName("FastForwardModeOff") val fastForwardModeOff: SageReference<AudioEvent>? = null,
    @SageIniName("RallyPointSet") val rallyPointSet: SageReference<AudioEvent>? = null,
    @SageIniName("UnableToSetRallyPoint") val unableToSetRallyPoint: SageReference<AudioEvent>? = null,
    @SageIniName("PlanningModeOrderGiven") val planningModeOrderGiven: SageReference<AudioEvent>? = null,
    @SageIniName("BuildingPlacementSound") val buildingPlacementSound: SageReference<AudioEvent>? = null,
    @SageIniName("BadBuildingPlacementSound") val badBuildingPlacementSound: SageReference<AudioEvent>? = null,
    @SageIniName("WallPlacementSound") val wallPlacementSound: SageReference<AudioEvent>? = null,
    @SageIniName("TargetObjectWithSpecialPowerSound") val targetObjectWithSpecialPowerSound: SageReference<AudioEvent>? = null,
    @SageIniName("AircraftWheelScreech") val aircraftWheelScreech: Opaque? = null,
    @SageIniName("BattleCrySound") val battleCrySound: Opaque? = null,
    @SageIniName("CrateSalvage") val crateSalvage: Opaque? = null,
    @SageIniName("GUIClickSound") val gUIClickSound: SageReference<AudioEvent>? = null,
    @SageIniName("LockonTickSound") val lockonTickSound: Opaque? = null,
    @SageIniName("RadarNotifyUnderAttackSound") val radarNotifyUnderAttackSound: Opaque? = null,
    @SageIniName("RadarNotifyUnitUnderAttackSound") val radarNotifyUnitUnderAttackSound: Opaque? = null,
    @SageIniName("SabotageResetTimeBuilding") val sabotageResetTimeBuilding: Opaque? = null,
    @SageIniName("SabotageShutDownBuilding") val sabotageShutDownBuilding: Opaque? = null,
    @SageIniName("TerroristInCarAttackVoice") val terroristInCarAttackVoice: Opaque? = null,
    @SageIniName("TerroristInCarMoveVoice") val terroristInCarMoveVoice: Opaque? = null,
    @SageIniName("TerroristInCarSelectVoice") val terroristInCarSelectVoice: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<MiscAudio>(
        name = "MiscAudio",
        tableKey = "miscaudios",
        properties = {
            property("RadarNotifyHarvesterUnderAttackSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.radarNotifyHarvesterUnderAttackSound }
            property("RadarNotifyStructureUnderAttackSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.radarNotifyStructureUnderAttackSound }
            property("RadarNotifyInfiltrationSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.radarNotifyInfiltrationSound }
            property("RadarNotifyOnlineSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.radarNotifyOnlineSound }
            property("RadarNotifyOfflineSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.radarNotifyOfflineSound }
            property("GenericRadarEvent", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.genericRadarEvent }
            property("BeaconPlacedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.beaconPlacedSound }
            property("BeaconPlacementFailed", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.beaconPlacementFailed }
            property("DefectorTimerTickSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.defectorTimerTickSound }
            property("DefectorTimerDingSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.defectorTimerDingSound }
            property("AllCheerSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.allCheerSound }
            property("NoCanDoSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.noCanDoSound }
            property("StealthDiscoveredSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.stealthDiscoveredSound }
            property("StealthNeutralizedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.stealthNeutralizedSound }
            property("MoneyDepositSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.moneyDepositSound }
            property("MoneyWithdrawSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.moneyWithdrawSound }
            property("BuildingDisabled", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.buildingDisabled }
            property("BuildingReenabled", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.buildingReenabled }
            property("VehicleDisabled", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.vehicleDisabled }
            property("VehicleReenabled", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.vehicleReenabled }
            property("SplatterVehiclePilotsBrain", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.splatterVehiclePilotsBrain }
            property("CrateHeal", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.crateHeal }
            property("CrateShroud", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.crateShroud }
            property("CrateFreeUnit", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.crateFreeUnit }
            property("CrateMoney", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.crateMoney }
            property("UnitPromoted", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.unitPromoted }
            property("RepairSparks", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.repairSparks }
            property("EnterCloseCombat", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.enterCloseCombat }
            property("ExitCloseCombat", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.exitCloseCombat }
            property("IncomingChatNotification", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.incomingChatNotification }
            property("PrivateMessageNotification", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.privateMessageNotification }
            property("BuddyMessageNotification", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.buddyMessageNotification }
            property("GameSpyCommunicatorOpen", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.gameSpyCommunicatorOpen }
            property("EnabledHotKeyPressed", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.enabledHotKeyPressed }
            property("DisabledHotKeyPressed", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.disabledHotKeyPressed }
            property("DisabledButtonClicked", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.disabledButtonClicked }
            property("LowLODShellMusic", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.lowLODShellMusic }
            property("HighLODShellMusic", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.highLODShellMusic }
            property("ScoreScreenMusic", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.scoreScreenMusic }
            property("ShellMapLoadMusic", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.shellMapLoadMusic }
            property("FullScreenSubMenuMusic", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.fullScreenSubMenuMusic }
            property("SaveFileLoadMusic", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.saveFileLoadMusic }
            property("CreditsMusic", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.creditsMusic }
            property("VolumeSampleMusic", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.volumeSampleMusic }
            property("VolumeSampleSoundFX", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.volumeSampleSoundFX }
            property("VolumeSampleVoice", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.volumeSampleVoice }
            property("VolumeSampleAmbient", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.volumeSampleAmbient }
            property("VolumeSampleMovie", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.volumeSampleMovie }
            property("MissionBriefingCharacterClick", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.missionBriefingCharacterClick }
            property("ComboBoxClick", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.comboBoxClick }
            property("RIFThingTemplateReloadedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.rIFThingTemplateReloadedSound }
            property("RIFObjectsRefreshedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.rIFObjectsRefreshedSound }
            property("FastForwardModeOn", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.fastForwardModeOn }
            property("FastForwardModeOff", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.fastForwardModeOff }
            property("RallyPointSet", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.rallyPointSet }
            property("UnableToSetRallyPoint", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.unableToSetRallyPoint }
            property("PlanningModeOrderGiven", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.planningModeOrderGiven }
            property("BuildingPlacementSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.buildingPlacementSound }
            property("BadBuildingPlacementSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.badBuildingPlacementSound }
            property("WallPlacementSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.wallPlacementSound }
            property("TargetObjectWithSpecialPowerSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.targetObjectWithSpecialPowerSound }
            property("AircraftWheelScreech", Opaque.type) { it.aircraftWheelScreech }
            property("BattleCrySound", Opaque.type) { it.battleCrySound }
            property("CrateSalvage", Opaque.type) { it.crateSalvage }
            property("GUIClickSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.gUIClickSound }
            property("LockonTickSound", Opaque.type) { it.lockonTickSound }
            property("RadarNotifyUnderAttackSound", Opaque.type) { it.radarNotifyUnderAttackSound }
            property("RadarNotifyUnitUnderAttackSound", Opaque.type) { it.radarNotifyUnitUnderAttackSound }
            property("SabotageResetTimeBuilding", Opaque.type) { it.sabotageResetTimeBuilding }
            property("SabotageShutDownBuilding", Opaque.type) { it.sabotageShutDownBuilding }
            property("TerroristInCarAttackVoice", Opaque.type) { it.terroristInCarAttackVoice }
            property("TerroristInCarMoveVoice", Opaque.type) { it.terroristInCarMoveVoice }
            property("TerroristInCarSelectVoice", Opaque.type) { it.terroristInCarSelectVoice }
        },
    )
}
