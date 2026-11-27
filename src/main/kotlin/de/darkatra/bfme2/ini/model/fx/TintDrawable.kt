package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.UnsignedIntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.MapWeatherType
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.Rgb
import de.darkatra.bfme2.ini.model.value.SageFilter

data class TintDrawable(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectFilter") override val objectFilter: SageFilter? = null,
    @SageIniName("SourceObjectFilter") override val sourceObjectFilter: SageFilter? = null,
    @SageIniName("RequiredSourceModelConditions") override val requiredSourceModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ExcludedSourceModelConditions") override val excludedSourceModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("RequiredSecondaryModelConditions") override val requiredSecondaryModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ExcludedSecondaryModelConditions") override val excludedSecondaryModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("StopIfNuggetPlayed") override val stopIfNuggetPlayed: Boolean = false,
    @SageIniName("Weather") override val weather: MapWeatherType? = null,
    @SageIniName("Color") val color: Rgb? = null,
    @SageIniName("PreColorTime") val preColorTime: UInt = 0u,
    @SageIniName("PostColorTime") val postColorTime: UInt = 0u,
    @SageIniName("SustainedColorTime") val sustainedColorTime: UInt = 0u,
    @SageIniName("Frequency") val frequency: Double = 0.0,
    @SageIniName("Amplitude") val amplitude: Double = 0.0,
) : FXNugget(), SageNestedAttribute {

    companion object : SageIniBlockDescriptor<TintDrawable>(
        name = "TintDrawable",
        parent = FXNugget,
        properties = {
            property("Color", Rgb.type) { it.color }
            property("PreColorTime", UnsignedIntValue) { it.preColorTime }
            property("PostColorTime", UnsignedIntValue) { it.postColorTime }
            property("SustainedColorTime", UnsignedIntValue) { it.sustainedColorTime }
            property("Frequency", FloatValue) { it.frequency }
            property("Amplitude", FloatValue) { it.amplitude }
        },
    )
}
