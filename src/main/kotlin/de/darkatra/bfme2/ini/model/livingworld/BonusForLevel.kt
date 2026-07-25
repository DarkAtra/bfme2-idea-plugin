package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class BonusForLevel(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MinLevel") val minLevel: Int = 0,
    @SageIniName("WeaponMultiplier") val weaponMultiplier: Double = 0.0,
    @SageIniName("ExperienceMultiplier") val experienceMultiplier: Double = 0.0,
    @SageIniName("ArmorMultiplier") val armorMultiplier: Double = 0.0,
    @SageIniName("MaximumUnitsAffected") val maximumUnitsAffected: Int = 0,
    @SageIniName("Priority") val priority: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<BonusForLevel>(
        name = "BonusForLevel",
        properties = {
            property("MinLevel", IntValue) { it.minLevel }
            property("WeaponMultiplier", FloatValue) { it.weaponMultiplier }
            property("ExperienceMultiplier", FloatValue) { it.experienceMultiplier }
            property("ArmorMultiplier", FloatValue) { it.armorMultiplier }
            property("MaximumUnitsAffected", IntValue) { it.maximumUnitsAffected }
            property("Priority", IntValue) { it.priority }
        },
    )
}
