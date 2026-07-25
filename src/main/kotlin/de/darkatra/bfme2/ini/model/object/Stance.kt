package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.behaviour.MeleeBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.SageReference

data class Stance(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AttributeModifier") val attributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("MeleeBehavior") val meleeBehavior: List<MeleeBehavior> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Stance>(
        name = "Stance",
        properties = {
            property("AttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.attributeModifier }
            property("MeleeBehavior", ListValue(BlockValue<MeleeBehavior> { listOf(MeleeBehavior) })) { it.meleeBehavior }
        },
    )
}
