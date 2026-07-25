package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.MappedImage
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.SageReference

data class ImagePart(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Position") val position: Coords? = null,
    @SageIniName("Size") val size: Coords? = null,
    @SageIniName("ImageName") val imageName: SageReference<MappedImage>? = null,
    @SageIniName("Layer") val layer: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ImagePart>(
        name = "ImagePart",
        properties = {
            property("Position", Coords.type) { it.position }
            property("Size", Coords.type) { it.size }
            property("ImageName", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.imageName }
            property("Layer", IntValue) { it.layer }
        },
    )
}
