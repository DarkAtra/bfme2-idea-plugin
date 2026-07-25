package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.TextureFile

data class WaterTextureList(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") val texture: List<TextureFile> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<WaterTextureList>(
        name = "WaterTextureList",
        tableKey = "watertexturelists",
        properties = {
            property("Texture", ListValue(TextureFile.type)) { it.texture }
        },
    )
}
