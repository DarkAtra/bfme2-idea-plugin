package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.MappedImageStatus
import de.darkatra.bfme2.ini.model.value.TextureFile

data class MappedImage(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") val texture: TextureFile? = null,
    @SageIniName("TextureWidth") val textureWidth: Int = 0,
    @SageIniName("TextureHeight") val textureHeight: Int = 0,
    @SageIniName("Coords") val coords: Map<String, String> = emptyMap(),
    @SageIniName("Status") val status: MappedImageStatus? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<MappedImage>(
        name = "MappedImage",
        tableKey = "mappedimages",
        properties = {
            property("Texture", TextureFile.type) { it.texture }
            property("TextureWidth", IntValue) { it.textureWidth }
            property("TextureHeight", IntValue) { it.textureHeight }
            property("Coords", MapValue(StringValue, StringValue)) { it.coords }
            property("Status", MappedImageStatus.type) { it.status }
        },
    )
}
