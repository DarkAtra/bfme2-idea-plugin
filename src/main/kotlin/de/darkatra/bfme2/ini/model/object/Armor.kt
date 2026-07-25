package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.Untyped

data class Armor(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Armor") val armor: List<Untyped> = emptyList(),
    @SageIniName("FlankedPenalty") val flankedPenalty: Double = 0.0,
    @SageIniName("DamageScalar") val damageScalar: Double = 1.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Armor>(
        name = "Armor",
        tableKey = "armorsets",
        properties = {
            property("Armor", ListValue(Untyped.type)) { it.armor }
            property("FlankedPenalty", FloatValue) { it.flankedPenalty }
            property("DamageScalar", FloatValue) { it.damageScalar }
        },
    )
}
