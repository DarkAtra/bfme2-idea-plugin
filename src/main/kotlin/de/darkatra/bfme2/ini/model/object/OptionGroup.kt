package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.Untyped

data class OptionGroup(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Bool") val bool: List<Untyped> = emptyList(),
    @SageIniName("Int") val int: List<Untyped> = emptyList(),
    @SageIniName("String") val string: List<Untyped> = emptyList(),
    @SageIniName("Real") val real: List<Untyped> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<OptionGroup>(
        name = "OptionGroup",
        tableKey = "optiongroups",
        properties = {
            property("Bool", ListValue(Untyped.type)) { it.bool }
            property("Int", ListValue(Untyped.type)) { it.int }
            property("String", ListValue(Untyped.type)) { it.string }
            property("Real", ListValue(Untyped.type)) { it.real }
        },
    )
}
