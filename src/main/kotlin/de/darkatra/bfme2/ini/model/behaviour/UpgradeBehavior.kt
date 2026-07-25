package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.SageReference

open class UpgradeBehavior(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TriggeredBy") open val triggeredBy: List<SageReference<UpgradeTrigger>> = emptyList(),
    @SageIniName("ConflictsWith") open val conflictsWith: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiresAllTriggers") open val requiresAllTriggers: Boolean = false,
    @SageIniName("RequiresAllConflictingTriggers") open val requiresAllConflictingTriggers: Boolean = false,
    @SageIniName("StartsActive") open val startsActive: Boolean = false,
    @SageIniName("Description") open val description: String = "",
    @SageIniName("ActiveDuringConstruction") open val activeDuringConstruction: Boolean = false,
    @SageIniName("CustomAnimAndDuration") open val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("Permanent") open val permanent: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<UpgradeBehavior>(
        name = "UpgradeBehavior",
        properties = {
            property("TriggeredBy", ListValue(ReferenceValue<UpgradeTrigger> { listOf(Upgrade, Science) })) { it.triggeredBy }
            property("ConflictsWith", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.conflictsWith }
            property("RequiresAllTriggers", BooleanValue) { it.requiresAllTriggers }
            property("RequiresAllConflictingTriggers", BooleanValue) { it.requiresAllConflictingTriggers }
            property("StartsActive", BooleanValue) { it.startsActive }
            property("Description", StringValue) { it.description }
            property("ActiveDuringConstruction", BooleanValue) { it.activeDuringConstruction }
            property("CustomAnimAndDuration", MapValue(StringValue, StringValue)) { it.customAnimAndDuration }
            property("Permanent", BooleanValue) { it.permanent }
        },
    )
}
