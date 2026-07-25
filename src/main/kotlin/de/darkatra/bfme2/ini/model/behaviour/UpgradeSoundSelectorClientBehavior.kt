package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.audio.SoundUpgrade
import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue

data class UpgradeSoundSelectorClientBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SoundUpgrade") val soundUpgrade: List<SoundUpgrade> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<UpgradeSoundSelectorClientBehavior>(
        name = "UpgradeSoundSelectorClientBehavior",
        properties = {
            property("SoundUpgrade", ListValue(BlockValue<SoundUpgrade> { listOf(SoundUpgrade) })) { it.soundUpgrade }
        },
    )
}
