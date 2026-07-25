package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Untyped

data class DifficultyTuning(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Difficulty") val difficulty: Opaque? = null,
    @SageIniName("EconomyMaxFarms") val economyMaxFarms: Int = 0,
    @SageIniName("EconomyUpgradeProbability") val economyUpgradeProbability: Untyped? = null,
    @SageIniName("SpecialPowerActivationProbability") val specialPowerActivationProbability: Untyped? = null,
    @SageIniName("OffensiveTacticActivationProbability") val offensiveTacticActivationProbability: Untyped? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<DifficultyTuning>(
        name = "DifficultyTuning",
        properties = {
            property("Difficulty", Opaque.type) { it.difficulty }
            property("EconomyMaxFarms", IntValue) { it.economyMaxFarms }
            property("EconomyUpgradeProbability", Untyped.type) { it.economyUpgradeProbability }
            property("SpecialPowerActivationProbability", Untyped.type) { it.specialPowerActivationProbability }
            property("OffensiveTacticActivationProbability", Untyped.type) { it.offensiveTacticActivationProbability }
        },
    )
}
