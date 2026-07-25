package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.Untyped

data class LargeGroupAudioUnusedKnownKeys(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Key") val key: List<Untyped> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LargeGroupAudioUnusedKnownKeys>(
        name = "LargeGroupAudioUnusedKnownKeys",
        tableKey = "largegroupaudiounusedknownkeys",
        properties = {
            property("Key", ListValue(Untyped.type)) { it.key }
        },
    )
}
