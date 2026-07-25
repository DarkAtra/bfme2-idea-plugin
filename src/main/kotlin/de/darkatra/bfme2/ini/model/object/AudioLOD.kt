package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class AudioLOD(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AllowDolby") val allowDolby: Boolean = false,
    @SageIniName("AllowReverb") val allowReverb: Boolean = false,
    @SageIniName("MaximumAmbientStreams") val maximumAmbientStreams: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AudioLOD>(
        name = "AudioLOD",
        tableKey = "audiolods",
        properties = {
            property("AllowDolby", BooleanValue) { it.allowDolby }
            property("AllowReverb", BooleanValue) { it.allowReverb }
            property("MaximumAmbientStreams", IntValue) { it.maximumAmbientStreams }
        },
    )
}
