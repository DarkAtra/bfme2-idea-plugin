package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class DestroyEnvironmentUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StartTime") val startTime: Int = 0,
    @SageIniName("DestructionTime") val destructionTime: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<DestroyEnvironmentUpdate>(
        name = "DestroyEnvironmentUpdate",
        properties = {
            property("StartTime", IntValue) { it.startTime }
            property("DestructionTime", IntValue) { it.destructionTime }
        },
    )
}
