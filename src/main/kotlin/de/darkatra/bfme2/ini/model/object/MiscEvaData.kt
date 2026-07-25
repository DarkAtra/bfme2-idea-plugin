package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class MiscEvaData(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("EnemySightedMaxVoicePositionScanRange") val enemySightedMaxVoicePositionScanRange: Int = 0,
    @SageIniName("EnemyCampDestroyedDamageTimeoutMS") val enemyCampDestroyedDamageTimeoutMS: Int = 0,
    @SageIniName("FriendlyCampDestroyedDamageTimeoutMS") val friendlyCampDestroyedDamageTimeoutMS: Int = 0,
    @SageIniName("MaxMillisecondsToKeepJumpToEvents") val maxMillisecondsToKeepJumpToEvents: Int = 0,
    @SageIniName("MaxMillisecondsBeforeResettingLastJumpTo") val maxMillisecondsBeforeResettingLastJumpTo: Int = 0,
    @SageIniName("MinDistanceBetweenJumpToEvents") val minDistanceBetweenJumpToEvents: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<MiscEvaData>(
        name = "MiscEvaData",
        tableKey = "miscevadatas",
        properties = {
            property("EnemySightedMaxVoicePositionScanRange", IntValue) { it.enemySightedMaxVoicePositionScanRange }
            property("EnemyCampDestroyedDamageTimeoutMS", IntValue) { it.enemyCampDestroyedDamageTimeoutMS }
            property("FriendlyCampDestroyedDamageTimeoutMS", IntValue) { it.friendlyCampDestroyedDamageTimeoutMS }
            property("MaxMillisecondsToKeepJumpToEvents", IntValue) { it.maxMillisecondsToKeepJumpToEvents }
            property("MaxMillisecondsBeforeResettingLastJumpTo", IntValue) { it.maxMillisecondsBeforeResettingLastJumpTo }
            property("MinDistanceBetweenJumpToEvents", IntValue) { it.minDistanceBetweenJumpToEvents }
        },
    )
}
