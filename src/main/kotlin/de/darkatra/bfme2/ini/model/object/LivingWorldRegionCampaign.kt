package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.livingworld.Region
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.SageReference

data class LivingWorldRegionCampaign(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RegionConqueredSound") val regionConqueredSound: SageReference<AudioEvent>? = null,
    @SageIniName("RegionEffectsManagerName") val regionEffectsManagerName: String = "",
    @SageIniName("RegionBonusArmy") val regionBonusArmy: String = "",
    @SageIniName("RegionBonusResource") val regionBonusResource: String = "",
    @SageIniName("RegionBonusLegendary") val regionBonusLegendary: String = "",
    @SageIniName("HeroOnlyArmyCommandPoints") val heroOnlyArmyCommandPoints: Int = 0,
    @SageIniName("SmallArmyCommandPoints") val smallArmyCommandPoints: Int = 0,
    @SageIniName("MediumArmyCommandPoints") val mediumArmyCommandPoints: Int = 0,
    @SageIniName("ArmyRetreatRounds") val armyRetreatRounds: Int = 0,
    @SageIniName("ArmyPlacementPos") val armyPlacementPos: List<Coords> = emptyList(),
    @SageIniName("ConcurrentRegionBonus") val concurrentRegionBonus: Opaque? = null,
    @SageIniName("ConqueredEffectEvenglow") val conqueredEffectEvenglow: Opaque? = null,
    @SageIniName("ConqueredEffectFlareup") val conqueredEffectFlareup: Opaque? = null,
    @SageIniName("EnemyBordersEffect") val enemyBordersEffect: Opaque? = null,
    @SageIniName("FriendlyBordersEffect") val friendlyBordersEffect: Opaque? = null,
    @SageIniName("HilightBordersEffect") val hilightBordersEffect: Opaque? = null,
    @SageIniName("MouseoutEffectFlareupContested") val mouseoutEffectFlareupContested: Opaque? = null,
    @SageIniName("MouseoutEffectFlareupOwned") val mouseoutEffectFlareupOwned: Opaque? = null,
    @SageIniName("MouseoverEffectFlareupContested") val mouseoverEffectFlareupContested: Opaque? = null,
    @SageIniName("MouseoverEffectFlareupOwned") val mouseoverEffectFlareupOwned: Opaque? = null,
    @SageIniName("RegionObject") val regionObject: Opaque? = null,
    @SageIniName("RegionPopupDefaultColor") val regionPopupDefaultColor: Rgba? = null,
    @SageIniName("RegionPopupOverColor") val regionPopupOverColor: Rgba? = null,
    @SageIniName("ZOffset") val zOffset: Int = 0,
    @SageIniName("Region") val region: List<Region> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldRegionCampaign>(
        name = "LivingWorldRegionCampaign",
        tableKey = "livingworldregioncampaigns",
        properties = {
            property("RegionConqueredSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.regionConqueredSound }
            property("RegionEffectsManagerName", StringValue) { it.regionEffectsManagerName }
            property("RegionBonusArmy", StringValue) { it.regionBonusArmy }
            property("RegionBonusResource", StringValue) { it.regionBonusResource }
            property("RegionBonusLegendary", StringValue) { it.regionBonusLegendary }
            property("HeroOnlyArmyCommandPoints", IntValue) { it.heroOnlyArmyCommandPoints }
            property("SmallArmyCommandPoints", IntValue) { it.smallArmyCommandPoints }
            property("MediumArmyCommandPoints", IntValue) { it.mediumArmyCommandPoints }
            property("ArmyRetreatRounds", IntValue) { it.armyRetreatRounds }
            property("ArmyPlacementPos", ListValue(Coords.type)) { it.armyPlacementPos }
            property("ConcurrentRegionBonus", Opaque.type) { it.concurrentRegionBonus }
            property("ConqueredEffectEvenglow", Opaque.type) { it.conqueredEffectEvenglow }
            property("ConqueredEffectFlareup", Opaque.type) { it.conqueredEffectFlareup }
            property("EnemyBordersEffect", Opaque.type) { it.enemyBordersEffect }
            property("FriendlyBordersEffect", Opaque.type) { it.friendlyBordersEffect }
            property("HilightBordersEffect", Opaque.type) { it.hilightBordersEffect }
            property("MouseoutEffectFlareupContested", Opaque.type) { it.mouseoutEffectFlareupContested }
            property("MouseoutEffectFlareupOwned", Opaque.type) { it.mouseoutEffectFlareupOwned }
            property("MouseoverEffectFlareupContested", Opaque.type) { it.mouseoverEffectFlareupContested }
            property("MouseoverEffectFlareupOwned", Opaque.type) { it.mouseoverEffectFlareupOwned }
            property("RegionObject", Opaque.type) { it.regionObject }
            property("RegionPopupDefaultColor", Rgba.type) { it.regionPopupDefaultColor }
            property("RegionPopupOverColor", Rgba.type) { it.regionPopupOverColor }
            property("ZOffset", IntValue) { it.zOffset }
            property("Region", ListValue(BlockValue<Region> { listOf(Region) })) { it.region }
        },
    )
}
