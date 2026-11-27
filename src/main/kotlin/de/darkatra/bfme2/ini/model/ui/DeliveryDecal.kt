package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

@SageIniName("_DeliveryDecal")
open class DeliveryDecal(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") open val texture: TextureFile? = null,
    @SageIniName("Texture2") open val texture2: TextureFile? = null,
    @SageIniName("Style") open val style: Untyped? = null,
    @SageIniName("OpacityMin") open val opacityMin: Double = 0.0,
    @SageIniName("OpacityMax") open val opacityMax: Double = 0.0,
    @SageIniName("OpacityThrobTime") open val opacityThrobTime: Double = 0.0,
    @SageIniName("RotationsPerMinute") open val rotationsPerMinute: Double = 0.0,
    @SageIniName("Color") open val color: Rgba? = null,
    @SageIniName("OnlyVisibleToOwningPlayer") open val onlyVisibleToOwningPlayer: Boolean = false,
    @SageIniName("MaxRadius") open val maxRadius: Double = 0.0,
    @SageIniName("MinRadius") open val minRadius: Double = 0.0,
    @SageIniName("MaxSelectedUnits") open val maxSelectedUnits: Int = 0,
    @SageIniName("SpiralAcceleration") open val spiralAcceleration: Double = 0.0,
) {

    companion object : SageIniBlockDescriptor<DeliveryDecal>(
        name = "_DeliveryDecal",
        properties = {
            property("Texture", TextureFile.type) { it.texture }
            property("Texture2", TextureFile.type) { it.texture2 }
            property("Style", Untyped.type) { it.style }
            property("OpacityMin", FloatValue) { it.opacityMin }
            property("OpacityMax", FloatValue) { it.opacityMax }
            property("OpacityThrobTime", FloatValue) { it.opacityThrobTime }
            property("RotationsPerMinute", FloatValue) { it.rotationsPerMinute }
            property("Color", Rgba.type) { it.color }
            property("OnlyVisibleToOwningPlayer", BooleanValue) { it.onlyVisibleToOwningPlayer }
            property("MaxRadius", FloatValue) { it.maxRadius }
            property("MinRadius", FloatValue) { it.minRadius }
            property("MaxSelectedUnits", IntValue) { it.maxSelectedUnits }
            property("SpiralAcceleration", FloatValue) { it.spiralAcceleration }
        },
    )
}
