package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.Untyped

data class FadeAndDieOrnamentUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Envelope") val envelope: Untyped? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<FadeAndDieOrnamentUpdate>(
        name = "FadeAndDieOrnamentUpdate",
        properties = {
            property("Envelope", Untyped.type) { it.envelope }
        },
    )
}
