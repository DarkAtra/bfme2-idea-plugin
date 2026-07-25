package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin

data class TemplateWithFilter(val template: SageReference<Object>? = null, val filter: SageFilter? = null) {

    companion object {

        val type: SageIniValueType<TemplateWithFilter> = StructValue("TemplateWithFilter") {
            component("Template", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.template }
            component("Filter", SageFilter.type) { it.filter }
        }
    }
}
