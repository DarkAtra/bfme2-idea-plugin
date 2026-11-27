package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

@SageIniName("IncreaseTreasury")
data class IncreaseTreasuryNugget(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TreasureAmount") val treasureAmount: Int = 0,
) : BuildingNugget {

    companion object : SageIniBlockDescriptor<IncreaseTreasuryNugget>(
        name = "IncreaseTreasury",
        properties = {
            property("TreasureAmount", IntValue) { it.treasureAmount }
        },
    )
}
