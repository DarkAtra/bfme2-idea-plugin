package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.SageReference

data class ModelConditionUpgrade(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TriggeredBy") override val triggeredBy: List<SageReference<UpgradeTrigger>> = emptyList(),
    @SageIniName("ConflictsWith") override val conflictsWith: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiresAllTriggers") override val requiresAllTriggers: Boolean = false,
    @SageIniName("RequiresAllConflictingTriggers") override val requiresAllConflictingTriggers: Boolean = false,
    @SageIniName("StartsActive") override val startsActive: Boolean = false,
    @SageIniName("Description") override val description: String = "",
    @SageIniName("ActiveDuringConstruction") override val activeDuringConstruction: Boolean = false,
    @SageIniName("CustomAnimAndDuration") override val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("Permanent") override val permanent: Boolean = false,
    @SageIniName("ConditionFlag") val conditionFlag: ModelCondition? = null,
    @SageIniName("AddConditionFlags") val addConditionFlags: List<ModelCondition> = emptyList(),
    @SageIniName("RemoveConditionFlags") val removeConditionFlags: List<ModelCondition> = emptyList(),
    @SageIniName("RemoveConditionFlagsInRange") val removeConditionFlagsInRange: List<String> = emptyList(),
    @SageIniName("TempConditionTime") val tempConditionTime: Double = 0.0,
    @SageIniName("AddTempConditionFlag") val addTempConditionFlag: Map<String, String> = emptyMap(),
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<ModelConditionUpgrade>(
        name = "ModelConditionUpgrade",
        parent = UpgradeBehavior,
        properties = {
            property("ConditionFlag", ModelCondition.type) { it.conditionFlag }
            property("AddConditionFlags", ListValue(ModelCondition.type)) { it.addConditionFlags }
            property("RemoveConditionFlags", ListValue(ModelCondition.type)) { it.removeConditionFlags }
            property("RemoveConditionFlagsInRange", ListValue(StringValue)) { it.removeConditionFlagsInRange }
            property("TempConditionTime", FloatValue) { it.tempConditionTime }
            property("AddTempConditionFlag", MapValue(StringValue, StringValue)) { it.addTempConditionFlag }
        },
    )
}
