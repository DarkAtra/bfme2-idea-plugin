package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class UnitDefinition(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("PreviewObject") val previewObject: SageReference<Object>? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<UnitDefinition>(
        name = "UnitDefinition",
        properties = {
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("PreviewObject", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.previewObject }
        },
    )
}
