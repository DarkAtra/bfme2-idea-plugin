package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
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

data class RiderChangeContain(
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
    @SageIniName("PassengersAllowedToFire") override val passengersAllowedToFire: Boolean = false,
    @SageIniName("Slots") override val slots: Int = 0,
    @SageIniName("BurnedDeathToUnits") override val burnedDeathToUnits: Boolean = false,
    @SageIniName("ExitDelay") override val exitDelay: Int = 0,
    @SageIniName("GoAggressiveOnExit") override val goAggressiveOnExit: Boolean = false,
    @SageIniName("DoorOpenTime") override val doorOpenTime: Int = 0,
    @SageIniName("ScatterNearbyOnExit") override val scatterNearbyOnExit: Boolean = false,
    @SageIniName("OrientLikeContainerOnExit") override val orientLikeContainerOnExit: Boolean = false,
    @SageIniName("KeepContainerVelocityOnExit") override val keepContainerVelocityOnExit: Boolean = false,
    @SageIniName("ExitPitchRate") override val exitPitchRate: Int = 0,
    @SageIniName("ExitBone") override val exitBone: Opaque? = null,
    @SageIniName("DestroyRidersWhoAreNotFreeToExit") override val destroyRidersWhoAreNotFreeToExit: Boolean = false,
    @SageIniName("InitialPayload") override val initialPayload: List<ObjectCount> = emptyList(),
    @SageIniName("NumberOfExitPaths") override val numberOfExitPaths: Int = 0,
    @SageIniName("ArmedRidersUpgradeMyWeaponSet") override val armedRidersUpgradeMyWeaponSet: Boolean = false,
    @SageIniName("WeaponBonusPassedToPassengers") override val weaponBonusPassedToPassengers: Boolean = false,
    @SageIniName("DelayExitInAir") override val delayExitInAir: Boolean = false,
    @SageIniName("ObjectStatusOfContained") override val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("PassengerFilter") override val passengerFilter: SageFilter? = null,
    @SageIniName("ShowPips") override val showPips: Boolean = false,
    @SageIniName("TypeOneForWeaponSet") override val typeOneForWeaponSet: KindOf? = null,
    @SageIniName("TypeTwoForWeaponSet") override val typeTwoForWeaponSet: KindOf? = null,
    @SageIniName("TypeOneForWeaponState") override val typeOneForWeaponState: KindOf? = null,
    @SageIniName("TypeTwoForWeaponState") override val typeTwoForWeaponState: KindOf? = null,
    @SageIniName("PassengerBonePrefix") override val passengerBonePrefix: List<Map<String, String>> = emptyList(),
    @SageIniName("KillPassengersOnDeath") override val killPassengersOnDeath: Boolean = false,
    @SageIniName("ManualPickUpFilter") override val manualPickUpFilter: SageFilter? = null,
    @SageIniName("EjectPassengersOnDeath") override val ejectPassengersOnDeath: Boolean = false,
    @SageIniName("CanGrabStructure") override val canGrabStructure: Boolean = false,
    @SageIniName("GrabWeapon") override val grabWeapon: SageReference<Weapon>? = null,
    @SageIniName("FireGrabWeaponOnVictim") override val fireGrabWeaponOnVictim: Boolean = false,
    @SageIniName("ReleaseSnappyness") override val releaseSnappyness: Double = 0.0,
    @SageIniName("ForceOrientationContainer") override val forceOrientationContainer: Boolean = false,
    @SageIniName("CollidePickup") override val collidePickup: Boolean = false,
    @SageIniName("AllowOwnPlayerInsideOverride") override val allowOwnPlayerInsideOverride: Boolean = false,
    @SageIniName("BoneSpecificConditionState") override val boneSpecificConditionState: List<Untyped> = emptyList(),
    @SageIniName("FadeFilter") override val fadeFilter: SageFilter? = null,
    @SageIniName("UpgradeCreationTrigger") override val upgradeCreationTrigger: List<UpgradeCreationTrigger> = emptyList(),
    @SageIniName("FadePassengerOnEnter") override val fadePassengerOnEnter: Boolean = false,
    @SageIniName("EnterFadeTime") override val enterFadeTime: Int = 0,
    @SageIniName("FadePassengerOnExit") override val fadePassengerOnExit: Boolean = false,
    @SageIniName("ExitFadeTime") override val exitFadeTime: Int = 0,
    @SageIniName("ConditionForEntry") override val conditionForEntry: ContainCondition? = null,
    @SageIniName("Rider1") val rider1: Untyped? = null,
    @SageIniName("Rider2") val rider2: Untyped? = null,
    @SageIniName("Rider3") val rider3: Untyped? = null,
    @SageIniName("Rider4") val rider4: Untyped? = null,
    @SageIniName("Rider5") val rider5: Untyped? = null,
    @SageIniName("Rider6") val rider6: Untyped? = null,
    @SageIniName("Rider7") val rider7: Untyped? = null,
    @SageIniName("ScuttleDelay") val scuttleDelay: Int = 0,
    @SageIniName("ScuttleStatus") val scuttleStatus: ObjectStatus? = null,
    @SageIniName("KillRiderWhenVehicleDies") val killRiderWhenVehicleDies: Boolean = false,
    @SageIniName("ObjectStatusOfCrew") val objectStatusOfCrew: List<ObjectStatus> = emptyList(),
    @SageIniName("InitialCrew") val initialCrew: ObjectCount? = null,
    @SageIniName("CrewFilter") val crewFilter: SageFilter? = null,
    @SageIniName("CrewMax") val crewMax: Int = 0,
    @SageIniName("TransferSelection") val transferSelection: Boolean = false,
) : TransportContain() {

    companion object : SageIniBlockDescriptor<RiderChangeContain>(
        name = "RiderChangeContain",
        parent = TransportContain,
        properties = {
            property("Rider1", Untyped.type) { it.rider1 }
            property("Rider2", Untyped.type) { it.rider2 }
            property("Rider3", Untyped.type) { it.rider3 }
            property("Rider4", Untyped.type) { it.rider4 }
            property("Rider5", Untyped.type) { it.rider5 }
            property("Rider6", Untyped.type) { it.rider6 }
            property("Rider7", Untyped.type) { it.rider7 }
            property("ScuttleDelay", IntValue) { it.scuttleDelay }
            property("ScuttleStatus", ObjectStatus.type) { it.scuttleStatus }
            property("KillRiderWhenVehicleDies", BooleanValue) { it.killRiderWhenVehicleDies }
            property("ObjectStatusOfCrew", ListValue(ObjectStatus.type)) { it.objectStatusOfCrew }
            property("InitialCrew", ObjectCount.type) { it.initialCrew }
            property("CrewFilter", SageFilter.type) { it.crewFilter }
            property("CrewMax", IntValue) { it.crewMax }
            property("TransferSelection", BooleanValue) { it.transferSelection }
        },
    )
}
