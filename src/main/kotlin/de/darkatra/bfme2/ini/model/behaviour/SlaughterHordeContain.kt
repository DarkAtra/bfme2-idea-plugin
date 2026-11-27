package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

open class SlaughterHordeContain(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PassengerFilter") override val passengerFilter: SageFilter? = null,
    @SageIniName("ObjectStatusOfContained") override val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("CashBackPercent") open val cashBackPercent: Double = 0.0,
    @SageIniName("ContainMax") override val containMax: Int = 0,
    @SageIniName("MaxHordeCapacity") open val maxHordeCapacity: Int = 0,
    @SageIniName("AllowAlliesInside") override val allowAlliesInside: Boolean = false,
    @SageIniName("AllowEnemiesInside") override val allowEnemiesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") override val allowNeutralInside: Boolean = false,
    @SageIniName("EnterSound") override val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("EntryOffset") override val entryOffset: Coords? = null,
    @SageIniName("ExitOffset") override val exitOffset: Coords? = null,
    @SageIniName("EntryPosition") override val entryPosition: Coords? = null,
    @SageIniName("CanAlwaysEnter") open val canAlwaysEnter: SageFilter? = null,
    @SageIniName("StatusRequiredForCanAlwaysEnter") open val statusRequiredForCanAlwaysEnter: ObjectStatus? = null,
) : HordeGarrisonContain() {

    companion object : SageIniBlockDescriptor<SlaughterHordeContain>(
        name = "SlaughterHordeContain",
        parent = HordeGarrisonContain,
        properties = {
            property("CashBackPercent", FloatValue) { it.cashBackPercent }
            property("MaxHordeCapacity", IntValue) { it.maxHordeCapacity }
            property("CanAlwaysEnter", SageFilter.type) { it.canAlwaysEnter }
            property("StatusRequiredForCanAlwaysEnter", ObjectStatus.type) { it.statusRequiredForCanAlwaysEnter }
        },
    )
}
