package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.SageReference

data class FloodMember(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MemberTemplateName") val memberTemplateName: SageReference<Object>? = null,
    @SageIniName("ControlPointOffsetOne") val controlPointOffsetOne: Coords? = null,
    @SageIniName("ControlPointOffsetTwo") val controlPointOffsetTwo: Coords? = null,
    @SageIniName("ControlPointOffsetThree") val controlPointOffsetThree: Coords? = null,
    @SageIniName("ControlPointOffsetFour") val controlPointOffsetFour: Coords? = null,
    @SageIniName("MemberSpeed") val memberSpeed: Double = 0.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<FloodMember>(
        name = "FloodMember",
        properties = {
            property("MemberTemplateName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.memberTemplateName }
            property("ControlPointOffsetOne", Coords.type) { it.controlPointOffsetOne }
            property("ControlPointOffsetTwo", Coords.type) { it.controlPointOffsetTwo }
            property("ControlPointOffsetThree", Coords.type) { it.controlPointOffsetThree }
            property("ControlPointOffsetFour", Coords.type) { it.controlPointOffsetFour }
            property("MemberSpeed", FloatValue) { it.memberSpeed }
        },
    )
}
