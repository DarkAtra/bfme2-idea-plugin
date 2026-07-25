package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.MapFile

data class AIBase(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Side") val side: FakeToken? = null,
    @SageIniName("Map") val map: MapFile? = null,
    @SageIniName("GameMapToUseOn") val gameMapToUseOn: List<MapFile> = emptyList(),
    @SageIniName("PlayerPositions") val playerPositions: Int = 0,
    @SageIniName("AllowsArbirtaryRotation") val allowsArbirtaryRotation: Boolean = false,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AIBase>(
        name = "AIBase",
        tableKey = "aibases",
        uniqueName = false,
        properties = {
            property("Side", FakeToken.type) { it.side }
            property("Map", MapFile.type) { it.map }
            property("GameMapToUseOn", ListValue(MapFile.type)) { it.gameMapToUseOn }
            property("PlayerPositions", IntValue) { it.playerPositions }
            property("AllowsArbirtaryRotation", BooleanValue) { it.allowsArbirtaryRotation }
        },
    )
}
