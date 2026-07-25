package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin

data class AttackPriorityTarget(val target: SageReference<Object>? = null, val value: Int? = null) {

    companion object {

        val type: SageIniValueType<AttackPriorityTarget> = StructValue("AttackPriorityTarget") {
            component("Target", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.target }
            component("Value", IntValue) { it.value }
        }
    }
}
