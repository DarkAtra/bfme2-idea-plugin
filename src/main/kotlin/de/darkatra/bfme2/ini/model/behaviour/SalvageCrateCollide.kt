package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.draw.Animation
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference

data class SalvageCrateCollide(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RequiredKindOf") override val requiredKindOf: List<KindOf> = emptyList(),
    @SageIniName("ForbiddenKindOf") override val forbiddenKindOf: List<KindOf> = emptyList(),
    @SageIniName("ForbidOwnerPlayer") override val forbidOwnerPlayer: Boolean = false,
    @SageIniName("BuildingPickup") override val buildingPickup: Boolean = false,
    @SageIniName("HumanOnly") override val humanOnly: Boolean = false,
    @SageIniName("FXList") override val fXList: SageReference<FXList>? = null,
    @SageIniName("PickupScience") override val pickupScience: SageReference<Science>? = null,
    @SageIniName("ExecuteFX") override val executeFX: SageReference<FXList>? = null,
    @SageIniName("ExecuteAnimation") override val executeAnimation: SageReference<Animation>? = null,
    @SageIniName("ExecuteAnimationTime") override val executeAnimationTime: Double = 0.0,
    @SageIniName("ExecuteAnimationZRise") override val executeAnimationZRise: Double = 0.0,
    @SageIniName("ExecuteAnimationFades") override val executeAnimationFades: Boolean = false,
    @SageIniName("WeaponChance") val weaponChance: Double = 0.0,
    @SageIniName("LevelChance") val levelChance: Double = 0.0,
    @SageIniName("MoneyChance") val moneyChance: Double = 0.0,
    @SageIniName("MinMoney") val minMoney: Int = 0,
    @SageIniName("MaxMoney") val maxMoney: Int = 0,
    @SageIniName("PorterChance") val porterChance: Double = 0.0,
    @SageIniName("BannerChance") val bannerChance: Double = 0.0,
    @SageIniName("LevelUpChance") val levelUpChance: Double = 0.0,
    @SageIniName("LevelUpRadius") val levelUpRadius: Double = 0.0,
    @SageIniName("ResourceChance") val resourceChance: Double = 0.0,
    @SageIniName("Upgrade") val upgrade: SageReference<Upgrade>? = null,
    @SageIniName("MinResource") val minResource: Int = 0,
    @SageIniName("MaxResource") val maxResource: Int = 0,
    @SageIniName("AllowAIPickup") val allowAIPickup: Boolean = false,
) : CrateCollide() {

    companion object : SageIniBlockDescriptor<SalvageCrateCollide>(
        name = "SalvageCrateCollide",
        parent = CrateCollide,
        properties = {
            property("WeaponChance", FloatValue) { it.weaponChance }
            property("LevelChance", FloatValue) { it.levelChance }
            property("MoneyChance", FloatValue) { it.moneyChance }
            property("MinMoney", IntValue) { it.minMoney }
            property("MaxMoney", IntValue) { it.maxMoney }
            property("PorterChance", FloatValue) { it.porterChance }
            property("BannerChance", FloatValue) { it.bannerChance }
            property("LevelUpChance", FloatValue) { it.levelUpChance }
            property("LevelUpRadius", FloatValue) { it.levelUpRadius }
            property("ResourceChance", FloatValue) { it.resourceChance }
            property("Upgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.upgrade }
            property("MinResource", IntValue) { it.minResource }
            property("MaxResource", IntValue) { it.maxResource }
            property("AllowAIPickup", BooleanValue) { it.allowAIPickup }
        },
    )
}
