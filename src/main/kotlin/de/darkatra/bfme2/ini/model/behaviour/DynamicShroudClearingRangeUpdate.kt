package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Untyped

data class DynamicShroudClearingRangeUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ChangeInterval") val changeInterval: Int = 0,
    @SageIniName("GrowInterval") val growInterval: Int = 0,
    @SageIniName("ShrinkDelay") val shrinkDelay: Int = 0,
    @SageIniName("ShrinkTime") val shrinkTime: Int = 0,
    @SageIniName("GrowDelay") val growDelay: Int = 0,
    @SageIniName("GrowTime") val growTime: Int = 0,
    @SageIniName("FinalVision") val finalVision: Double = 0.0,
    @SageIniName("GridDecalTemplate") val gridDecalTemplate: Untyped? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<DynamicShroudClearingRangeUpdate>(
        name = "DynamicShroudClearingRangeUpdate",
        properties = {
            property("ChangeInterval", IntValue) { it.changeInterval }
            property("GrowInterval", IntValue) { it.growInterval }
            property("ShrinkDelay", IntValue) { it.shrinkDelay }
            property("ShrinkTime", IntValue) { it.shrinkTime }
            property("GrowDelay", IntValue) { it.growDelay }
            property("GrowTime", IntValue) { it.growTime }
            property("FinalVision", FloatValue) { it.finalVision }
            property("GridDecalTemplate", Untyped.type) { it.gridDecalTemplate }
        },
    )
}
