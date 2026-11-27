package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.BannerType
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.LivingWorldArmyIcon
import de.darkatra.bfme2.ini.model.`object`.MappedImage
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.Video
import de.darkatra.bfme2.ini.model.value.Coord2D
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class ArmyToSpawn(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PlayerArmy") val playerArmy: Untyped? = null,
    @SageIniName("Icon") val icon: SageReference<LivingWorldArmyIcon>? = null,
    @SageIniName("IconSize") val iconSize: Untyped? = null,
    @SageIniName("PalantirMovie") val palantirMovie: SageReference<Video>? = null,
    @SageIniName("BuildTime") val buildTime: Int = 0,
    @SageIniName("ConstructButtonImage") val constructButtonImage: SageReference<MappedImage>? = null,
    @SageIniName("ConstructButtonTitle") val constructButtonTitle: Untyped? = null,
    @SageIniName("ConstructButtonHelp") val constructButtonHelp: Untyped? = null,
    @SageIniName("HeroTemplateName") val heroTemplateName: SageReference<Object>? = null,
    @SageIniName("Banner") val banner: SageReference<BannerType>? = null,
    @SageIniName("Position") val position: Coord2D? = null,
    @SageIniName("InitialRegion") val initialRegion: String = "",
    @SageIniName("SpawnForTemplates") val spawnForTemplates: List<String> = emptyList(),
    @SageIniName("ScriptingName") val scriptingName: String = "",
    @SageIniName("TooltipStringTag") val tooltipStringTag: String = "",
    @SageIniName("IsCity") val isCity: Boolean = false,
    @SageIniName("MoveSpeed") val moveSpeed: Double = 0.0,
    @SageIniName("SpawnAtActStart") val spawnAtActStart: Boolean = false,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ArmyToSpawn>(
        name = "ArmyToSpawn",
        properties = {
            property("PlayerArmy", Untyped.type) { it.playerArmy }
            property("Icon", ReferenceValue<LivingWorldArmyIcon> { listOf(LivingWorldArmyIcon) }) { it.icon }
            property("IconSize", Untyped.type) { it.iconSize }
            property("PalantirMovie", ReferenceValue<Video> { listOf(Video) }) { it.palantirMovie }
            property("BuildTime", IntValue) { it.buildTime }
            property("ConstructButtonImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.constructButtonImage }
            property("ConstructButtonTitle", Untyped.type) { it.constructButtonTitle }
            property("ConstructButtonHelp", Untyped.type) { it.constructButtonHelp }
            property("HeroTemplateName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.heroTemplateName }
            property("Banner", ReferenceValue<BannerType> { listOf(BannerType) }) { it.banner }
            property("Position", Coord2D.type) { it.position }
            property("InitialRegion", StringValue) { it.initialRegion }
            property("SpawnForTemplates", ListValue(StringValue)) { it.spawnForTemplates }
            property("ScriptingName", StringValue) { it.scriptingName }
            property("TooltipStringTag", StringValue) { it.tooltipStringTag }
            property("IsCity", BooleanValue) { it.isCity }
            property("MoveSpeed", FloatValue) { it.moveSpeed }
            property("SpawnAtActStart", BooleanValue) { it.spawnAtActStart }
        },
    )
}
