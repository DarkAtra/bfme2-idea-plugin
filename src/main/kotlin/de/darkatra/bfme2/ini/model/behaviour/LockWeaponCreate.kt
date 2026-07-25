package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.SlotTypes

data class LockWeaponCreate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SlotToLock") val slotToLock: SlotTypes? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<LockWeaponCreate>(
        name = "LockWeaponCreate",
        properties = {
            property("SlotToLock", SlotTypes.type) { it.slotToLock }
        },
    )
}
