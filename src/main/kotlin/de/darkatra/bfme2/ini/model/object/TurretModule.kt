package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniObject

data class TurretModule(
    val header: SageBlockHeader = SageBlockHeader(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<TurretModule>(
        name = "TurretModule",
    )
}
