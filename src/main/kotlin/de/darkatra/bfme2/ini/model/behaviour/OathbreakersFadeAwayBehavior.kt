package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class OathbreakersFadeAwayBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("FadeOutTime") val fadeOutTime: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<OathbreakersFadeAwayBehavior>(
        name = "OathbreakersFadeAwayBehavior",
        properties = {
            property("FadeOutTime", IntValue) { it.fadeOutTime }
        },
    )
}
