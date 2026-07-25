package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.SageFilter

data class CivilianSpawnCollide(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeleteObjectFilter") val deleteObjectFilter: SageFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<CivilianSpawnCollide>(
        name = "CivilianSpawnCollide",
        properties = {
            property("DeleteObjectFilter", SageFilter.type) { it.deleteObjectFilter }
        },
    )
}
