package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.CombatChainUnitType
import de.darkatra.bfme2.ini.model.value.Untyped

data class CombatChainDefinition(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Unit") val unit: CombatChainUnitType? = null,
    @SageIniName("TargetTypes") val targetTypes: Untyped? = null,
    @SageIniName("TargetPriorityModifiers") val targetPriorityModifiers: Untyped? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<CombatChainDefinition>(
        name = "CombatChainDefinition",
        properties = {
            property("Unit", CombatChainUnitType.type) { it.unit }
            property("TargetTypes", Untyped.type) { it.targetTypes }
            property("TargetPriorityModifiers", Untyped.type) { it.targetPriorityModifiers }
        },
    )
}
