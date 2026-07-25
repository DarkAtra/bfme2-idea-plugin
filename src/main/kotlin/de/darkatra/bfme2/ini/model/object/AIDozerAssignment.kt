package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.SageReference

data class AIDozerAssignment(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Side") val side: FakeToken? = null,
    @SageIniName("Unit") val unit: SageReference<Object>? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AIDozerAssignment>(
        name = "AIDozerAssignment",
        tableKey = "aidozerassignments",
        properties = {
            property("Side", FakeToken.type) { it.side }
            property("Unit", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.unit }
        },
    )
}
