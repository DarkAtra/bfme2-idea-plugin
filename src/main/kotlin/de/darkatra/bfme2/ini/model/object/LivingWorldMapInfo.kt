package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.livingworld.EyeTower
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.TextureFile

data class LivingWorldMapInfo(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MapObject") val mapObject: Opaque? = null,
    @SageIniName("NumWorldTiles") val numWorldTiles: Int = 0,
    @SageIniName("CloudBorderSubObject") val cloudBorderSubObject: Opaque? = null,
    @SageIniName("TextLayerSubObject") val textLayerSubObject: Opaque? = null,
    @SageIniName("AddShadowSubObject") val addShadowSubObject: Opaque? = null,
    @SageIniName("Center") val center: Coords? = null,
    @SageIniName("Extent") val extent: Coords? = null,
    @SageIniName("AptCenter") val aptCenter: Coords? = null,
    @SageIniName("AptZoom") val aptZoom: Double = 0.0,
    @SageIniName("AptPitch") val aptPitch: Double = 0.0,
    @SageIniName("CameraBoundX") val cameraBoundX: Double = 0.0,
    @SageIniName("CameraBoundY") val cameraBoundY: Double = 0.0,
    @SageIniName("ClickScrollThreshold") val clickScrollThreshold: Double = 0.0,
    @SageIniName("MouseWheelZoomPerTick") val mouseWheelZoomPerTick: Double = 0.0,
    @SageIniName("MouseWheelZoomDampenFactor") val mouseWheelZoomDampenFactor: Double = 0.0,
    @SageIniName("AutoScrollSpeed") val autoScrollSpeed: Double = 0.0,
    @SageIniName("MaxAutoScrollTime") val maxAutoScrollTime: Double = 0.0,
    @SageIniName("NumPointsPerArmyLine") val numPointsPerArmyLine: Int = 0,
    @SageIniName("ArmyLineHeightBias") val armyLineHeightBias: Double = 0.0,
    @SageIniName("ArmyLineWidth") val armyLineWidth: Double = 0.0,
    @SageIniName("ArmyLineColorAttacking") val armyLineColorAttacking: Rgba? = null,
    @SageIniName("ArmyLineColorNeutral") val armyLineColorNeutral: Rgba? = null,
    @SageIniName("ArmyLineColorAllied") val armyLineColorAllied: Rgba? = null,
    @SageIniName("ArmyLineTextureName") val armyLineTextureName: TextureFile? = null,
    @SageIniName("Ambient") val ambient: Rgba? = null,
    @SageIniName("SunDir") val sunDir: Coords? = null,
    @SageIniName("SunRGB") val sunRGB: Rgba? = null,
    @SageIniName("Accent1Dir") val accent1Dir: Coords? = null,
    @SageIniName("Accent1RGB") val accent1RGB: Rgba? = null,
    @SageIniName("Accent2Dir") val accent2Dir: Coords? = null,
    @SageIniName("Accent2RGB") val accent2RGB: Rgba? = null,
    @SageIniName("MenBanner") val menBanner: Opaque? = null,
    @SageIniName("ElvesBanner") val elvesBanner: Opaque? = null,
    @SageIniName("DwarvesBanner") val dwarvesBanner: Opaque? = null,
    @SageIniName("IsengardBanner") val isengardBanner: Opaque? = null,
    @SageIniName("MordorBanner") val mordorBanner: Opaque? = null,
    @SageIniName("WildBanner") val wildBanner: Opaque? = null,
    @SageIniName("NeutralBanner") val neutralBanner: Opaque? = null,
    @SageIniName("MenAnts") val menAnts: Opaque? = null,
    @SageIniName("ElvesAnts") val elvesAnts: Opaque? = null,
    @SageIniName("DwarvesAnts") val dwarvesAnts: Opaque? = null,
    @SageIniName("IsengardAnts") val isengardAnts: Opaque? = null,
    @SageIniName("MordorAnts") val mordorAnts: Opaque? = null,
    @SageIniName("WildAnts") val wildAnts: Opaque? = null,
    @SageIniName("NeutralAnts") val neutralAnts: Opaque? = null,
    @SageIniName("BannerScaleSpeed") val bannerScaleSpeed: Double = 0.0,
    @SageIniName("BannerMaxScale") val bannerMaxScale: Double = 0.0,
    @SageIniName("BannerTiltAngle") val bannerTiltAngle: Double = 0.0,
    @SageIniName("BannerHeight") val bannerHeight: Double = 0.0,
    @SageIniName("ArmyHeight") val armyHeight: Double = 0.0,
    @SageIniName("BeaconHeight") val beaconHeight: Double = 0.0,
    @SageIniName("DefaultArmyMoveSpeed") val defaultArmyMoveSpeed: Double = 0.0,
    @SageIniName("HeroArmyIconDiameter") val heroArmyIconDiameter: Double = 0.0,
    @SageIniName("BattleMarker") val battleMarker: Opaque? = null,
    @SageIniName("PalantirMarker") val palantirMarker: Opaque? = null,
    @SageIniName("RegionAwardDisputeMarker") val regionAwardDisputeMarker: Opaque? = null,
    @SageIniName("BattleMarkerCreatedSound") val battleMarkerCreatedSound: SageReference<AudioEvent>? = null,
    @SageIniName("EnterMapSound") val enterMapSound: SageReference<AudioEvent>? = null,
    @SageIniName("AnimRays") val animRays: Opaque? = null,
    @SageIniName("AnimRaysColor") val animRaysColor: Rgba? = null,
    @SageIniName("AnimRaysPartSysOffset") val animRaysPartSysOffset: Coords? = null,
    @SageIniName("AnimRaysColorScale") val animRaysColorScale: Double = 0.0,
    @SageIniName("AnimRaysEffectShells") val animRaysEffectShells: Int = 0,
    @SageIniName("AnimRaysEffectDiameter") val animRaysEffectDiameter: Int = 0,
    @SageIniName("AnimRaysEffectLifetime") val animRaysEffectLifetime: Int = 0,
    @SageIniName("AnimRaysCreateSound") val animRaysCreateSound: SageReference<AudioEvent>? = null,
    @SageIniName("AnimCloud") val animCloud: Opaque? = null,
    @SageIniName("AnimCloudPartSys") val animCloudPartSys: Opaque? = null,
    @SageIniName("NumAnimClouds") val numAnimClouds: Int = 0,
    @SageIniName("AnimCloudRegionMin") val animCloudRegionMin: Coords? = null,
    @SageIniName("AnimCloudRegionMax") val animCloudRegionMax: Coords? = null,
    @SageIniName("AnimCloudLifetime") val animCloudLifetime: Int = 0,
    @SageIniName("EmbersPartSys") val embersPartSys: Opaque? = null,
    @SageIniName("CloudPos") val cloudPos: Coords? = null,
    @SageIniName("CloudGrowthPos") val cloudGrowthPos: Coords? = null,
    @SageIniName("ShadowColor") val shadowColor: Rgba? = null,
    @SageIniName("ArmySelectedFadeInStart") val armySelectedFadeInStart: Int = 0,
    @SageIniName("ArmySelectedFadeInEnd") val armySelectedFadeInEnd: Int = 0,
    @SageIniName("ArmySelectedFadeOutStart") val armySelectedFadeOutStart: Int = 0,
    @SageIniName("ArmySelectedFadeOutEnd") val armySelectedFadeOutEnd: Int = 0,
    @SageIniName("ArmyHilightedFadeInTime") val armyHilightedFadeInTime: Int = 0,
    @SageIniName("ArmyHilightedFadeOutTime") val armyHilightedFadeOutTime: Int = 0,
    @SageIniName("AngmarAnts") val angmarAnts: Opaque? = null,
    @SageIniName("AngmarBanner") val angmarBanner: Opaque? = null,
    @SageIniName("AnimRaysPartSys") val animRaysPartSys: Opaque? = null,
    @SageIniName("ArmyHilightedIconObject") val armyHilightedIconObject: Opaque? = null,
    @SageIniName("ArmySelectedIconObject") val armySelectedIconObject: Opaque? = null,
    @SageIniName("ArmySoldierLarge") val armySoldierLarge: Opaque? = null,
    @SageIniName("ArmySoldierMedium") val armySoldierMedium: Opaque? = null,
    @SageIniName("ArmySoldierSmall") val armySoldierSmall: Opaque? = null,
    @SageIniName("CloudGrowthRate") val cloudGrowthRate: Int = 0,
    @SageIniName("CloudGrowthSize") val cloudGrowthSize: Double = 0.0,
    @SageIniName("CloudInitialOpacity") val cloudInitialOpacity: Double = 0.0,
    @SageIniName("CloudInitialSize") val cloudInitialSize: Double = 0.0,
    @SageIniName("EnableMapShadows") val enableMapShadows: Boolean = false,
    @SageIniName("EyeTower") val eyeTower: EyeTower? = null,
    @SageIniName("GondorAnts") val gondorAnts: Opaque? = null,
    @SageIniName("GondorBanner") val gondorBanner: Opaque? = null,
    @SageIniName("MordorCloud") val mordorCloud: Opaque? = null,
    @SageIniName("RohanAnts") val rohanAnts: Opaque? = null,
    @SageIniName("RohanBanner") val rohanBanner: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldMapInfo>(
        name = "LivingWorldMapInfo",
        tableKey = "livingworldmapinfos",
        properties = {
            property("MapObject", Opaque.type) { it.mapObject }
            property("NumWorldTiles", IntValue) { it.numWorldTiles }
            property("CloudBorderSubObject", Opaque.type) { it.cloudBorderSubObject }
            property("TextLayerSubObject", Opaque.type) { it.textLayerSubObject }
            property("AddShadowSubObject", Opaque.type) { it.addShadowSubObject }
            property("Center", Coords.type) { it.center }
            property("Extent", Coords.type) { it.extent }
            property("AptCenter", Coords.type) { it.aptCenter }
            property("AptZoom", FloatValue) { it.aptZoom }
            property("AptPitch", FloatValue) { it.aptPitch }
            property("CameraBoundX", FloatValue) { it.cameraBoundX }
            property("CameraBoundY", FloatValue) { it.cameraBoundY }
            property("ClickScrollThreshold", FloatValue) { it.clickScrollThreshold }
            property("MouseWheelZoomPerTick", FloatValue) { it.mouseWheelZoomPerTick }
            property("MouseWheelZoomDampenFactor", FloatValue) { it.mouseWheelZoomDampenFactor }
            property("AutoScrollSpeed", FloatValue) { it.autoScrollSpeed }
            property("MaxAutoScrollTime", FloatValue) { it.maxAutoScrollTime }
            property("NumPointsPerArmyLine", IntValue) { it.numPointsPerArmyLine }
            property("ArmyLineHeightBias", FloatValue) { it.armyLineHeightBias }
            property("ArmyLineWidth", FloatValue) { it.armyLineWidth }
            property("ArmyLineColorAttacking", Rgba.type) { it.armyLineColorAttacking }
            property("ArmyLineColorNeutral", Rgba.type) { it.armyLineColorNeutral }
            property("ArmyLineColorAllied", Rgba.type) { it.armyLineColorAllied }
            property("ArmyLineTextureName", TextureFile.type) { it.armyLineTextureName }
            property("Ambient", Rgba.type) { it.ambient }
            property("SunDir", Coords.type) { it.sunDir }
            property("SunRGB", Rgba.type) { it.sunRGB }
            property("Accent1Dir", Coords.type) { it.accent1Dir }
            property("Accent1RGB", Rgba.type) { it.accent1RGB }
            property("Accent2Dir", Coords.type) { it.accent2Dir }
            property("Accent2RGB", Rgba.type) { it.accent2RGB }
            property("MenBanner", Opaque.type) { it.menBanner }
            property("ElvesBanner", Opaque.type) { it.elvesBanner }
            property("DwarvesBanner", Opaque.type) { it.dwarvesBanner }
            property("IsengardBanner", Opaque.type) { it.isengardBanner }
            property("MordorBanner", Opaque.type) { it.mordorBanner }
            property("WildBanner", Opaque.type) { it.wildBanner }
            property("NeutralBanner", Opaque.type) { it.neutralBanner }
            property("MenAnts", Opaque.type) { it.menAnts }
            property("ElvesAnts", Opaque.type) { it.elvesAnts }
            property("DwarvesAnts", Opaque.type) { it.dwarvesAnts }
            property("IsengardAnts", Opaque.type) { it.isengardAnts }
            property("MordorAnts", Opaque.type) { it.mordorAnts }
            property("WildAnts", Opaque.type) { it.wildAnts }
            property("NeutralAnts", Opaque.type) { it.neutralAnts }
            property("BannerScaleSpeed", FloatValue) { it.bannerScaleSpeed }
            property("BannerMaxScale", FloatValue) { it.bannerMaxScale }
            property("BannerTiltAngle", FloatValue) { it.bannerTiltAngle }
            property("BannerHeight", FloatValue) { it.bannerHeight }
            property("ArmyHeight", FloatValue) { it.armyHeight }
            property("BeaconHeight", FloatValue) { it.beaconHeight }
            property("DefaultArmyMoveSpeed", FloatValue) { it.defaultArmyMoveSpeed }
            property("HeroArmyIconDiameter", FloatValue) { it.heroArmyIconDiameter }
            property("BattleMarker", Opaque.type) { it.battleMarker }
            property("PalantirMarker", Opaque.type) { it.palantirMarker }
            property("RegionAwardDisputeMarker", Opaque.type) { it.regionAwardDisputeMarker }
            property("BattleMarkerCreatedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.battleMarkerCreatedSound }
            property("EnterMapSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.enterMapSound }
            property("AnimRays", Opaque.type) { it.animRays }
            property("AnimRaysColor", Rgba.type) { it.animRaysColor }
            property("AnimRaysPartSysOffset", Coords.type) { it.animRaysPartSysOffset }
            property("AnimRaysColorScale", FloatValue) { it.animRaysColorScale }
            property("AnimRaysEffectShells", IntValue) { it.animRaysEffectShells }
            property("AnimRaysEffectDiameter", IntValue) { it.animRaysEffectDiameter }
            property("AnimRaysEffectLifetime", IntValue) { it.animRaysEffectLifetime }
            property("AnimRaysCreateSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.animRaysCreateSound }
            property("AnimCloud", Opaque.type) { it.animCloud }
            property("AnimCloudPartSys", Opaque.type) { it.animCloudPartSys }
            property("NumAnimClouds", IntValue) { it.numAnimClouds }
            property("AnimCloudRegionMin", Coords.type) { it.animCloudRegionMin }
            property("AnimCloudRegionMax", Coords.type) { it.animCloudRegionMax }
            property("AnimCloudLifetime", IntValue) { it.animCloudLifetime }
            property("EmbersPartSys", Opaque.type) { it.embersPartSys }
            property("CloudPos", Coords.type) { it.cloudPos }
            property("CloudGrowthPos", Coords.type) { it.cloudGrowthPos }
            property("ShadowColor", Rgba.type) { it.shadowColor }
            property("ArmySelectedFadeInStart", IntValue) { it.armySelectedFadeInStart }
            property("ArmySelectedFadeInEnd", IntValue) { it.armySelectedFadeInEnd }
            property("ArmySelectedFadeOutStart", IntValue) { it.armySelectedFadeOutStart }
            property("ArmySelectedFadeOutEnd", IntValue) { it.armySelectedFadeOutEnd }
            property("ArmyHilightedFadeInTime", IntValue) { it.armyHilightedFadeInTime }
            property("ArmyHilightedFadeOutTime", IntValue) { it.armyHilightedFadeOutTime }
            property("AngmarAnts", Opaque.type) { it.angmarAnts }
            property("AngmarBanner", Opaque.type) { it.angmarBanner }
            property("AnimRaysPartSys", Opaque.type) { it.animRaysPartSys }
            property("ArmyHilightedIconObject", Opaque.type) { it.armyHilightedIconObject }
            property("ArmySelectedIconObject", Opaque.type) { it.armySelectedIconObject }
            property("ArmySoldierLarge", Opaque.type) { it.armySoldierLarge }
            property("ArmySoldierMedium", Opaque.type) { it.armySoldierMedium }
            property("ArmySoldierSmall", Opaque.type) { it.armySoldierSmall }
            property("CloudGrowthRate", IntValue) { it.cloudGrowthRate }
            property("CloudGrowthSize", FloatValue) { it.cloudGrowthSize }
            property("CloudInitialOpacity", FloatValue) { it.cloudInitialOpacity }
            property("CloudInitialSize", FloatValue) { it.cloudInitialSize }
            property("EnableMapShadows", BooleanValue) { it.enableMapShadows }
            property("EyeTower", BlockValue<EyeTower> { listOf(EyeTower) }) { it.eyeTower }
            property("GondorAnts", Opaque.type) { it.gondorAnts }
            property("GondorBanner", Opaque.type) { it.gondorBanner }
            property("MordorCloud", Opaque.type) { it.mordorCloud }
            property("RohanAnts", Opaque.type) { it.rohanAnts }
            property("RohanBanner", Opaque.type) { it.rohanBanner }
        },
    )
}
