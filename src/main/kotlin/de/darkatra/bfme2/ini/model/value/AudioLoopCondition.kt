package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent

data class AudioLoopCondition(
    val required: List<ModelCondition> = emptyList(),
    val excluded: List<ModelCondition> = emptyList(),
    val sound: SageReference<AudioEvent>? = null
) {

    companion object {

        val type: SageIniValueType<AudioLoopCondition> = StructValue("AudioLoopCondition") {
            component("Required", ListValue(ModelCondition.type)) { it.required }
            component("Excluded", ListValue(ModelCondition.type)) { it.excluded }
            component("Sound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.sound }
        }
    }
}
