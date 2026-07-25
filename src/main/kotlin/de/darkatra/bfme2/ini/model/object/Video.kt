package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Untyped

data class Video(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Filename") val filename: Opaque? = null,
    @SageIniName("Comment") val comment: Untyped? = null,
    @SageIniName("Volume") val volume: Double = 0.0,
    @SageIniName("IsDefault") val isDefault: Boolean = false,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Video>(
        name = "Video",
        tableKey = "videos",
        properties = {
            property("Filename", Opaque.type) { it.filename }
            property("Comment", Untyped.type) { it.comment }
            property("Volume", FloatValue) { it.volume }
            property("IsDefault", BooleanValue) { it.isDefault }
        },
    )
}
