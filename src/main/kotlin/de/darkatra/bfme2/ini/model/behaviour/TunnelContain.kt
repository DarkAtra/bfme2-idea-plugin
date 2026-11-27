package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.ObjectCount
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class TunnelContain(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ContainMax") override val containMax: Int = 0,
    @SageIniName("EnterSound") override val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("ExitSound") override val exitSound: SageReference<AudioEvent>? = null,
    @SageIniName("DamagePercentToUnits") override val damagePercentToUnits: Double = 0.0,
    @SageIniName("PassengersInTurret") override val passengersInTurret: Boolean = false,
    @SageIniName("AllowAlliesInside") override val allowAlliesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") override val allowNeutralInside: Boolean = false,
    @SageIniName("AllowEnemiesInside") override val allowEnemiesInside: Boolean = false,
    @SageIniName("MobileGarrison") override val mobileGarrison: Boolean = false,
    @SageIniName("InitialRoster") override val initialRoster: ObjectCount? = null,
    @SageIniName("ImmuneToClearBuildingAttacks") override val immuneToClearBuildingAttacks: Boolean = false,
    @SageIniName("ObjectStatusOfContained") override val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("PassengerFilter") override val passengerFilter: SageFilter? = null,
    @SageIniName("TimeForFullHeal") override val timeForFullHeal: Int = 0,
    @SageIniName("PassengerBonePrefix") override val passengerBonePrefix: List<Map<String, String>> = emptyList(),
    @SageIniName("EntryPosition") val entryPosition: Coords? = null,
    @SageIniName("EntryOffset") val entryOffset: Coords? = null,
    @SageIniName("ExitOffset") val exitOffset: Coords? = null,
    @SageIniName("KillPassengersOnDeath") override val killPassengersOnDeath: Boolean = false,
    @SageIniName("ShowPips") override val showPips: Boolean = false,
    @SageIniName("ExitDelay") val exitDelay: Int = 0,
    @SageIniName("NumberOfExitPaths") override val numberOfExitPaths: Int = 0,
    @SageIniName("AllowOwnPlayerInsideOverride") override val allowOwnPlayerInsideOverride: Boolean = false,
    @SageIniName("EjectPassengersOnDeath") override val ejectPassengersOnDeath: Boolean = false,
) : GarrisonContain() {

    companion object : SageIniBlockDescriptor<TunnelContain>(
        name = "TunnelContain",
        parent = GarrisonContain,
        properties = {
            property("EntryPosition", Coords.type) { it.entryPosition }
            property("EntryOffset", Coords.type) { it.entryOffset }
            property("ExitOffset", Coords.type) { it.exitOffset }
            property("ExitDelay", IntValue) { it.exitDelay }
        },
    )
}
