package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Untyped

@SageIniName("IncreaseCommandPoints")
data class IncreaseCommandPointsNugget(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Type") val type: Untyped? = null,
    @SageIniName("Amount") val amount: Int = 0,
) : BuildingNugget {

    companion object : SageIniBlockDescriptor<IncreaseCommandPointsNugget>(
        name = "IncreaseCommandPoints",
        properties = {
            property("Type", Untyped.type) { it.type }
            property("Amount", IntValue) { it.amount }
        },
    )
}
