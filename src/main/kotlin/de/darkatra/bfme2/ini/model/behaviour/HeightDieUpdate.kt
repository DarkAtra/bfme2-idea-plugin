package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class HeightDieUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TargetHeight") val targetHeight: Double = 0.0,
    @SageIniName("TargetHeightIncludesStructures") val targetHeightIncludesStructures: Boolean = false,
    @SageIniName("OnlyWhenMovingDown") val onlyWhenMovingDown: Boolean = false,
    @SageIniName("DestroyAttachedParticlesAtHeight") val destroyAttachedParticlesAtHeight: Double = 0.0,
    @SageIniName("SnapToGroundOnDeath") val snapToGroundOnDeath: Boolean = false,
    @SageIniName("InitialDelay") val initialDelay: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<HeightDieUpdate>(
        name = "HeightDieUpdate",
        properties = {
            property("TargetHeight", FloatValue) { it.targetHeight }
            property("TargetHeightIncludesStructures", BooleanValue) { it.targetHeightIncludesStructures }
            property("OnlyWhenMovingDown", BooleanValue) { it.onlyWhenMovingDown }
            property("DestroyAttachedParticlesAtHeight", FloatValue) { it.destroyAttachedParticlesAtHeight }
            property("SnapToGroundOnDeath", BooleanValue) { it.snapToGroundOnDeath }
            property("InitialDelay", IntValue) { it.initialDelay }
        },
    )
}
