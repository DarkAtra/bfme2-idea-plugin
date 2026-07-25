package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class LivingWorldAITemplate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DesiredSoldierRatio") val desiredSoldierRatio: Int = 0,
    @SageIniName("DesiredArcherRatio") val desiredArcherRatio: Int = 0,
    @SageIniName("DesiredPikemenRatio") val desiredPikemenRatio: Int = 0,
    @SageIniName("DesiredCavalryRatio") val desiredCavalryRatio: Int = 0,
    @SageIniName("DesiredMonsterRatio") val desiredMonsterRatio: Int = 0,
    @SageIniName("DesiredHeroRatio") val desiredHeroRatio: Int = 0,
    @SageIniName("DesiredFortressRatio") val desiredFortressRatio: Int = 0,
    @SageIniName("BuildingScoreArmory") val buildingScoreArmory: Int = 0,
    @SageIniName("BuildingScoreBarracks") val buildingScoreBarracks: Int = 0,
    @SageIniName("BuildingScoreCastle") val buildingScoreCastle: Int = 0,
    @SageIniName("BuildingScoreFarm") val buildingScoreFarm: Int = 0,
    @SageIniName("BonusPreferenceResource") val bonusPreferenceResource: Int = 0,
    @SageIniName("BonusPreferenceArmy") val bonusPreferenceArmy: Int = 0,
    @SageIniName("BonusPreferenceLegendary") val bonusPreferenceLegendary: Int = 0,
    @SageIniName("BonusPreferenceAttack") val bonusPreferenceAttack: Int = 0,
    @SageIniName("BonusPreferenceDefense") val bonusPreferenceDefense: Int = 0,
    @SageIniName("BonusPreferenceExperience") val bonusPreferenceExperience: Int = 0,
    @SageIniName("BonusPreferenceTreasury") val bonusPreferenceTreasury: Int = 0,
    @SageIniName("DesiredSiegeRatio") val desiredSiegeRatio: Int = 0,
    @SageIniName("DesiredSupportRatio") val desiredSupportRatio: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldAITemplate>(
        name = "LivingWorldAITemplate",
        tableKey = "livingworldaitemplates",
        properties = {
            property("DesiredSoldierRatio", IntValue) { it.desiredSoldierRatio }
            property("DesiredArcherRatio", IntValue) { it.desiredArcherRatio }
            property("DesiredPikemenRatio", IntValue) { it.desiredPikemenRatio }
            property("DesiredCavalryRatio", IntValue) { it.desiredCavalryRatio }
            property("DesiredMonsterRatio", IntValue) { it.desiredMonsterRatio }
            property("DesiredHeroRatio", IntValue) { it.desiredHeroRatio }
            property("DesiredFortressRatio", IntValue) { it.desiredFortressRatio }
            property("BuildingScoreArmory", IntValue) { it.buildingScoreArmory }
            property("BuildingScoreBarracks", IntValue) { it.buildingScoreBarracks }
            property("BuildingScoreCastle", IntValue) { it.buildingScoreCastle }
            property("BuildingScoreFarm", IntValue) { it.buildingScoreFarm }
            property("BonusPreferenceResource", IntValue) { it.bonusPreferenceResource }
            property("BonusPreferenceArmy", IntValue) { it.bonusPreferenceArmy }
            property("BonusPreferenceLegendary", IntValue) { it.bonusPreferenceLegendary }
            property("BonusPreferenceAttack", IntValue) { it.bonusPreferenceAttack }
            property("BonusPreferenceDefense", IntValue) { it.bonusPreferenceDefense }
            property("BonusPreferenceExperience", IntValue) { it.bonusPreferenceExperience }
            property("BonusPreferenceTreasury", IntValue) { it.bonusPreferenceTreasury }
            property("DesiredSiegeRatio", IntValue) { it.desiredSiegeRatio }
            property("DesiredSupportRatio", IntValue) { it.desiredSupportRatio }
        },
    )
}
