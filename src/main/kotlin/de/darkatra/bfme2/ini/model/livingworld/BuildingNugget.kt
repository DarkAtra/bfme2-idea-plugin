package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

/**
 * A `BuildingNugget <type> <tag>` block, whose properties depend on its type.
 */
interface BuildingNugget : SageNestedAttribute {

    companion object {

        val types: List<SageIniBlockDescriptor<out BuildingNugget>> by lazy {
            listOf(IncreaseCommandPointsNugget, IncreaseTreasuryNugget, SpawnArmyNugget, StrengthenArmyNugget, UpgradeTroopsNugget)
        }
    }
}
