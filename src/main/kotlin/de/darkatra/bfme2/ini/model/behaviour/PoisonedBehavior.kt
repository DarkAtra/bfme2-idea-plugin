package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class PoisonedBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PoisonDamageInterval") val poisonDamageInterval: Int = 0,
    @SageIniName("PoisonDuration") val poisonDuration: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<PoisonedBehavior>(
        name = "PoisonedBehavior",
        properties = {
            property("PoisonDamageInterval", IntValue) { it.poisonDamageInterval }
            property("PoisonDuration", IntValue) { it.poisonDuration }
        },
    )
}
