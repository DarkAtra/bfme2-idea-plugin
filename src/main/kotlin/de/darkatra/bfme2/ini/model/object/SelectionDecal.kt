package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.TextureFile

data class SelectionDecal(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") val texture: TextureFile? = null,
    @SageIniName("Texture2") val texture2: Opaque? = null,
    @SageIniName("Style") val style: FakeToken? = null,
    @SageIniName("OpacityMin") val opacityMin: Double = 0.0,
    @SageIniName("OpacityMax") val opacityMax: Double = 0.0,
    @SageIniName("MinRadius") val minRadius: Double = 0.0,
    @SageIniName("MaxRadius") val maxRadius: Double = 0.0,
    @SageIniName("MaxSelectedUnits") val maxSelectedUnits: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<SelectionDecal>(
        name = "SelectionDecal",
        properties = {
            property("Texture", TextureFile.type) { it.texture }
            property("Texture2", Opaque.type) { it.texture2 }
            property("Style", FakeToken.type) { it.style }
            property("OpacityMin", FloatValue) { it.opacityMin }
            property("OpacityMax", FloatValue) { it.opacityMax }
            property("MinRadius", FloatValue) { it.minRadius }
            property("MaxRadius", FloatValue) { it.maxRadius }
            property("MaxSelectedUnits", IntValue) { it.maxSelectedUnits }
        },
    )
}
