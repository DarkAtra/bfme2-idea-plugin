package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue

data class PlayerAIType(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("LibraryMap") val libraryMap: String = "",
) : SageIniObject {

    companion object : SageIniBlockDescriptor<PlayerAIType>(
        name = "PlayerAIType",
        tableKey = "playeraitypes",
        properties = {
            property("LibraryMap", StringValue) { it.libraryMap }
        },
    )
}
