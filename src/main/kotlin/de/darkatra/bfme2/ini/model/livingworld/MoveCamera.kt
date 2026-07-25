package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Coords

data class MoveCamera(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Position") val position: Coords? = null,
    @SageIniName("ViewAngle") val viewAngle: Int = 0,
    @SageIniName("ScrollTime") val scrollTime: Double = 0.0,
    @SageIniName("DelayFromActStart") val delayFromActStart: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<MoveCamera>(
        name = "MoveCamera",
        properties = {
            property("Position", Coords.type) { it.position }
            property("ViewAngle", IntValue) { it.viewAngle }
            property("ScrollTime", FloatValue) { it.scrollTime }
            property("DelayFromActStart", FloatValue) { it.delayFromActStart }
        },
    )
}
