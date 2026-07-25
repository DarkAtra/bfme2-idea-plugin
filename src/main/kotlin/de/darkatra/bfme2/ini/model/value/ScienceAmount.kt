package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.Science

data class ScienceAmount(val science: SageReference<Science>? = null, val amount: Int = 0) {

    companion object {

        val type: SageIniValueType<ScienceAmount> = StructValue("ScienceAmount") {
            component("Science", ReferenceValue<Science> { listOf(Science) }) { it.science }
            component("Amount", IntValue) { it.amount }
        }
    }
}
