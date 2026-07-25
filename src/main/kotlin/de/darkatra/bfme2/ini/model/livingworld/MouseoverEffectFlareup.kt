package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.Untyped

data class MouseoverEffectFlareup(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Geometry") override val geometry: Untyped? = null,
    @SageIniName("LoadInShell") override val loadInShell: Boolean = false,
    @SageIniName("ColorIntensityControlPoint") override val colorIntensityControlPoint: List<ColorIntensityControlPoint> = emptyList(),
) : RegionEffect() {

    companion object : SageIniBlockDescriptor<MouseoverEffectFlareup>(
        name = "MouseoverEffectFlareup",
        parent = RegionEffect,
    )
}
