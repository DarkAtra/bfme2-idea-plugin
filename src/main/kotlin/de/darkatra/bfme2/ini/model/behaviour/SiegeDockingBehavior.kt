package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class SiegeDockingBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DUMMY") val dUMMY: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SiegeDockingBehavior>(
        name = "SiegeDockingBehavior",
        properties = {
            property("DUMMY", IntValue) { it.dUMMY }
        },
    )
}
