package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

@SageIniName("_RegionEffect")
open class RegionEffect(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Geometry") open val geometry: Untyped? = null,
    @SageIniName("LoadInShell") open val loadInShell: Boolean = false,
    @SageIniName("ColorIntensityControlPoint") open val colorIntensityControlPoint: List<ColorIntensityControlPoint> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<RegionEffect>(
        name = "_RegionEffect",
        properties = {
            property("Geometry", Untyped.type) { it.geometry }
            property("LoadInShell", BooleanValue) { it.loadInShell }
            property(
                "ColorIntensityControlPoint",
                ListValue(BlockValue<ColorIntensityControlPoint> { listOf(ColorIntensityControlPoint) })
            ) { it.colorIntensityControlPoint }
        },
    )
}
