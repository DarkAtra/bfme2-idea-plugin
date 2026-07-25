package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.Science

/** Alternative groups of required sciences: any group satisfies the requirement, all sciences of a group are required. */
data class ScienceRequirements(val alternatives: List<List<SageReference<Science>>> = emptyList()) {

    companion object {

        val type: SageIniValueType<ScienceRequirements> = StructValue("ScienceRequirements") {
            component("Alternatives", ListValue(ListValue(ReferenceValue<Science> { listOf(Science) }))) { it.alternatives }
        }
    }
}
