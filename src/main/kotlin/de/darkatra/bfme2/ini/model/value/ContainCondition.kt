package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class ContainCondition(val modelConditionState: ModelCondition? = null) {

    companion object {

        val type: SageIniValueType<ContainCondition> = StructValue("ContainCondition") {
            component("ModelConditionState", ModelCondition.type) { it.modelConditionState }
        }
    }
}
