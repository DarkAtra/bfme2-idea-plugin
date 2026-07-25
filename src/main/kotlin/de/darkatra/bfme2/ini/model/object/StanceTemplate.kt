package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue

data class StanceTemplate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Stance") val stance: List<Stance> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<StanceTemplate>(
        name = "StanceTemplate",
        tableKey = "stancetemplates",
        properties = {
            property("Stance", ListValue(BlockValue<Stance> { listOf(Stance) })) { it.stance }
        },
    )
}
