package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.SageFilter

data class UnitCategory(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Name") val name: String = "",
    @SageIniName("PluralName") val pluralName: String = "",
    @SageIniName("Filter") val filter: SageFilter? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<UnitCategory>(
        name = "UnitCategory",
        properties = {
            property("Name", StringValue) { it.name }
            property("PluralName", StringValue) { it.pluralName }
            property("Filter", SageFilter.type) { it.filter }
        },
    )
}
