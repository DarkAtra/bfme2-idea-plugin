package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AttackPriority
import de.darkatra.bfme2.ini.model.`object`.EvaEventBase
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.NewEvaEvent
import de.darkatra.bfme2.ini.model.`object`.PredefinedEvaEvent
import de.darkatra.bfme2.ini.model.`object`.Turret
import de.darkatra.bfme2.ini.model.value.AutoAcquireEnemiesType
import de.darkatra.bfme2.ini.model.value.ObjectCount
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class CastleBehavior(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TurretsLinked") override val turretsLinked: Boolean = false,
    @SageIniName("AutoAcquireEnemiesWhenIdle") override val autoAcquireEnemiesWhenIdle: List<AutoAcquireEnemiesType> = emptyList(),
    @SageIniName("MoodAttackCheckRate") override val moodAttackCheckRate: Int = 0,
    @SageIniName("ForbidPlayerCommands") override val forbidPlayerCommands: Boolean = false,
    @SageIniName("AILuaEventsList") override val aILuaEventsList: Untyped? = null,
    @SageIniName("HoldGroundCloseRangeDistance") override val holdGroundCloseRangeDistance: Double = 0.0,
    @SageIniName("MinCowerTime") override val minCowerTime: Int = 0,
    @SageIniName("MaxCowerTime") override val maxCowerTime: Int = 0,
    @SageIniName("CanAttackWhileContained") override val canAttackWhileContained: Boolean = false,
    @SageIniName("RampageTime") override val rampageTime: Int = 0,
    @SageIniName("TimeToEjectPassengersOnRampage") override val timeToEjectPassengersOnRampage: Int = 0,
    @SageIniName("AttackPriority") override val attackPriority: SageReference<AttackPriority>? = null,
    @SageIniName("SpecialContactPoints") override val specialContactPoints: List<Untyped> = emptyList(),
    @SageIniName("FadeOnPortals") override val fadeOnPortals: Boolean = false,
    @SageIniName("StopChaseDistance") override val stopChaseDistance: Double = 0.0,
    @SageIniName("RampageRequiresAflame") override val rampageRequiresAflame: Boolean = false,
    @SageIniName("MoveForNoOne") override val moveForNoOne: Boolean = false,
    @SageIniName("StandGround") override val standGround: Boolean = false,
    @SageIniName("BurningDeathTime") override val burningDeathTime: Int = 0,
    @SageIniName("BuildVariation") override val buildVariation: Int = 0,
    @SageIniName("SidesAllowed") val sidesAllowed: List<Untyped> = emptyList(),
    @SageIniName("UseSecondaryBuildList") val useSecondaryBuildList: Boolean = false,
    @SageIniName("UseTheNewCastleSystemInsteadOfTheClunkyBuildList") val useTheNewCastleSystemInsteadOfTheClunkyBuildList: Boolean = false,
    @SageIniName("RepairHealthPercentPerSecond") val repairHealthPercentPerSecond: Double = 0.0,
    @SageIniName("FilterValidOwnedEntries") val filterValidOwnedEntries: SageFilter? = null,
    @SageIniName("FilterCrew") val filterCrew: SageFilter? = null,
    @SageIniName("FadeTime") val fadeTime: Double = 0.0,
    @SageIniName("UnpackDelayTime") val unpackDelayTime: Double = 0.0,
    @SageIniName("BuildTime") val buildTime: Double = 0.0,
    @SageIniName("ScanDistance") val scanDistance: Double = 0.0,
    @SageIniName("MaxCastleRadius") val maxCastleRadius: Double = 0.0,
    @SageIniName("CrewPrepareTime") val crewPrepareTime: Int = 0,
    @SageIniName("InstantUnpack") val instantUnpack: Boolean = false,
    @SageIniName("KeepDeathKillsEverything") val keepDeathKillsEverything: Boolean = false,
    @SageIniName("CrewPrepareInterval") val crewPrepareInterval: Int = 0,
    @SageIniName("DisableStructureRotation") val disableStructureRotation: Boolean = false,
    @SageIniName("Summoned") val summoned: Boolean = false,
    @SageIniName("TransferFoundationHealthToCastleUponUnpack") val transferFoundationHealthToCastleUponUnpack: Boolean = false,
    @SageIniName("CastleToUnpackForFaction") val castleToUnpackForFaction: Opaque? = null,
    @SageIniName("FactionDecal") val factionDecal: Untyped? = null,
    @SageIniName("PreBuiltList") val preBuiltList: List<ObjectCount> = emptyList(),
    @SageIniName("PreBuiltPlyr") val preBuiltPlyr: Untyped? = null,
    @SageIniName("DecalName") val decalName: Untyped? = null,
    @SageIniName("DecalSize") val decalSize: Double = 0.0,
    @SageIniName("CrewReleaseFX") val crewReleaseFX: SageReference<FXList>? = null,
    @SageIniName("CrewPrepareFX") val crewPrepareFX: SageReference<FXList>? = null,
    @SageIniName("EvaEnemyCastleSightedEvent") val evaEnemyCastleSightedEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("Turret") override val turret: List<Turret> = emptyList(),
    @SageIniName("AltTurret") override val altTurret: List<Turret> = emptyList(),
) : FoundationAIUpdate() {

    companion object : SageIniBlockDescriptor<CastleBehavior>(
        name = "CastleBehavior",
        parent = FoundationAIUpdate,
        properties = {
            property("SidesAllowed", ListValue(Untyped.type)) { it.sidesAllowed }
            property("UseSecondaryBuildList", BooleanValue) { it.useSecondaryBuildList }
            property("UseTheNewCastleSystemInsteadOfTheClunkyBuildList", BooleanValue) { it.useTheNewCastleSystemInsteadOfTheClunkyBuildList }
            property("RepairHealthPercentPerSecond", FloatValue) { it.repairHealthPercentPerSecond }
            property("FilterValidOwnedEntries", SageFilter.type) { it.filterValidOwnedEntries }
            property("FilterCrew", SageFilter.type) { it.filterCrew }
            property("FadeTime", FloatValue) { it.fadeTime }
            property("UnpackDelayTime", FloatValue) { it.unpackDelayTime }
            property("BuildTime", FloatValue) { it.buildTime }
            property("ScanDistance", FloatValue) { it.scanDistance }
            property("MaxCastleRadius", FloatValue) { it.maxCastleRadius }
            property("CrewPrepareTime", IntValue) { it.crewPrepareTime }
            property("InstantUnpack", BooleanValue) { it.instantUnpack }
            property("KeepDeathKillsEverything", BooleanValue) { it.keepDeathKillsEverything }
            property("CrewPrepareInterval", IntValue) { it.crewPrepareInterval }
            property("DisableStructureRotation", BooleanValue) { it.disableStructureRotation }
            property("Summoned", BooleanValue) { it.summoned }
            property("TransferFoundationHealthToCastleUponUnpack", BooleanValue) { it.transferFoundationHealthToCastleUponUnpack }
            property("CastleToUnpackForFaction", Opaque.type) { it.castleToUnpackForFaction }
            property("FactionDecal", Untyped.type) { it.factionDecal }
            property("PreBuiltList", ListValue(ObjectCount.type)) { it.preBuiltList }
            property("PreBuiltPlyr", Untyped.type) { it.preBuiltPlyr }
            property("DecalName", Untyped.type) { it.decalName }
            property("DecalSize", FloatValue) { it.decalSize }
            property("CrewReleaseFX", ReferenceValue<FXList> { listOf(FXList) }) { it.crewReleaseFX }
            property("CrewPrepareFX", ReferenceValue<FXList> { listOf(FXList) }) { it.crewPrepareFX }
            property("EvaEnemyCastleSightedEvent", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.evaEnemyCastleSightedEvent }
        },
    )
}
