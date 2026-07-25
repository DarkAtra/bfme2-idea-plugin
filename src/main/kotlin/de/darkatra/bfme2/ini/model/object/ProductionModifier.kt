package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class ProductionModifier(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RequiredUpgrade") val requiredUpgrade: SageReference<Upgrade>? = null,
    @SageIniName("ModifierFilter") val modifierFilter: SageFilter? = null,
    @SageIniName("CostMultiplier") val costMultiplier: Double = 0.0,
    @SageIniName("TimeMultiplier") val timeMultiplier: Double = 0.0,
    @SageIniName("HeroPurchase") val heroPurchase: Boolean = false,
    @SageIniName("HeroRevive") val heroRevive: Boolean = false,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ProductionModifier>(
        name = "ProductionModifier",
        properties = {
            property("RequiredUpgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.requiredUpgrade }
            property("ModifierFilter", SageFilter.type) { it.modifierFilter }
            property("CostMultiplier", FloatValue) { it.costMultiplier }
            property("TimeMultiplier", FloatValue) { it.timeMultiplier }
            property("HeroPurchase", BooleanValue) { it.heroPurchase }
            property("HeroRevive", BooleanValue) { it.heroRevive }
        },
    )
}
