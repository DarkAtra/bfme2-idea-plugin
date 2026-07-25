package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class TerrainResourceBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("MaxIncome") val maxIncome: Int = 0,
    @SageIniName("IncomeInterval") val incomeInterval: Int = 0,
    @SageIniName("HighPriority") val highPriority: Boolean = false,
    @SageIniName("Visible") val visible: Boolean = false,
    @SageIniName("Upgrade") val upgrade: SageReference<Upgrade>? = null,
    @SageIniName("UpgradeBonusPercent") val upgradeBonusPercent: Double = 0.0,
    @SageIniName("UpgradeMustBePresent") val upgradeMustBePresent: SageFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<TerrainResourceBehavior>(
        name = "TerrainResourceBehavior",
        properties = {
            property("Radius", FloatValue) { it.radius }
            property("MaxIncome", IntValue) { it.maxIncome }
            property("IncomeInterval", IntValue) { it.incomeInterval }
            property("HighPriority", BooleanValue) { it.highPriority }
            property("Visible", BooleanValue) { it.visible }
            property("Upgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.upgrade }
            property("UpgradeBonusPercent", FloatValue) { it.upgradeBonusPercent }
            property("UpgradeMustBePresent", SageFilter.type) { it.upgradeMustBePresent }
        },
    )
}
