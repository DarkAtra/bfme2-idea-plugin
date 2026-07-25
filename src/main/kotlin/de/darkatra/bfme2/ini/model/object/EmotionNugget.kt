package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.EmotionNuggetAIState
import de.darkatra.bfme2.ini.model.value.EmotionTypes
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.SageReference

data class EmotionNugget(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Type") val type: EmotionTypes? = null,
    @SageIniName("AIState") val aIState: EmotionNuggetAIState? = null,
    @SageIniName("ModelConditions") val modelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("ModelConditionsClear") val modelConditionsClear: List<ModelCondition> = emptyList(),
    @SageIniName("Duration") val duration: Int = 0,
    @SageIniName("AILockDuration") val aILockDuration: Int = 0,
    @SageIniName("AttributeStartDelay") val attributeStartDelay: Int = 0,
    @SageIniName("InactiveDuration") val inactiveDuration: Int = 0,
    @SageIniName("InactiveDurationSameType") val inactiveDurationSameType: Int = 0,
    @SageIniName("InactiveDurationSameObject") val inactiveDurationSameObject: Int = 0,
    @SageIniName("OnlyIfEnemyThreatBelow") val onlyIfEnemyThreatBelow: Int = 0,
    @SageIniName("IgnoreIfUnitBusy") val ignoreIfUnitBusy: Boolean = false,
    @SageIniName("IgnoreIfUnitIdle") val ignoreIfUnitIdle: Boolean = false,
    @SageIniName("PreventPlayerCommands") val preventPlayerCommands: Boolean = false,
    @SageIniName("AttributeModifierWhileEmotionActive") val attributeModifierWhileEmotionActive: Boolean = false,
    @SageIniName("StartFXList") val startFXList: SageReference<FXList>? = null,
    @SageIniName("UpdateFXList") val updateFXList: SageReference<FXList>? = null,
    @SageIniName("EndFXList") val endFXList: SageReference<FXList>? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<EmotionNugget>(
        name = "EmotionNugget",
        tableKey = "emotions",
        properties = {
            property("Type", EmotionTypes.type) { it.type }
            property("AIState", EmotionNuggetAIState.type) { it.aIState }
            property("ModelConditions", ListValue(ModelCondition.type)) { it.modelConditions }
            property("ModelConditionsClear", ListValue(ModelCondition.type)) { it.modelConditionsClear }
            property("Duration", IntValue) { it.duration }
            property("AILockDuration", IntValue) { it.aILockDuration }
            property("AttributeStartDelay", IntValue) { it.attributeStartDelay }
            property("InactiveDuration", IntValue) { it.inactiveDuration }
            property("InactiveDurationSameType", IntValue) { it.inactiveDurationSameType }
            property("InactiveDurationSameObject", IntValue) { it.inactiveDurationSameObject }
            property("OnlyIfEnemyThreatBelow", IntValue) { it.onlyIfEnemyThreatBelow }
            property("IgnoreIfUnitBusy", BooleanValue) { it.ignoreIfUnitBusy }
            property("IgnoreIfUnitIdle", BooleanValue) { it.ignoreIfUnitIdle }
            property("PreventPlayerCommands", BooleanValue) { it.preventPlayerCommands }
            property("AttributeModifierWhileEmotionActive", BooleanValue) { it.attributeModifierWhileEmotionActive }
            property("StartFXList", ReferenceValue<FXList> { listOf(FXList) }) { it.startFXList }
            property("UpdateFXList", ReferenceValue<FXList> { listOf(FXList) }) { it.updateFXList }
            property("EndFXList", ReferenceValue<FXList> { listOf(FXList) }) { it.endFXList }
        },
    )
}
