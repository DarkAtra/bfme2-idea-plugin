package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.livingworld.LivingWorldIconObject
import de.darkatra.bfme2.ini.model.value.SageReference

data class LivingWorldBuildingIcon(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("OnSelectedSound") val onSelectedSound: SageReference<AudioEvent>? = null,
    @SageIniName("OnConstructionBegunSound") val onConstructionBegunSound: SageReference<AudioEvent>? = null,
    @SageIniName("OnConstructionFinishedSound") val onConstructionFinishedSound: SageReference<AudioEvent>? = null,
    @SageIniName("Object") val `object`: List<LivingWorldIconObject> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldBuildingIcon>(
        name = "LivingWorldBuildingIcon",
        tableKey = "livingworldbuildingicons",
        properties = {
            property("OnSelectedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.onSelectedSound }
            property("OnConstructionBegunSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.onConstructionBegunSound }
            property("OnConstructionFinishedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.onConstructionFinishedSound }
            property("Object", ListValue(BlockValue<LivingWorldIconObject> { listOf(LivingWorldIconObject) })) { it.`object` }
        },
    )
}
