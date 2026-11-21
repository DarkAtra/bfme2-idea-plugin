package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.MappedImage
import de.darkatra.bfme2.ini.model.value.SageReference

data class StrategicHUDButton(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Image") val image: SageReference<MappedImage>? = null,
    @SageIniName("Title") val title: String = "",
    @SageIniName("Help") val help: String = "",
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<StrategicHUDButton>(
        name = "StrategicHUDButton",
        properties = {
            property("Image", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.image }
            property("Title", StringValue) { it.title }
            property("Help", StringValue) { it.help }
        },
    )
}
