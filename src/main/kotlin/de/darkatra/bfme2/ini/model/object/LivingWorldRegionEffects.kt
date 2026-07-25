package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.livingworld.BordersEffect
import de.darkatra.bfme2.ini.model.livingworld.FilledOwnershipEffect
import de.darkatra.bfme2.ini.model.livingworld.HomeRegionHighlight
import de.darkatra.bfme2.ini.model.livingworld.MouseoverEffectFlareup
import de.darkatra.bfme2.ini.model.livingworld.RegionSelectionEffect
import de.darkatra.bfme2.ini.model.livingworld.UnifiedEffect
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgba

data class LivingWorldRegionEffects(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RegionObject") val regionObject: Opaque? = null,
    @SageIniName("NeutralRegionColor") val neutralRegionColor: Rgba? = null,
    @SageIniName("RegionBorderColor") val regionBorderColor: Rgba? = null,
    @SageIniName("ShellStartPositionColor") val shellStartPositionColor: Rgba? = null,
    @SageIniName("BordersEffect") val bordersEffect: List<BordersEffect> = emptyList(),
    @SageIniName("FilledOwnershipEffect") val filledOwnershipEffect: List<FilledOwnershipEffect> = emptyList(),
    @SageIniName("MouseoverEffectFlareup") val mouseoverEffectFlareup: List<MouseoverEffectFlareup> = emptyList(),
    @SageIniName("HomeRegionHighlight") val homeRegionHighlight: List<HomeRegionHighlight> = emptyList(),
    @SageIniName("RegionSelectionEffect") val regionSelectionEffect: List<RegionSelectionEffect> = emptyList(),
    @SageIniName("UnifiedEffect") val unifiedEffect: List<UnifiedEffect> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldRegionEffects>(
        name = "LivingWorldRegionEffects",
        tableKey = "livingworldregioneffects",
        properties = {
            property("RegionObject", Opaque.type) { it.regionObject }
            property("NeutralRegionColor", Rgba.type) { it.neutralRegionColor }
            property("RegionBorderColor", Rgba.type) { it.regionBorderColor }
            property("ShellStartPositionColor", Rgba.type) { it.shellStartPositionColor }
            property("BordersEffect", ListValue(BlockValue<BordersEffect> { listOf(BordersEffect) })) { it.bordersEffect }
            property("FilledOwnershipEffect", ListValue(BlockValue<FilledOwnershipEffect> { listOf(FilledOwnershipEffect) })) { it.filledOwnershipEffect }
            property("MouseoverEffectFlareup", ListValue(BlockValue<MouseoverEffectFlareup> { listOf(MouseoverEffectFlareup) })) { it.mouseoverEffectFlareup }
            property("HomeRegionHighlight", ListValue(BlockValue<HomeRegionHighlight> { listOf(HomeRegionHighlight) })) { it.homeRegionHighlight }
            property("RegionSelectionEffect", ListValue(BlockValue<RegionSelectionEffect> { listOf(RegionSelectionEffect) })) { it.regionSelectionEffect }
            property("UnifiedEffect", ListValue(BlockValue<UnifiedEffect> { listOf(UnifiedEffect) })) { it.unifiedEffect }
        },
    )
}
