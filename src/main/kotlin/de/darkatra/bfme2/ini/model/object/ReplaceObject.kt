package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class ReplaceObject(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TargetObjectFilter") val targetObjectFilter: SageFilter? = null,
    @SageIniName("ReplacementObjectName") val replacementObjectName: List<SageReference<Object>> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ReplaceObject>(
        name = "ReplaceObject",
        properties = {
            property("TargetObjectFilter", SageFilter.type) { it.targetObjectFilter }
            property("ReplacementObjectName", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.replacementObjectName }
        },
    )
}
