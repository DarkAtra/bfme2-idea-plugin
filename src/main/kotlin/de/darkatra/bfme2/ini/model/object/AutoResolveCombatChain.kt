package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.Untyped

data class AutoResolveCombatChain(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Target") val target: List<Untyped> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AutoResolveCombatChain>(
        name = "AutoResolveCombatChain",
        tableKey = "autoresolvecombatchains",
        properties = {
            property("Target", ListValue(Untyped.type)) { it.target }
        },
    )
}
