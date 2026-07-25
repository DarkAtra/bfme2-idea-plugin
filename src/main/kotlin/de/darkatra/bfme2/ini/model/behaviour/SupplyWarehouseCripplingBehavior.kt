package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class SupplyWarehouseCripplingBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SelfHealSupression") val selfHealSupression: Int = 0,
    @SageIniName("SelfHealDelay") val selfHealDelay: Int = 0,
    @SageIniName("SelfHealAmount") val selfHealAmount: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SupplyWarehouseCripplingBehavior>(
        name = "SupplyWarehouseCripplingBehavior",
        properties = {
            property("SelfHealSupression", IntValue) { it.selfHealSupression }
            property("SelfHealDelay", IntValue) { it.selfHealDelay }
            property("SelfHealAmount", FloatValue) { it.selfHealAmount }
        },
    )
}
