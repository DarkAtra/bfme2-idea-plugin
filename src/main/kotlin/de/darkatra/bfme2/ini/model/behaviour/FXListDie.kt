package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class FXListDie(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") override val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Int = 0,
    @SageIniName("OrientToObject") val orientToObject: Boolean = false,
    @SageIniName("DeathFX") val deathFX: SageReference<FXList>? = null,
    @SageIniName("StartsActive") val startsActive: Boolean = false,
    @SageIniName("ConflictsWith") val conflictsWith: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("TriggeredBy") val triggeredBy: List<SageReference<UpgradeTrigger>> = emptyList(),
) : DieBehavior() {

    companion object : SageIniBlockDescriptor<FXListDie>(
        name = "FXListDie",
        parent = DieBehavior,
        properties = {
            property("OrientToObject", BooleanValue) { it.orientToObject }
            property("DeathFX", ReferenceValue<FXList> { listOf(FXList) }) { it.deathFX }
            property("StartsActive", BooleanValue) { it.startsActive }
            property("ConflictsWith", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.conflictsWith }
            property("TriggeredBy", ListValue(ReferenceValue<UpgradeTrigger> { listOf(Upgrade, Science) })) { it.triggeredBy }
        },
    )
}
