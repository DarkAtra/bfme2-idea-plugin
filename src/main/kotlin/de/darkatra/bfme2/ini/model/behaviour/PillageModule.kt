package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.UnsignedIntValue
import de.darkatra.bfme2.ini.model.value.SageFilter

data class PillageModule(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PillageAmount") val pillageAmount: UInt = 0u,
    @SageIniName("NumDamageEventsPerPillage") val numDamageEventsPerPillage: UInt = 0u,
    @SageIniName("PillageFilter") val pillageFilter: SageFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<PillageModule>(
        name = "PillageModule",
        properties = {
            property("PillageAmount", UnsignedIntValue) { it.pillageAmount }
            property("NumDamageEventsPerPillage", UnsignedIntValue) { it.numDamageEventsPerPillage }
            property("PillageFilter", SageFilter.type) { it.pillageFilter }
        },
    )
}
