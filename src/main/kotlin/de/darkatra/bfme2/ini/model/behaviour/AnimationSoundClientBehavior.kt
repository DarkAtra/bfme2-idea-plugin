package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue

data class AnimationSoundClientBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MaxUpdateRangeCap") val maxUpdateRangeCap: Int = 0,
    @SageIniName("AnimationSound") val animationSound: Map<String, String> = emptyMap(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<AnimationSoundClientBehavior>(
        name = "AnimationSoundClientBehavior",
        properties = {
            property("MaxUpdateRangeCap", IntValue) { it.maxUpdateRangeCap }
            property("AnimationSound", MapValue(StringValue, StringValue)) { it.animationSound }
        },
    )
}
