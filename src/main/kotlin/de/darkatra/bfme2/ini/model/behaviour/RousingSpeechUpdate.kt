package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SpecialPowerUnpackConditions

data class RousingSpeechUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("RequiredConditions") val requiredConditions: SpecialPowerUnpackConditions? = null,
    @SageIniName("StartAbilityRange") val startAbilityRange: Double = 0.0,
    @SageIniName("UpdateInterval") val updateInterval: Int = 0,
    @SageIniName("ApproachRequiresLOS") val approachRequiresLOS: Boolean = false,
    @SageIniName("BonusRadius") val bonusRadius: Double = 0.0,
    @SageIniName("SpeechDuration") val speechDuration: Int = 0,
    @SageIniName("LeaderFX") val leaderFX: SageReference<FXList>? = null,
    @SageIniName("FollowerFX") val followerFX: SageReference<FXList>? = null,
    @SageIniName("CreateWave") val createWave: Boolean = false,
    @SageIniName("WaveWidth") val waveWidth: Double = 0.0,
    @SageIniName("ModifierName") val modifierName: List<SageReference<ModifierList>> = emptyList(),
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("LevelUp") val levelUp: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<RousingSpeechUpdate>(
        name = "RousingSpeechUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("RequiredConditions", SpecialPowerUnpackConditions.type) { it.requiredConditions }
            property("StartAbilityRange", FloatValue) { it.startAbilityRange }
            property("UpdateInterval", IntValue) { it.updateInterval }
            property("ApproachRequiresLOS", BooleanValue) { it.approachRequiresLOS }
            property("BonusRadius", FloatValue) { it.bonusRadius }
            property("SpeechDuration", IntValue) { it.speechDuration }
            property("LeaderFX", ReferenceValue<FXList> { listOf(FXList) }) { it.leaderFX }
            property("FollowerFX", ReferenceValue<FXList> { listOf(FXList) }) { it.followerFX }
            property("CreateWave", BooleanValue) { it.createWave }
            property("WaveWidth", FloatValue) { it.waveWidth }
            property("ModifierName", ListValue(ReferenceValue<ModifierList> { listOf(ModifierList) })) { it.modifierName }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("LevelUp", BooleanValue) { it.levelUp }
        },
    )
}
