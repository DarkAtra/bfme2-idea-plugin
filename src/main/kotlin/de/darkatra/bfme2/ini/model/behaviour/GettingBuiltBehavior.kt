package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class GettingBuiltBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("WorkerName") val workerName: SageReference<Object>? = null,
    @SageIniName("EvilWorkerName") val evilWorkerName: SageReference<Object>? = null,
    @SageIniName("TestFaction") val testFaction: Boolean = false,
    @SageIniName("SpawnTimer") val spawnTimer: Double = 0.0,
    @SageIniName("RebuildWhenDead") val rebuildWhenDead: Boolean = false,
    @SageIniName("HealWeapon") val healWeapon: SageReference<Weapon>? = null,
    @SageIniName("RebuildTimeSeconds") val rebuildTimeSeconds: Double = 0.0,
    @SageIniName("PercentOfBuildCostToRebuildPristine") val percentOfBuildCostToRebuildPristine: Double = 0.0,
    @SageIniName("PercentOfBuildCostToRebuildDamaged") val percentOfBuildCostToRebuildDamaged: Double = 0.0,
    @SageIniName("PercentOfBuildCostToRebuildReallyDamaged") val percentOfBuildCostToRebuildReallyDamaged: Double = 0.0,
    @SageIniName("PercentOfBuildCostToRebuildRubble") val percentOfBuildCostToRebuildRubble: Double = 0.0,
    @SageIniName("DisallowRebuildFilter") val disallowRebuildFilter: SageFilter? = null,
    @SageIniName("DisallowRebuildRange") val disallowRebuildRange: Double = 0.0,
    @SageIniName("UseSpawnTimerWithoutWorker") val useSpawnTimerWithoutWorker: Boolean = false,
    @SageIniName("SelfBuildingLoop") val selfBuildingLoop: SageReference<AudioEvent>? = null,
    @SageIniName("SelfRepairFromDamageLoop") val selfRepairFromDamageLoop: SageReference<AudioEvent>? = null,
    @SageIniName("SelfRepairFromRubbleLoop") val selfRepairFromRubbleLoop: SageReference<AudioEvent>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<GettingBuiltBehavior>(
        name = "GettingBuiltBehavior",
        properties = {
            property("WorkerName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.workerName }
            property("EvilWorkerName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.evilWorkerName }
            property("TestFaction", BooleanValue) { it.testFaction }
            property("SpawnTimer", FloatValue) { it.spawnTimer }
            property("RebuildWhenDead", BooleanValue) { it.rebuildWhenDead }
            property("HealWeapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.healWeapon }
            property("RebuildTimeSeconds", FloatValue) { it.rebuildTimeSeconds }
            property("PercentOfBuildCostToRebuildPristine", FloatValue) { it.percentOfBuildCostToRebuildPristine }
            property("PercentOfBuildCostToRebuildDamaged", FloatValue) { it.percentOfBuildCostToRebuildDamaged }
            property("PercentOfBuildCostToRebuildReallyDamaged", FloatValue) { it.percentOfBuildCostToRebuildReallyDamaged }
            property("PercentOfBuildCostToRebuildRubble", FloatValue) { it.percentOfBuildCostToRebuildRubble }
            property("DisallowRebuildFilter", SageFilter.type) { it.disallowRebuildFilter }
            property("DisallowRebuildRange", FloatValue) { it.disallowRebuildRange }
            property("UseSpawnTimerWithoutWorker", BooleanValue) { it.useSpawnTimerWithoutWorker }
            property("SelfBuildingLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.selfBuildingLoop }
            property("SelfRepairFromDamageLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.selfRepairFromDamageLoop }
            property("SelfRepairFromRubbleLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.selfRepairFromRubbleLoop }
        },
    )
}
