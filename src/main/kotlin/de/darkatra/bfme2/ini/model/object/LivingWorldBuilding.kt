package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.livingworld.BuildingNugget
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class LivingWorldBuilding(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AvailableTo") val availableTo: SageReference<LivingWorldPlayerTemplate>? = null,
    @SageIniName("BattleThingTemplate") val battleThingTemplate: SageReference<Object>? = null,
    @SageIniName("BuildingIcon") val buildingIcon: SageReference<LivingWorldBuildingIcon>? = null,
    @SageIniName("ConstructButtonImage") val constructButtonImage: SageReference<MappedImage>? = null,
    @SageIniName("TurnsToBuild") val turnsToBuild: Int = 0,
    @SageIniName("Type") val type: Untyped? = null,
    @SageIniName("ConstructButtonTitle") val constructButtonTitle: String = "",
    @SageIniName("ConstructButtonHelp") val constructButtonHelp: String = "",
    @SageIniName("DisplayNameTag") val displayNameTag: String = "",
    @SageIniName("DisplayDescriptionTag") val displayDescriptionTag: String = "",
    @SageIniName("CreateUnitDuringAutoResolve") val createUnitDuringAutoResolve: Boolean = false,
    @SageIniName("CanDefendTerritory") val canDefendTerritory: Boolean = false,
    @SageIniName("StrategicResourceCost") val strategicResourceCost: Int = 0,
    @SageIniName("BuildingNugget") val buildingNugget: List<BuildingNugget> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldBuilding>(
        name = "LivingWorldBuilding",
        tableKey = "livingworldbuildings",
        properties = {
            property("AvailableTo", ReferenceValue<LivingWorldPlayerTemplate> { listOf(LivingWorldPlayerTemplate) }) { it.availableTo }
            property("BattleThingTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.battleThingTemplate }
            property("BuildingIcon", ReferenceValue<LivingWorldBuildingIcon> { listOf(LivingWorldBuildingIcon) }) { it.buildingIcon }
            property("ConstructButtonImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.constructButtonImage }
            property("TurnsToBuild", IntValue) { it.turnsToBuild }
            property("Type", Untyped.type) { it.type }
            property("ConstructButtonTitle", StringValue) { it.constructButtonTitle }
            property("ConstructButtonHelp", StringValue) { it.constructButtonHelp }
            property("DisplayNameTag", StringValue) { it.displayNameTag }
            property("DisplayDescriptionTag", StringValue) { it.displayDescriptionTag }
            property("CreateUnitDuringAutoResolve", BooleanValue) { it.createUnitDuringAutoResolve }
            property("CanDefendTerritory", BooleanValue) { it.canDefendTerritory }
            property("StrategicResourceCost", IntValue) { it.strategicResourceCost }
            property("BuildingNugget", ListValue(BlockValue<BuildingNugget> { listOf(BuildingNugget) })) { it.buildingNugget }
        },
    )
}
