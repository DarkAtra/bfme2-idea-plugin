package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.MapWeatherType
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.SageFilter

data class CameraShakerVolume(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectFilter") override val objectFilter: SageFilter? = null,
    @SageIniName("SourceObjectFilter") override val sourceObjectFilter: SageFilter? = null,
    @SageIniName("RequiredSourceModelConditions") override val requiredSourceModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ExcludedSourceModelConditions") override val excludedSourceModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("RequiredSecondaryModelConditions") override val requiredSecondaryModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ExcludedSecondaryModelConditions") override val excludedSecondaryModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("StopIfNuggetPlayed") override val stopIfNuggetPlayed: Boolean = false,
    @SageIniName("Weather") override val weather: MapWeatherType? = null,
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("Duration_Seconds") val durationSeconds: Double = 0.0,
    @SageIniName("Amplitude_Degrees") val amplitudeDegrees: Double = 0.0,
) : FXNugget(), SageNestedAttribute {

    companion object : SageIniBlockDescriptor<CameraShakerVolume>(
        name = "CameraShakerVolume",
        parent = FXNugget,
        properties = {
            property("Radius", FloatValue) { it.radius }
            property("Duration_Seconds", FloatValue) { it.durationSeconds }
            property("Amplitude_Degrees", FloatValue) { it.amplitudeDegrees }
        },
    )
}
