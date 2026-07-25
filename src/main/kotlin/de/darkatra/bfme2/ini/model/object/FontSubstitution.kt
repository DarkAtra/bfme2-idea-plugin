package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class FontSubstitution(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Size") val size: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<FontSubstitution>(
        name = "FontSubstitution",
        tableKey = "fontsubstitutions",
        properties = {
            property("Size", IntValue) { it.size }
        },
    )
}
