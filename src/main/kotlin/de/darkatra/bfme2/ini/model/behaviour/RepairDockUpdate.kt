package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class RepairDockUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("NumberApproachPositions") val numberApproachPositions: Int = 0,
    @SageIniName("AllowsPassthrough") val allowsPassthrough: Boolean = false,
    @SageIniName("TimeForFullHeal") val timeForFullHeal: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<RepairDockUpdate>(
        name = "RepairDockUpdate",
        properties = {
            property("NumberApproachPositions", IntValue) { it.numberApproachPositions }
            property("AllowsPassthrough", BooleanValue) { it.allowsPassthrough }
            property("TimeForFullHeal", IntValue) { it.timeForFullHeal }
        },
    )
}
