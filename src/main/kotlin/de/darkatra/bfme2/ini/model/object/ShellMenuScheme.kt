package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniObject

data class ShellMenuScheme(
    val header: SageBlockHeader = SageBlockHeader(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ShellMenuScheme>(
        name = "ShellMenuScheme",
        tableKey = "shellmenuschemes",
    )
}
