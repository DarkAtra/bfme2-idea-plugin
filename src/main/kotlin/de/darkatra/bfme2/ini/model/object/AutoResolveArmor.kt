package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.value.Untyped

data class AutoResolveArmor(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Armor") val armor: Untyped? = null,
) : SageIniObject, AutoResolveEntry {

    companion object : SageIniBlockDescriptor<AutoResolveArmor>(
        name = "AutoResolveArmor",
        properties = {
            property("Armor", Untyped.type) { it.armor }
        },
    )
}
