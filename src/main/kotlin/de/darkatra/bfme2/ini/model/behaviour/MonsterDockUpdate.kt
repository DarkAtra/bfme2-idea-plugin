package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.SageFilter

data class MonsterDockUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("NumberApproachPositions") val numberApproachPositions: Int = 0,
    @SageIniName("AllowsPassthrough") val allowsPassthrough: Boolean = false,
    @SageIniName("DockableObjectFilter") val dockableObjectFilter: SageFilter? = null,
    @SageIniName("DockedAnimationTime") val dockedAnimationTime: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<MonsterDockUpdate>(
        name = "MonsterDockUpdate",
        properties = {
            property("NumberApproachPositions", IntValue) { it.numberApproachPositions }
            property("AllowsPassthrough", BooleanValue) { it.allowsPassthrough }
            property("DockableObjectFilter", SageFilter.type) { it.dockableObjectFilter }
            property("DockedAnimationTime", IntValue) { it.dockedAnimationTime }
        },
    )
}
