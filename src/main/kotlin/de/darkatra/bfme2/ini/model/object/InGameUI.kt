package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.ui.RadiusCursorTemplate
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.Untyped

data class InGameUI(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MaxSelectionSize") val maxSelectionSize: Int = 0,
    @SageIniName("MessageColor1") val messageColor1: Rgba? = null,
    @SageIniName("MessageColor2") val messageColor2: Rgba? = null,
    @SageIniName("MessagePosition") val messagePosition: Coords? = null,
    @SageIniName("MessagePositionLW") val messagePositionLW: Coords? = null,
    @SageIniName("MessageFont") val messageFont: Untyped? = null,
    @SageIniName("MessagePointSize") val messagePointSize: Int = 0,
    @SageIniName("MessageDelayMS") val messageDelayMS: Int = 0,
    @SageIniName("MilitaryCaptionColor") val militaryCaptionColor: Rgba? = null,
    @SageIniName("MilitaryCaptionPosition") val militaryCaptionPosition: Coords? = null,
    @SageIniName("MilitaryCaptionCentered") val militaryCaptionCentered: Boolean = false,
    @SageIniName("MilitaryCaptionTitleFont") val militaryCaptionTitleFont: Untyped? = null,
    @SageIniName("MilitaryCaptionTitlePointSize") val militaryCaptionTitlePointSize: Int = 0,
    @SageIniName("MilitaryCaptionTitleBold") val militaryCaptionTitleBold: Boolean = false,
    @SageIniName("MilitaryCaptionFont") val militaryCaptionFont: Untyped? = null,
    @SageIniName("MilitaryCaptionPointSize") val militaryCaptionPointSize: Int = 0,
    @SageIniName("MilitaryCaptionBold") val militaryCaptionBold: Boolean = false,
    @SageIniName("MilitaryCaptionDelayMS") val militaryCaptionDelayMS: Int = 0,
    @SageIniName("DrawableCaptionFont") val drawableCaptionFont: Untyped? = null,
    @SageIniName("DrawableCaptionPointSize") val drawableCaptionPointSize: Int = 0,
    @SageIniName("DrawableCaptionBold") val drawableCaptionBold: Boolean = false,
    @SageIniName("DrawableCaptionColor") val drawableCaptionColor: Rgba? = null,
    @SageIniName("SuperweaponCountdownPosition") val superweaponCountdownPosition: Coords? = null,
    @SageIniName("SuperweaponCountdownFlashDuration") val superweaponCountdownFlashDuration: Int = 0,
    @SageIniName("SuperweaponCountdownFlashColor") val superweaponCountdownFlashColor: Rgba? = null,
    @SageIniName("SuperweaponCountdownNormalFont") val superweaponCountdownNormalFont: Untyped? = null,
    @SageIniName("SuperweaponCountdownNormalPointSize") val superweaponCountdownNormalPointSize: Int = 0,
    @SageIniName("SuperweaponCountdownNormalBold") val superweaponCountdownNormalBold: Boolean = false,
    @SageIniName("SuperweaponCountdownReadyFont") val superweaponCountdownReadyFont: Untyped? = null,
    @SageIniName("SuperweaponCountdownReadyPointSize") val superweaponCountdownReadyPointSize: Int = 0,
    @SageIniName("SuperweaponCountdownReadyBold") val superweaponCountdownReadyBold: Boolean = false,
    @SageIniName("NamedTimerCountdownPosition") val namedTimerCountdownPosition: Coords? = null,
    @SageIniName("NamedTimerCountdownFlashDuration") val namedTimerCountdownFlashDuration: Int = 0,
    @SageIniName("NamedTimerCountdownFlashColor") val namedTimerCountdownFlashColor: Rgba? = null,
    @SageIniName("NamedTimerCountdownNormalFont") val namedTimerCountdownNormalFont: Untyped? = null,
    @SageIniName("NamedTimerCountdownNormalPointSize") val namedTimerCountdownNormalPointSize: Int = 0,
    @SageIniName("NamedTimerCountdownNormalBold") val namedTimerCountdownNormalBold: Boolean = false,
    @SageIniName("NamedTimerCountdownNormalColor") val namedTimerCountdownNormalColor: Rgba? = null,
    @SageIniName("NamedTimerCountdownReadyFont") val namedTimerCountdownReadyFont: Untyped? = null,
    @SageIniName("NamedTimerCountdownReadyPointSize") val namedTimerCountdownReadyPointSize: Int = 0,
    @SageIniName("NamedTimerCountdownReadyBold") val namedTimerCountdownReadyBold: Boolean = false,
    @SageIniName("NamedTimerCountdownReadyColor") val namedTimerCountdownReadyColor: Rgba? = null,
    @SageIniName("HelpBoxNameFont") val helpBoxNameFont: Untyped? = null,
    @SageIniName("HelpBoxNamePointSize") val helpBoxNamePointSize: Int = 0,
    @SageIniName("HelpBoxNameBold") val helpBoxNameBold: Boolean = false,
    @SageIniName("HelpBoxNameColor") val helpBoxNameColor: Rgba? = null,
    @SageIniName("HelpBoxCostFont") val helpBoxCostFont: Untyped? = null,
    @SageIniName("HelpBoxCostPointSize") val helpBoxCostPointSize: Int = 0,
    @SageIniName("HelpBoxCostBold") val helpBoxCostBold: Boolean = false,
    @SageIniName("HelpBoxCostColor") val helpBoxCostColor: Rgba? = null,
    @SageIniName("HelpBoxShortcutFont") val helpBoxShortcutFont: Untyped? = null,
    @SageIniName("HelpBoxShortcutPointSize") val helpBoxShortcutPointSize: Int = 0,
    @SageIniName("HelpBoxShortcutBold") val helpBoxShortcutBold: Boolean = false,
    @SageIniName("HelpBoxShortcutColor") val helpBoxShortcutColor: Rgba? = null,
    @SageIniName("HelpBoxDescriptionFont") val helpBoxDescriptionFont: Untyped? = null,
    @SageIniName("HelpBoxDescriptionPointSize") val helpBoxDescriptionPointSize: Int = 0,
    @SageIniName("HelpBoxDescriptionBold") val helpBoxDescriptionBold: Boolean = false,
    @SageIniName("HelpBoxDescriptionColor") val helpBoxDescriptionColor: Rgba? = null,
    @SageIniName("FloatingTextTimeOut") val floatingTextTimeOut: Int = 0,
    @SageIniName("FloatingTextMoveUpSpeed") val floatingTextMoveUpSpeed: Int = 0,
    @SageIniName("FloatingTextVanishRate") val floatingTextVanishRate: Int = 0,
    @SageIniName("DrawRMBScrollAnchor") val drawRMBScrollAnchor: Boolean = false,
    @SageIniName("MoveRMBScrollAnchor") val moveRMBScrollAnchor: Boolean = false,
    @SageIniName("UnitHelpTextDelay") val unitHelpTextDelay: Double = 0.0,
    @SageIniName("SelectNearestBuilderCycleTimeOut") val selectNearestBuilderCycleTimeOut: Int = 0,
    @SageIniName("TerrainResourceClaimDecal") val terrainResourceClaimDecal: Opaque? = null,
    @SageIniName("PlaceTerrainResourceClaimantDecal") val placeTerrainResourceClaimantDecal: Opaque? = null,
    @SageIniName("PlaceTerrainResourceClaimantFont") val placeTerrainResourceClaimantFont: Untyped? = null,
    @SageIniName("PlaceTerrainResourceClaimantFontColor") val placeTerrainResourceClaimantFontColor: Rgba? = null,
    @SageIniName("HeroInitialSpawnNotificationMessage") val heroInitialSpawnNotificationMessage: String = "",
    @SageIniName("HeroInitialSpawnNotificationTimeout") val heroInitialSpawnNotificationTimeout: Double = 0.0,
    @SageIniName("HeroRespawnNotificationMessage") val heroRespawnNotificationMessage: String = "",
    @SageIniName("HeroRespawnNotificationTimeout") val heroRespawnNotificationTimeout: Double = 0.0,
    @SageIniName("HeroDeathNotificationMessage") val heroDeathNotificationMessage: String = "",
    @SageIniName("HeroDeathNotificationTimeout") val heroDeathNotificationTimeout: Double = 0.0,
    @SageIniName("HeroEarnedAwardNotificationMessage") val heroEarnedAwardNotificationMessage: String = "",
    @SageIniName("HeroEarnedAwardNotificationTimeout") val heroEarnedAwardNotificationTimeout: Double = 0.0,
    @SageIniName("RadiusCursorUseWeaponScatterRadius") val radiusCursorUseWeaponScatterRadius: Opaque? = null,
    @SageIniName("A10StrikeRadiusCursor") val a10StrikeRadiusCursor: Opaque? = null,
    @SageIniName("AmbulanceRadiusCursor") val ambulanceRadiusCursor: Opaque? = null,
    @SageIniName("AmbushRadiusCursor") val ambushRadiusCursor: Opaque? = null,
    @SageIniName("AnthraxBombRadiusCursor") val anthraxBombRadiusCursor: Opaque? = null,
    @SageIniName("ArcheryTrainingRadiusCursor") val archeryTrainingRadiusCursor: Opaque? = null,
    @SageIniName("ArmyOfTheDeadRadiusCursor") val armyOfTheDeadRadiusCursor: Opaque? = null,
    @SageIniName("ArrowStormRadiusCursor") val arrowStormRadiusCursor: Opaque? = null,
    @SageIniName("ArtilleryRadiusCursor") val artilleryRadiusCursor: Opaque? = null,
    @SageIniName("AthelasRadiusCursor") val athelasRadiusCursor: Opaque? = null,
    @SageIniName("AttackContinueAreaRadiusCursor") val attackContinueAreaRadiusCursor: Opaque? = null,
    @SageIniName("AttackDamageAreaRadiusCursor") val attackDamageAreaRadiusCursor: Opaque? = null,
    @SageIniName("AttackScatterAreaRadiusCursor") val attackScatterAreaRadiusCursor: Opaque? = null,
    @SageIniName("CaptainOfGondorRadiusCursor") val captainOfGondorRadiusCursor: Opaque? = null,
    @SageIniName("CarpetBombRadiusCursor") val carpetBombRadiusCursor: Opaque? = null,
    @SageIniName("ClearMinesRadiusCursor") val clearMinesRadiusCursor: Opaque? = null,
    @SageIniName("ClusterMinesRadiusCursor") val clusterMinesRadiusCursor: Opaque? = null,
    @SageIniName("DaisyCutterRadiusCursor") val daisyCutterRadiusCursor: Opaque? = null,
    @SageIniName("DevastationRadiusCursor") val devastationRadiusCursor: Opaque? = null,
    @SageIniName("DominateRadiusCursor") val dominateRadiusCursor: Opaque? = null,
    @SageIniName("EMPPulseRadiusCursor") val eMPPulseRadiusCursor: Opaque? = null,
    @SageIniName("EagleAlliesRadiusCursor") val eagleAlliesRadiusCursor: Opaque? = null,
    @SageIniName("EagleSwoopRadiusCursor") val eagleSwoopRadiusCursor: Opaque? = null,
    @SageIniName("ElvenAlliesRadiusCursor") val elvenAlliesRadiusCursor: Opaque? = null,
    @SageIniName("ElvenWoodRadiusCursor") val elvenWoodRadiusCursor: Opaque? = null,
    @SageIniName("EmergencyRepairRadiusCursor") val emergencyRepairRadiusCursor: Opaque? = null,
    @SageIniName("EntAlliesRadiusCursor") val entAlliesRadiusCursor: Opaque? = null,
    @SageIniName("EyeOfSauronRadiusCursor") val eyeOfSauronRadiusCursor: Opaque? = null,
    @SageIniName("FellBeastSwoopRadiusCursor") val fellBeastSwoopRadiusCursor: Opaque? = null,
    @SageIniName("FireBreathRadiusCursor") val fireBreathRadiusCursor: Opaque? = null,
    @SageIniName("FrenzyRadiusCursor") val frenzyRadiusCursor: Opaque? = null,
    @SageIniName("FriendlySpecialPowerRadiusCursor") val friendlySpecialPowerRadiusCursor: Opaque? = null,
    @SageIniName("GuardAreaRadiusCursor") val guardAreaRadiusCursor: Opaque? = null,
    @SageIniName("HealRadiusCursor") val healRadiusCursor: Opaque? = null,
    @SageIniName("HelixNapalmBombRadiusCursor") val helixNapalmBombRadiusCursor: Opaque? = null,
    @SageIniName("IndustryRadiusCursor") val industryRadiusCursor: Opaque? = null,
    @SageIniName("KingsFavorRadiusCursor") val kingsFavorRadiusCursor: Opaque? = null,
    @SageIniName("LeapRadiusCursor") val leapRadiusCursor: Opaque? = null,
    @SageIniName("LightningSwordRadiusCursor") val lightningSwordRadiusCursor: Opaque? = null,
    @SageIniName("MessageBold") val messageBold: Boolean = false,
    @SageIniName("MilitaryCaptionRandomizeTyping") val militaryCaptionRandomizeTyping: Boolean = false,
    @SageIniName("NapalmStrikeRadiusCursor") val napalmStrikeRadiusCursor: Opaque? = null,
    @SageIniName("NuclearMissileRadiusCursor") val nuclearMissileRadiusCursor: Opaque? = null,
    @SageIniName("OffensiveSpecialPowerRadiusCursor") val offensiveSpecialPowerRadiusCursor: Opaque? = null,
    @SageIniName("PalantirVisionRadiusCursor") val palantirVisionRadiusCursor: Opaque? = null,
    @SageIniName("ParadropRadiusCursor") val paradropRadiusCursor: Opaque? = null,
    @SageIniName("ParticleCannonRadiusCursor") val particleCannonRadiusCursor: Opaque? = null,
    @SageIniName("PopupMessageColor") val popupMessageColor: Rgba? = null,
    @SageIniName("RadarRadiusCursor") val radarRadiusCursor: Opaque? = null,
    @SageIniName("RohanAlliesRadiusCursor") val rohanAlliesRadiusCursor: Opaque? = null,
    @SageIniName("ScudStormRadiusCursor") val scudStormRadiusCursor: Opaque? = null,
    @SageIniName("SpectreGunshipRadiusCursor") val spectreGunshipRadiusCursor: Opaque? = null,
    @SageIniName("SpeechCraftRadiusCursor") val speechCraftRadiusCursor: Opaque? = null,
    @SageIniName("SpyDroneRadiusCursor") val spyDroneRadiusCursor: Opaque? = null,
    @SageIniName("SpySatelliteRadiusCursor") val spySatelliteRadiusCursor: Opaque? = null,
    @SageIniName("SummonBalrogRadiusCursor") val summonBalrogRadiusCursor: Opaque? = null,
    @SageIniName("SummonOathBreakersRadiusCursor") val summonOathBreakersRadiusCursor: Opaque? = null,
    @SageIniName("SuperweaponScatterAreaRadiusCursor") val superweaponScatterAreaRadiusCursor: Opaque? = null,
    @SageIniName("TaintRadiusCursor") val taintRadiusCursor: Opaque? = null,
    @SageIniName("TrainingRadiusCursor") val trainingRadiusCursor: Opaque? = null,
    @SageIniName("WarChantRadiusCursor") val warChantRadiusCursor: Opaque? = null,
    @SageIniName("RadiusCursorTemplate") val radiusCursorTemplate: List<RadiusCursorTemplate> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<InGameUI>(
        name = "InGameUI",
        tableKey = "ingameuis",
        properties = {
            property("MaxSelectionSize", IntValue) { it.maxSelectionSize }
            property("MessageColor1", Rgba.type) { it.messageColor1 }
            property("MessageColor2", Rgba.type) { it.messageColor2 }
            property("MessagePosition", Coords.type) { it.messagePosition }
            property("MessagePositionLW", Coords.type) { it.messagePositionLW }
            property("MessageFont", Untyped.type) { it.messageFont }
            property("MessagePointSize", IntValue) { it.messagePointSize }
            property("MessageDelayMS", IntValue) { it.messageDelayMS }
            property("MilitaryCaptionColor", Rgba.type) { it.militaryCaptionColor }
            property("MilitaryCaptionPosition", Coords.type) { it.militaryCaptionPosition }
            property("MilitaryCaptionCentered", BooleanValue) { it.militaryCaptionCentered }
            property("MilitaryCaptionTitleFont", Untyped.type) { it.militaryCaptionTitleFont }
            property("MilitaryCaptionTitlePointSize", IntValue) { it.militaryCaptionTitlePointSize }
            property("MilitaryCaptionTitleBold", BooleanValue) { it.militaryCaptionTitleBold }
            property("MilitaryCaptionFont", Untyped.type) { it.militaryCaptionFont }
            property("MilitaryCaptionPointSize", IntValue) { it.militaryCaptionPointSize }
            property("MilitaryCaptionBold", BooleanValue) { it.militaryCaptionBold }
            property("MilitaryCaptionDelayMS", IntValue) { it.militaryCaptionDelayMS }
            property("DrawableCaptionFont", Untyped.type) { it.drawableCaptionFont }
            property("DrawableCaptionPointSize", IntValue) { it.drawableCaptionPointSize }
            property("DrawableCaptionBold", BooleanValue) { it.drawableCaptionBold }
            property("DrawableCaptionColor", Rgba.type) { it.drawableCaptionColor }
            property("SuperweaponCountdownPosition", Coords.type) { it.superweaponCountdownPosition }
            property("SuperweaponCountdownFlashDuration", IntValue) { it.superweaponCountdownFlashDuration }
            property("SuperweaponCountdownFlashColor", Rgba.type) { it.superweaponCountdownFlashColor }
            property("SuperweaponCountdownNormalFont", Untyped.type) { it.superweaponCountdownNormalFont }
            property("SuperweaponCountdownNormalPointSize", IntValue) { it.superweaponCountdownNormalPointSize }
            property("SuperweaponCountdownNormalBold", BooleanValue) { it.superweaponCountdownNormalBold }
            property("SuperweaponCountdownReadyFont", Untyped.type) { it.superweaponCountdownReadyFont }
            property("SuperweaponCountdownReadyPointSize", IntValue) { it.superweaponCountdownReadyPointSize }
            property("SuperweaponCountdownReadyBold", BooleanValue) { it.superweaponCountdownReadyBold }
            property("NamedTimerCountdownPosition", Coords.type) { it.namedTimerCountdownPosition }
            property("NamedTimerCountdownFlashDuration", IntValue) { it.namedTimerCountdownFlashDuration }
            property("NamedTimerCountdownFlashColor", Rgba.type) { it.namedTimerCountdownFlashColor }
            property("NamedTimerCountdownNormalFont", Untyped.type) { it.namedTimerCountdownNormalFont }
            property("NamedTimerCountdownNormalPointSize", IntValue) { it.namedTimerCountdownNormalPointSize }
            property("NamedTimerCountdownNormalBold", BooleanValue) { it.namedTimerCountdownNormalBold }
            property("NamedTimerCountdownNormalColor", Rgba.type) { it.namedTimerCountdownNormalColor }
            property("NamedTimerCountdownReadyFont", Untyped.type) { it.namedTimerCountdownReadyFont }
            property("NamedTimerCountdownReadyPointSize", IntValue) { it.namedTimerCountdownReadyPointSize }
            property("NamedTimerCountdownReadyBold", BooleanValue) { it.namedTimerCountdownReadyBold }
            property("NamedTimerCountdownReadyColor", Rgba.type) { it.namedTimerCountdownReadyColor }
            property("HelpBoxNameFont", Untyped.type) { it.helpBoxNameFont }
            property("HelpBoxNamePointSize", IntValue) { it.helpBoxNamePointSize }
            property("HelpBoxNameBold", BooleanValue) { it.helpBoxNameBold }
            property("HelpBoxNameColor", Rgba.type) { it.helpBoxNameColor }
            property("HelpBoxCostFont", Untyped.type) { it.helpBoxCostFont }
            property("HelpBoxCostPointSize", IntValue) { it.helpBoxCostPointSize }
            property("HelpBoxCostBold", BooleanValue) { it.helpBoxCostBold }
            property("HelpBoxCostColor", Rgba.type) { it.helpBoxCostColor }
            property("HelpBoxShortcutFont", Untyped.type) { it.helpBoxShortcutFont }
            property("HelpBoxShortcutPointSize", IntValue) { it.helpBoxShortcutPointSize }
            property("HelpBoxShortcutBold", BooleanValue) { it.helpBoxShortcutBold }
            property("HelpBoxShortcutColor", Rgba.type) { it.helpBoxShortcutColor }
            property("HelpBoxDescriptionFont", Untyped.type) { it.helpBoxDescriptionFont }
            property("HelpBoxDescriptionPointSize", IntValue) { it.helpBoxDescriptionPointSize }
            property("HelpBoxDescriptionBold", BooleanValue) { it.helpBoxDescriptionBold }
            property("HelpBoxDescriptionColor", Rgba.type) { it.helpBoxDescriptionColor }
            property("FloatingTextTimeOut", IntValue) { it.floatingTextTimeOut }
            property("FloatingTextMoveUpSpeed", IntValue) { it.floatingTextMoveUpSpeed }
            property("FloatingTextVanishRate", IntValue) { it.floatingTextVanishRate }
            property("DrawRMBScrollAnchor", BooleanValue) { it.drawRMBScrollAnchor }
            property("MoveRMBScrollAnchor", BooleanValue) { it.moveRMBScrollAnchor }
            property("UnitHelpTextDelay", FloatValue) { it.unitHelpTextDelay }
            property("SelectNearestBuilderCycleTimeOut", IntValue) { it.selectNearestBuilderCycleTimeOut }
            property("TerrainResourceClaimDecal", Opaque.type) { it.terrainResourceClaimDecal }
            property("PlaceTerrainResourceClaimantDecal", Opaque.type) { it.placeTerrainResourceClaimantDecal }
            property("PlaceTerrainResourceClaimantFont", Untyped.type) { it.placeTerrainResourceClaimantFont }
            property("PlaceTerrainResourceClaimantFontColor", Rgba.type) { it.placeTerrainResourceClaimantFontColor }
            property("HeroInitialSpawnNotificationMessage", StringValue) { it.heroInitialSpawnNotificationMessage }
            property("HeroInitialSpawnNotificationTimeout", FloatValue) { it.heroInitialSpawnNotificationTimeout }
            property("HeroRespawnNotificationMessage", StringValue) { it.heroRespawnNotificationMessage }
            property("HeroRespawnNotificationTimeout", FloatValue) { it.heroRespawnNotificationTimeout }
            property("HeroDeathNotificationMessage", StringValue) { it.heroDeathNotificationMessage }
            property("HeroDeathNotificationTimeout", FloatValue) { it.heroDeathNotificationTimeout }
            property("HeroEarnedAwardNotificationMessage", StringValue) { it.heroEarnedAwardNotificationMessage }
            property("HeroEarnedAwardNotificationTimeout", FloatValue) { it.heroEarnedAwardNotificationTimeout }
            property("RadiusCursorUseWeaponScatterRadius", Opaque.type) { it.radiusCursorUseWeaponScatterRadius }
            property("A10StrikeRadiusCursor", Opaque.type) { it.a10StrikeRadiusCursor }
            property("AmbulanceRadiusCursor", Opaque.type) { it.ambulanceRadiusCursor }
            property("AmbushRadiusCursor", Opaque.type) { it.ambushRadiusCursor }
            property("AnthraxBombRadiusCursor", Opaque.type) { it.anthraxBombRadiusCursor }
            property("ArcheryTrainingRadiusCursor", Opaque.type) { it.archeryTrainingRadiusCursor }
            property("ArmyOfTheDeadRadiusCursor", Opaque.type) { it.armyOfTheDeadRadiusCursor }
            property("ArrowStormRadiusCursor", Opaque.type) { it.arrowStormRadiusCursor }
            property("ArtilleryRadiusCursor", Opaque.type) { it.artilleryRadiusCursor }
            property("AthelasRadiusCursor", Opaque.type) { it.athelasRadiusCursor }
            property("AttackContinueAreaRadiusCursor", Opaque.type) { it.attackContinueAreaRadiusCursor }
            property("AttackDamageAreaRadiusCursor", Opaque.type) { it.attackDamageAreaRadiusCursor }
            property("AttackScatterAreaRadiusCursor", Opaque.type) { it.attackScatterAreaRadiusCursor }
            property("CaptainOfGondorRadiusCursor", Opaque.type) { it.captainOfGondorRadiusCursor }
            property("CarpetBombRadiusCursor", Opaque.type) { it.carpetBombRadiusCursor }
            property("ClearMinesRadiusCursor", Opaque.type) { it.clearMinesRadiusCursor }
            property("ClusterMinesRadiusCursor", Opaque.type) { it.clusterMinesRadiusCursor }
            property("DaisyCutterRadiusCursor", Opaque.type) { it.daisyCutterRadiusCursor }
            property("DevastationRadiusCursor", Opaque.type) { it.devastationRadiusCursor }
            property("DominateRadiusCursor", Opaque.type) { it.dominateRadiusCursor }
            property("EMPPulseRadiusCursor", Opaque.type) { it.eMPPulseRadiusCursor }
            property("EagleAlliesRadiusCursor", Opaque.type) { it.eagleAlliesRadiusCursor }
            property("EagleSwoopRadiusCursor", Opaque.type) { it.eagleSwoopRadiusCursor }
            property("ElvenAlliesRadiusCursor", Opaque.type) { it.elvenAlliesRadiusCursor }
            property("ElvenWoodRadiusCursor", Opaque.type) { it.elvenWoodRadiusCursor }
            property("EmergencyRepairRadiusCursor", Opaque.type) { it.emergencyRepairRadiusCursor }
            property("EntAlliesRadiusCursor", Opaque.type) { it.entAlliesRadiusCursor }
            property("EyeOfSauronRadiusCursor", Opaque.type) { it.eyeOfSauronRadiusCursor }
            property("FellBeastSwoopRadiusCursor", Opaque.type) { it.fellBeastSwoopRadiusCursor }
            property("FireBreathRadiusCursor", Opaque.type) { it.fireBreathRadiusCursor }
            property("FrenzyRadiusCursor", Opaque.type) { it.frenzyRadiusCursor }
            property("FriendlySpecialPowerRadiusCursor", Opaque.type) { it.friendlySpecialPowerRadiusCursor }
            property("GuardAreaRadiusCursor", Opaque.type) { it.guardAreaRadiusCursor }
            property("HealRadiusCursor", Opaque.type) { it.healRadiusCursor }
            property("HelixNapalmBombRadiusCursor", Opaque.type) { it.helixNapalmBombRadiusCursor }
            property("IndustryRadiusCursor", Opaque.type) { it.industryRadiusCursor }
            property("KingsFavorRadiusCursor", Opaque.type) { it.kingsFavorRadiusCursor }
            property("LeapRadiusCursor", Opaque.type) { it.leapRadiusCursor }
            property("LightningSwordRadiusCursor", Opaque.type) { it.lightningSwordRadiusCursor }
            property("MessageBold", BooleanValue) { it.messageBold }
            property("MilitaryCaptionRandomizeTyping", BooleanValue) { it.militaryCaptionRandomizeTyping }
            property("NapalmStrikeRadiusCursor", Opaque.type) { it.napalmStrikeRadiusCursor }
            property("NuclearMissileRadiusCursor", Opaque.type) { it.nuclearMissileRadiusCursor }
            property("OffensiveSpecialPowerRadiusCursor", Opaque.type) { it.offensiveSpecialPowerRadiusCursor }
            property("PalantirVisionRadiusCursor", Opaque.type) { it.palantirVisionRadiusCursor }
            property("ParadropRadiusCursor", Opaque.type) { it.paradropRadiusCursor }
            property("ParticleCannonRadiusCursor", Opaque.type) { it.particleCannonRadiusCursor }
            property("PopupMessageColor", Rgba.type) { it.popupMessageColor }
            property("RadarRadiusCursor", Opaque.type) { it.radarRadiusCursor }
            property("RohanAlliesRadiusCursor", Opaque.type) { it.rohanAlliesRadiusCursor }
            property("ScudStormRadiusCursor", Opaque.type) { it.scudStormRadiusCursor }
            property("SpectreGunshipRadiusCursor", Opaque.type) { it.spectreGunshipRadiusCursor }
            property("SpeechCraftRadiusCursor", Opaque.type) { it.speechCraftRadiusCursor }
            property("SpyDroneRadiusCursor", Opaque.type) { it.spyDroneRadiusCursor }
            property("SpySatelliteRadiusCursor", Opaque.type) { it.spySatelliteRadiusCursor }
            property("SummonBalrogRadiusCursor", Opaque.type) { it.summonBalrogRadiusCursor }
            property("SummonOathBreakersRadiusCursor", Opaque.type) { it.summonOathBreakersRadiusCursor }
            property("SuperweaponScatterAreaRadiusCursor", Opaque.type) { it.superweaponScatterAreaRadiusCursor }
            property("TaintRadiusCursor", Opaque.type) { it.taintRadiusCursor }
            property("TrainingRadiusCursor", Opaque.type) { it.trainingRadiusCursor }
            property("WarChantRadiusCursor", Opaque.type) { it.warChantRadiusCursor }
            property("RadiusCursorTemplate", ListValue(BlockValue<RadiusCursorTemplate> { listOf(RadiusCursorTemplate) })) { it.radiusCursorTemplate }
        },
    )
}
