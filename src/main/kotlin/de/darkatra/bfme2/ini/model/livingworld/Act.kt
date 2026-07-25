package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.SpawnArmy

data class Act(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpawnArmy") val spawnArmy: List<SpawnArmy> = emptyList(),
    @SageIniName("EyeTowerPoints") val eyeTowerPoints: List<EyeTowerPoints> = emptyList(),
    @SageIniName("WorldText") val worldText: List<WorldText> = emptyList(),
    @SageIniName("MoveCamera") val moveCamera: List<MoveCamera> = emptyList(),
    @SageIniName("MoveArmy") val moveArmy: List<MoveArmy> = emptyList(),
    @SageIniName("SetPlayerControlOfArmy") val setPlayerControlOfArmy: List<SetPlayerControlOfArmy> = emptyList(),
    @SageIniName("EnableRegion") val enableRegion: List<EnableRegion> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Act>(
        name = "Act",
        properties = {
            property("SpawnArmy", ListValue(BlockValue<SpawnArmy> { listOf(SpawnArmy) })) { it.spawnArmy }
            property("EyeTowerPoints", ListValue(BlockValue<EyeTowerPoints> { listOf(EyeTowerPoints) })) { it.eyeTowerPoints }
            property("WorldText", ListValue(BlockValue<WorldText> { listOf(WorldText) })) { it.worldText }
            property("MoveCamera", ListValue(BlockValue<MoveCamera> { listOf(MoveCamera) })) { it.moveCamera }
            property("MoveArmy", ListValue(BlockValue<MoveArmy> { listOf(MoveArmy) })) { it.moveArmy }
            property("SetPlayerControlOfArmy", ListValue(BlockValue<SetPlayerControlOfArmy> { listOf(SetPlayerControlOfArmy) })) { it.setPlayerControlOfArmy }
            property("EnableRegion", ListValue(BlockValue<EnableRegion> { listOf(EnableRegion) })) { it.enableRegion }
        },
    )
}
