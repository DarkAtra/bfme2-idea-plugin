package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageReference

data class GrantUpgradeCreate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("UpgradeToGrant") val upgradeToGrant: SageReference<Upgrade>? = null,
    @SageIniName("ExemptStatus") val exemptStatus: ObjectStatus? = null,
    @SageIniName("GiveOnBuildComplete") val giveOnBuildComplete: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<GrantUpgradeCreate>(
        name = "GrantUpgradeCreate",
        properties = {
            property("UpgradeToGrant", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.upgradeToGrant }
            property("ExemptStatus", ObjectStatus.type) { it.exemptStatus }
            property("GiveOnBuildComplete", BooleanValue) { it.giveOnBuildComplete }
        },
    )
}
