package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.ContainCondition
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.ObjectCount
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class HordeGarrisonContain(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectStatusOfContained") override val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("Slots") override val slots: Int = 0,
    @SageIniName("EnterSound") override val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("ExitSound") override val exitSound: SageReference<AudioEvent>? = null,
    @SageIniName("DamagePercentToUnits") override val damagePercentToUnits: Double = 0.0,
    @SageIniName("PassengerFilter") override val passengerFilter: SageFilter? = null,
    @SageIniName("AllowEnemiesInside") override val allowEnemiesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") override val allowNeutralInside: Boolean = false,
    @SageIniName("AllowAlliesInside") override val allowAlliesInside: Boolean = false,
    @SageIniName("AllowOwnPlayerInsideOverride") override val allowOwnPlayerInsideOverride: Boolean = false,
    @SageIniName("ExitDelay") override val exitDelay: Int = 0,
    @SageIniName("NumberOfExitPaths") override val numberOfExitPaths: Int = 0,
    @SageIniName("ForceOrientationContainer") override val forceOrientationContainer: Boolean = false,
    @SageIniName("PassengerBonePrefix") override val passengerBonePrefix: List<Map<String, String>> = emptyList(),
    @SageIniName("EjectPassengersOnDeath") override val ejectPassengersOnDeath: Boolean = false,
    @SageIniName("ShowPips") override val showPips: Boolean = false,
    @SageIniName("FadeFilter") override val fadeFilter: SageFilter? = null,
    @SageIniName("FadePassengerOnEnter") override val fadePassengerOnEnter: Boolean = false,
    @SageIniName("EnterFadeTime") override val enterFadeTime: Int = 0,
    @SageIniName("FadePassengerOnExit") override val fadePassengerOnExit: Boolean = false,
    @SageIniName("ExitFadeTime") override val exitFadeTime: Int = 0,
    @SageIniName("KillPassengersOnDeath") override val killPassengersOnDeath: Boolean = false,
    @SageIniName("InitialPayload") override val initialPayload: List<ObjectCount> = emptyList(),
    @SageIniName("ConditionForEntry") override val conditionForEntry: ContainCondition? = null,
    @SageIniName("ContainMax") val containMax: Int = 0,
    @SageIniName("MaxHordeCapacity") val maxHordeCapacity: Int = 0,
    @SageIniName("EntryPosition") val entryPosition: Coords? = null,
    @SageIniName("EntryOffset") val entryOffset: Coords? = null,
    @SageIniName("ExitOffset") val exitOffset: Coords? = null,
) : HordeTransportContain() {

    companion object : SageIniBlockDescriptor<HordeGarrisonContain>(
        name = "HordeGarrisonContain",
        parent = HordeTransportContain,
        properties = {
            property("ContainMax", IntValue) { it.containMax }
            property("MaxHordeCapacity", IntValue) { it.maxHordeCapacity }
            property("EntryPosition", Coords.type) { it.entryPosition }
            property("EntryOffset", Coords.type) { it.entryOffset }
            property("ExitOffset", Coords.type) { it.exitOffset }
        },
    )
}
