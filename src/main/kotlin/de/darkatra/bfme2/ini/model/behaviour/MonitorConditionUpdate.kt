package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.CommandSet
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.WeaponSetConditions

data class MonitorConditionUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ModelConditionCommandSet") val modelConditionCommandSet: SageReference<CommandSet>? = null,
    @SageIniName("WeaponSetFlags") val weaponSetFlags: WeaponSetConditions? = null,
    @SageIniName("WeaponToggleCommandSet") val weaponToggleCommandSet: SageReference<CommandSet>? = null,
    @SageIniName("ModelConditionFlags") val modelConditionFlags: List<ModelCondition> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<MonitorConditionUpdate>(
        name = "MonitorConditionUpdate",
        properties = {
            property("ModelConditionCommandSet", ReferenceValue<CommandSet> { listOf(CommandSet) }) { it.modelConditionCommandSet }
            property("WeaponSetFlags", WeaponSetConditions.type) { it.weaponSetFlags }
            property("WeaponToggleCommandSet", ReferenceValue<CommandSet> { listOf(CommandSet) }) { it.weaponToggleCommandSet }
            property("ModelConditionFlags", ListValue(ModelCondition.type)) { it.modelConditionFlags }
        },
    )
}
