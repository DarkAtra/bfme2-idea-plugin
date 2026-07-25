package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class AutoResolveArmor(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Armor") val armor: Untyped? = null,
    @SageIniName("RequiredUpgrades") val requiredUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("ExcludedUpgrades") val excludedUpgrades: List<SageReference<Upgrade>> = emptyList(),
) : SageIniObject, AutoResolveEntry {

    companion object : SageIniBlockDescriptor<AutoResolveArmor>(
        name = "AutoResolveArmor",
        properties = {
            property("Armor", Untyped.type) { it.armor }
            property("RequiredUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.requiredUpgrades }
            property("ExcludedUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.excludedUpgrades }
        },
    )
}
