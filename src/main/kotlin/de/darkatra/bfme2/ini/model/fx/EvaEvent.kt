package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.EvaEventBase
import de.darkatra.bfme2.ini.model.`object`.NewEvaEvent
import de.darkatra.bfme2.ini.model.`object`.PredefinedEvaEvent
import de.darkatra.bfme2.ini.model.value.MapWeatherType
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class EvaEvent(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectFilter") override val objectFilter: SageFilter? = null,
    @SageIniName("SourceObjectFilter") override val sourceObjectFilter: SageFilter? = null,
    @SageIniName("RequiredSourceModelConditions") override val requiredSourceModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ExcludedSourceModelConditions") override val excludedSourceModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("RequiredSecondaryModelConditions") override val requiredSecondaryModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ExcludedSecondaryModelConditions") override val excludedSecondaryModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("StopIfNuggetPlayed") override val stopIfNuggetPlayed: Boolean = false,
    @SageIniName("Weather") override val weather: MapWeatherType? = null,
    @SageIniName("EvaEventOwner") val evaEventOwner: SageReference<EvaEventBase>? = null,
    @SageIniName("EvaEventAlly") val evaEventAlly: Untyped? = null,
    @SageIniName("EvaEventEnemy") val evaEventEnemy: Untyped? = null,
    @SageIniName("AlwaysPlayFromHomeBase") val alwaysPlayFromHomeBase: Boolean = false,
    @SageIniName("CountAsJumpToLocation") val countAsJumpToLocation: Boolean = false,
    @SageIniName("ExpirationTimeMS") val expirationTimeMS: Int = 0,
    @SageIniName("MillisecondsToWaitBeforePlaying") val millisecondsToWaitBeforePlaying: Int = 0,
    @SageIniName("OtherEvaEventsToBlock") val otherEvaEventsToBlock: List<SageReference<EvaEventBase>> = emptyList(),
    @SageIniName("Priority") val priority: Int = 0,
    @SageIniName("QuietTimeMS") val quietTimeMS: Int = 0,
    @SageIniName("SideSound") val sideSound: Opaque? = null,
    @SageIniName("SideSounds") val sideSounds: Opaque? = null,
    @SageIniName("TimeBetweenChecksMS") val timeBetweenChecksMS: Int = 0,
    @SageIniName("TimeBetweenEventsMS") val timeBetweenEventsMS: Int = 0,
) : FXNugget(), SageNestedAttribute {

    companion object : SageIniBlockDescriptor<EvaEvent>(
        name = "EvaEvent",
        parent = FXNugget,
        properties = {
            property("EvaEventOwner", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.evaEventOwner }
            property("EvaEventAlly", Untyped.type) { it.evaEventAlly }
            property("EvaEventEnemy", Untyped.type) { it.evaEventEnemy }
            property("AlwaysPlayFromHomeBase", BooleanValue) { it.alwaysPlayFromHomeBase }
            property("CountAsJumpToLocation", BooleanValue) { it.countAsJumpToLocation }
            property("ExpirationTimeMS", IntValue) { it.expirationTimeMS }
            property("MillisecondsToWaitBeforePlaying", IntValue) { it.millisecondsToWaitBeforePlaying }
            property("OtherEvaEventsToBlock", ListValue(ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) })) { it.otherEvaEventsToBlock }
            property("Priority", IntValue) { it.priority }
            property("QuietTimeMS", IntValue) { it.quietTimeMS }
            property("SideSound", Opaque.type) { it.sideSound }
            property("SideSounds", Opaque.type) { it.sideSounds }
            property("TimeBetweenChecksMS", IntValue) { it.timeBetweenChecksMS }
            property("TimeBetweenEventsMS", IntValue) { it.timeBetweenEventsMS }
        },
    )
}
