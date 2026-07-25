package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.livingworld.BonusForLevel
import de.darkatra.bfme2.ini.model.value.Opaque

data class AutoResolveLeadership(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Affects") val affects: List<Opaque> = emptyList(),
    @SageIniName("AffectsHigherLevelFirst") val affectsHigherLevelFirst: Boolean = false,
    @SageIniName("BonusForLevel") val bonusForLevel: List<BonusForLevel> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AutoResolveLeadership>(
        name = "AutoResolveLeadership",
        tableKey = "autoresolveleaderships",
        properties = {
            property("Affects", ListValue(Opaque.type)) { it.affects }
            property("AffectsHigherLevelFirst", BooleanValue) { it.affectsHigherLevelFirst }
            property("BonusForLevel", ListValue(BlockValue<BonusForLevel> { listOf(BonusForLevel) })) { it.bonusForLevel }
        },
    )
}
