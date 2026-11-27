package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.Untyped

@SageIniName("StrengthenArmy")
data class StrengthenArmyNugget(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StrengtheningRange") val strengtheningRange: Untyped? = null,
    @SageIniName("BonusKey") val bonusKey: Untyped? = null,
    @SageIniName("Bonus") val bonus: List<Untyped> = emptyList(),
) : BuildingNugget {

    companion object : SageIniBlockDescriptor<StrengthenArmyNugget>(
        name = "StrengthenArmy",
        properties = {
            property("StrengtheningRange", Untyped.type) { it.strengtheningRange }
            property("BonusKey", Untyped.type) { it.bonusKey }
            property("Bonus", ListValue(Untyped.type)) { it.bonus }
        },
    )
}
