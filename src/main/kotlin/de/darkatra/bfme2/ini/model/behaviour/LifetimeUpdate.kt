package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.DeathType

data class LifetimeUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MinLifetime") val minLifetime: Int = 0,
    @SageIniName("MaxLifetime") val maxLifetime: Int = 0,
    @SageIniName("WaitForWakeUp") val waitForWakeUp: Boolean = false,
    @SageIniName("DeathType") val deathType: DeathType? = null,
    @SageIniName("ScoreKill") val scoreKill: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<LifetimeUpdate>(
        name = "LifetimeUpdate",
        properties = {
            property("MinLifetime", IntValue) { it.minLifetime }
            property("MaxLifetime", IntValue) { it.maxLifetime }
            property("WaitForWakeUp", BooleanValue) { it.waitForWakeUp }
            property("DeathType", DeathType.type) { it.deathType }
            property("ScoreKill", BooleanValue) { it.scoreKill }
        },
    )
}
