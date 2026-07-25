package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.AttackPriorityTarget

data class AttackPriority(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Default") val default: Int = 0,
    @SageIniName("Target") val target: List<AttackPriorityTarget> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AttackPriority>(
        name = "AttackPriority",
        tableKey = "attackpriorities",
        properties = {
            property("Default", IntValue) { it.default }
            property("Target", ListValue(AttackPriorityTarget.type)) { it.target }
        },
    )
}
