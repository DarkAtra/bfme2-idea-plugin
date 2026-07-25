package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class Bonus(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MinResourceBonus") val minResourceBonus: Int = 0,
    @SageIniName("MinSciencePurchasePoints") val minSciencePurchasePoints: Int = 0,
    @SageIniName("MinSciencePurchasePointsForBonus") val minSciencePurchasePointsForBonus: Int = 0,
    @SageIniName("WeaponMultiplier") val weaponMultiplier: Double = 0.0,
    @SageIniName("ArmorMultiplier") val armorMultiplier: Double = 0.0,
    @SageIniName("ExperienceMultiplier") val experienceMultiplier: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Bonus>(
        name = "Bonus",
        properties = {
            property("MinResourceBonus", IntValue) { it.minResourceBonus }
            property("MinSciencePurchasePoints", IntValue) { it.minSciencePurchasePoints }
            property("MinSciencePurchasePointsForBonus", IntValue) { it.minSciencePurchasePointsForBonus }
            property("WeaponMultiplier", FloatValue) { it.weaponMultiplier }
            property("ArmorMultiplier", FloatValue) { it.armorMultiplier }
            property("ExperienceMultiplier", FloatValue) { it.experienceMultiplier }
        },
    )
}
