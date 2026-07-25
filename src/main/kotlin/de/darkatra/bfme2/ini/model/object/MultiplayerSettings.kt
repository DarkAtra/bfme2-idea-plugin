package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class MultiplayerSettings(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("InitialCreditsVeryLow") val initialCreditsVeryLow: Int = 0,
    @SageIniName("InitialCreditsLow") val initialCreditsLow: Int = 0,
    @SageIniName("InitialCreditsMedium") val initialCreditsMedium: Int = 0,
    @SageIniName("InitialCreditsHigh") val initialCreditsHigh: Int = 0,
    @SageIniName("InitialCreditsVeryHigh") val initialCreditsVeryHigh: Int = 0,
    @SageIniName("StartCountdownTimer") val startCountdownTimer: Int = 0,
    @SageIniName("MaxBeaconsPerPlayer") val maxBeaconsPerPlayer: Int = 0,
    @SageIniName("UseShroud") val useShroud: Boolean = false,
    @SageIniName("ShowRandomPlayerTemplate") val showRandomPlayerTemplate: Boolean = false,
    @SageIniName("ShowRandomStartPos") val showRandomStartPos: Boolean = false,
    @SageIniName("ShowRandomColor") val showRandomColor: Boolean = false,
    @SageIniName("InitialCreditsMax") val initialCreditsMax: Int = 0,
    @SageIniName("InitialCreditsMin") val initialCreditsMin: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<MultiplayerSettings>(
        name = "MultiplayerSettings",
        tableKey = "multiplayersettings",
        properties = {
            property("InitialCreditsVeryLow", IntValue) { it.initialCreditsVeryLow }
            property("InitialCreditsLow", IntValue) { it.initialCreditsLow }
            property("InitialCreditsMedium", IntValue) { it.initialCreditsMedium }
            property("InitialCreditsHigh", IntValue) { it.initialCreditsHigh }
            property("InitialCreditsVeryHigh", IntValue) { it.initialCreditsVeryHigh }
            property("StartCountdownTimer", IntValue) { it.startCountdownTimer }
            property("MaxBeaconsPerPlayer", IntValue) { it.maxBeaconsPerPlayer }
            property("UseShroud", BooleanValue) { it.useShroud }
            property("ShowRandomPlayerTemplate", BooleanValue) { it.showRandomPlayerTemplate }
            property("ShowRandomStartPos", BooleanValue) { it.showRandomStartPos }
            property("ShowRandomColor", BooleanValue) { it.showRandomColor }
            property("InitialCreditsMax", IntValue) { it.initialCreditsMax }
            property("InitialCreditsMin", IntValue) { it.initialCreditsMin }
        },
    )
}
