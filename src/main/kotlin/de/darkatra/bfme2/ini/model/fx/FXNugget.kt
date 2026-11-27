package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.MapWeatherType
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.SageFilter

@SageIniName("_FXNugget")
open class FXNugget(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectFilter") open val objectFilter: SageFilter? = null,
    @SageIniName("SourceObjectFilter") open val sourceObjectFilter: SageFilter? = null,
    @SageIniName("RequiredSourceModelConditions") open val requiredSourceModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ExcludedSourceModelConditions") open val excludedSourceModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("RequiredSecondaryModelConditions") open val requiredSecondaryModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ExcludedSecondaryModelConditions") open val excludedSecondaryModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("StopIfNuggetPlayed") open val stopIfNuggetPlayed: Boolean = false,
    @SageIniName("Weather") open val weather: MapWeatherType? = null,
) {

    companion object : SageIniBlockDescriptor<FXNugget>(
        name = "_FXNugget",
        properties = {
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("SourceObjectFilter", SageFilter.type) { it.sourceObjectFilter }
            property("RequiredSourceModelConditions", ListValue(ModelCondition.type)) { it.requiredSourceModelConditions }
            property("ExcludedSourceModelConditions", ListValue(ModelCondition.type)) { it.excludedSourceModelConditions }
            property("RequiredSecondaryModelConditions", ListValue(ModelCondition.type)) { it.requiredSecondaryModelConditions }
            property("ExcludedSecondaryModelConditions", ListValue(ModelCondition.type)) { it.excludedSecondaryModelConditions }
            property("StopIfNuggetPlayed", BooleanValue) { it.stopIfNuggetPlayed }
            property("Weather", MapWeatherType.type) { it.weather }
        },
    )
}
