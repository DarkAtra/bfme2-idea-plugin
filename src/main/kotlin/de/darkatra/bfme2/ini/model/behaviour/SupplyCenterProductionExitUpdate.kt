package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Coords

data class SupplyCenterProductionExitUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("UnitCreatePoint") val unitCreatePoint: Coords? = null,
    @SageIniName("NaturalRallyPoint") val naturalRallyPoint: Coords? = null,
    @SageIniName("GrantTemporaryStealth") val grantTemporaryStealth: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SupplyCenterProductionExitUpdate>(
        name = "SupplyCenterProductionExitUpdate",
        properties = {
            property("UnitCreatePoint", Coords.type) { it.unitCreatePoint }
            property("NaturalRallyPoint", Coords.type) { it.naturalRallyPoint }
            property("GrantTemporaryStealth", IntValue) { it.grantTemporaryStealth }
        },
    )
}
