package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class ModifierEntry(
    val type: ModifierType? = null,
    val value: String? = null,
    val amount: Double? = null,
    val damageTypes: List<DamageType> = emptyList()
) {

    companion object {

        val type: SageIniValueType<ModifierEntry> = StructValue("ModifierEntry") {
            component("Type", ModifierType.type) { it.type }
            component("Value", StringValue) { it.value }
            component("Amount", FloatValue) { it.amount }
            component("DamageTypes", ListValue(DamageType.type)) { it.damageTypes }
        }
    }
}
