package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.SageIniModel
import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageDraw
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue

data class ReplaceModule(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Behavior") val behavior: List<SageBehavior> = emptyList(),
    @SageIniName("Body") val body: List<SageBehavior> = emptyList(),
    @SageIniName("ClientUpdate") val clientUpdate: List<SageBehavior> = emptyList(),
    @SageIniName("ClientBehavior") val clientBehavior: List<SageBehavior> = emptyList(),
    @SageIniName("Draw") val draw: List<SageDraw> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ReplaceModule>(
        name = "ReplaceModule",
        properties = {
            property("Behavior", ListValue(BlockValue<SageBehavior> { SageIniModel.behaviors })) { it.behavior }
            property("Body", ListValue(BlockValue<SageBehavior> { SageIniModel.behaviors })) { it.body }
            property("ClientUpdate", ListValue(BlockValue<SageBehavior> { SageIniModel.behaviors })) { it.clientUpdate }
            property("ClientBehavior", ListValue(BlockValue<SageBehavior> { SageIniModel.behaviors })) { it.clientBehavior }
            property("Draw", ListValue(BlockValue<SageDraw> { SageIniModel.draws })) { it.draw }
        },
    )
}
