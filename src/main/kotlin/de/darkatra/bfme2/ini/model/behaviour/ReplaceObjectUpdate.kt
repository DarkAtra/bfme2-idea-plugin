package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ReplaceObject
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageReference

data class ReplaceObjectUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") override val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("SkipContinue") val skipContinue: Boolean = false,
    @SageIniName("UnpackingVariation") override val unpackingVariation: Int = 0,
    @SageIniName("UnpackTime") override val unpackTime: Int = 0,
    @SageIniName("PreparationTime") override val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") override val persistentPrepTime: Int = 0,
    @SageIniName("PackTime") override val packTime: Int = 0,
    @SageIniName("AwardXPForTriggering") override val awardXPForTriggering: Int = 0,
    @SageIniName("StartAbilityRange") override val startAbilityRange: Double = 0.0,
    @SageIniName("MustFinishAbility") override val mustFinishAbility: Boolean = false,
    @SageIniName("ReplaceRadius") val replaceRadius: Double = 0.0,
    @SageIniName("ReplaceFX") val replaceFX: SageReference<FXList>? = null,
    @SageIniName("Scatter") val scatter: Boolean = false,
    @SageIniName("ReplaceObject") val replaceObject: List<ReplaceObject> = emptyList(),
) : SpecialAbilityUpdate() {

    companion object : SageIniBlockDescriptor<ReplaceObjectUpdate>(
        name = "ReplaceObjectUpdate",
        parent = SpecialAbilityUpdate,
        properties = {
            property("SkipContinue", BooleanValue) { it.skipContinue }
            property("ReplaceRadius", FloatValue) { it.replaceRadius }
            property("ReplaceFX", ReferenceValue<FXList> { listOf(FXList) }) { it.replaceFX }
            property("Scatter", BooleanValue) { it.scatter }
            property("ReplaceObject", ListValue(BlockValue<ReplaceObject> { listOf(ReplaceObject) })) { it.replaceObject }
        },
    )
}
