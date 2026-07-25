package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue

data class FactionVictoryData(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AllyDeathScaleFactor") val allyDeathScaleFactor: Double = 0.0,
    @SageIniName("EnemyKillScaleFactor") val enemyKillScaleFactor: Double = 0.0,
    @SageIniName("VictoryThreshold") val victoryThreshold: Double = 0.0,
    @SageIniName("MajorUnitValue") val majorUnitValue: Double = 0.0,
    @SageIniName("MapToCellVictoryRatio") val mapToCellVictoryRatio: Double = 0.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<FactionVictoryData>(
        name = "FactionVictoryData",
        tableKey = "factionvictorydatas",
        properties = {
            property("AllyDeathScaleFactor", FloatValue) { it.allyDeathScaleFactor }
            property("EnemyKillScaleFactor", FloatValue) { it.enemyKillScaleFactor }
            property("VictoryThreshold", FloatValue) { it.victoryThreshold }
            property("MajorUnitValue", FloatValue) { it.majorUnitValue }
            property("MapToCellVictoryRatio", FloatValue) { it.mapToCellVictoryRatio }
        },
    )
}
