package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.value.SageFilter

data class PickupStuffUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SkirmishAIOnly") val skirmishAIOnly: Boolean = false,
    @SageIniName("ScanRange") val scanRange: Double = 0.0,
    @SageIniName("StuffToPickUp") val stuffToPickUp: SageFilter? = null,
    @SageIniName("ScanIntervalSeconds") val scanIntervalSeconds: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<PickupStuffUpdate>(
        name = "PickupStuffUpdate",
        properties = {
            property("SkirmishAIOnly", BooleanValue) { it.skirmishAIOnly }
            property("ScanRange", FloatValue) { it.scanRange }
            property("StuffToPickUp", SageFilter.type) { it.stuffToPickUp }
            property("ScanIntervalSeconds", FloatValue) { it.scanIntervalSeconds }
        },
    )
}
