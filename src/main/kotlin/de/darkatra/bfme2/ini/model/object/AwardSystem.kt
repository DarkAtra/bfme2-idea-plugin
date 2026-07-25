package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue

data class AwardSystem(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ThingStat") val thingStat: List<ThingStat> = emptyList(),
    @SageIniName("ObjectAward") val objectAward: List<ObjectAward> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AwardSystem>(
        name = "AwardSystem",
        tableKey = "awardsystems",
        properties = {
            property("ThingStat", ListValue(BlockValue<ThingStat> { listOf(ThingStat) })) { it.thingStat }
            property("ObjectAward", ListValue(BlockValue<ObjectAward> { listOf(ObjectAward) })) { it.objectAward }
        },
    )
}
