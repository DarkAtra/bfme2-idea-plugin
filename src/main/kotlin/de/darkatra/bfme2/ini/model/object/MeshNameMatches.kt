package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class MeshNameMatches(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Instances") val instances: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<MeshNameMatches>(
        name = "MeshNameMatches",
        properties = {
            property("Instances", IntValue) { it.instances }
        },
    )
}
