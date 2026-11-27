package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.ObjectCount
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

open class HordeGarrisonContain(
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
    @SageIniName("MobileGarrison") override val mobileGarrison: Boolean = false,
    @SageIniName("InitialRoster") override val initialRoster: ObjectCount? = null,
    @SageIniName("ImmuneToClearBuildingAttacks") override val immuneToClearBuildingAttacks: Boolean = false,
    @SageIniName("IsEnclosingContainer") override val isEnclosingContainer: Boolean = false,
    @SageIniName("EntryOffset") open val entryOffset: Coords? = null,
    @SageIniName("EntryPosition") open val entryPosition: Coords? = null,
    @SageIniName("ExitDelay") open val exitDelay: Int = 0,
    @SageIniName("ExitOffset") open val exitOffset: Coords? = null,
) : GarrisonContain() {

    companion object : SageIniBlockDescriptor<HordeGarrisonContain>(
        name = "HordeGarrisonContain",
        parent = GarrisonContain,
        properties = {
            property("EntryOffset", Coords.type) { it.entryOffset }
            property("EntryPosition", Coords.type) { it.entryPosition }
            property("ExitDelay", IntValue) { it.exitDelay }
            property("ExitOffset", Coords.type) { it.exitOffset }
        },
    )
}
