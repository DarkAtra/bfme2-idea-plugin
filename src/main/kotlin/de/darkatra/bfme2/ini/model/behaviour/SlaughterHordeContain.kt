package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

open class SlaughterHordeContain(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PassengerFilter") open val passengerFilter: SageFilter? = null,
    @SageIniName("ObjectStatusOfContained") open val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("CashBackPercent") open val cashBackPercent: Double = 0.0,
    @SageIniName("ContainMax") open val containMax: Int = 0,
    @SageIniName("MaxHordeCapacity") open val maxHordeCapacity: Int = 0,
    @SageIniName("AllowAlliesInside") open val allowAlliesInside: Boolean = false,
    @SageIniName("AllowEnemiesInside") open val allowEnemiesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") open val allowNeutralInside: Boolean = false,
    @SageIniName("EnterSound") open val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("EntryOffset") open val entryOffset: Coords? = null,
    @SageIniName("ExitOffset") open val exitOffset: Coords? = null,
    @SageIniName("EntryPosition") open val entryPosition: Coords? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SlaughterHordeContain>(
        name = "SlaughterHordeContain",
        properties = {
            property("PassengerFilter", SageFilter.type) { it.passengerFilter }
            property("ObjectStatusOfContained", ListValue(ObjectStatus.type)) { it.objectStatusOfContained }
            property("CashBackPercent", FloatValue) { it.cashBackPercent }
            property("ContainMax", IntValue) { it.containMax }
            property("MaxHordeCapacity", IntValue) { it.maxHordeCapacity }
            property("AllowAlliesInside", BooleanValue) { it.allowAlliesInside }
            property("AllowEnemiesInside", BooleanValue) { it.allowEnemiesInside }
            property("AllowNeutralInside", BooleanValue) { it.allowNeutralInside }
            property("EnterSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.enterSound }
            property("EntryOffset", Coords.type) { it.entryOffset }
            property("ExitOffset", Coords.type) { it.exitOffset }
            property("EntryPosition", Coords.type) { it.entryPosition }
        },
    )
}
