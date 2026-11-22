package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageAudio
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.AudioControlFlags
import de.darkatra.bfme2.ini.model.value.SageReference

data class Multisound(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Subsounds") val subsounds: List<SageReference<SageAudio>> = emptyList(),
    @SageIniName("Control") val control: List<AudioControlFlags> = emptyList(),
) : SageAudio {

    companion object : SageIniBlockDescriptor<Multisound>(
        name = "Multisound",
        tableKey = "multisounds",
        properties = {
            property("Subsounds", ListValue(ReferenceValue<SageAudio> { listOf(AudioEvent, Multisound, MusicTrack, StreamedSound) })) { it.subsounds }
            property("Control", ListValue(AudioControlFlags.type)) { it.control }
        },
    )
}
