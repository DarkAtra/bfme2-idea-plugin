package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.SageReference

@SageIniName("UpgradeTroops")
data class UpgradeTroopsNugget(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("NumUpgradesPerTurn") val numUpgradesPerTurn: Int = 0,
    @SageIniName("UpgradeableUnits") val upgradeableUnits: List<SageReference<Object>> = emptyList(),
) : BuildingNugget {

    companion object : SageIniBlockDescriptor<UpgradeTroopsNugget>(
        name = "UpgradeTroops",
        properties = {
            property("NumUpgradesPerTurn", IntValue) { it.numUpgradesPerTurn }
            property("UpgradeableUnits", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.upgradeableUnits }
        },
    )
}
