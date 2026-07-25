package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.`object`.FloodMember

data class FloodUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AngleOfFlow") val angleOfFlow: Int = 0,
    @SageIniName("DirectionIsRelative") val directionIsRelative: Boolean = false,
    @SageIniName("FloodMember") val floodMember: List<FloodMember> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<FloodUpdate>(
        name = "FloodUpdate",
        properties = {
            property("AngleOfFlow", IntValue) { it.angleOfFlow }
            property("DirectionIsRelative", BooleanValue) { it.directionIsRelative }
            property("FloodMember", ListValue(BlockValue<FloodMember> { listOf(FloodMember) })) { it.floodMember }
        },
    )
}
