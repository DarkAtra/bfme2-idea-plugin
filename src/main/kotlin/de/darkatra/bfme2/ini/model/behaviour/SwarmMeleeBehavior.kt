package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName

@SageIniName("Swarm")
data class SwarmMeleeBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
) : MeleeBehavior {

    companion object : SageIniBlockDescriptor<SwarmMeleeBehavior>(
        name = "Swarm",
    )
}
