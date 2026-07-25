package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.value.SageFilter

data class ReflectDamage(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DamageTypesToReflect") val damageTypesToReflect: SageFilter? = null,
    @SageIniName("ReflectDamageFloat") val reflectDamageFloat: Double = 0.0,
    @SageIniName("MinimumDamageToReflect") val minimumDamageToReflect: Double = 0.0,
    @SageIniName("ReflectDamagePercentage") val reflectDamagePercentage: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ReflectDamage>(
        name = "ReflectDamage",
        properties = {
            property("DamageTypesToReflect", SageFilter.type) { it.damageTypesToReflect }
            property("ReflectDamageFloat", FloatValue) { it.reflectDamageFloat }
            property("MinimumDamageToReflect", FloatValue) { it.minimumDamageToReflect }
            property("ReflectDamagePercentage", FloatValue) { it.reflectDamagePercentage }
        },
    )
}
