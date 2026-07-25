package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class SupplyWarehouseDockUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("NumberApproachPositions") val numberApproachPositions: Int = 0,
    @SageIniName("AllowsPassthrough") val allowsPassthrough: Boolean = false,
    @SageIniName("StartingBoxes") val startingBoxes: Int = 0,
    @SageIniName("DeleteWhenEmpty") val deleteWhenEmpty: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SupplyWarehouseDockUpdate>(
        name = "SupplyWarehouseDockUpdate",
        properties = {
            property("NumberApproachPositions", IntValue) { it.numberApproachPositions }
            property("AllowsPassthrough", BooleanValue) { it.allowsPassthrough }
            property("StartingBoxes", IntValue) { it.startingBoxes }
            property("DeleteWhenEmpty", BooleanValue) { it.deleteWhenEmpty }
        },
    )
}
