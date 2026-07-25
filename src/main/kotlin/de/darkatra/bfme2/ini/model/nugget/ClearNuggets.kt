package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageNugget

data class ClearNuggets(
    val header: SageBlockHeader = SageBlockHeader(),
) : SageNugget {

    companion object : SageIniBlockDescriptor<ClearNuggets>(
        name = "ClearNuggets",
        bareDirective = true,
    )
}
