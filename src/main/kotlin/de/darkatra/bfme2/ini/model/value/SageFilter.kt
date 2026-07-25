package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class SageFilter(val members: List<String> = emptyList()) {

    companion object {

        val type: SageIniValueType<SageFilter> = StructValue("SageFilter") {
            component("Members", ListValue(StringValue)) { it.members }
        }
    }
}
