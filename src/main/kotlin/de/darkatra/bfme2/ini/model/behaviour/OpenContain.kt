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
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

open class OpenContain(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ContainMax") open val containMax: Int = 0,
    @SageIniName("EnterSound") open val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("ExitSound") open val exitSound: SageReference<AudioEvent>? = null,
    @SageIniName("DamagePercentToUnits") open val damagePercentToUnits: Double = 0.0,
    @SageIniName("PassengersInTurret") open val passengersInTurret: Boolean = false,
    @SageIniName("AllowAlliesInside") open val allowAlliesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") open val allowNeutralInside: Boolean = false,
    @SageIniName("AllowEnemiesInside") open val allowEnemiesInside: Boolean = false,
    @SageIniName("AllowOwnPlayerInsideOverride") open val allowOwnPlayerInsideOverride: Boolean = false,
    @SageIniName("BoneSpecificConditionState") open val boneSpecificConditionState: List<Untyped> = emptyList(),
    @SageIniName("CollidePickup") open val collidePickup: Boolean = false,
    @SageIniName("DamageAmountRequired") open val damageAmountRequired: Double = -1.0,
    @SageIniName("DeathTypes") open val deathTypes: SageFilter? = null,
    @SageIniName("DoorOpenTime") open val doorOpenTime: Int = 0,
    @SageIniName("EjectPassengersOnDeath") open val ejectPassengersOnDeath: Boolean = false,
    @SageIniName("Enabled") open val enabled: Boolean = true,
    @SageIniName("ExemptStatus") open val exemptStatus: ObjectStatus? = null,
    @SageIniName("KillPassengersOnDeath") open val killPassengersOnDeath: Boolean = false,
    @SageIniName("ManualPickUpFilter") open val manualPickUpFilter: SageFilter? = null,
    @SageIniName("MaxKillerAngle") open val maxKillerAngle: Double = -57.2958,
    @SageIniName("MinKillerAngle") open val minKillerAngle: Double = 57.2958,
    @SageIniName("ModifierRequiredTime") open val modifierRequiredTime: Int = 20000,
    @SageIniName("ModifierToGiveOnExit") open val modifierToGiveOnExit: List<SageReference<ModifierList>> = emptyList(),
    @SageIniName("NumberOfExitPaths") open val numberOfExitPaths: Int = 0,
    @SageIniName("ObjectStatusOfContained") open val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("PassengerBonePrefix") open val passengerBonePrefix: List<Map<String, String>> = emptyList(),
    @SageIniName("PassengerFilter") open val passengerFilter: SageFilter? = null,
    @SageIniName("PassengersTestCollisionHeight") open val passengersTestCollisionHeight: Double = -1000.0,
    @SageIniName("RequiredStatus") open val requiredStatus: ObjectStatus? = null,
    @SageIniName("ShowPips") open val showPips: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<OpenContain>(
        name = "OpenContain",
        properties = {
            property("ContainMax", IntValue) { it.containMax }
            property("EnterSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.enterSound }
            property("ExitSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.exitSound }
            property("DamagePercentToUnits", FloatValue) { it.damagePercentToUnits }
            property("PassengersInTurret", BooleanValue) { it.passengersInTurret }
            property("AllowAlliesInside", BooleanValue) { it.allowAlliesInside }
            property("AllowNeutralInside", BooleanValue) { it.allowNeutralInside }
            property("AllowEnemiesInside", BooleanValue) { it.allowEnemiesInside }
            property("AllowOwnPlayerInsideOverride", BooleanValue) { it.allowOwnPlayerInsideOverride }
            property("BoneSpecificConditionState", ListValue(Untyped.type)) { it.boneSpecificConditionState }
            property("CollidePickup", BooleanValue) { it.collidePickup }
            property("DamageAmountRequired", FloatValue) { it.damageAmountRequired }
            property("DeathTypes", SageFilter.type) { it.deathTypes }
            property("DoorOpenTime", IntValue) { it.doorOpenTime }
            property("EjectPassengersOnDeath", BooleanValue) { it.ejectPassengersOnDeath }
            property("Enabled", BooleanValue) { it.enabled }
            property("ExemptStatus", ObjectStatus.type) { it.exemptStatus }
            property("KillPassengersOnDeath", BooleanValue) { it.killPassengersOnDeath }
            property("ManualPickUpFilter", SageFilter.type) { it.manualPickUpFilter }
            property("MaxKillerAngle", FloatValue) { it.maxKillerAngle }
            property("MinKillerAngle", FloatValue) { it.minKillerAngle }
            property("ModifierRequiredTime", IntValue) { it.modifierRequiredTime }
            property("ModifierToGiveOnExit", ListValue(ReferenceValue<ModifierList> { listOf(ModifierList) })) { it.modifierToGiveOnExit }
            property("NumberOfExitPaths", IntValue) { it.numberOfExitPaths }
            property("ObjectStatusOfContained", ListValue(ObjectStatus.type)) { it.objectStatusOfContained }
            property("PassengerBonePrefix", ListValue(MapValue(StringValue, StringValue))) { it.passengerBonePrefix }
            property("PassengerFilter", SageFilter.type) { it.passengerFilter }
            property("PassengersTestCollisionHeight", FloatValue) { it.passengersTestCollisionHeight }
            property("RequiredStatus", ObjectStatus.type) { it.requiredStatus }
            property("ShowPips", BooleanValue) { it.showPips }
        },
    )
}
