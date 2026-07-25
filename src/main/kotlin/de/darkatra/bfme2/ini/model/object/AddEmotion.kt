package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class AddEmotion(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Duration") val duration: Int = 0,
    @SageIniName("AILockDuration") val aILockDuration: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<AddEmotion>(
        name = "AddEmotion",
        keyedByLabel = true,
        properties = {
            property("Duration", IntValue) { it.duration }
            property("AILockDuration", IntValue) { it.aILockDuration }
        },
    )
}
