package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.SageFilter

data class PillageModule(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PillageAmount") val pillageAmount: Int = 0,
    @SageIniName("NumDamageEventsPerPillage") val numDamageEventsPerPillage: Int = 0,
    @SageIniName("PillageFilter") val pillageFilter: SageFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<PillageModule>(
        name = "PillageModule",
        properties = {
            property("PillageAmount", IntValue) { it.pillageAmount }
            property("NumDamageEventsPerPillage", IntValue) { it.numDamageEventsPerPillage }
            property("PillageFilter", SageFilter.type) { it.pillageFilter }
        },
    )
}
