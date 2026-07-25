package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class BrutalDifficultyCheats(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BuildCostReduction") val buildCostReduction: Double = 0.0,
    @SageIniName("BuildTimeReduction") val buildTimeReduction: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<BrutalDifficultyCheats>(
        name = "BrutalDifficultyCheats",
        properties = {
            property("BuildCostReduction", FloatValue) { it.buildCostReduction }
            property("BuildTimeReduction", FloatValue) { it.buildTimeReduction }
        },
    )
}
