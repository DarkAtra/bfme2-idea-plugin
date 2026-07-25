package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.AudioLoopCondition

data class ModelConditionAudioLoopClientBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ModelCondition") val modelCondition: List<AudioLoopCondition> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ModelConditionAudioLoopClientBehavior>(
        name = "ModelConditionAudioLoopClientBehavior",
        properties = {
            property("ModelCondition", ListValue(AudioLoopCondition.type)) { it.modelCondition }
        },
    )
}
