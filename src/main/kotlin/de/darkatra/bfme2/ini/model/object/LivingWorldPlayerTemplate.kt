package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class LivingWorldPlayerTemplate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Faction") val faction: SageReference<PlayerTemplate>? = null,
    @SageIniName("Music") val music: Opaque? = null,
    @SageIniName("AutoResolveLoop") val autoResolveLoop: Opaque? = null,
    @SageIniName("StartingWorldCP") val startingWorldCP: Int = 0,
    @SageIniName("MaxWorldCP") val maxWorldCP: Int = 0,
    @SageIniName("StartingHeroCP") val startingHeroCP: Int = 0,
    @SageIniName("MaxHeroCP") val maxHeroCP: Int = 0,
    @SageIniName("FactionIcon") val factionIcon: String = "",
    @SageIniName("DefaultArmyIconName") val defaultArmyIconName: String = "",
    @SageIniName("BuildPlotIconName") val buildPlotIconName: String = "",
    @SageIniName("BuildPlotSelectionPortraitName") val buildPlotSelectionPortraitName: String = "",
    @SageIniName("GarrisonSelectionPortraitName") val garrisonSelectionPortraitName: String = "",
    @SageIniName("GarrisonDisplayNameTag") val garrisonDisplayNameTag: Untyped? = null,
    @SageIniName("FactionDozerTemplateName") val factionDozerTemplateName: String = "",
    @SageIniName("FactionInnUnitTemplateName") val factionInnUnitTemplateName: String = "",
    @SageIniName("ScenarioMaxResources") val scenarioMaxResources: Int = 0,
    @SageIniName("ScenarioStartResources") val scenarioStartResources: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldPlayerTemplate>(
        name = "LivingWorldPlayerTemplate",
        tableKey = "livingworldplayertemplates",
        properties = {
            property("Faction", ReferenceValue<PlayerTemplate> { listOf(PlayerTemplate) }) { it.faction }
            property("Music", Opaque.type) { it.music }
            property("AutoResolveLoop", Opaque.type) { it.autoResolveLoop }
            property("StartingWorldCP", IntValue) { it.startingWorldCP }
            property("MaxWorldCP", IntValue) { it.maxWorldCP }
            property("StartingHeroCP", IntValue) { it.startingHeroCP }
            property("MaxHeroCP", IntValue) { it.maxHeroCP }
            property("FactionIcon", StringValue) { it.factionIcon }
            property("DefaultArmyIconName", StringValue) { it.defaultArmyIconName }
            property("BuildPlotIconName", StringValue) { it.buildPlotIconName }
            property("BuildPlotSelectionPortraitName", StringValue) { it.buildPlotSelectionPortraitName }
            property("GarrisonSelectionPortraitName", StringValue) { it.garrisonSelectionPortraitName }
            property("GarrisonDisplayNameTag", Untyped.type) { it.garrisonDisplayNameTag }
            property("FactionDozerTemplateName", StringValue) { it.factionDozerTemplateName }
            property("FactionInnUnitTemplateName", StringValue) { it.factionInnUnitTemplateName }
            property("ScenarioMaxResources", IntValue) { it.scenarioMaxResources }
            property("ScenarioStartResources", IntValue) { it.scenarioStartResources }
        },
    )
}
