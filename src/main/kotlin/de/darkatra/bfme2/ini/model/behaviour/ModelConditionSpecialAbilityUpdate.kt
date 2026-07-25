package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class ModelConditionSpecialAbilityUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("UnpackingVariation") val unpackingVariation: Int = 0,
    @SageIniName("UnpackTime") val unpackTime: Int = 0,
    @SageIniName("PreparationTime") val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") val persistentPrepTime: Int = 0,
    @SageIniName("PackTime") val packTime: Int = 0,
    @SageIniName("AwardXPForTriggering") val awardXPForTriggering: Int = 0,
    @SageIniName("GenerateTerror") val generateTerror: Boolean = false,
    @SageIniName("EmotionPulseRadius") val emotionPulseRadius: Double = 0.0,
    @SageIniName("DisableWhenWearingTheRing") val disableWhenWearingTheRing: Boolean = false,
    @SageIniName("WhichSpecialPower") val whichSpecialPower: Int = 0,
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("TriggerSound") val triggerSound: SageReference<AudioEvent>? = null,
    @SageIniName("MustFinishAbility") val mustFinishAbility: Boolean = false,
    @SageIniName("LoseStealthOnTrigger") val loseStealthOnTrigger: Boolean = false,
    @SageIniName("PreTriggerUnstealthTime") val preTriggerUnstealthTime: Int = 0,
    @SageIniName("GenerateUncontrollableFear") val generateUncontrollableFear: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ModelConditionSpecialAbilityUpdate>(
        name = "ModelConditionSpecialAbilityUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("UnpackingVariation", IntValue) { it.unpackingVariation }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("PreparationTime", IntValue) { it.preparationTime }
            property("PersistentPrepTime", IntValue) { it.persistentPrepTime }
            property("PackTime", IntValue) { it.packTime }
            property("AwardXPForTriggering", IntValue) { it.awardXPForTriggering }
            property("GenerateTerror", BooleanValue) { it.generateTerror }
            property("EmotionPulseRadius", FloatValue) { it.emotionPulseRadius }
            property("DisableWhenWearingTheRing", BooleanValue) { it.disableWhenWearingTheRing }
            property("WhichSpecialPower", IntValue) { it.whichSpecialPower }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("TriggerSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.triggerSound }
            property("MustFinishAbility", BooleanValue) { it.mustFinishAbility }
            property("LoseStealthOnTrigger", BooleanValue) { it.loseStealthOnTrigger }
            property("PreTriggerUnstealthTime", IntValue) { it.preTriggerUnstealthTime }
            property("GenerateUncontrollableFear", BooleanValue) { it.generateUncontrollableFear }
        },
    )
}
