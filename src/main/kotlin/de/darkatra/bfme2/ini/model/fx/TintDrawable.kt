package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Rgb

data class TintDrawable(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Color") val color: Rgb? = null,
    @SageIniName("PreColorTime") val preColorTime: Int = 0,
    @SageIniName("PostColorTime") val postColorTime: Int = 0,
    @SageIniName("SustainedColorTime") val sustainedColorTime: Int = 0,
    @SageIniName("Frequency") val frequency: Double = 0.0,
    @SageIniName("Amplitude") val amplitude: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<TintDrawable>(
        name = "TintDrawable",
        properties = {
            property("Color", Rgb.type) { it.color }
            property("PreColorTime", IntValue) { it.preColorTime }
            property("PostColorTime", IntValue) { it.postColorTime }
            property("SustainedColorTime", IntValue) { it.sustainedColorTime }
            property("Frequency", FloatValue) { it.frequency }
            property("Amplitude", FloatValue) { it.amplitude }
        },
    )
}
