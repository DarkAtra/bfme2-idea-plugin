package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.TextureFile

data class WaterSet(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SkyTexture") val skyTexture: TextureFile? = null,
    @SageIniName("WaterTexture") val waterTexture: TextureFile? = null,
    @SageIniName("Vertex00Color") val vertex00Color: Rgba? = null,
    @SageIniName("Vertex10Color") val vertex10Color: Rgba? = null,
    @SageIniName("Vertex01Color") val vertex01Color: Rgba? = null,
    @SageIniName("Vertex11Color") val vertex11Color: Rgba? = null,
    @SageIniName("DiffuseColor") val diffuseColor: Rgba? = null,
    @SageIniName("TransparentDiffuseColor") val transparentDiffuseColor: Rgba? = null,
    @SageIniName("UScrollPerMS") val uScrollPerMS: Double = 0.0,
    @SageIniName("VScrollPerMS") val vScrollPerMS: Double = 0.0,
    @SageIniName("SkyTexelsPerUnit") val skyTexelsPerUnit: Double = 0.0,
    @SageIniName("WaterRepeatCount") val waterRepeatCount: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<WaterSet>(
        name = "WaterSet",
        tableKey = "watersets",
        properties = {
            property("SkyTexture", TextureFile.type) { it.skyTexture }
            property("WaterTexture", TextureFile.type) { it.waterTexture }
            property("Vertex00Color", Rgba.type) { it.vertex00Color }
            property("Vertex10Color", Rgba.type) { it.vertex10Color }
            property("Vertex01Color", Rgba.type) { it.vertex01Color }
            property("Vertex11Color", Rgba.type) { it.vertex11Color }
            property("DiffuseColor", Rgba.type) { it.diffuseColor }
            property("TransparentDiffuseColor", Rgba.type) { it.transparentDiffuseColor }
            property("UScrollPerMS", FloatValue) { it.uScrollPerMS }
            property("VScrollPerMS", FloatValue) { it.vScrollPerMS }
            property("SkyTexelsPerUnit", FloatValue) { it.skyTexelsPerUnit }
            property("WaterRepeatCount", IntValue) { it.waterRepeatCount }
        },
    )
}
