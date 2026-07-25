package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.SageReference

data class RemoveUpgradeUpgrade(
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
    @SageIniName("UpgradeToRemove") val upgradeToRemove: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("SuppressEvaEventForRemoval") val suppressEvaEventForRemoval: Boolean = false,
    @SageIniName("RemoveFromAllPlayerObjects") val removeFromAllPlayerObjects: Boolean = false,
    @SageIniName("UpgradeGroupsToRemove") val upgradeGroupsToRemove: List<String> = emptyList(),
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<RemoveUpgradeUpgrade>(
        name = "RemoveUpgradeUpgrade",
        parent = UpgradeBehavior,
        properties = {
            property("UpgradeToRemove", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.upgradeToRemove }
            property("SuppressEvaEventForRemoval", BooleanValue) { it.suppressEvaEventForRemoval }
            property("RemoveFromAllPlayerObjects", BooleanValue) { it.removeFromAllPlayerObjects }
            property("UpgradeGroupsToRemove", ListValue(StringValue)) { it.upgradeGroupsToRemove }
        },
    )
}
