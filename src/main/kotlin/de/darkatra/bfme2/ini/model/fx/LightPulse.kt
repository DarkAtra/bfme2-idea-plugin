package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Rgb

data class LightPulse(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Color") val color: Rgb? = null,
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("IncreaseTime") val increaseTime: Int = 0,
    @SageIniName("DecreaseTime") val decreaseTime: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<LightPulse>(
        name = "LightPulse",
        properties = {
            property("Color", Rgb.type) { it.color }
            property("Radius", FloatValue) { it.radius }
            property("IncreaseTime", IntValue) { it.increaseTime }
            property("DecreaseTime", IntValue) { it.decreaseTime }
        },
    )
}
