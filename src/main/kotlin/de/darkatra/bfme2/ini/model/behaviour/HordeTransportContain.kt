package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.ContainCondition
import de.darkatra.bfme2.ini.model.value.ObjectCount
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

open class HordeTransportContain(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectStatusOfContained") open val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("Slots") open val slots: Int = 0,
    @SageIniName("EnterSound") open val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("ExitSound") open val exitSound: SageReference<AudioEvent>? = null,
    @SageIniName("DamagePercentToUnits") open val damagePercentToUnits: Double = 0.0,
    @SageIniName("PassengerFilter") open val passengerFilter: SageFilter? = null,
    @SageIniName("AllowEnemiesInside") open val allowEnemiesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") open val allowNeutralInside: Boolean = false,
    @SageIniName("AllowAlliesInside") open val allowAlliesInside: Boolean = false,
    @SageIniName("AllowOwnPlayerInsideOverride") open val allowOwnPlayerInsideOverride: Boolean = false,
    @SageIniName("ExitDelay") open val exitDelay: Int = 0,
    @SageIniName("NumberOfExitPaths") open val numberOfExitPaths: Int = 0,
    @SageIniName("ForceOrientationContainer") open val forceOrientationContainer: Boolean = false,
    @SageIniName("PassengerBonePrefix") open val passengerBonePrefix: List<Map<String, String>> = emptyList(),
    @SageIniName("EjectPassengersOnDeath") open val ejectPassengersOnDeath: Boolean = false,
    @SageIniName("ShowPips") open val showPips: Boolean = false,
    @SageIniName("FadeFilter") open val fadeFilter: SageFilter? = null,
    @SageIniName("FadePassengerOnEnter") open val fadePassengerOnEnter: Boolean = false,
    @SageIniName("EnterFadeTime") open val enterFadeTime: Int = 0,
    @SageIniName("FadePassengerOnExit") open val fadePassengerOnExit: Boolean = false,
    @SageIniName("ExitFadeTime") open val exitFadeTime: Int = 0,
    @SageIniName("KillPassengersOnDeath") open val killPassengersOnDeath: Boolean = false,
    @SageIniName("InitialPayload") open val initialPayload: List<ObjectCount> = emptyList(),
    @SageIniName("ConditionForEntry") open val conditionForEntry: ContainCondition? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<HordeTransportContain>(
        name = "HordeTransportContain",
        properties = {
            property("ObjectStatusOfContained", ListValue(ObjectStatus.type)) { it.objectStatusOfContained }
            property("Slots", IntValue) { it.slots }
            property("EnterSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.enterSound }
            property("ExitSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.exitSound }
            property("DamagePercentToUnits", FloatValue) { it.damagePercentToUnits }
            property("PassengerFilter", SageFilter.type) { it.passengerFilter }
            property("AllowEnemiesInside", BooleanValue) { it.allowEnemiesInside }
            property("AllowNeutralInside", BooleanValue) { it.allowNeutralInside }
            property("AllowAlliesInside", BooleanValue) { it.allowAlliesInside }
            property("AllowOwnPlayerInsideOverride", BooleanValue) { it.allowOwnPlayerInsideOverride }
            property("ExitDelay", IntValue) { it.exitDelay }
            property("NumberOfExitPaths", IntValue) { it.numberOfExitPaths }
            property("ForceOrientationContainer", BooleanValue) { it.forceOrientationContainer }
            property("PassengerBonePrefix", ListValue(MapValue(StringValue, StringValue))) { it.passengerBonePrefix }
            property("EjectPassengersOnDeath", BooleanValue) { it.ejectPassengersOnDeath }
            property("ShowPips", BooleanValue) { it.showPips }
            property("FadeFilter", SageFilter.type) { it.fadeFilter }
            property("FadePassengerOnEnter", BooleanValue) { it.fadePassengerOnEnter }
            property("EnterFadeTime", IntValue) { it.enterFadeTime }
            property("FadePassengerOnExit", BooleanValue) { it.fadePassengerOnExit }
            property("ExitFadeTime", IntValue) { it.exitFadeTime }
            property("KillPassengersOnDeath", BooleanValue) { it.killPassengersOnDeath }
            property("InitialPayload", ListValue(ObjectCount.type)) { it.initialPayload }
            property("ConditionForEntry", ContainCondition.type) { it.conditionForEntry }
        },
    )
}
