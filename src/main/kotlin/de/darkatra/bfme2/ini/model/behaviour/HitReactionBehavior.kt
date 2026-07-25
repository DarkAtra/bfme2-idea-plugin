package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class HitReactionBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("HitReactionLifeTimer1") val hitReactionLifeTimer1: Int = 0,
    @SageIniName("HitReactionLifeTimer2") val hitReactionLifeTimer2: Int = 0,
    @SageIniName("HitReactionLifeTimer3") val hitReactionLifeTimer3: Int = 0,
    @SageIniName("HitReactionThreshold1") val hitReactionThreshold1: Double = 0.0,
    @SageIniName("HitReactionThreshold2") val hitReactionThreshold2: Double = 0.0,
    @SageIniName("HitReactionThreshold3") val hitReactionThreshold3: Double = 0.0,
    @SageIniName("FastHitsResetReaction") val fastHitsResetReaction: Boolean = false,
    @SageIniName("HitsParalyze") val hitsParalyze: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<HitReactionBehavior>(
        name = "HitReactionBehavior",
        properties = {
            property("HitReactionLifeTimer1", IntValue) { it.hitReactionLifeTimer1 }
            property("HitReactionLifeTimer2", IntValue) { it.hitReactionLifeTimer2 }
            property("HitReactionLifeTimer3", IntValue) { it.hitReactionLifeTimer3 }
            property("HitReactionThreshold1", FloatValue) { it.hitReactionThreshold1 }
            property("HitReactionThreshold2", FloatValue) { it.hitReactionThreshold2 }
            property("HitReactionThreshold3", FloatValue) { it.hitReactionThreshold3 }
            property("FastHitsResetReaction", BooleanValue) { it.fastHitsResetReaction }
            property("HitsParalyze", BooleanValue) { it.hitsParalyze }
        },
    )
}
