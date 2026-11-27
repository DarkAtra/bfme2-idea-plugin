package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Untyped

data class LargeGroupAudioUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("UnitWeight") val unitWeight: Int = 0,
    @SageIniName("Key") val key: Untyped? = null,
    @SageIniName("TimeBetweenUpdatesMin") val timeBetweenUpdatesMin: Int = 0,
    @SageIniName("TimeBetweenUpdatesVariation") val timeBetweenUpdatesVariation: Int = 200,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<LargeGroupAudioUpdate>(
        name = "LargeGroupAudioUpdate",
        properties = {
            property("UnitWeight", IntValue) { it.unitWeight }
            property("Key", Untyped.type) { it.key }
            property("TimeBetweenUpdatesMin", IntValue) { it.timeBetweenUpdatesMin }
            property("TimeBetweenUpdatesVariation", IntValue) { it.timeBetweenUpdatesVariation }
        },
    )
}
