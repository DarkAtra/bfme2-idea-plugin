package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class ApplyRandomForce(
    val header: SageBlockHeader = SageBlockHeader(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ApplyRandomForce>(
        name = "ApplyRandomForce",
    )
}
