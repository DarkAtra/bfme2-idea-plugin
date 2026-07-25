package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class InheritUpgradeCreate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("Upgrade") val upgrade: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<InheritUpgradeCreate>(
        name = "InheritUpgradeCreate",
        properties = {
            property("Radius", FloatValue) { it.radius }
            property("Upgrade", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.upgrade }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
        },
    )
}
