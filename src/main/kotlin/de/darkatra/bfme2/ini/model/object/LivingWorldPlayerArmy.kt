package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.livingworld.ArmyEntry
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgb
import de.darkatra.bfme2.ini.model.value.Untyped

data class LivingWorldPlayerArmy(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Name") val name: Untyped? = null,
    @SageIniName("DisplayNameTag") val displayNameTag: String = "",
    @SageIniName("Color") val color: Rgb? = null,
    @SageIniName("MinCommandPoints") val minCommandPoints: Int = 0,
    @SageIniName("NightColor") val nightColor: Rgb? = null,
    @SageIniName("ReplenishArmyName") val replenishArmyName: Opaque? = null,
    @SageIniName("ArmyEntry") val armyEntry: List<ArmyEntry> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldPlayerArmy>(
        name = "LivingWorldPlayerArmy",
        tableKey = "livingworldplayerarmys",
        properties = {
            property("Name", Untyped.type) { it.name }
            property("DisplayNameTag", StringValue) { it.displayNameTag }
            property("Color", Rgb.type) { it.color }
            property("MinCommandPoints", IntValue) { it.minCommandPoints }
            property("NightColor", Rgb.type) { it.nightColor }
            property("ReplenishArmyName", Opaque.type) { it.replenishArmyName }
            property("ArmyEntry", ListValue(BlockValue<ArmyEntry> { listOf(ArmyEntry) })) { it.armyEntry }
        },
    )
}
