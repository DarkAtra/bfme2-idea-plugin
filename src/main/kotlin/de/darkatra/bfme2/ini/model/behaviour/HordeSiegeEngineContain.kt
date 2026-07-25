package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.ContainCondition
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.ObjectCount
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped
import de.darkatra.bfme2.ini.model.value.UpgradeCreationTrigger

data class HordeSiegeEngineContain(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectStatusOfCrew") override val objectStatusOfCrew: List<ObjectStatus> = emptyList(),
    @SageIniName("Slots") override val slots: Int = 0,
    @SageIniName("DamagePercentToUnits") override val damagePercentToUnits: Double = 0.0,
    @SageIniName("PassengerFilter") override val passengerFilter: SageFilter? = null,
    @SageIniName("KillPassengersOnDeath") override val killPassengersOnDeath: Boolean = false,
    @SageIniName("AllowAlliesInside") override val allowAlliesInside: Boolean = false,
    @SageIniName("AllowEnemiesInside") override val allowEnemiesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") override val allowNeutralInside: Boolean = false,
    @SageIniName("CrewFilter") override val crewFilter: SageFilter? = null,
    @SageIniName("CrewMax") override val crewMax: Int = 0,
    @SageIniName("InitialCrew") override val initialCrew: ObjectCount? = null,
    @SageIniName("ExitDelay") override val exitDelay: Int = 0,
    @SageIniName("NumberOfExitPaths") override val numberOfExitPaths: Int = 0,
    @SageIniName("GoAggressiveOnExit") override val goAggressiveOnExit: Boolean = false,
    @SageIniName("TypeOneForWeaponSet") override val typeOneForWeaponSet: KindOf? = null,
    @SageIniName("EjectPassengersOnDeath") override val ejectPassengersOnDeath: Boolean = false,
    @SageIniName("PassengerBonePrefix") override val passengerBonePrefix: List<Map<String, String>> = emptyList(),
    @SageIniName("BoneSpecificConditionState") override val boneSpecificConditionState: List<Untyped> = emptyList(),
    @SageIniName("ObjectStatusOfContained") override val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("ShowPips") override val showPips: Boolean = false,
    @SageIniName("SpeedPercentPerCrew") override val speedPercentPerCrew: Double = 0.0,
    @SageIniName("ConditionForEntry") override val conditionForEntry: ContainCondition? = null,
    @SageIniName("TransferSelection") override val transferSelection: Boolean = false,
    @SageIniName("EnterSound") override val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("ExitSound") override val exitSound: SageReference<AudioEvent>? = null,
    @SageIniName("UpgradeCreationTrigger") override val upgradeCreationTrigger: List<UpgradeCreationTrigger> = emptyList(),
    @SageIniName("FadeFilter") val fadeFilter: SageFilter? = null,
    @SageIniName("FadePassengerOnEnter") val fadePassengerOnEnter: Boolean = false,
    @SageIniName("EnterFadeTime") val enterFadeTime: Int = 0,
    @SageIniName("FadePassengerOnExit") val fadePassengerOnExit: Boolean = false,
    @SageIniName("ExitFadeTime") val exitFadeTime: Int = 0,
    @SageIniName("FadeReverse") val fadeReverse: Boolean = false,
) : SiegeEngineContain() {

    companion object : SageIniBlockDescriptor<HordeSiegeEngineContain>(
        name = "HordeSiegeEngineContain",
        parent = SiegeEngineContain,
        properties = {
            property("FadeFilter", SageFilter.type) { it.fadeFilter }
            property("FadePassengerOnEnter", BooleanValue) { it.fadePassengerOnEnter }
            property("EnterFadeTime", IntValue) { it.enterFadeTime }
            property("FadePassengerOnExit", BooleanValue) { it.fadePassengerOnExit }
            property("ExitFadeTime", IntValue) { it.exitFadeTime }
            property("FadeReverse", BooleanValue) { it.fadeReverse }
        },
    )
}
