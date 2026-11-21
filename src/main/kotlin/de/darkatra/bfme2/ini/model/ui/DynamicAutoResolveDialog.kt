package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class DynamicAutoResolveDialog(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BattleRoundsPerStep") val battleRoundsPerStep: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<DynamicAutoResolveDialog>(
        name = "DynamicAutoResolveDialog",
        properties = {
            property("BattleRoundsPerStep", IntValue) { it.battleRoundsPerStep }
        },
    )
}
