package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.CommandSet
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference

data class CommandSetUpgrade(
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
    @SageIniName("CommandSet") val commandSet: SageReference<CommandSet>? = null,
    @SageIniName("CommandSetAlt") val commandSetAlt: SageReference<CommandSet>? = null,
    @SageIniName("TriggerAlt") val triggerAlt: Opaque? = null,
    @SageIniName("RemovesUpgrades") val removesUpgrades: List<SageReference<Upgrade>> = emptyList(),
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<CommandSetUpgrade>(
        name = "CommandSetUpgrade",
        parent = UpgradeBehavior,
        properties = {
            property("CommandSet", ReferenceValue<CommandSet> { listOf(CommandSet) }) { it.commandSet }
            property("CommandSetAlt", ReferenceValue<CommandSet> { listOf(CommandSet) }) { it.commandSetAlt }
            property("TriggerAlt", Opaque.type) { it.triggerAlt }
            property("RemovesUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.removesUpgrades }
        },
    )
}
