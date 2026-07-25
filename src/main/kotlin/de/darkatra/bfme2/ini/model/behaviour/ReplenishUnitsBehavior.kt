package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageReference

data class ReplenishUnitsBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StartsActive") val startsActive: Boolean = false,
    @SageIniName("ReplenishDelay") val replenishDelay: Int = 0,
    @SageIniName("ReplenishRadius") val replenishRadius: Double = 0.0,
    @SageIniName("NoReplenishIfEnemyWithinRadius") val noReplenishIfEnemyWithinRadius: Double = 0.0,
    @SageIniName("ReplenishStatii") val replenishStatii: ObjectStatus? = null,
    @SageIniName("ReplenishHordeMembersOnly") val replenishHordeMembersOnly: Boolean = false,
    @SageIniName("TriggeredBy") val triggeredBy: List<SageReference<UpgradeTrigger>> = emptyList(),
    @SageIniName("ConflictsWith") val conflictsWith: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiresAllTriggers") val requiresAllTriggers: Boolean = false,
    @SageIniName("RequiresAllConflictingTriggers") val requiresAllConflictingTriggers: Boolean = false,
    @SageIniName("Permanent") val permanent: Boolean = false,
    @SageIniName("ReplenishFXList") val replenishFXList: SageReference<FXList>? = null,
    @SageIniName("CustomAnimAndDuration") val customAnimAndDuration: Map<String, String> = emptyMap(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ReplenishUnitsBehavior>(
        name = "ReplenishUnitsBehavior",
        properties = {
            property("StartsActive", BooleanValue) { it.startsActive }
            property("ReplenishDelay", IntValue) { it.replenishDelay }
            property("ReplenishRadius", FloatValue) { it.replenishRadius }
            property("NoReplenishIfEnemyWithinRadius", FloatValue) { it.noReplenishIfEnemyWithinRadius }
            property("ReplenishStatii", ObjectStatus.type) { it.replenishStatii }
            property("ReplenishHordeMembersOnly", BooleanValue) { it.replenishHordeMembersOnly }
            property("TriggeredBy", ListValue(ReferenceValue<UpgradeTrigger> { listOf(Upgrade, Science) })) { it.triggeredBy }
            property("ConflictsWith", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.conflictsWith }
            property("RequiresAllTriggers", BooleanValue) { it.requiresAllTriggers }
            property("RequiresAllConflictingTriggers", BooleanValue) { it.requiresAllConflictingTriggers }
            property("Permanent", BooleanValue) { it.permanent }
            property("ReplenishFXList", ReferenceValue<FXList> { listOf(FXList) }) { it.replenishFXList }
            property("CustomAnimAndDuration", MapValue(StringValue, StringValue)) { it.customAnimAndDuration }
        },
    )
}
