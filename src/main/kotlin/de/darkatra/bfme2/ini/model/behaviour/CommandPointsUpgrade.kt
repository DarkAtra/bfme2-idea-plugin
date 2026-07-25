package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class CommandPointsUpgrade(
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
    @SageIniName("CommandPoints") val commandPoints: Int = 0,
    @SageIniName("RequiredObject") val requiredObject: SageFilter? = null,
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<CommandPointsUpgrade>(
        name = "CommandPointsUpgrade",
        parent = UpgradeBehavior,
        properties = {
            property("CommandPoints", IntValue) { it.commandPoints }
            property("RequiredObject", SageFilter.type) { it.requiredObject }
        },
    )
}
