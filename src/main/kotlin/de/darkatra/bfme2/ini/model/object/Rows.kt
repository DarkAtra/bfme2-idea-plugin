package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class Rows(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Row") val row: List<Untyped> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Rows>(
        name = "Rows",
        properties = {
            property("Row", ListValue(Untyped.type)) { it.row }
        },
    )
}
