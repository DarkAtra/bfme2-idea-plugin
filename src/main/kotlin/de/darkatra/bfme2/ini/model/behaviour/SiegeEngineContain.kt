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
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.ObjectCount
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped
import de.darkatra.bfme2.ini.model.value.UpgradeCreationTrigger

open class SiegeEngineContain(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectStatusOfCrew") open val objectStatusOfCrew: List<ObjectStatus> = emptyList(),
    @SageIniName("Slots") open val slots: Int = 0,
    @SageIniName("DamagePercentToUnits") open val damagePercentToUnits: Double = 0.0,
    @SageIniName("PassengerFilter") open val passengerFilter: SageFilter? = null,
    @SageIniName("KillPassengersOnDeath") open val killPassengersOnDeath: Boolean = false,
    @SageIniName("AllowAlliesInside") open val allowAlliesInside: Boolean = false,
    @SageIniName("AllowEnemiesInside") open val allowEnemiesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") open val allowNeutralInside: Boolean = false,
    @SageIniName("CrewFilter") open val crewFilter: SageFilter? = null,
    @SageIniName("CrewMax") open val crewMax: Int = 0,
    @SageIniName("InitialCrew") open val initialCrew: ObjectCount? = null,
    @SageIniName("ExitDelay") open val exitDelay: Int = 0,
    @SageIniName("NumberOfExitPaths") open val numberOfExitPaths: Int = 0,
    @SageIniName("GoAggressiveOnExit") open val goAggressiveOnExit: Boolean = false,
    @SageIniName("TypeOneForWeaponSet") open val typeOneForWeaponSet: KindOf? = null,
    @SageIniName("EjectPassengersOnDeath") open val ejectPassengersOnDeath: Boolean = false,
    @SageIniName("PassengerBonePrefix") open val passengerBonePrefix: List<Map<String, String>> = emptyList(),
    @SageIniName("BoneSpecificConditionState") open val boneSpecificConditionState: List<Untyped> = emptyList(),
    @SageIniName("ObjectStatusOfContained") open val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("ShowPips") open val showPips: Boolean = false,
    @SageIniName("SpeedPercentPerCrew") open val speedPercentPerCrew: Double = 0.0,
    @SageIniName("ConditionForEntry") open val conditionForEntry: ContainCondition? = null,
    @SageIniName("TransferSelection") open val transferSelection: Boolean = false,
    @SageIniName("EnterSound") open val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("ExitSound") open val exitSound: SageReference<AudioEvent>? = null,
    @SageIniName("UpgradeCreationTrigger") open val upgradeCreationTrigger: List<UpgradeCreationTrigger> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SiegeEngineContain>(
        name = "SiegeEngineContain",
        properties = {
            property("ObjectStatusOfCrew", ListValue(ObjectStatus.type)) { it.objectStatusOfCrew }
            property("Slots", IntValue) { it.slots }
            property("DamagePercentToUnits", FloatValue) { it.damagePercentToUnits }
            property("PassengerFilter", SageFilter.type) { it.passengerFilter }
            property("KillPassengersOnDeath", BooleanValue) { it.killPassengersOnDeath }
            property("AllowAlliesInside", BooleanValue) { it.allowAlliesInside }
            property("AllowEnemiesInside", BooleanValue) { it.allowEnemiesInside }
            property("AllowNeutralInside", BooleanValue) { it.allowNeutralInside }
            property("CrewFilter", SageFilter.type) { it.crewFilter }
            property("CrewMax", IntValue) { it.crewMax }
            property("InitialCrew", ObjectCount.type) { it.initialCrew }
            property("ExitDelay", IntValue) { it.exitDelay }
            property("NumberOfExitPaths", IntValue) { it.numberOfExitPaths }
            property("GoAggressiveOnExit", BooleanValue) { it.goAggressiveOnExit }
            property("TypeOneForWeaponSet", KindOf.type) { it.typeOneForWeaponSet }
            property("EjectPassengersOnDeath", BooleanValue) { it.ejectPassengersOnDeath }
            property("PassengerBonePrefix", ListValue(MapValue(StringValue, StringValue))) { it.passengerBonePrefix }
            property("BoneSpecificConditionState", ListValue(Untyped.type)) { it.boneSpecificConditionState }
            property("ObjectStatusOfContained", ListValue(ObjectStatus.type)) { it.objectStatusOfContained }
            property("ShowPips", BooleanValue) { it.showPips }
            property("SpeedPercentPerCrew", FloatValue) { it.speedPercentPerCrew }
            property("ConditionForEntry", ContainCondition.type) { it.conditionForEntry }
            property("TransferSelection", BooleanValue) { it.transferSelection }
            property("EnterSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.enterSound }
            property("ExitSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.exitSound }
            property("UpgradeCreationTrigger", ListValue(UpgradeCreationTrigger.type)) { it.upgradeCreationTrigger }
        },
    )
}
