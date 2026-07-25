package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.Opaque

data class BuildingBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("NightWindowName") val nightWindowName: Opaque? = null,
    @SageIniName("FireWindowName") val fireWindowName: Opaque? = null,
    @SageIniName("GlowWindowName") val glowWindowName: Opaque? = null,
    @SageIniName("FireName") val fireName: Opaque? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<BuildingBehavior>(
        name = "BuildingBehavior",
        properties = {
            property("NightWindowName", Opaque.type) { it.nightWindowName }
            property("FireWindowName", Opaque.type) { it.fireWindowName }
            property("GlowWindowName", Opaque.type) { it.glowWindowName }
            property("FireName", Opaque.type) { it.fireName }
        },
    )
}
