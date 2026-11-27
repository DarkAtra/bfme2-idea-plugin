package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.ui.ImagePart
import de.darkatra.bfme2.ini.model.ui.LinePart

data class ShellMenuScheme(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ImagePart") val imagePart: List<ImagePart> = emptyList(),
    @SageIniName("LinePart") val linePart: List<LinePart> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ShellMenuScheme>(
        name = "ShellMenuScheme",
        tableKey = "shellmenuschemes",
        properties = {
            property("ImagePart", ListValue(BlockValue<ImagePart> { listOf(ImagePart) })) { it.imagePart }
            property("LinePart", ListValue(BlockValue<LinePart> { listOf(LinePart) })) { it.linePart }
        },
    )
}
