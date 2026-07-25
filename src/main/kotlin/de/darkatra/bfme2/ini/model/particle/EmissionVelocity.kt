package de.darkatra.bfme2.ini.model.particle

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class EmissionVelocity(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("X") val x: List<Double> = emptyList(),
    @SageIniName("Y") val y: List<Double> = emptyList(),
    @SageIniName("Z") val z: List<Double> = emptyList(),
    @SageIniName("Speed") val speed: List<Double> = emptyList(),
    @SageIniName("OtherSpeed") val otherSpeed: List<Double> = emptyList(),
    @SageIniName("Normal") val normal: List<Double> = emptyList(),
    @SageIniName("Radial") val radial: List<Double> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<EmissionVelocity>(
        name = "EmissionVelocity",
        keyedByLabel = true,
        properties = {
            property("X", ListValue(FloatValue)) { it.x }
            property("Y", ListValue(FloatValue)) { it.y }
            property("Z", ListValue(FloatValue)) { it.z }
            property("Speed", ListValue(FloatValue)) { it.speed }
            property("OtherSpeed", ListValue(FloatValue)) { it.otherSpeed }
            property("Normal", ListValue(FloatValue)) { it.normal }
            property("Radial", ListValue(FloatValue)) { it.radial }
        },
    )
}
