package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue

data class FloatUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Enabled") val enabled: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<FloatUpdate>(
        name = "FloatUpdate",
        properties = {
            property("Enabled", BooleanValue) { it.enabled }
        },
    )
}
