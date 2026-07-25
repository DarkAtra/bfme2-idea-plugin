package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue

data class FontDefaultSettings(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Antialiased") val antialiased: Boolean = false,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<FontDefaultSettings>(
        name = "FontDefaultSettings",
        tableKey = "fontdefaultsettings",
        properties = {
            property("Antialiased", BooleanValue) { it.antialiased }
        },
    )
}
