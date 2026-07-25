package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.value.Coords

data class ControlBarResizer(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AltPosition") val altPosition: Coords? = null,
    @SageIniName("AltSize") val altSize: Coords? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ControlBarResizer>(
        name = "ControlBarResizer",
        tableKey = "controlbarresizers",
        properties = {
            property("AltPosition", Coords.type) { it.altPosition }
            property("AltSize", Coords.type) { it.altSize }
        },
    )
}
