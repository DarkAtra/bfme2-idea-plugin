package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageReference

data class ToggleHiddenSpecialAbilityUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("UnpackingVariation") val unpackingVariation: Int = 0,
    @SageIniName("StartAbilityRange") val startAbilityRange: Double = 0.0,
    @SageIniName("UnpackTime") val unpackTime: Int = 0,
    @SageIniName("PreparationTime") val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") val persistentPrepTime: Int = 0,
    @SageIniName("PackTime") val packTime: Int = 0,
    @SageIniName("AwardXPForTriggering") val awardXPForTriggering: Int = 0,
    @SageIniName("EffectDuration") val effectDuration: Int = 0,
    @SageIniName("ShowPalantirTimer") val showPalantirTimer: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ToggleHiddenSpecialAbilityUpdate>(
        name = "ToggleHiddenSpecialAbilityUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("UnpackingVariation", IntValue) { it.unpackingVariation }
            property("StartAbilityRange", FloatValue) { it.startAbilityRange }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("PreparationTime", IntValue) { it.preparationTime }
            property("PersistentPrepTime", IntValue) { it.persistentPrepTime }
            property("PackTime", IntValue) { it.packTime }
            property("AwardXPForTriggering", IntValue) { it.awardXPForTriggering }
            property("EffectDuration", IntValue) { it.effectDuration }
            property("ShowPalantirTimer", BooleanValue) { it.showPalantirTimer }
        },
    )
}
