package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class SpawnBehavior(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TriggeredBy") override val triggeredBy: List<SageReference<UpgradeTrigger>> = emptyList(),
    @SageIniName("ConflictsWith") override val conflictsWith: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiresAllTriggers") override val requiresAllTriggers: Boolean = false,
    @SageIniName("RequiresAllConflictingTriggers") override val requiresAllConflictingTriggers: Boolean = false,
    @SageIniName("StartsActive") override val startsActive: Boolean = false,
    @SageIniName("Description") override val description: String = "",
    @SageIniName("ActiveDuringConstruction") override val activeDuringConstruction: Boolean = false,
    @SageIniName("CustomAnimAndDuration") override val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("Permanent") override val permanent: Boolean = false,
    @SageIniName("SlavesHaveFreeWill") val slavesHaveFreeWill: Boolean = false,
    @SageIniName("DeathType") val deathType: SageFilter? = null,
    @SageIniName("ExemptStatus") val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") val maxKillerAngle: Int = 0,
    @SageIniName("SpawnNumber") val spawnNumber: Int = 0,
    @SageIniName("SpawnReplaceDelay") val spawnReplaceDelay: Int = 0,
    @SageIniName("OneShot") val oneShot: Boolean = false,
    @SageIniName("CanReclaimOrphans") val canReclaimOrphans: Boolean = false,
    @SageIniName("AggregateHealth") val aggregateHealth: Boolean = false,
    @SageIniName("ExitByBudding") val exitByBudding: Boolean = false,
    @SageIniName("SpawnTemplateName") val spawnTemplateName: List<SageReference<Object>> = emptyList(),
    @SageIniName("SpawnedRequireSpawner") val spawnedRequireSpawner: Boolean = false,
    @SageIniName("PropagateDamageTypesToSlavesWhenExisting") val propagateDamageTypesToSlavesWhenExisting: SageFilter? = null,
    @SageIniName("InitialBurst") val initialBurst: Int = 0,
    @SageIniName("RespectCommandLimit") val respectCommandLimit: Boolean = false,
    @SageIniName("FadeInTime") val fadeInTime: Int = 0,
    @SageIniName("KillSpawnsBasedOnModelConditionState") val killSpawnsBasedOnModelConditionState: Boolean = false,
    @SageIniName("ShareUpgrades") val shareUpgrades: Boolean = false,
    @SageIniName("SpawnInsideBuilding") val spawnInsideBuilding: Boolean = false,
    @SageIniName("DeathTypes") val deathTypes: SageFilter? = null,
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<SpawnBehavior>(
        name = "SpawnBehavior",
        parent = UpgradeBehavior,
        properties = {
            property("SlavesHaveFreeWill", BooleanValue) { it.slavesHaveFreeWill }
            property("DeathType", SageFilter.type) { it.deathType }
            property("ExemptStatus", ObjectStatus.type) { it.exemptStatus }
            property("RequiredStatus", ObjectStatus.type) { it.requiredStatus }
            property("DamageAmountRequired", FloatValue) { it.damageAmountRequired }
            property("MinKillerAngle", IntValue) { it.minKillerAngle }
            property("MaxKillerAngle", IntValue) { it.maxKillerAngle }
            property("SpawnNumber", IntValue) { it.spawnNumber }
            property("SpawnReplaceDelay", IntValue) { it.spawnReplaceDelay }
            property("OneShot", BooleanValue) { it.oneShot }
            property("CanReclaimOrphans", BooleanValue) { it.canReclaimOrphans }
            property("AggregateHealth", BooleanValue) { it.aggregateHealth }
            property("ExitByBudding", BooleanValue) { it.exitByBudding }
            property("SpawnTemplateName", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.spawnTemplateName }
            property("SpawnedRequireSpawner", BooleanValue) { it.spawnedRequireSpawner }
            property("PropagateDamageTypesToSlavesWhenExisting", SageFilter.type) { it.propagateDamageTypesToSlavesWhenExisting }
            property("InitialBurst", IntValue) { it.initialBurst }
            property("RespectCommandLimit", BooleanValue) { it.respectCommandLimit }
            property("FadeInTime", IntValue) { it.fadeInTime }
            property("KillSpawnsBasedOnModelConditionState", BooleanValue) { it.killSpawnsBasedOnModelConditionState }
            property("ShareUpgrades", BooleanValue) { it.shareUpgrades }
            property("SpawnInsideBuilding", BooleanValue) { it.spawnInsideBuilding }
            property("DeathTypes", SageFilter.type) { it.deathTypes }
        },
    )
}
