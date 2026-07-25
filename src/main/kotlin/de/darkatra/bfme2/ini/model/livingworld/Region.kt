package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Untyped

data class Region(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DisplayName") val displayName: Untyped? = null,
    @SageIniName("MapName") val mapName: Untyped? = null,
    @SageIniName("HeroArmySpot") val heroArmySpot: List<Untyped> = emptyList(),
    @SageIniName("BuildingSpot") val buildingSpot: List<Untyped> = emptyList(),
    @SageIniName("SubObject") val subObject: List<Untyped> = emptyList(),
    @SageIniName("ConqueredNotice") val conqueredNotice: Untyped? = null,
    @SageIniName("SkirmishStillImage") val skirmishStillImage: Untyped? = null,
    @SageIniName("SkirmishMusicTrack") val skirmishMusicTrack: Opaque? = null,
    @SageIniName("RegionPortrait") val regionPortrait: Opaque? = null,
    @SageIniName("ConnectsTo") val connectsTo: List<Opaque> = emptyList(),
    @SageIniName("GarrisonArmySpot") val garrisonArmySpot: Coords? = null,
    @SageIniName("CenterPoint") val centerPoint: Coords? = null,
    @SageIniName("CustomCenterPoint") val customCenterPoint: Boolean = false,
    @SageIniName("CPLimit") val cPLimit: Int = 0,
    @SageIniName("AllyCPLimit") val allyCPLimit: Int = 0,
    @SageIniName("MovieNameFirstTime") val movieNameFirstTime: Opaque? = null,
    @SageIniName("MovieNameRepeat") val movieNameRepeat: Opaque? = null,
    @SageIniName("AttackBonus") val attackBonus: Int = 0,
    @SageIniName("DefenseBonus") val defenseBonus: Int = 0,
    @SageIniName("ArmyBonus") val armyBonus: Int = 0,
    @SageIniName("LegendaryBonus") val legendaryBonus: Int = 0,
    @SageIniName("ExperienceBonus") val experienceBonus: Int = 0,
    @SageIniName("ResourceBonus") val resourceBonus: Int = 0,
    @SageIniName("FertileTerritoryBonus") val fertileTerritoryBonus: Int = 0,
    @SageIniName("CreateAutoFort") val createAutoFort: Boolean = false,
    @SageIniName("FortressPortrait") val fortressPortrait: Opaque? = null,
    @SageIniName("FortressDisplayName") val fortressDisplayName: Untyped? = null,
    @SageIniName("FortressDisplayDescription") val fortressDisplayDescription: Untyped? = null,
    @SageIniName("Connection") val connection: List<Connection> = emptyList(),
    @SageIniName("RestrictBuildings") val restrictBuildings: List<RestrictBuildings> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Region>(
        name = "Region",
        properties = {
            property("DisplayName", Untyped.type) { it.displayName }
            property("MapName", Untyped.type) { it.mapName }
            property("HeroArmySpot", ListValue(Untyped.type)) { it.heroArmySpot }
            property("BuildingSpot", ListValue(Untyped.type)) { it.buildingSpot }
            property("SubObject", ListValue(Untyped.type)) { it.subObject }
            property("ConqueredNotice", Untyped.type) { it.conqueredNotice }
            property("SkirmishStillImage", Untyped.type) { it.skirmishStillImage }
            property("SkirmishMusicTrack", Opaque.type) { it.skirmishMusicTrack }
            property("RegionPortrait", Opaque.type) { it.regionPortrait }
            property("ConnectsTo", ListValue(Opaque.type)) { it.connectsTo }
            property("GarrisonArmySpot", Coords.type) { it.garrisonArmySpot }
            property("CenterPoint", Coords.type) { it.centerPoint }
            property("CustomCenterPoint", BooleanValue) { it.customCenterPoint }
            property("CPLimit", IntValue) { it.cPLimit }
            property("AllyCPLimit", IntValue) { it.allyCPLimit }
            property("MovieNameFirstTime", Opaque.type) { it.movieNameFirstTime }
            property("MovieNameRepeat", Opaque.type) { it.movieNameRepeat }
            property("AttackBonus", IntValue) { it.attackBonus }
            property("DefenseBonus", IntValue) { it.defenseBonus }
            property("ArmyBonus", IntValue) { it.armyBonus }
            property("LegendaryBonus", IntValue) { it.legendaryBonus }
            property("ExperienceBonus", IntValue) { it.experienceBonus }
            property("ResourceBonus", IntValue) { it.resourceBonus }
            property("FertileTerritoryBonus", IntValue) { it.fertileTerritoryBonus }
            property("CreateAutoFort", BooleanValue) { it.createAutoFort }
            property("FortressPortrait", Opaque.type) { it.fortressPortrait }
            property("FortressDisplayName", Untyped.type) { it.fortressDisplayName }
            property("FortressDisplayDescription", Untyped.type) { it.fortressDisplayDescription }
            property("Connection", ListValue(BlockValue<Connection> { listOf(Connection) })) { it.connection }
            property("RestrictBuildings", ListValue(BlockValue<RestrictBuildings> { listOf(RestrictBuildings) })) { it.restrictBuildings }
        },
    )
}
