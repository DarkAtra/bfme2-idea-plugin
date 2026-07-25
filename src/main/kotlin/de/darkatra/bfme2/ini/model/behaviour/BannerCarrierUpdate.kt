package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageReference

data class BannerCarrierUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("IdleSpawnRate") val idleSpawnRate: Int = 0,
    @SageIniName("MeleeFreeUnitSpawnTime") val meleeFreeUnitSpawnTime: Int = 0,
    @SageIniName("DiedRespawnTime") val diedRespawnTime: Int = 0,
    @SageIniName("MeleeFreeBannerReSpawnTime") val meleeFreeBannerReSpawnTime: Int = 0,
    @SageIniName("BannerMorphFX") val bannerMorphFX: SageReference<FXList>? = null,
    @SageIniName("UnitSpawnFX") val unitSpawnFX: SageReference<FXList>? = null,
    @SageIniName("MorphCondition") val morphCondition: List<Map<String, String>> = emptyList(),
    @SageIniName("ReplenishNearbyHorde") val replenishNearbyHorde: Boolean = false,
    @SageIniName("ScanHordeDistance") val scanHordeDistance: Double = 0.0,
    @SageIniName("ReplenishAllNearbyHordes") val replenishAllNearbyHordes: Boolean = false,
    @SageIniName("UpgradeRequired") val upgradeRequired: SageReference<Upgrade>? = null,
    @SageIniName("ExpLevelDraw") val expLevelDraw: List<Map<String, String>> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<BannerCarrierUpdate>(
        name = "BannerCarrierUpdate",
        properties = {
            property("IdleSpawnRate", IntValue) { it.idleSpawnRate }
            property("MeleeFreeUnitSpawnTime", IntValue) { it.meleeFreeUnitSpawnTime }
            property("DiedRespawnTime", IntValue) { it.diedRespawnTime }
            property("MeleeFreeBannerReSpawnTime", IntValue) { it.meleeFreeBannerReSpawnTime }
            property("BannerMorphFX", ReferenceValue<FXList> { listOf(FXList) }) { it.bannerMorphFX }
            property("UnitSpawnFX", ReferenceValue<FXList> { listOf(FXList) }) { it.unitSpawnFX }
            property("MorphCondition", ListValue(MapValue(StringValue, StringValue))) { it.morphCondition }
            property("ReplenishNearbyHorde", BooleanValue) { it.replenishNearbyHorde }
            property("ScanHordeDistance", FloatValue) { it.scanHordeDistance }
            property("ReplenishAllNearbyHordes", BooleanValue) { it.replenishAllNearbyHordes }
            property("UpgradeRequired", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.upgradeRequired }
            property("ExpLevelDraw", ListValue(MapValue(StringValue, StringValue))) { it.expLevelDraw }
        },
    )
}
