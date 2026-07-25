package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class LargeGroupBonusUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("UpdateRate") val updateRate: Int = 0,
    @SageIniName("HordeMemberFilter") val hordeMemberFilter: SageFilter? = null,
    @SageIniName("Count") val count: Int = 0,
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("RubOffRadius") val rubOffRadius: Double = 0.0,
    @SageIniName("AlliesOnly") val alliesOnly: Boolean = false,
    @SageIniName("AttributeModifier") val attributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("FlagSubObjectNames") val flagSubObjectNames: List<Untyped> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<LargeGroupBonusUpdate>(
        name = "LargeGroupBonusUpdate",
        properties = {
            property("UpdateRate", IntValue) { it.updateRate }
            property("HordeMemberFilter", SageFilter.type) { it.hordeMemberFilter }
            property("Count", IntValue) { it.count }
            property("Radius", FloatValue) { it.radius }
            property("RubOffRadius", FloatValue) { it.rubOffRadius }
            property("AlliesOnly", BooleanValue) { it.alliesOnly }
            property("AttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.attributeModifier }
            property("FlagSubObjectNames", ListValue(Untyped.type)) { it.flagSubObjectNames }
        },
    )
}
