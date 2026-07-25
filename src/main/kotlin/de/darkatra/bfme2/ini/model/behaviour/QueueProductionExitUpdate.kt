package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Coords

data class QueueProductionExitUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("UnitCreatePoint") val unitCreatePoint: Coords? = null,
    @SageIniName("NaturalRallyPoint") val naturalRallyPoint: Coords? = null,
    @SageIniName("ExitDelay") val exitDelay: Int = 0,
    @SageIniName("InitialBurst") val initialBurst: Int = 0,
    @SageIniName("PlacementViewAngle") val placementViewAngle: Int = 0,
    @SageIniName("NoExitPath") val noExitPath: Boolean = false,
    @SageIniName("AllowAirborneCreation") val allowAirborneCreation: Boolean = false,
    @SageIniName("UseReturnToFormation") val useReturnToFormation: Boolean = false,
    @SageIniName("CanRallyToSlaughter") val canRallyToSlaughter: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<QueueProductionExitUpdate>(
        name = "QueueProductionExitUpdate",
        properties = {
            property("UnitCreatePoint", Coords.type) { it.unitCreatePoint }
            property("NaturalRallyPoint", Coords.type) { it.naturalRallyPoint }
            property("ExitDelay", IntValue) { it.exitDelay }
            property("InitialBurst", IntValue) { it.initialBurst }
            property("PlacementViewAngle", IntValue) { it.placementViewAngle }
            property("NoExitPath", BooleanValue) { it.noExitPath }
            property("AllowAirborneCreation", BooleanValue) { it.allowAirborneCreation }
            property("UseReturnToFormation", BooleanValue) { it.useReturnToFormation }
            property("CanRallyToSlaughter", BooleanValue) { it.canRallyToSlaughter }
        },
    )
}
