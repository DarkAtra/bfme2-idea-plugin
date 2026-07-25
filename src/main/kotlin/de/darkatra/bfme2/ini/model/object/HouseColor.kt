package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.value.TextureFile

data class HouseColor(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BaseTexture") val baseTexture: TextureFile? = null,
    @SageIniName("HouseTexture") val houseTexture: TextureFile? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<HouseColor>(
        name = "HouseColor",
        tableKey = "housecolors",
        properties = {
            property("BaseTexture", TextureFile.type) { it.baseTexture }
            property("HouseTexture", TextureFile.type) { it.houseTexture }
        },
    )
}
