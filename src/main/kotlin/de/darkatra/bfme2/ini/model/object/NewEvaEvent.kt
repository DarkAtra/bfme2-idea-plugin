package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.audio.SideSound
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.Opaque

data class NewEvaEvent(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Priority") override val priority: Int = 0,
    @SageIniName("TimeBetweenEventsMS") override val timeBetweenEventsMS: Int = 0,
    @SageIniName("ExpirationTimeMS") override val expirationTimeMS: Int = 0,
    @SageIniName("AlwaysPlayFromHomeBase") override val alwaysPlayFromHomeBase: Boolean = false,
    @SageIniName("CountAsJumpToLocation") override val countAsJumpToLocation: Boolean = false,
    @SageIniName("MillisecondsToWaitBeforePlaying") val millisecondsToWaitBeforePlaying: Int = 0,
    @SageIniName("OtherEvaEventsToBlock") val otherEvaEventsToBlock: List<Opaque> = emptyList(),
    @SageIniName("SideSound") override val sideSound: List<SideSound> = emptyList(),
) : EvaEventBase() {

    companion object : SageIniBlockDescriptor<NewEvaEvent>(
        name = "NewEvaEvent",
        parent = EvaEventBase,
        tableKey = "evaevents",
        properties = {
            property("MillisecondsToWaitBeforePlaying", IntValue) { it.millisecondsToWaitBeforePlaying }
            property("OtherEvaEventsToBlock", ListValue(Opaque.type)) { it.otherEvaEventsToBlock }
        },
    )
}
