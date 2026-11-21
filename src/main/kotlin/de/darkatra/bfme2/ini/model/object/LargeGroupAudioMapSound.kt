package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageAudio
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class LargeGroupAudioMapSound(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Sound") val sound: SageReference<SageAudio>? = null,
    @SageIniName("Key") val key: List<Untyped> = emptyList(),
    @SageIniName("Duck") val duck: List<Untyped> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<LargeGroupAudioMapSound>(
        name = "Sound",
        properties = {
            property("Sound", ReferenceValue<SageAudio> { listOf(AudioEvent, Multisound) }) { it.sound }
            property("Key", ListValue(Untyped.type)) { it.key }
            property("Duck", ListValue(Untyped.type)) { it.duck }
        },
    )
}
