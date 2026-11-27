package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
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

open class TransportContain(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ContainMax") override val containMax: Int = 0,
    @SageIniName("EnterSound") override val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("ExitSound") override val exitSound: SageReference<AudioEvent>? = null,
    @SageIniName("DamagePercentToUnits") override val damagePercentToUnits: Double = 0.0,
    @SageIniName("PassengersInTurret") override val passengersInTurret: Boolean = false,
    @SageIniName("AllowAlliesInside") override val allowAlliesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") override val allowNeutralInside: Boolean = false,
    @SageIniName("AllowEnemiesInside") override val allowEnemiesInside: Boolean = false,
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
    @SageIniName("Slots") open val slots: Int = 0,
    @SageIniName("ExitDelay") open val exitDelay: Int = 0,
    @SageIniName("GoAggressiveOnExit") open val goAggressiveOnExit: Boolean = false,
    @SageIniName("ScatterNearbyOnExit") open val scatterNearbyOnExit: Boolean = false,
    @SageIniName("OrientLikeContainerOnExit") open val orientLikeContainerOnExit: Boolean = false,
    @SageIniName("ExitPitchRate") open val exitPitchRate: Int = 0,
    @SageIniName("ExitBone") open val exitBone: Opaque? = null,
    @SageIniName("DestroyRidersWhoAreNotFreeToExit") open val destroyRidersWhoAreNotFreeToExit: Boolean = false,
    @SageIniName("InitialPayload") open val initialPayload: List<ObjectCount> = emptyList(),
    @SageIniName("TypeOneForWeaponSet") open val typeOneForWeaponSet: KindOf? = null,
    @SageIniName("TypeTwoForWeaponSet") open val typeTwoForWeaponSet: KindOf? = null,
    @SageIniName("TypeOneForWeaponState") open val typeOneForWeaponState: KindOf? = null,
    @SageIniName("TypeTwoForWeaponState") open val typeTwoForWeaponState: KindOf? = null,
    @SageIniName("CanGrabStructure") open val canGrabStructure: Boolean = false,
    @SageIniName("GrabWeapon") open val grabWeapon: SageReference<Weapon>? = null,
    @SageIniName("FireGrabWeaponOnVictim") open val fireGrabWeaponOnVictim: Boolean = false,
    @SageIniName("ReleaseSnappyness") open val releaseSnappyness: Double = 0.0,
    @SageIniName("ForceOrientationContainer") open val forceOrientationContainer: Boolean = false,
    @SageIniName("FadeFilter") open val fadeFilter: SageFilter? = null,
    @SageIniName("UpgradeCreationTrigger") open val upgradeCreationTrigger: List<UpgradeCreationTrigger> = emptyList(),
    @SageIniName("FadePassengerOnEnter") open val fadePassengerOnEnter: Boolean = false,
    @SageIniName("EnterFadeTime") open val enterFadeTime: Int = 0,
    @SageIniName("FadePassengerOnExit") open val fadePassengerOnExit: Boolean = false,
    @SageIniName("ExitFadeTime") open val exitFadeTime: Int = 0,
    @SageIniName("ConditionForEntry") open val conditionForEntry: ContainCondition? = null,
    @SageIniName("ShouldThrowOutPassengers") open val shouldThrowOutPassengers: Boolean = false,
    @SageIniName("FadeReverse") open val fadeReverse: Boolean = false,
    @SageIniName("HealthRegen%PerSec") open val healthRegenPerSec: Double = 0.0,
    @SageIniName("ResetMoodCheckTimeOnExit") open val resetMoodCheckTimeOnExit: Boolean = true,
    @SageIniName("ThrowOutPassengersDelay") open val throwOutPassengersDelay: Int = 0,
    @SageIniName("ThrowOutPassengersLandingWarhead") open val throwOutPassengersLandingWarhead: SageReference<Weapon>? = null,
    @SageIniName("ThrowOutPassengersVelocity") open val throwOutPassengersVelocity: Coords? = null,
    @SageIniName("TypeThreeForWeaponState") open val typeThreeForWeaponState: KindOf? = null,
) : OpenContain() {

    companion object : SageIniBlockDescriptor<TransportContain>(
        name = "TransportContain",
        parent = OpenContain,
        properties = {
            property("Slots", IntValue) { it.slots }
            property("ExitDelay", IntValue) { it.exitDelay }
            property("GoAggressiveOnExit", BooleanValue) { it.goAggressiveOnExit }
            property("ScatterNearbyOnExit", BooleanValue) { it.scatterNearbyOnExit }
            property("OrientLikeContainerOnExit", BooleanValue) { it.orientLikeContainerOnExit }
            property("ExitPitchRate", IntValue) { it.exitPitchRate }
            property("ExitBone", Opaque.type) { it.exitBone }
            property("DestroyRidersWhoAreNotFreeToExit", BooleanValue) { it.destroyRidersWhoAreNotFreeToExit }
            property("InitialPayload", ListValue(ObjectCount.type)) { it.initialPayload }
            property("TypeOneForWeaponSet", KindOf.type) { it.typeOneForWeaponSet }
            property("TypeTwoForWeaponSet", KindOf.type) { it.typeTwoForWeaponSet }
            property("TypeOneForWeaponState", KindOf.type) { it.typeOneForWeaponState }
            property("TypeTwoForWeaponState", KindOf.type) { it.typeTwoForWeaponState }
            property("CanGrabStructure", BooleanValue) { it.canGrabStructure }
            property("GrabWeapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.grabWeapon }
            property("FireGrabWeaponOnVictim", BooleanValue) { it.fireGrabWeaponOnVictim }
            property("ReleaseSnappyness", FloatValue) { it.releaseSnappyness }
            property("ForceOrientationContainer", BooleanValue) { it.forceOrientationContainer }
            property("FadeFilter", SageFilter.type) { it.fadeFilter }
            property("UpgradeCreationTrigger", ListValue(UpgradeCreationTrigger.type)) { it.upgradeCreationTrigger }
            property("FadePassengerOnEnter", BooleanValue) { it.fadePassengerOnEnter }
            property("EnterFadeTime", IntValue) { it.enterFadeTime }
            property("FadePassengerOnExit", BooleanValue) { it.fadePassengerOnExit }
            property("ExitFadeTime", IntValue) { it.exitFadeTime }
            property("ConditionForEntry", ContainCondition.type) { it.conditionForEntry }
            property("ShouldThrowOutPassengers", BooleanValue) { it.shouldThrowOutPassengers }
            property("FadeReverse", BooleanValue) { it.fadeReverse }
            property("HealthRegen%PerSec", FloatValue) { it.healthRegenPerSec }
            property("ResetMoodCheckTimeOnExit", BooleanValue) { it.resetMoodCheckTimeOnExit }
            property("ThrowOutPassengersDelay", IntValue) { it.throwOutPassengersDelay }
            property("ThrowOutPassengersLandingWarhead", ReferenceValue<Weapon> { listOf(Weapon) }) { it.throwOutPassengersLandingWarhead }
            property("ThrowOutPassengersVelocity", Coords.type) { it.throwOutPassengersVelocity }
            property("TypeThreeForWeaponState", KindOf.type) { it.typeThreeForWeaponState }
        },
    )
}
