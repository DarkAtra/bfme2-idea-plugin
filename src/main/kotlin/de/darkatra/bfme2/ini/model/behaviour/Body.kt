package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor

data class Body(
    val header: SageBlockHeader = SageBlockHeader(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<Body>(
        name = "Body",
    )
}
