package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.TextureFile

data class MouseCursor(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") val texture: TextureFile? = null,
    @SageIniName("Image") val image: TextureFile? = null,
    @SageIniName("HotSpot") val hotSpot: Coords? = null,
    @SageIniName("Directions") val directions: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<MouseCursor>(
        name = "MouseCursor",
        tableKey = "cursors",
        properties = {
            property("Texture", TextureFile.type) { it.texture }
            property("Image", TextureFile.type) { it.image }
            property("HotSpot", Coords.type) { it.hotSpot }
            property("Directions", IntValue) { it.directions }
        },
    )
}
