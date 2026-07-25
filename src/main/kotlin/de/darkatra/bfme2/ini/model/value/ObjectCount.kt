package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin

data class ObjectCount(val template: SageReference<Object>? = null, val count: Int = 0) {

    companion object {

        val type: SageIniValueType<ObjectCount> = StructValue("ObjectCount") {
            component("Template", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.template }
            component("Count", IntValue) { it.count }
        }
    }
}
