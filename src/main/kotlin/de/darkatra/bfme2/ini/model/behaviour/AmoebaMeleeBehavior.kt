package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.ModelCondition

@SageIniName("Amoeba")
data class AmoebaMeleeBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("FacingBonus") val facingBonus: Double = 0.0,
    @SageIniName("AngleLimitCos") val angleLimitCos: Double = 0.0,
    @SageIniName("InnerRange") val innerRange: Double = 0.0,
    @SageIniName("OuterRange") val outerRange: Double = 0.0,
    @SageIniName("OuterRangeBuildings") val outerRangeBuildings: Double = 0.0,
    @SageIniName("IdleModelConditions") val idleModelConditions: List<ModelCondition> = emptyList(),
    @SageIniName("DelayUntilIdle") val delayUntilIdle: Int = 0,
    @SageIniName("DelayRandomActivateMin") val delayRandomActivateMin: Int = 0,
    @SageIniName("DelayRandomActivateMax") val delayRandomActivateMax: Int = 0,
) : MeleeBehavior {

    companion object : SageIniBlockDescriptor<AmoebaMeleeBehavior>(
        name = "Amoeba",
        properties = {
            property("FacingBonus", FloatValue) { it.facingBonus }
            property("AngleLimitCos", FloatValue) { it.angleLimitCos }
            property("InnerRange", FloatValue) { it.innerRange }
            property("OuterRange", FloatValue) { it.outerRange }
            property("OuterRangeBuildings", FloatValue) { it.outerRangeBuildings }
            property("IdleModelConditions", ListValue(ModelCondition.type)) { it.idleModelConditions }
            property("DelayUntilIdle", IntValue) { it.delayUntilIdle }
            property("DelayRandomActivateMin", IntValue) { it.delayRandomActivateMin }
            property("DelayRandomActivateMax", IntValue) { it.delayRandomActivateMax }
        },
    )
}
