package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.ModifierCategories
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class PassiveAreaEffectBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("EffectRadius") val effectRadius: Double = 0.0,
    @SageIniName("PingDelay") val pingDelay: Int = 0,
    @SageIniName("HealPercentPerSecond") val healPercentPerSecond: Double = 0.0,
    @SageIniName("ModifierName") val modifierName: List<SageReference<ModifierList>> = emptyList(),
    @SageIniName("AllowFilter") val allowFilter: SageFilter? = null,
    @SageIniName("UpgradeRequired") val upgradeRequired: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("NonStackable") val nonStackable: Boolean = false,
    @SageIniName("AntiCategories") val antiCategories: ModifierCategories? = null,
    @SageIniName("AntiFX") val antiFX: SageReference<FXList>? = null,
    @SageIniName("HealFX") val healFX: SageReference<FXList>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<PassiveAreaEffectBehavior>(
        name = "PassiveAreaEffectBehavior",
        properties = {
            property("EffectRadius", FloatValue) { it.effectRadius }
            property("PingDelay", IntValue) { it.pingDelay }
            property("HealPercentPerSecond", FloatValue) { it.healPercentPerSecond }
            property("ModifierName", ListValue(ReferenceValue<ModifierList> { listOf(ModifierList) })) { it.modifierName }
            property("AllowFilter", SageFilter.type) { it.allowFilter }
            property("UpgradeRequired", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.upgradeRequired }
            property("NonStackable", BooleanValue) { it.nonStackable }
            property("AntiCategories", ModifierCategories.type) { it.antiCategories }
            property("AntiFX", ReferenceValue<FXList> { listOf(FXList) }) { it.antiFX }
            property("HealFX", ReferenceValue<FXList> { listOf(FXList) }) { it.healFX }
        },
    )
}
