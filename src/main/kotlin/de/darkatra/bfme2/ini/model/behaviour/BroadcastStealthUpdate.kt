package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.SageReference

data class BroadcastStealthUpdate(
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
    @SageIniName("AllowKindOf") val allowKindOf: List<KindOf> = emptyList(),
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("DelayBetweenUpdates") val delayBetweenUpdates: Int = 0,
    @SageIniName("PersistantConditions") val persistantConditions: ModelCondition? = null,
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<BroadcastStealthUpdate>(
        name = "BroadcastStealthUpdate",
        parent = UpgradeBehavior,
        properties = {
            property("AllowKindOf", ListValue(KindOf.type)) { it.allowKindOf }
            property("Radius", FloatValue) { it.radius }
            property("DelayBetweenUpdates", IntValue) { it.delayBetweenUpdates }
            property("PersistantConditions", ModelCondition.type) { it.persistantConditions }
        },
    )
}
