package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.SageReference

data class AIEconomyAssigment(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TemplateName") val templateName: SageReference<Object>? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<AIEconomyAssigment>(
        name = "AIEconomyAssigment",
        properties = {
            property("TemplateName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.templateName }
        },
    )
}
