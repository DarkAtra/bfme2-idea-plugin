package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.SageFilter

data class ModelConditionSpecialAbilityUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("GenerateTerror") val generateTerror: Boolean = false,
    @SageIniName("EmotionPulseRadius") val emotionPulseRadius: Double = 0.0,
    @SageIniName("WhichSpecialPower") val whichSpecialPower: Int = 0,
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("GenerateUncontrollableFear") val generateUncontrollableFear: Boolean = false,
) : SpecialAbilityUpdate() {

    companion object : SageIniBlockDescriptor<ModelConditionSpecialAbilityUpdate>(
        name = "ModelConditionSpecialAbilityUpdate",
        parent = SpecialAbilityUpdate,
        properties = {
            property("GenerateTerror", BooleanValue) { it.generateTerror }
            property("EmotionPulseRadius", FloatValue) { it.emotionPulseRadius }
            property("WhichSpecialPower", IntValue) { it.whichSpecialPower }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("GenerateUncontrollableFear", BooleanValue) { it.generateUncontrollableFear }
        },
    )
}
