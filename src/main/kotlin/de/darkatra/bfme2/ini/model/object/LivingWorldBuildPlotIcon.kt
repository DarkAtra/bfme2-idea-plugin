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

data class LivingWorldBuildPlotIcon(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("OnSelectedSound") val onSelectedSound: SageReference<AudioEvent>? = null,
    @SageIniName("OnBuildingDestroyedSound") val onBuildingDestroyedSound: SageReference<AudioEvent>? = null,
    @SageIniName("Object") val `object`: List<LivingWorldIconObject> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldBuildPlotIcon>(
        name = "LivingWorldBuildPlotIcon",
        tableKey = "livingworldbuildploticons",
        properties = {
            property("OnSelectedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.onSelectedSound }
            property("OnBuildingDestroyedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.onBuildingDestroyedSound }
            property("Object", ListValue(BlockValue<LivingWorldIconObject> { listOf(LivingWorldIconObject) })) { it.`object` }
        },
    )
}
