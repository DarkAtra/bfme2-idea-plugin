package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

data class DecalTemplate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") val texture: TextureFile? = null,
    @SageIniName("Style") val style: Untyped? = null,
    @SageIniName("OpacityMin") val opacityMin: Double = 0.0,
    @SageIniName("OpacityMax") val opacityMax: Double = 0.0,
    @SageIniName("MaxRadius") val maxRadius: Double = 0.0,
    @SageIniName("Color") val color: Rgba? = null,
    @SageIniName("OnlyVisibleToOwningPlayer") val onlyVisibleToOwningPlayer: Boolean = false,
    @SageIniName("RotationsPerMinute") val rotationsPerMinute: Double = 0.0,
    @SageIniName("SpiralAcceleration") val spiralAcceleration: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<DecalTemplate>(
        name = "DecalTemplate",
        properties = {
            property("Texture", TextureFile.type) { it.texture }
            property("Style", Untyped.type) { it.style }
            property("OpacityMin", FloatValue) { it.opacityMin }
            property("OpacityMax", FloatValue) { it.opacityMax }
            property("MaxRadius", FloatValue) { it.maxRadius }
            property("Color", Rgba.type) { it.color }
            property("OnlyVisibleToOwningPlayer", BooleanValue) { it.onlyVisibleToOwningPlayer }
            property("RotationsPerMinute", FloatValue) { it.rotationsPerMinute }
            property("SpiralAcceleration", FloatValue) { it.spiralAcceleration }
        },
    )
}
