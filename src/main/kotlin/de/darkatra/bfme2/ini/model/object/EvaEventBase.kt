package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.audio.SideSound
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue

@SageIniName("_EvaEventBase")
open class EvaEventBase(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Priority") open val priority: Int = 0,
    @SageIniName("TimeBetweenEventsMS") open val timeBetweenEventsMS: Int = 0,
    @SageIniName("ExpirationTimeMS") open val expirationTimeMS: Int = 0,
    @SageIniName("AlwaysPlayFromHomeBase") open val alwaysPlayFromHomeBase: Boolean = false,
    @SageIniName("CountAsJumpToLocation") open val countAsJumpToLocation: Boolean = false,
    @SageIniName("SideSound") open val sideSound: List<SideSound> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<EvaEventBase>(
        name = "_EvaEventBase",
        tableKey = "evaevents",
        properties = {
            property("Priority", IntValue) { it.priority }
            property("TimeBetweenEventsMS", IntValue) { it.timeBetweenEventsMS }
            property("ExpirationTimeMS", IntValue) { it.expirationTimeMS }
            property("AlwaysPlayFromHomeBase", BooleanValue) { it.alwaysPlayFromHomeBase }
            property("CountAsJumpToLocation", BooleanValue) { it.countAsJumpToLocation }
            property("SideSound", ListValue(BlockValue<SideSound> { listOf(SideSound) })) { it.sideSound }
        },
    )
}
