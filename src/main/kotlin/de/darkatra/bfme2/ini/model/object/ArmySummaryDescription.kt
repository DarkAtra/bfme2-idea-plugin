package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.SageFilter

data class ArmySummaryDescription(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("HeroFilter") val heroFilter: SageFilter? = null,
    @SageIniName("UnitCategory") val unitCategory: List<UnitCategory> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ArmySummaryDescription>(
        name = "ArmySummaryDescription",
        tableKey = "armysummarydescriptions",
        properties = {
            property("HeroFilter", SageFilter.type) { it.heroFilter }
            property("UnitCategory", ListValue(BlockValue<UnitCategory> { listOf(UnitCategory) })) { it.unitCategory }
        },
    )
}
