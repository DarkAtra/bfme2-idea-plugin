package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageReference

data class RampageBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RampageHealthThreshold") val rampageHealthThreshold: Double = 0.0,
    @SageIniName("RampageLifeTimer") val rampageLifeTimer: Int = 0,
    @SageIniName("RampageAngryLifeTimer") val rampageAngryLifeTimer: Int = 0,
    @SageIniName("RampageResetTimer") val rampageResetTimer: Int = 0,
    @SageIniName("RampageEnemyCheckRange") val rampageEnemyCheckRange: Double = 0.0,
    @SageIniName("RampageEnemyThreshold") val rampageEnemyThreshold: Int = 0,
    @SageIniName("RequiredUpgrade") val requiredUpgrade: List<SageReference<Upgrade>> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<RampageBehavior>(
        name = "RampageBehavior",
        properties = {
            property("RampageHealthThreshold", FloatValue) { it.rampageHealthThreshold }
            property("RampageLifeTimer", IntValue) { it.rampageLifeTimer }
            property("RampageAngryLifeTimer", IntValue) { it.rampageAngryLifeTimer }
            property("RampageResetTimer", IntValue) { it.rampageResetTimer }
            property("RampageEnemyCheckRange", FloatValue) { it.rampageEnemyCheckRange }
            property("RampageEnemyThreshold", IntValue) { it.rampageEnemyThreshold }
            property("RequiredUpgrade", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.requiredUpgrade }
        },
    )
}
