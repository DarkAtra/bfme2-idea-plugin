package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter

open class DieBehavior(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") open val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") open val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") open val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") open val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") open val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") open val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") open val maxKillerAngle: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<DieBehavior>(
        name = "DieBehavior",
        properties = {
            property("DeathType", SageFilter.type) { it.deathType }
            property("DeathTypes", SageFilter.type) { it.deathTypes }
            property("ExemptStatus", ObjectStatus.type) { it.exemptStatus }
            property("RequiredStatus", ObjectStatus.type) { it.requiredStatus }
            property("DamageAmountRequired", FloatValue) { it.damageAmountRequired }
            property("MinKillerAngle", IntValue) { it.minKillerAngle }
            property("MaxKillerAngle", IntValue) { it.maxKillerAngle }
        },
    )
}
