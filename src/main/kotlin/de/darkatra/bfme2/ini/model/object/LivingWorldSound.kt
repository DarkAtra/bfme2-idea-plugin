package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class LivingWorldSound(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Sound") val sound: SageReference<AudioEvent>? = null,
    @SageIniName("Flags") val flags: Untyped? = null,
    @SageIniName("Position") val position: Coords? = null,
    @SageIniName("ZoomRegionLow") val zoomRegionLow: Coords? = null,
    @SageIniName("ZoomRegionHigh") val zoomRegionHigh: Coords? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldSound>(
        name = "LivingWorldSound",
        tableKey = "livingworldsounds",
        properties = {
            property("Sound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.sound }
            property("Flags", Untyped.type) { it.flags }
            property("Position", Coords.type) { it.position }
            property("ZoomRegionLow", Coords.type) { it.zoomRegionLow }
            property("ZoomRegionHigh", Coords.type) { it.zoomRegionHigh }
        },
    )
}
