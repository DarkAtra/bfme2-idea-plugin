package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.Coords

data class MapCache(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("fileSize") val fileSize: Int = 0,
    @SageIniName("fileCRC") val fileCrc: Int = 0,
    @SageIniName("timestampLo") val timestampLo: Int = 0,
    @SageIniName("timestampHi") val timestampHi: Int = 0,
    @SageIniName("isOfficial") val isOfficial: Boolean = false,
    @SageIniName("isMultiplayer") val isMultiplayer: Boolean = false,
    @SageIniName("isScenarioMP") val isScenarioMp: Boolean = false,
    @SageIniName("numPlayers") val numPlayers: Int = 0,
    @SageIniName("extentMin") val extentMin: Coords? = null,
    @SageIniName("extentMax") val extentMax: Coords? = null,
    @SageIniName("displayName") val displayName: String = "",
    @SageIniName("description") val description: String = "",
    @SageIniName("InitialCameraPosition") val initialCameraPosition: Coords? = null,
    @SageIniName("Player_1_Start") val player1Start: Coords? = null,
    @SageIniName("Player_2_Start") val player2Start: Coords? = null,
    @SageIniName("Player_3_Start") val player3Start: Coords? = null,
    @SageIniName("Player_4_Start") val player4Start: Coords? = null,
    @SageIniName("Player_5_Start") val player5Start: Coords? = null,
    @SageIniName("Player_6_Start") val player6Start: Coords? = null,
    @SageIniName("Player_7_Start") val player7Start: Coords? = null,
    @SageIniName("Player_8_Start") val player8Start: Coords? = null,
    @SageIniName("PlayerPosition") val playerPosition: List<PlayerPosition> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<MapCache>(
        name = "MapCache",
        fileName = "mapcache.ini",
        properties = {
            property("fileSize", IntValue) { it.fileSize }
            property("fileCRC", IntValue) { it.fileCrc }
            property("timestampLo", IntValue) { it.timestampLo }
            property("timestampHi", IntValue) { it.timestampHi }
            property("isOfficial", BooleanValue) { it.isOfficial }
            property("isMultiplayer", BooleanValue) { it.isMultiplayer }
            property("isScenarioMP", BooleanValue) { it.isScenarioMp }
            property("numPlayers", IntValue) { it.numPlayers }
            property("extentMin", Coords.type) { it.extentMin }
            property("extentMax", Coords.type) { it.extentMax }
            property("displayName", StringValue) { it.displayName }
            property("description", StringValue) { it.description }
            property("InitialCameraPosition", Coords.type) { it.initialCameraPosition }
            property("Player_1_Start", Coords.type) { it.player1Start }
            property("Player_2_Start", Coords.type) { it.player2Start }
            property("Player_3_Start", Coords.type) { it.player3Start }
            property("Player_4_Start", Coords.type) { it.player4Start }
            property("Player_5_Start", Coords.type) { it.player5Start }
            property("Player_6_Start", Coords.type) { it.player6Start }
            property("Player_7_Start", Coords.type) { it.player7Start }
            property("Player_8_Start", Coords.type) { it.player8Start }
            property("PlayerPosition", ListValue(BlockValue<PlayerPosition> { listOf(PlayerPosition) })) { it.playerPosition }
        },
    )
}
