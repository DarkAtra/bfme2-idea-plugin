package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.livingworld.Bonus
import de.darkatra.bfme2.ini.model.value.SageReference

data class LivingWorldAutoResolveResourceBonus(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Sides") val sides: List<SageReference<LivingWorldPlayerTemplate>> = emptyList(),
    @SageIniName("Bonus") val bonus: List<Bonus> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldAutoResolveResourceBonus>(
        name = "LivingWorldAutoResolveResourceBonus",
        tableKey = "livingworldautoresolveresourcebonus",
        properties = {
            property("Sides", ListValue(ReferenceValue<LivingWorldPlayerTemplate> { listOf(LivingWorldPlayerTemplate) })) { it.sides }
            property("Bonus", ListValue(BlockValue<Bonus> { listOf(Bonus) })) { it.bonus }
        },
    )
}
