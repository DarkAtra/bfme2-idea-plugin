package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

data class DecalTemplate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") override val texture: TextureFile? = null,
    @SageIniName("Texture2") override val texture2: TextureFile? = null,
    @SageIniName("Style") override val style: Untyped? = null,
    @SageIniName("OpacityMin") override val opacityMin: Double = 0.0,
    @SageIniName("OpacityMax") override val opacityMax: Double = 0.0,
    @SageIniName("OpacityThrobTime") override val opacityThrobTime: Double = 0.0,
    @SageIniName("RotationsPerMinute") override val rotationsPerMinute: Double = 0.0,
    @SageIniName("Color") override val color: Rgba? = null,
    @SageIniName("OnlyVisibleToOwningPlayer") override val onlyVisibleToOwningPlayer: Boolean = false,
    @SageIniName("MaxRadius") override val maxRadius: Double = 0.0,
    @SageIniName("MinRadius") override val minRadius: Double = 0.0,
    @SageIniName("MaxSelectedUnits") override val maxSelectedUnits: Int = 0,
    @SageIniName("SpiralAcceleration") override val spiralAcceleration: Double = 0.0,
) : DeliveryDecal(), SageNestedAttribute {

    companion object : SageIniBlockDescriptor<DecalTemplate>(
        name = "DecalTemplate",
        parent = DeliveryDecal,
    )
}
