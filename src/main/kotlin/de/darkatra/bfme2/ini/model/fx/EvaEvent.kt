package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.EvaEventBase
import de.darkatra.bfme2.ini.model.`object`.NewEvaEvent
import de.darkatra.bfme2.ini.model.`object`.PredefinedEvaEvent
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class EvaEvent(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("EvaEventOwner") val evaEventOwner: SageReference<EvaEventBase>? = null,
    @SageIniName("EvaEventAlly") val evaEventAlly: Untyped? = null,
    @SageIniName("EvaEventEnemy") val evaEventEnemy: Untyped? = null,
    @SageIniName("RequiredSourceModelConditions") val requiredSourceModelConditions: Untyped? = null,
    @SageIniName("ExcludedSourceModelConditions") val excludedSourceModelConditions: Untyped? = null,
    @SageIniName("AlwaysPlayFromHomeBase") val alwaysPlayFromHomeBase: Boolean = false,
    @SageIniName("CountAsJumpToLocation") val countAsJumpToLocation: Boolean = false,
    @SageIniName("ExpirationTimeMS") val expirationTimeMS: Int = 0,
    @SageIniName("MillisecondsToWaitBeforePlaying") val millisecondsToWaitBeforePlaying: Int = 0,
    @SageIniName("OtherEvaEventsToBlock") val otherEvaEventsToBlock: Opaque? = null,
    @SageIniName("Priority") val priority: Int = 0,
    @SageIniName("QuietTimeMS") val quietTimeMS: Int = 0,
    @SageIniName("SideSound") val sideSound: Opaque? = null,
    @SageIniName("SideSounds") val sideSounds: Opaque? = null,
    @SageIniName("TimeBetweenChecksMS") val timeBetweenChecksMS: Int = 0,
    @SageIniName("TimeBetweenEventsMS") val timeBetweenEventsMS: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<EvaEvent>(
        name = "EvaEvent",
        properties = {
            property("EvaEventOwner", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.evaEventOwner }
            property("EvaEventAlly", Untyped.type) { it.evaEventAlly }
            property("EvaEventEnemy", Untyped.type) { it.evaEventEnemy }
            property("RequiredSourceModelConditions", Untyped.type) { it.requiredSourceModelConditions }
            property("ExcludedSourceModelConditions", Untyped.type) { it.excludedSourceModelConditions }
            property("AlwaysPlayFromHomeBase", BooleanValue) { it.alwaysPlayFromHomeBase }
            property("CountAsJumpToLocation", BooleanValue) { it.countAsJumpToLocation }
            property("ExpirationTimeMS", IntValue) { it.expirationTimeMS }
            property("MillisecondsToWaitBeforePlaying", IntValue) { it.millisecondsToWaitBeforePlaying }
            property("OtherEvaEventsToBlock", Opaque.type) { it.otherEvaEventsToBlock }
            property("Priority", IntValue) { it.priority }
            property("QuietTimeMS", IntValue) { it.quietTimeMS }
            property("SideSound", Opaque.type) { it.sideSound }
            property("SideSounds", Opaque.type) { it.sideSounds }
            property("TimeBetweenChecksMS", IntValue) { it.timeBetweenChecksMS }
            property("TimeBetweenEventsMS", IntValue) { it.timeBetweenEventsMS }
        },
    )
}
