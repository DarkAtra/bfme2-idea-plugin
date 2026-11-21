package de.darkatra.bfme2.ini.model.audio

import de.darkatra.bfme2.ini.model.common.SageAudio
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.Multisound
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.SageReference

data class SideSound(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Side") val side: FakeToken? = null,
    @SageIniName("Sound") val sound: SageReference<SageAudio>? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<SideSound>(
        name = "SideSound",
        properties = {
            property("Side", FakeToken.type) { it.side }
            property("Sound", ReferenceValue<SageAudio> { listOf(AudioEvent, Multisound) }) { it.sound }
        },
    )
}
