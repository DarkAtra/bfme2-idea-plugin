package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.LivingWorldRegionCampaign
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class Scenario(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DisplayName") val displayName: Untyped? = null,
    @SageIniName("DisplayDescription") val displayDescription: Untyped? = null,
    @SageIniName("DisplayGameType") val displayGameType: Untyped? = null,
    @SageIniName("DisplayObjectives") val displayObjectives: Untyped? = null,
    @SageIniName("DisplayFiction") val displayFiction: Untyped? = null,
    @SageIniName("DisplayVictoriousText") val displayVictoriousText: Untyped? = null,
    @SageIniName("DisplayDefeatedText") val displayDefeatedText: Untyped? = null,
    @SageIniName("RegionCampaign") val regionCampaign: SageReference<LivingWorldRegionCampaign>? = null,
    @SageIniName("NumPlayers") val numPlayers: Int = 0,
    @SageIniName("MaxPlayers") val maxPlayers: Int = 0,
    @SageIniName("DefaultStartSpots") val defaultStartSpots: List<Opaque> = emptyList(),
    @SageIniName("DisallowStartInRegions") val disallowStartInRegions: List<Opaque> = emptyList(),
    @SageIniName("DisableRegions") val disableRegions: List<Opaque> = emptyList(),
    @SageIniName("DisabledFactions") val disabledFactions: Opaque? = null,
    @SageIniName("HistoricalScenario") val historicalScenario: Boolean = false,
    @SageIniName("MinPlayers") val minPlayers: Int = 0,
    @SageIniName("PlayerDefeatCondition") val playerDefeatCondition: List<PlayerDefeatCondition> = emptyList(),
    @SageIniName("TeamDefeatCondition") val teamDefeatCondition: List<TeamDefeatCondition> = emptyList(),
    @SageIniName("PlayerVictoryCondition") val playerVictoryCondition: List<PlayerVictoryCondition> = emptyList(),
    @SageIniName("TeamVictoryCondition") val teamVictoryCondition: List<TeamVictoryCondition> = emptyList(),
    @SageIniName("OwnershipSet") val ownershipSet: List<OwnershipSet> = emptyList(),
    @SageIniName("StartingRestriction") val startingRestriction: List<StartingRestriction> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Scenario>(
        name = "Scenario",
        properties = {
            property("DisplayName", Untyped.type) { it.displayName }
            property("DisplayDescription", Untyped.type) { it.displayDescription }
            property("DisplayGameType", Untyped.type) { it.displayGameType }
            property("DisplayObjectives", Untyped.type) { it.displayObjectives }
            property("DisplayFiction", Untyped.type) { it.displayFiction }
            property("DisplayVictoriousText", Untyped.type) { it.displayVictoriousText }
            property("DisplayDefeatedText", Untyped.type) { it.displayDefeatedText }
            property("RegionCampaign", ReferenceValue<LivingWorldRegionCampaign> { listOf(LivingWorldRegionCampaign) }) { it.regionCampaign }
            property("NumPlayers", IntValue) { it.numPlayers }
            property("MaxPlayers", IntValue) { it.maxPlayers }
            property("DefaultStartSpots", ListValue(Opaque.type)) { it.defaultStartSpots }
            property("DisallowStartInRegions", ListValue(Opaque.type)) { it.disallowStartInRegions }
            property("DisableRegions", ListValue(Opaque.type)) { it.disableRegions }
            property("DisabledFactions", Opaque.type) { it.disabledFactions }
            property("HistoricalScenario", BooleanValue) { it.historicalScenario }
            property("MinPlayers", IntValue) { it.minPlayers }
            property("PlayerDefeatCondition", ListValue(BlockValue<PlayerDefeatCondition> { listOf(PlayerDefeatCondition) })) { it.playerDefeatCondition }
            property("TeamDefeatCondition", ListValue(BlockValue<TeamDefeatCondition> { listOf(TeamDefeatCondition) })) { it.teamDefeatCondition }
            property("PlayerVictoryCondition", ListValue(BlockValue<PlayerVictoryCondition> { listOf(PlayerVictoryCondition) })) { it.playerVictoryCondition }
            property("TeamVictoryCondition", ListValue(BlockValue<TeamVictoryCondition> { listOf(TeamVictoryCondition) })) { it.teamVictoryCondition }
            property("OwnershipSet", ListValue(BlockValue<OwnershipSet> { listOf(OwnershipSet) })) { it.ownershipSet }
            property("StartingRestriction", ListValue(BlockValue<StartingRestriction> { listOf(StartingRestriction) })) { it.startingRestriction }
        },
    )
}
