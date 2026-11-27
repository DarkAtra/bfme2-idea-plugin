package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.MapWeatherType
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.Rgb
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.Untyped

data class DynamicDecal(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectFilter") override val objectFilter: SageFilter? = null,
    @SageIniName("SourceObjectFilter") override val sourceObjectFilter: SageFilter? = null,
    @SageIniName("RequiredSourceModelConditions") override val requiredSourceModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ExcludedSourceModelConditions") override val excludedSourceModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("RequiredSecondaryModelConditions") override val requiredSecondaryModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ExcludedSecondaryModelConditions") override val excludedSecondaryModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("StopIfNuggetPlayed") override val stopIfNuggetPlayed: Boolean = false,
    @SageIniName("Weather") override val weather: MapWeatherType? = null,
    @SageIniName("DecalName") val decalName: Untyped? = null,
    @SageIniName("Offset") val offset: Coords? = null,
    @SageIniName("Size") val size: Double = 0.0,
    @SageIniName("Color") val color: Rgb? = null,
    @SageIniName("Shader") val shader: Untyped? = null,
    @SageIniName("OpacityStart") val opacityStart: Int = 0,
    @SageIniName("OpacityPeak") val opacityPeak: Int = 0,
    @SageIniName("OpacityPeakTime") val opacityPeakTime: Int = 0,
    @SageIniName("OpacityFadeTimeOne") val opacityFadeTimeOne: Int = 0,
    @SageIniName("OpacityFadeTimeTwo") val opacityFadeTimeTwo: Int = 0,
    @SageIniName("OpacityEnd") val opacityEnd: Int = 0,
    @SageIniName("StartingDelay") val startingDelay: Int = 0,
    @SageIniName("Lifetime") val lifetime: Int = 0,
) : FXNugget(), SageNestedAttribute {

    companion object : SageIniBlockDescriptor<DynamicDecal>(
        name = "DynamicDecal",
        parent = FXNugget,
        properties = {
            property("DecalName", Untyped.type) { it.decalName }
            property("Offset", Coords.type) { it.offset }
            property("Size", FloatValue) { it.size }
            property("Color", Rgb.type) { it.color }
            property("Shader", Untyped.type) { it.shader }
            property("OpacityStart", IntValue) { it.opacityStart }
            property("OpacityPeak", IntValue) { it.opacityPeak }
            property("OpacityPeakTime", IntValue) { it.opacityPeakTime }
            property("OpacityFadeTimeOne", IntValue) { it.opacityFadeTimeOne }
            property("OpacityFadeTimeTwo", IntValue) { it.opacityFadeTimeTwo }
            property("OpacityEnd", IntValue) { it.opacityEnd }
            property("StartingDelay", IntValue) { it.startingDelay }
            property("Lifetime", IntValue) { it.lifetime }
        },
    )
}
