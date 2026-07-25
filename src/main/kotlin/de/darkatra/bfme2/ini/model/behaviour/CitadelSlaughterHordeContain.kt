package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class CitadelSlaughterHordeContain(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PassengerFilter") override val passengerFilter: SageFilter? = null,
    @SageIniName("ObjectStatusOfContained") override val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("CashBackPercent") override val cashBackPercent: Double = 0.0,
    @SageIniName("ContainMax") override val containMax: Int = 0,
    @SageIniName("MaxHordeCapacity") override val maxHordeCapacity: Int = 0,
    @SageIniName("AllowAlliesInside") override val allowAlliesInside: Boolean = false,
    @SageIniName("AllowEnemiesInside") override val allowEnemiesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") override val allowNeutralInside: Boolean = false,
    @SageIniName("EnterSound") override val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("EntryOffset") override val entryOffset: Coords? = null,
    @SageIniName("ExitOffset") override val exitOffset: Coords? = null,
    @SageIniName("EntryPosition") override val entryPosition: Coords? = null,
    @SageIniName("AllowOwnPlayerInsideOverride") val allowOwnPlayerInsideOverride: Boolean = false,
    @SageIniName("StatusForRingEntry") val statusForRingEntry: ObjectStatus? = null,
    @SageIniName("UpgradeForRingEntry") val upgradeForRingEntry: SageReference<Upgrade>? = null,
    @SageIniName("ObjectToDestroyForRingEntry") val objectToDestroyForRingEntry: SageFilter? = null,
    @SageIniName("FXForRingEntry") val fXForRingEntry: SageReference<FXList>? = null,
) : SlaughterHordeContain() {

    companion object : SageIniBlockDescriptor<CitadelSlaughterHordeContain>(
        name = "CitadelSlaughterHordeContain",
        parent = SlaughterHordeContain,
        properties = {
            property("AllowOwnPlayerInsideOverride", BooleanValue) { it.allowOwnPlayerInsideOverride }
            property("StatusForRingEntry", ObjectStatus.type) { it.statusForRingEntry }
            property("UpgradeForRingEntry", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.upgradeForRingEntry }
            property("ObjectToDestroyForRingEntry", SageFilter.type) { it.objectToDestroyForRingEntry }
            property("FXForRingEntry", ReferenceValue<FXList> { listOf(FXList) }) { it.fXForRingEntry }
        },
    )
}
