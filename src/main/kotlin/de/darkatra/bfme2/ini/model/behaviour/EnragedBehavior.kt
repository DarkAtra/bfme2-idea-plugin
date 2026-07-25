package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue

data class EnragedBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("EnragedLifeTimer") val enragedLifeTimer: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<EnragedBehavior>(
        name = "EnragedBehavior",
        properties = {
            property("EnragedLifeTimer", FloatValue) { it.enragedLifeTimer }
        },
    )
}
