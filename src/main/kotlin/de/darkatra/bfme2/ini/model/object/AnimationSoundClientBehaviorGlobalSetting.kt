package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class AnimationSoundClientBehaviorGlobalSetting(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MinMicrophoneDistanceToDirty") val minMicrophoneDistanceToDirty: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AnimationSoundClientBehaviorGlobalSetting>(
        name = "AnimationSoundClientBehaviorGlobalSetting",
        tableKey = "animationsoundclientbehaviorglobalsettings",
        properties = {
            property("MinMicrophoneDistanceToDirty", IntValue) { it.minMicrophoneDistanceToDirty }
        },
    )
}
