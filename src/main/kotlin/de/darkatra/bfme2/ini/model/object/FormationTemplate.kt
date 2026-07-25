package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class FormationTemplate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Rows") val rows: List<Rows> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<FormationTemplate>(
        name = "FormationTemplate",
        properties = {
            property("Rows", ListValue(BlockValue<Rows> { listOf(Rows) })) { it.rows }
        },
    )
}
