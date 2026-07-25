package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class SpawnAndFadeNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("ObjectTargetFilter") val objectTargetFilter: SageFilter? = null,
    @SageIniName("SpawnedObjectName") val spawnedObjectName: SageReference<Object>? = null,
    @SageIniName("SpawnOffset") val spawnOffset: Coords? = null,
) : WeaponEffectNugget() {

    companion object : SageIniBlockDescriptor<SpawnAndFadeNugget>(
        name = "SpawnAndFadeNugget",
        parent = WeaponEffectNugget,
        properties = {
            property("ObjectTargetFilter", SageFilter.type) { it.objectTargetFilter }
            property("SpawnedObjectName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.spawnedObjectName }
            property("SpawnOffset", Coords.type) { it.spawnOffset }
        },
    )
}
