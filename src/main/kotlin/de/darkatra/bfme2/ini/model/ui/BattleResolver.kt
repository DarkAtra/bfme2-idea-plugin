package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class BattleResolver(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StartingAutoResolveBattleMessageDuration") val startingAutoResolveBattleMessageDuration: Double = 0.0,
    @SageIniName("AllEnemiesRetreatedMessageDuration") val allEnemiesRetreatedMessageDuration: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<BattleResolver>(
        name = "BattleResolver",
        properties = {
            property("StartingAutoResolveBattleMessageDuration", FloatValue) { it.startingAutoResolveBattleMessageDuration }
            property("AllEnemiesRetreatedMessageDuration", FloatValue) { it.allEnemiesRetreatedMessageDuration }
        },
    )
}
