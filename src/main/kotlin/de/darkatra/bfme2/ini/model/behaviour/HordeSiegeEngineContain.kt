package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.ContainCondition
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.ObjectCount
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped
import de.darkatra.bfme2.ini.model.value.UpgradeCreationTrigger

data class HordeSiegeEngineContain(
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
    @SageIniName("AllowOwnPlayerInsideOverride") override val allowOwnPlayerInsideOverride: Boolean = false,
    @SageIniName("BoneSpecificConditionState") override val boneSpecificConditionState: List<Untyped> = emptyList(),
    @SageIniName("CollidePickup") override val collidePickup: Boolean = false,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = -1.0,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("DoorOpenTime") override val doorOpenTime: Int = 0,
    @SageIniName("EjectPassengersOnDeath") override val ejectPassengersOnDeath: Boolean = false,
    @SageIniName("Enabled") override val enabled: Boolean = true,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("KillPassengersOnDeath") override val killPassengersOnDeath: Boolean = false,
    @SageIniName("ManualPickUpFilter") override val manualPickUpFilter: SageFilter? = null,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Double = -57.2958,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Double = 57.2958,
    @SageIniName("ModifierRequiredTime") override val modifierRequiredTime: Int = 20000,
    @SageIniName("ModifierToGiveOnExit") override val modifierToGiveOnExit: List<SageReference<ModifierList>> = emptyList(),
    @SageIniName("NumberOfExitPaths") override val numberOfExitPaths: Int = 0,
    @SageIniName("ObjectStatusOfContained") override val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("PassengerBonePrefix") override val passengerBonePrefix: List<Map<String, String>> = emptyList(),
    @SageIniName("PassengerFilter") override val passengerFilter: SageFilter? = null,
    @SageIniName("PassengersTestCollisionHeight") override val passengersTestCollisionHeight: Double = -1000.0,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("ShowPips") override val showPips: Boolean = false,
    @SageIniName("PassengersAllowedToFire") override val passengersAllowedToFire: Boolean = false,
    @SageIniName("Slots") override val slots: Int = 0,
    @SageIniName("BurnedDeathToUnits") override val burnedDeathToUnits: Boolean = false,
    @SageIniName("ExitDelay") override val exitDelay: Int = 0,
    @SageIniName("GoAggressiveOnExit") override val goAggressiveOnExit: Boolean = false,
    @SageIniName("ScatterNearbyOnExit") override val scatterNearbyOnExit: Boolean = false,
    @SageIniName("OrientLikeContainerOnExit") override val orientLikeContainerOnExit: Boolean = false,
    @SageIniName("KeepContainerVelocityOnExit") override val keepContainerVelocityOnExit: Boolean = false,
    @SageIniName("ExitPitchRate") override val exitPitchRate: Int = 0,
    @SageIniName("ExitBone") override val exitBone: Opaque? = null,
    @SageIniName("DestroyRidersWhoAreNotFreeToExit") override val destroyRidersWhoAreNotFreeToExit: Boolean = false,
    @SageIniName("InitialPayload") override val initialPayload: List<ObjectCount> = emptyList(),
    @SageIniName("ArmedRidersUpgradeMyWeaponSet") override val armedRidersUpgradeMyWeaponSet: Boolean = false,
    @SageIniName("WeaponBonusPassedToPassengers") override val weaponBonusPassedToPassengers: Boolean = false,
    @SageIniName("DelayExitInAir") override val delayExitInAir: Boolean = false,
    @SageIniName("TypeOneForWeaponSet") override val typeOneForWeaponSet: KindOf? = null,
    @SageIniName("TypeTwoForWeaponSet") override val typeTwoForWeaponSet: KindOf? = null,
    @SageIniName("TypeOneForWeaponState") override val typeOneForWeaponState: KindOf? = null,
    @SageIniName("TypeTwoForWeaponState") override val typeTwoForWeaponState: KindOf? = null,
    @SageIniName("CanGrabStructure") override val canGrabStructure: Boolean = false,
    @SageIniName("GrabWeapon") override val grabWeapon: SageReference<Weapon>? = null,
    @SageIniName("FireGrabWeaponOnVictim") override val fireGrabWeaponOnVictim: Boolean = false,
    @SageIniName("ReleaseSnappyness") override val releaseSnappyness: Double = 0.0,
    @SageIniName("ForceOrientationContainer") override val forceOrientationContainer: Boolean = false,
    @SageIniName("FadeFilter") override val fadeFilter: SageFilter? = null,
    @SageIniName("UpgradeCreationTrigger") override val upgradeCreationTrigger: List<UpgradeCreationTrigger> = emptyList(),
    @SageIniName("FadePassengerOnEnter") override val fadePassengerOnEnter: Boolean = false,
    @SageIniName("EnterFadeTime") override val enterFadeTime: Int = 0,
    @SageIniName("FadePassengerOnExit") override val fadePassengerOnExit: Boolean = false,
    @SageIniName("ExitFadeTime") override val exitFadeTime: Int = 0,
    @SageIniName("ConditionForEntry") override val conditionForEntry: ContainCondition? = null,
    @SageIniName("ShouldThrowOutPassengers") override val shouldThrowOutPassengers: Boolean = false,
    @SageIniName("FadeReverse") override val fadeReverse: Boolean = false,
    @SageIniName("HealthRegen%PerSec") override val healthRegenPerSec: Double = 0.0,
    @SageIniName("ResetMoodCheckTimeOnExit") override val resetMoodCheckTimeOnExit: Boolean = true,
    @SageIniName("ThrowOutPassengersDelay") override val throwOutPassengersDelay: Int = 0,
    @SageIniName("ThrowOutPassengersLandingWarhead") override val throwOutPassengersLandingWarhead: SageReference<Weapon>? = null,
    @SageIniName("ThrowOutPassengersVelocity") override val throwOutPassengersVelocity: Coords? = null,
    @SageIniName("TypeThreeForWeaponState") override val typeThreeForWeaponState: KindOf? = null,
    @SageIniName("CrewAllowedToFire") val crewAllowedToFire: Boolean = false,
    @SageIniName("CrewFilter") val crewFilter: SageFilter? = null,
    @SageIniName("CrewMax") val crewMax: Int = 0,
    @SageIniName("InitialCrew") val initialCrew: ObjectCount? = null,
    @SageIniName("ObjectStatusOfCrew") val objectStatusOfCrew: List<ObjectStatus> = emptyList(),
    @SageIniName("SpeedPercentPerCrew") val speedPercentPerCrew: Double = 0.0,
) : TransportContain() {

    companion object : SageIniBlockDescriptor<HordeSiegeEngineContain>(
        name = "HordeSiegeEngineContain",
        parent = TransportContain,
        properties = {
            property("CrewAllowedToFire", BooleanValue) { it.crewAllowedToFire }
            property("CrewFilter", SageFilter.type) { it.crewFilter }
            property("CrewMax", IntValue) { it.crewMax }
            property("InitialCrew", ObjectCount.type) { it.initialCrew }
            property("ObjectStatusOfCrew", ListValue(ObjectStatus.type)) { it.objectStatusOfCrew }
            property("SpeedPercentPerCrew", FloatValue) { it.speedPercentPerCrew }
        },
    )
}
