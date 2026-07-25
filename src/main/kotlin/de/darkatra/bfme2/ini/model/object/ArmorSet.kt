package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.ArmorSetFlags
import de.darkatra.bfme2.ini.model.value.SageReference

data class ArmorSet(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Conditions") val conditions: List<ArmorSetFlags> = emptyList(),
    @SageIniName("Armor") val armor: SageReference<Armor>? = null,
    @SageIniName("DamageFX") val damageFX: SageReference<DamageFX>? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ArmorSet>(
        name = "ArmorSet",
        properties = {
            property("Conditions", ListValue(ArmorSetFlags.type)) { it.conditions }
            property("Armor", ReferenceValue<Armor> { listOf(Armor) }) { it.armor }
            property("DamageFX", ReferenceValue<DamageFX> { listOf(DamageFX) }) { it.damageFX }
        },
    )
}
