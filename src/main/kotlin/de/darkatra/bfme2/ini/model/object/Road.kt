package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.value.TextureFile

data class Road(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") val texture: TextureFile? = null,
    @SageIniName("RoadWidth") val roadWidth: Double = 0.0,
    @SageIniName("RoadWidthInTexture") val roadWidthInTexture: Double = 0.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Road>(
        name = "Road",
        tableKey = "roads",
        properties = {
            property("Texture", TextureFile.type) { it.texture }
            property("RoadWidth", FloatValue) { it.roadWidth }
            property("RoadWidthInTexture", FloatValue) { it.roadWidthInTexture }
        },
    )
}
