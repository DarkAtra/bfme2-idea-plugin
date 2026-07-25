package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class RefundDie(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") override val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Int = 0,
    @SageIniName("UpgradeRequired") val upgradeRequired: SageReference<Upgrade>? = null,
    @SageIniName("BuildingRequired") val buildingRequired: SageFilter? = null,
    @SageIniName("RefundPercent") val refundPercent: Double = 0.0,
) : DieBehavior() {

    companion object : SageIniBlockDescriptor<RefundDie>(
        name = "RefundDie",
        parent = DieBehavior,
        properties = {
            property("UpgradeRequired", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.upgradeRequired }
            property("BuildingRequired", SageFilter.type) { it.buildingRequired }
            property("RefundPercent", FloatValue) { it.refundPercent }
        },
    )
}
