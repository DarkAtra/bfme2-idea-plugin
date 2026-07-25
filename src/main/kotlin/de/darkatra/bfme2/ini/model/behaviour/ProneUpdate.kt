package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue

data class ProneUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DamageToFramesRatio") val damageToFramesRatio: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ProneUpdate>(
        name = "ProneUpdate",
        properties = {
            property("DamageToFramesRatio", FloatValue) { it.damageToFramesRatio }
        },
    )
}
