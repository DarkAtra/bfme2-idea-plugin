package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.draw.SoundState

data class ModelConditionSoundSelectorClientBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SoundState") val soundState: List<SoundState> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ModelConditionSoundSelectorClientBehavior>(
        name = "ModelConditionSoundSelectorClientBehavior",
        properties = {
            property("SoundState", ListValue(BlockValue<SoundState> { listOf(SoundState) })) { it.soundState }
        },
    )
}
