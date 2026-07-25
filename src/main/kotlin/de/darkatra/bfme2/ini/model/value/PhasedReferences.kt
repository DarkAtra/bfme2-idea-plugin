package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class PhasedReferences<P : Enum<P>, T>(val phase: P? = null, val references: List<SageReference<T>> = emptyList()) {

    companion object {

        fun <P : Enum<P>, T> type(
            phase: SageIniValueType<P>,
            reference: SageIniValueType<SageReference<T>>,
        ): SageIniValueType<PhasedReferences<P, T>> = StructValue("PhasedReferences") {
            component("Phase", phase) { it.phase }
            component("References", ListValue(reference)) { it.references }
        }
    }
}
