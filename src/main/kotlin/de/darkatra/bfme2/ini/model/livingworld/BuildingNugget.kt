package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class BuildingNugget(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Type") val type: Untyped? = null,
    @SageIniName("Amount") val amount: Int = 0,
    @SageIniName("Bonus") val bonus: List<Untyped> = emptyList(),
    @SageIniName("BonusKey") val bonusKey: Untyped? = null,
    @SageIniName("TreasureAmount") val treasureAmount: Int = 0,
    @SageIniName("QueueSize") val queueSize: Int = 0,
    @SageIniName("StrengtheningRange") val strengtheningRange: Untyped? = null,
    @SageIniName("NumUpgradesPerTurn") val numUpgradesPerTurn: Int = 0,
    @SageIniName("UpgradeableUnits") val upgradeableUnits: List<SageReference<Object>> = emptyList(),
    @SageIniName("ArmyToSpawn") val armyToSpawn: List<ArmyToSpawn> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<BuildingNugget>(
        name = "BuildingNugget",
        properties = {
            property("Type", Untyped.type) { it.type }
            property("Amount", IntValue) { it.amount }
            property("Bonus", ListValue(Untyped.type)) { it.bonus }
            property("BonusKey", Untyped.type) { it.bonusKey }
            property("TreasureAmount", IntValue) { it.treasureAmount }
            property("QueueSize", IntValue) { it.queueSize }
            property("StrengtheningRange", Untyped.type) { it.strengtheningRange }
            property("NumUpgradesPerTurn", IntValue) { it.numUpgradesPerTurn }
            property("UpgradeableUnits", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.upgradeableUnits }
            property("ArmyToSpawn", ListValue(BlockValue<ArmyToSpawn> { listOf(ArmyToSpawn) })) { it.armyToSpawn }
        },
    )
}
