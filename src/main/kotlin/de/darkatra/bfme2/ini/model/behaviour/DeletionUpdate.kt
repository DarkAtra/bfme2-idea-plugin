package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class DeletionUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MinLifetime") val minLifetime: Int = 0,
    @SageIniName("MaxLifetime") val maxLifetime: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<DeletionUpdate>(
        name = "DeletionUpdate",
        properties = {
            property("MinLifetime", IntValue) { it.minLifetime }
            property("MaxLifetime", IntValue) { it.maxLifetime }
        },
    )
}
