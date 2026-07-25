package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class Sound(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Name") val name: SageReference<AudioEvent>? = null,
    @SageIniName("Sound") val sound: SageReference<AudioEvent>? = null,
    @SageIniName("Key") val key: Opaque? = null,
    @SageIniName("Duck") val duck: Untyped? = null,
    @SageIniName("StopIfNuggetPlayed") val stopIfNuggetPlayed: Boolean = false,
    @SageIniName("SourceObjectFilter") val sourceObjectFilter: Untyped? = null,
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("RequiredSourceModelConditions") val requiredSourceModelConditions: Untyped? = null,
    @SageIniName("ExcludedSourceModelConditions") val excludedSourceModelConditions: Untyped? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Sound>(
        name = "Sound",
        properties = {
            property("Name", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.name }
            property("Sound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.sound }
            property("Key", Opaque.type) { it.key }
            property("Duck", Untyped.type) { it.duck }
            property("StopIfNuggetPlayed", BooleanValue) { it.stopIfNuggetPlayed }
            property("SourceObjectFilter", Untyped.type) { it.sourceObjectFilter }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("RequiredSourceModelConditions", Untyped.type) { it.requiredSourceModelConditions }
            property("ExcludedSourceModelConditions", Untyped.type) { it.excludedSourceModelConditions }
        },
    )
}
