package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque

data class ConcurrentRegionBonus(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Territory") val territory: String = "",
    @SageIniName("EffectName") val effectName: String = "",
    @SageIniName("Regions") val regions: List<Opaque> = emptyList(),
    @SageIniName("UnifiedEvaEvent") val unifiedEvaEvent: Opaque? = null,
    @SageIniName("LostEvaEvent") val lostEvaEvent: Opaque? = null,
    @SageIniName("LookAtCenter") val lookAtCenter: Coords? = null,
    @SageIniName("LookAtHeading") val lookAtHeading: Double = 0.0,
    @SageIniName("LookAtZoom") val lookAtZoom: Double = 0.0,
    @SageIniName("AttackBonus") val attackBonus: Int = 0,
    @SageIniName("DefenseBonus") val defenseBonus: Int = 0,
    @SageIniName("ExperienceBonus") val experienceBonus: Int = 0,
    @SageIniName("ArmyBonus") val armyBonus: Int = 0,
    @SageIniName("BuildingDiscountBonus") val buildingDiscountBonus: Int = 0,
    @SageIniName("DiscountedBarracksUnitsBonus") val discountedBarracksUnitsBonus: Int = 0,
    @SageIniName("DiscountedHeroUnitsBonus") val discountedHeroUnitsBonus: Int = 0,
    @SageIniName("DiscountedSeigeUnitsBonus") val discountedSeigeUnitsBonus: Int = 0,
    @SageIniName("ExtraStartResourcesBonus") val extraStartResourcesBonus: Int = 0,
    @SageIniName("FreeBuilderBonus") val freeBuilderBonus: Int = 0,
    @SageIniName("FreeInnUnitsBonus") val freeInnUnitsBonus: Int = 0,
    @SageIniName("LegendaryBonus") val legendaryBonus: Int = 0,
    @SageIniName("ResourceBonus") val resourceBonus: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ConcurrentRegionBonus>(
        name = "ConcurrentRegionBonus",
        tableKey = "concurrentregionbonus",
        properties = {
            property("Territory", StringValue) { it.territory }
            property("EffectName", StringValue) { it.effectName }
            property("Regions", ListValue(Opaque.type)) { it.regions }
            property("UnifiedEvaEvent", Opaque.type) { it.unifiedEvaEvent }
            property("LostEvaEvent", Opaque.type) { it.lostEvaEvent }
            property("LookAtCenter", Coords.type) { it.lookAtCenter }
            property("LookAtHeading", FloatValue) { it.lookAtHeading }
            property("LookAtZoom", FloatValue) { it.lookAtZoom }
            property("AttackBonus", IntValue) { it.attackBonus }
            property("DefenseBonus", IntValue) { it.defenseBonus }
            property("ExperienceBonus", IntValue) { it.experienceBonus }
            property("ArmyBonus", IntValue) { it.armyBonus }
            property("BuildingDiscountBonus", IntValue) { it.buildingDiscountBonus }
            property("DiscountedBarracksUnitsBonus", IntValue) { it.discountedBarracksUnitsBonus }
            property("DiscountedHeroUnitsBonus", IntValue) { it.discountedHeroUnitsBonus }
            property("DiscountedSeigeUnitsBonus", IntValue) { it.discountedSeigeUnitsBonus }
            property("ExtraStartResourcesBonus", IntValue) { it.extraStartResourcesBonus }
            property("FreeBuilderBonus", IntValue) { it.freeBuilderBonus }
            property("FreeInnUnitsBonus", IntValue) { it.freeInnUnitsBonus }
            property("LegendaryBonus", IntValue) { it.legendaryBonus }
            property("ResourceBonus", IntValue) { it.resourceBonus }
        },
    )
}
