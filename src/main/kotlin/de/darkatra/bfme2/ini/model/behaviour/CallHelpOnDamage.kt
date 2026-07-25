package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.SageFilter

data class CallHelpOnDamage(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DamageTypes") val damageTypes: SageFilter? = null,
    @SageIniName("CallRadius") val callRadius: Double = 0.0,
    @SageIniName("CallDelay") val callDelay: Int = 0,
    @SageIniName("MoveToAttacker") val moveToAttacker: Boolean = false,
    @SageIniName("ValidObjects") val validObjects: SageFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<CallHelpOnDamage>(
        name = "CallHelpOnDamage",
        properties = {
            property("DamageTypes", SageFilter.type) { it.damageTypes }
            property("CallRadius", FloatValue) { it.callRadius }
            property("CallDelay", IntValue) { it.callDelay }
            property("MoveToAttacker", BooleanValue) { it.moveToAttacker }
            property("ValidObjects", SageFilter.type) { it.validObjects }
        },
    )
}
