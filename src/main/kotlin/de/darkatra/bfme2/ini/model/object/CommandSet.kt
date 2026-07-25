package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniNumberedSlots
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.SageReference

data class CommandSet(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("InitialVisible") val initialVisible: Int = 0,
    val slots: Map<Int, SageReference<CommandButton>> = emptyMap(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<CommandSet>(
        name = "CommandSet",
        tableKey = "commandsets",
        numberedSlots = SageIniNumberedSlots(ReferenceValue<CommandButton> { listOf(CommandButton) }) { it.slots },
        properties = {
            property("InitialVisible", IntValue) { it.initialVisible }
        },
    )
}
