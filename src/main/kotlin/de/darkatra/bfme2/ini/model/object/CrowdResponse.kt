package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue

data class CrowdResponse(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Weight") val weight: Int = 0,
    @SageIniName("Threshold") val threshold: List<Threshold> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<CrowdResponse>(
        name = "CrowdResponse",
        tableKey = "crowdresponses",
        properties = {
            property("Weight", IntValue) { it.weight }
            property("Threshold", ListValue(BlockValue<Threshold> { listOf(Threshold) })) { it.threshold }
        },
    )
}
