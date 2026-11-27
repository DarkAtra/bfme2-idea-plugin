package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue

@SageIniName("SpawnArmy")
data class SpawnArmyNugget(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("QueueSize") val queueSize: Int = 0,
    @SageIniName("ArmyToSpawn") val armyToSpawn: List<ArmyToSpawn> = emptyList(),
) : BuildingNugget {

    companion object : SageIniBlockDescriptor<SpawnArmyNugget>(
        name = "SpawnArmy",
        properties = {
            property("QueueSize", IntValue) { it.queueSize }
            property("ArmyToSpawn", ListValue(BlockValue<ArmyToSpawn> { listOf(ArmyToSpawn) })) { it.armyToSpawn }
        },
    )
}
