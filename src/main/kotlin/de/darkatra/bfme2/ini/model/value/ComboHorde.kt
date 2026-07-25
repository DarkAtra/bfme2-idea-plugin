package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin

data class ComboHorde(
    val target: SageReference<Object>? = null,
    val result: SageReference<Object>? = null,
    val initiateVoice: SageReference<AudioEvent>? = null
) {

    companion object {

        val type: SageIniValueType<ComboHorde> = StructValue("ComboHorde") {
            component("Target", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.target }
            component("Result", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.result }
            component("InitiateVoice", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.initiateVoice }
        }
    }
}
