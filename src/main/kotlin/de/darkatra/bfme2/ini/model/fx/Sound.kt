package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageAudio
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.Multisound
import de.darkatra.bfme2.ini.model.value.MapWeatherType
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class Sound(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectFilter") override val objectFilter: SageFilter? = null,
    @SageIniName("SourceObjectFilter") override val sourceObjectFilter: SageFilter? = null,
    @SageIniName("RequiredSourceModelConditions") override val requiredSourceModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ExcludedSourceModelConditions") override val excludedSourceModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("RequiredSecondaryModelConditions") override val requiredSecondaryModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ExcludedSecondaryModelConditions") override val excludedSecondaryModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("StopIfNuggetPlayed") override val stopIfNuggetPlayed: Boolean = false,
    @SageIniName("Weather") override val weather: MapWeatherType? = null,
    @SageIniName("Name") val name: SageReference<SageAudio>? = null,
    @SageIniName("Sound") val sound: SageReference<AudioEvent>? = null,
    @SageIniName("Key") val key: Opaque? = null,
    @SageIniName("Duck") val duck: Untyped? = null,
) : FXNugget(), SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Sound>(
        name = "Sound",
        parent = FXNugget,
        properties = {
            property("Name", ReferenceValue<SageAudio> { listOf(AudioEvent, Multisound) }) { it.name }
            property("Sound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.sound }
            property("Key", Opaque.type) { it.key }
            property("Duck", Untyped.type) { it.duck }
        },
    )
}
