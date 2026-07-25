package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.livingworld.Act
import de.darkatra.bfme2.ini.model.livingworld.AddPlayer
import de.darkatra.bfme2.ini.model.livingworld.Scenario
import de.darkatra.bfme2.ini.model.value.Opaque

data class LivingWorldCampaign(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("IsEvilCampaign") val isEvilCampaign: Boolean = false,
    @SageIniName("IsScriptedCampaign") val isScriptedCampaign: Boolean = false,
    @SageIniName("SecondsPerReinforcement") val secondsPerReinforcement: Int = 0,
    @SageIniName("StartingCashRTS") val startingCashRTS: Int = 0,
    @SageIniName("StartingCashRTSWithFort") val startingCashRTSWithFort: Int = 0,
    @SageIniName("InitialRevivalCostMultiplier") val initialRevivalCostMultiplier: Double = 0.0,
    @SageIniName("InitialRevivalTimeMultiplier") val initialRevivalTimeMultiplier: Double = 0.0,
    @SageIniName("LocalPlayer") val localPlayer: Opaque? = null,
    @SageIniName("LivingWorldVictoryType") val livingWorldVictoryType: Opaque? = null,
    @SageIniName("Tutorial") val tutorial: Opaque? = null,
    @SageIniName("Act") val act: List<Act> = emptyList(),
    @SageIniName("Scenario") val scenario: List<Scenario> = emptyList(),
    @SageIniName("AddPlayer") val addPlayer: List<AddPlayer> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldCampaign>(
        name = "LivingWorldCampaign",
        tableKey = "livingworldcampaigns",
        properties = {
            property("IsEvilCampaign", BooleanValue) { it.isEvilCampaign }
            property("IsScriptedCampaign", BooleanValue) { it.isScriptedCampaign }
            property("SecondsPerReinforcement", IntValue) { it.secondsPerReinforcement }
            property("StartingCashRTS", IntValue) { it.startingCashRTS }
            property("StartingCashRTSWithFort", IntValue) { it.startingCashRTSWithFort }
            property("InitialRevivalCostMultiplier", FloatValue) { it.initialRevivalCostMultiplier }
            property("InitialRevivalTimeMultiplier", FloatValue) { it.initialRevivalTimeMultiplier }
            property("LocalPlayer", Opaque.type) { it.localPlayer }
            property("LivingWorldVictoryType", Opaque.type) { it.livingWorldVictoryType }
            property("Tutorial", Opaque.type) { it.tutorial }
            property("Act", ListValue(BlockValue<Act> { listOf(Act) })) { it.act }
            property("Scenario", ListValue(BlockValue<Scenario> { listOf(Scenario) })) { it.scenario }
            property("AddPlayer", ListValue(BlockValue<AddPlayer> { listOf(AddPlayer) })) { it.addPlayer }
        },
    )
}
