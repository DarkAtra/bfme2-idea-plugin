package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.Structure

data class SkirmishBuildList(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Structure") val structure: List<Structure> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<SkirmishBuildList>(
        name = "SkirmishBuildList",
        properties = {
            property("Structure", ListValue(BlockValue<Structure> { listOf(Structure) })) { it.structure }
        },
    )
}
