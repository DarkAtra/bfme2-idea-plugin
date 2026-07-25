package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ReplaceObject
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageReference

data class ReplaceObjectUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("SkipContinue") val skipContinue: Boolean = false,
    @SageIniName("UnpackingVariation") val unpackingVariation: Int = 0,
    @SageIniName("UnpackTime") val unpackTime: Int = 0,
    @SageIniName("PreparationTime") val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") val persistentPrepTime: Int = 0,
    @SageIniName("PackTime") val packTime: Int = 0,
    @SageIniName("AwardXPForTriggering") val awardXPForTriggering: Int = 0,
    @SageIniName("StartAbilityRange") val startAbilityRange: Double = 0.0,
    @SageIniName("MustFinishAbility") val mustFinishAbility: Boolean = false,
    @SageIniName("ReplaceRadius") val replaceRadius: Double = 0.0,
    @SageIniName("ReplaceFX") val replaceFX: SageReference<FXList>? = null,
    @SageIniName("Scatter") val scatter: Boolean = false,
    @SageIniName("ReplaceObject") val replaceObject: List<ReplaceObject> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ReplaceObjectUpdate>(
        name = "ReplaceObjectUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("SkipContinue", BooleanValue) { it.skipContinue }
            property("UnpackingVariation", IntValue) { it.unpackingVariation }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("PreparationTime", IntValue) { it.preparationTime }
            property("PersistentPrepTime", IntValue) { it.persistentPrepTime }
            property("PackTime", IntValue) { it.packTime }
            property("AwardXPForTriggering", IntValue) { it.awardXPForTriggering }
            property("StartAbilityRange", FloatValue) { it.startAbilityRange }
            property("MustFinishAbility", BooleanValue) { it.mustFinishAbility }
            property("ReplaceRadius", FloatValue) { it.replaceRadius }
            property("ReplaceFX", ReferenceValue<FXList> { listOf(FXList) }) { it.replaceFX }
            property("Scatter", BooleanValue) { it.scatter }
            property("ReplaceObject", ListValue(BlockValue<ReplaceObject> { listOf(ReplaceObject) })) { it.replaceObject }
        },
    )
}
