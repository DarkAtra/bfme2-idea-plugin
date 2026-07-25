package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue

data class ExperienceScalarTable(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Scalars") val scalars: List<Double> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ExperienceScalarTable>(
        name = "ExperienceScalarTable",
        tableKey = "experiencescalartables",
        properties = {
            property("Scalars", ListValue(FloatValue)) { it.scalars }
        },
    )
}
