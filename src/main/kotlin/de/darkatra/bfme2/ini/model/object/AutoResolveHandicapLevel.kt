package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class AutoResolveHandicapLevel(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("GUIDisplayedLevel") val gUIDisplayedLevel: Int = 0,
    @SageIniName("WeaponMultiplier") val weaponMultiplier: Double = 0.0,
    @SageIniName("ArmorMultiplier") val armorMultiplier: Double = 0.0,
    @SageIniName("ExperienceMultiplier") val experienceMultiplier: Double = 0.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<AutoResolveHandicapLevel>(
        name = "AutoResolveHandicapLevel",
        tableKey = "autoresolvehandicaplevels",
        properties = {
            property("GUIDisplayedLevel", IntValue) { it.gUIDisplayedLevel }
            property("WeaponMultiplier", FloatValue) { it.weaponMultiplier }
            property("ArmorMultiplier", FloatValue) { it.armorMultiplier }
            property("ExperienceMultiplier", FloatValue) { it.experienceMultiplier }
        },
    )
}
