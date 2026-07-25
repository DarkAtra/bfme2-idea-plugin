package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.LivingWorldArmyIcon
import de.darkatra.bfme2.ini.model.`object`.MappedImage
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class ArmyToSpawn(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PlayerArmy") val playerArmy: Untyped? = null,
    @SageIniName("Icon") val icon: SageReference<LivingWorldArmyIcon>? = null,
    @SageIniName("IconSize") val iconSize: Untyped? = null,
    @SageIniName("PalantirMovie") val palantirMovie: Untyped? = null,
    @SageIniName("BuildTime") val buildTime: Int = 0,
    @SageIniName("ConstructButtonImage") val constructButtonImage: SageReference<MappedImage>? = null,
    @SageIniName("ConstructButtonTitle") val constructButtonTitle: Untyped? = null,
    @SageIniName("ConstructButtonHelp") val constructButtonHelp: Untyped? = null,
    @SageIniName("HeroTemplateName") val heroTemplateName: SageReference<Object>? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ArmyToSpawn>(
        name = "ArmyToSpawn",
        properties = {
            property("PlayerArmy", Untyped.type) { it.playerArmy }
            property("Icon", ReferenceValue<LivingWorldArmyIcon> { listOf(LivingWorldArmyIcon) }) { it.icon }
            property("IconSize", Untyped.type) { it.iconSize }
            property("PalantirMovie", Untyped.type) { it.palantirMovie }
            property("BuildTime", IntValue) { it.buildTime }
            property("ConstructButtonImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.constructButtonImage }
            property("ConstructButtonTitle", Untyped.type) { it.constructButtonTitle }
            property("ConstructButtonHelp", Untyped.type) { it.constructButtonHelp }
            property("HeroTemplateName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.heroTemplateName }
        },
    )
}
