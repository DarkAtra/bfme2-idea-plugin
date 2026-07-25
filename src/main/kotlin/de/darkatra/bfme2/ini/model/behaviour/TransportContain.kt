package de.darkatra.bfme2.ini.model.behaviour

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
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.ContainCondition
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.ObjectCount
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped
import de.darkatra.bfme2.ini.model.value.UpgradeCreationTrigger

open class TransportContain(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AllowInsideKindOf") override val allowInsideKindOf: List<KindOf> = emptyList(),
    @SageIniName("ForbidInsideKindOf") override val forbidInsideKindOf: List<KindOf> = emptyList(),
    @SageIniName("ContainMax") override val containMax: Int = 0,
    @SageIniName("EnterSound") override val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("ExitSound") override val exitSound: SageReference<AudioEvent>? = null,
    @SageIniName("DamagePercentToUnits") override val damagePercentToUnits: Double = 0.0,
    @SageIniName("PassengersInTurret") override val passengersInTurret: Boolean = false,
    @SageIniName("AllowAlliesInside") override val allowAlliesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") override val allowNeutralInside: Boolean = false,
    @SageIniName("AllowEnemiesInside") override val allowEnemiesInside: Boolean = false,
    @SageIniName("ShouldDrawPips") override val shouldDrawPips: Boolean = false,
    @SageIniName("PassengersAllowedToFire") open val passengersAllowedToFire: Boolean = false,
    @SageIniName("Slots") open val slots: Int = 0,
    @SageIniName("BurnedDeathToUnits") open val burnedDeathToUnits: Boolean = false,
    @SageIniName("ExitDelay") open val exitDelay: Int = 0,
    @SageIniName("GoAggressiveOnExit") open val goAggressiveOnExit: Boolean = false,
    @SageIniName("DoorOpenTime") open val doorOpenTime: Int = 0,
    @SageIniName("ScatterNearbyOnExit") open val scatterNearbyOnExit: Boolean = false,
    @SageIniName("OrientLikeContainerOnExit") open val orientLikeContainerOnExit: Boolean = false,
    @SageIniName("KeepContainerVelocityOnExit") open val keepContainerVelocityOnExit: Boolean = false,
    @SageIniName("ExitPitchRate") open val exitPitchRate: Int = 0,
    @SageIniName("ExitBone") open val exitBone: Opaque? = null,
    @SageIniName("DestroyRidersWhoAreNotFreeToExit") open val destroyRidersWhoAreNotFreeToExit: Boolean = false,
    @SageIniName("InitialPayload") open val initialPayload: List<ObjectCount> = emptyList(),
    @SageIniName("NumberOfExitPaths") open val numberOfExitPaths: Int = 0,
    @SageIniName("ArmedRidersUpgradeMyWeaponSet") open val armedRidersUpgradeMyWeaponSet: Boolean = false,
    @SageIniName("WeaponBonusPassedToPassengers") open val weaponBonusPassedToPassengers: Boolean = false,
    @SageIniName("DelayExitInAir") open val delayExitInAir: Boolean = false,
    @SageIniName("ObjectStatusOfContained") open val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("PassengerFilter") open val passengerFilter: SageFilter? = null,
    @SageIniName("ShowPips") open val showPips: Boolean = false,
    @SageIniName("TypeOneForWeaponSet") open val typeOneForWeaponSet: KindOf? = null,
    @SageIniName("TypeTwoForWeaponSet") open val typeTwoForWeaponSet: KindOf? = null,
    @SageIniName("TypeOneForWeaponState") open val typeOneForWeaponState: KindOf? = null,
    @SageIniName("TypeTwoForWeaponState") open val typeTwoForWeaponState: KindOf? = null,
    @SageIniName("PassengerBonePrefix") open val passengerBonePrefix: List<Map<String, String>> = emptyList(),
    @SageIniName("KillPassengersOnDeath") open val killPassengersOnDeath: Boolean = false,
    @SageIniName("ManualPickUpFilter") open val manualPickUpFilter: SageFilter? = null,
    @SageIniName("EjectPassengersOnDeath") open val ejectPassengersOnDeath: Boolean = false,
    @SageIniName("CanGrabStructure") open val canGrabStructure: Boolean = false,
    @SageIniName("GrabWeapon") open val grabWeapon: SageReference<Weapon>? = null,
    @SageIniName("FireGrabWeaponOnVictim") open val fireGrabWeaponOnVictim: Boolean = false,
    @SageIniName("ReleaseSnappyness") open val releaseSnappyness: Double = 0.0,
    @SageIniName("ForceOrientationContainer") open val forceOrientationContainer: Boolean = false,
    @SageIniName("CollidePickup") open val collidePickup: Boolean = false,
    @SageIniName("AllowOwnPlayerInsideOverride") open val allowOwnPlayerInsideOverride: Boolean = false,
    @SageIniName("BoneSpecificConditionState") open val boneSpecificConditionState: List<Untyped> = emptyList(),
    @SageIniName("FadeFilter") open val fadeFilter: SageFilter? = null,
    @SageIniName("UpgradeCreationTrigger") open val upgradeCreationTrigger: List<UpgradeCreationTrigger> = emptyList(),
    @SageIniName("FadePassengerOnEnter") open val fadePassengerOnEnter: Boolean = false,
    @SageIniName("EnterFadeTime") open val enterFadeTime: Int = 0,
    @SageIniName("FadePassengerOnExit") open val fadePassengerOnExit: Boolean = false,
    @SageIniName("ExitFadeTime") open val exitFadeTime: Int = 0,
    @SageIniName("ConditionForEntry") open val conditionForEntry: ContainCondition? = null,
) : OpenContain() {

    companion object : SageIniBlockDescriptor<TransportContain>(
        name = "TransportContain",
        parent = OpenContain,
        properties = {
            property("PassengersAllowedToFire", BooleanValue) { it.passengersAllowedToFire }
            property("Slots", IntValue) { it.slots }
            property("BurnedDeathToUnits", BooleanValue) { it.burnedDeathToUnits }
            property("ExitDelay", IntValue) { it.exitDelay }
            property("GoAggressiveOnExit", BooleanValue) { it.goAggressiveOnExit }
            property("DoorOpenTime", IntValue) { it.doorOpenTime }
            property("ScatterNearbyOnExit", BooleanValue) { it.scatterNearbyOnExit }
            property("OrientLikeContainerOnExit", BooleanValue) { it.orientLikeContainerOnExit }
            property("KeepContainerVelocityOnExit", BooleanValue) { it.keepContainerVelocityOnExit }
            property("ExitPitchRate", IntValue) { it.exitPitchRate }
            property("ExitBone", Opaque.type) { it.exitBone }
            property("DestroyRidersWhoAreNotFreeToExit", BooleanValue) { it.destroyRidersWhoAreNotFreeToExit }
            property("InitialPayload", ListValue(ObjectCount.type)) { it.initialPayload }
            property("NumberOfExitPaths", IntValue) { it.numberOfExitPaths }
            property("ArmedRidersUpgradeMyWeaponSet", BooleanValue) { it.armedRidersUpgradeMyWeaponSet }
            property("WeaponBonusPassedToPassengers", BooleanValue) { it.weaponBonusPassedToPassengers }
            property("DelayExitInAir", BooleanValue) { it.delayExitInAir }
            property("ObjectStatusOfContained", ListValue(ObjectStatus.type)) { it.objectStatusOfContained }
            property("PassengerFilter", SageFilter.type) { it.passengerFilter }
            property("ShowPips", BooleanValue) { it.showPips }
            property("TypeOneForWeaponSet", KindOf.type) { it.typeOneForWeaponSet }
            property("TypeTwoForWeaponSet", KindOf.type) { it.typeTwoForWeaponSet }
            property("TypeOneForWeaponState", KindOf.type) { it.typeOneForWeaponState }
            property("TypeTwoForWeaponState", KindOf.type) { it.typeTwoForWeaponState }
            property("PassengerBonePrefix", ListValue(MapValue(StringValue, StringValue))) { it.passengerBonePrefix }
            property("KillPassengersOnDeath", BooleanValue) { it.killPassengersOnDeath }
            property("ManualPickUpFilter", SageFilter.type) { it.manualPickUpFilter }
            property("EjectPassengersOnDeath", BooleanValue) { it.ejectPassengersOnDeath }
            property("CanGrabStructure", BooleanValue) { it.canGrabStructure }
            property("GrabWeapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.grabWeapon }
            property("FireGrabWeaponOnVictim", BooleanValue) { it.fireGrabWeaponOnVictim }
            property("ReleaseSnappyness", FloatValue) { it.releaseSnappyness }
            property("ForceOrientationContainer", BooleanValue) { it.forceOrientationContainer }
            property("CollidePickup", BooleanValue) { it.collidePickup }
            property("AllowOwnPlayerInsideOverride", BooleanValue) { it.allowOwnPlayerInsideOverride }
            property("BoneSpecificConditionState", ListValue(Untyped.type)) { it.boneSpecificConditionState }
            property("FadeFilter", SageFilter.type) { it.fadeFilter }
            property("UpgradeCreationTrigger", ListValue(UpgradeCreationTrigger.type)) { it.upgradeCreationTrigger }
            property("FadePassengerOnEnter", BooleanValue) { it.fadePassengerOnEnter }
            property("EnterFadeTime", IntValue) { it.enterFadeTime }
            property("FadePassengerOnExit", BooleanValue) { it.fadePassengerOnExit }
            property("ExitFadeTime", IntValue) { it.exitFadeTime }
            property("ConditionForEntry", ContainCondition.type) { it.conditionForEntry }
        },
    )
}
