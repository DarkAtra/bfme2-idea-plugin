package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.Opaque

data class SpawnPointProductionExitUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpawnPointBoneName") val spawnPointBoneName: Opaque? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SpawnPointProductionExitUpdate>(
        name = "SpawnPointProductionExitUpdate",
        properties = {
            property("SpawnPointBoneName", Opaque.type) { it.spawnPointBoneName }
        },
    )
}
