package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

/**
 * A single model condition written as `ModelConditionState:FLAG`, e.g. `TriggerModelCondition = ModelConditionState:SPECIAL_POWER_1`.
 */
data class ModelConditionFlag(val modelConditionState: ModelCondition? = null) {

    companion object {

        val type: SageIniValueType<ModelConditionFlag> = StructValue("ModelConditionFlag") {
            component("ModelConditionState", ModelCondition.type) { it.modelConditionState }
        }
    }
}
