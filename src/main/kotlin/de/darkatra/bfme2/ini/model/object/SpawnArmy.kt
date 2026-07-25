package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference

data class SpawnArmy(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ScriptingName") val scriptingName: Opaque? = null,
    @SageIniName("SpawnForTemplates") val spawnForTemplates: SageReference<LivingWorldPlayerTemplate>? = null,
    @SageIniName("PlayerArmy") val playerArmy: Opaque? = null,
    @SageIniName("Icon") val icon: SageReference<LivingWorldArmyIcon>? = null,
    @SageIniName("HeroTemplateName") val heroTemplateName: SageReference<Object>? = null,
    @SageIniName("Banner") val banner: SageReference<BannerType>? = null,
    @SageIniName("InitialRegion") val initialRegion: Opaque? = null,
    @SageIniName("MoveSpeed") val moveSpeed: Double = 0.0,
    @SageIniName("IsCity") val isCity: Boolean = false,
    @SageIniName("PalantirMovie") val palantirMovie: Opaque? = null,
    @SageIniName("Position") val position: Coords? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<SpawnArmy>(
        name = "SpawnArmy",
        tableKey = "spawnarmys",
        properties = {
            property("ScriptingName", Opaque.type) { it.scriptingName }
            property("SpawnForTemplates", ReferenceValue<LivingWorldPlayerTemplate> { listOf(LivingWorldPlayerTemplate) }) { it.spawnForTemplates }
            property("PlayerArmy", Opaque.type) { it.playerArmy }
            property("Icon", ReferenceValue<LivingWorldArmyIcon> { listOf(LivingWorldArmyIcon) }) { it.icon }
            property("HeroTemplateName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.heroTemplateName }
            property("Banner", ReferenceValue<BannerType> { listOf(BannerType) }) { it.banner }
            property("InitialRegion", Opaque.type) { it.initialRegion }
            property("MoveSpeed", FloatValue) { it.moveSpeed }
            property("IsCity", BooleanValue) { it.isCity }
            property("PalantirMovie", Opaque.type) { it.palantirMovie }
            property("Position", Coords.type) { it.position }
        },
    )
}
