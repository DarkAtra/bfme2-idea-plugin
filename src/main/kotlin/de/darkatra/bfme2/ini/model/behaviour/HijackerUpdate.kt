package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.Opaque

data class HijackerUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ParachuteName") val parachuteName: Opaque? = null,
    @SageIniName("AttachToTargetBone") val attachToTargetBone: Opaque? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<HijackerUpdate>(
        name = "HijackerUpdate",
        properties = {
            property("ParachuteName", Opaque.type) { it.parachuteName }
            property("AttachToTargetBone", Opaque.type) { it.attachToTargetBone }
        },
    )
}
