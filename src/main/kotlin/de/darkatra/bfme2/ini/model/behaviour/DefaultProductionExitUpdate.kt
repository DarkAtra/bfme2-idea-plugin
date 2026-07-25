package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.value.Coords

data class DefaultProductionExitUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("UnitCreatePoint") val unitCreatePoint: Coords? = null,
    @SageIniName("NaturalRallyPoint") val naturalRallyPoint: Coords? = null,
    @SageIniName("UseSpawnRallyPoint") val useSpawnRallyPoint: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<DefaultProductionExitUpdate>(
        name = "DefaultProductionExitUpdate",
        properties = {
            property("UnitCreatePoint", Coords.type) { it.unitCreatePoint }
            property("NaturalRallyPoint", Coords.type) { it.naturalRallyPoint }
            property("UseSpawnRallyPoint", BooleanValue) { it.useSpawnRallyPoint }
        },
    )
}
