package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.MappedImage
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.RespawnRule
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class RespawnUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathAnim") val deathAnim: ModelCondition? = null,
    @SageIniName("DeathFX") val deathFX: SageReference<FXList>? = null,
    @SageIniName("DeathAnimationTime") val deathAnimationTime: Int = 0,
    @SageIniName("InitialSpawnFX") val initialSpawnFX: SageReference<FXList>? = null,
    @SageIniName("RespawnAnim") val respawnAnim: ModelCondition? = null,
    @SageIniName("RespawnFX") val respawnFX: SageReference<FXList>? = null,
    @SageIniName("RespawnAnimationTime") val respawnAnimationTime: Int = 0,
    @SageIniName("AutoRespawnAtObjectFilter") val autoRespawnAtObjectFilter: SageFilter? = null,
    @SageIniName("ButtonImage") val buttonImage: SageReference<MappedImage>? = null,
    @SageIniName("RespawnRules") val respawnRules: RespawnRule? = null,
    @SageIniName("RespawnEntry") val respawnEntry: List<Opaque> = emptyList(),
    @SageIniName("RespawnAsTemplate") val respawnAsTemplate: SageReference<Object>? = null,
    @SageIniName("InitialSpawnAnim") val initialSpawnAnim: ModelCondition? = null,
    @SageIniName("InitialSpawnAnimationTime") val initialSpawnAnimationTime: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<RespawnUpdate>(
        name = "RespawnUpdate",
        properties = {
            property("DeathAnim", ModelCondition.type) { it.deathAnim }
            property("DeathFX", ReferenceValue<FXList> { listOf(FXList) }) { it.deathFX }
            property("DeathAnimationTime", IntValue) { it.deathAnimationTime }
            property("InitialSpawnFX", ReferenceValue<FXList> { listOf(FXList) }) { it.initialSpawnFX }
            property("RespawnAnim", ModelCondition.type) { it.respawnAnim }
            property("RespawnFX", ReferenceValue<FXList> { listOf(FXList) }) { it.respawnFX }
            property("RespawnAnimationTime", IntValue) { it.respawnAnimationTime }
            property("AutoRespawnAtObjectFilter", SageFilter.type) { it.autoRespawnAtObjectFilter }
            property("ButtonImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.buttonImage }
            property("RespawnRules", RespawnRule.type) { it.respawnRules }
            property("RespawnEntry", ListValue(Opaque.type)) { it.respawnEntry }
            property("RespawnAsTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.respawnAsTemplate }
            property("InitialSpawnAnim", ModelCondition.type) { it.initialSpawnAnim }
            property("InitialSpawnAnimationTime", IntValue) { it.initialSpawnAnimationTime }
        },
    )
}
