package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageReference

data class SlaveWatcherBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RemoveUpgrade") val removeUpgrade: SageReference<Upgrade>? = null,
    @SageIniName("GrantUpgrade") val grantUpgrade: SageReference<Upgrade>? = null,
    @SageIniName("ShareUpgrades") val shareUpgrades: Boolean = false,
    @SageIniName("LetSlaveLive") val letSlaveLive: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SlaveWatcherBehavior>(
        name = "SlaveWatcherBehavior",
        properties = {
            property("RemoveUpgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.removeUpgrade }
            property("GrantUpgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.grantUpgrade }
            property("ShareUpgrades", BooleanValue) { it.shareUpgrades }
            property("LetSlaveLive", BooleanValue) { it.letSlaveLive }
        },
    )
}
