package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class ClickReactionBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ClickReactionTimer") val clickReactionTimer: Int = 0,
    @SageIniName("ReactionFrames1") val reactionFrames1: Int = 0,
    @SageIniName("ReactionFrames2") val reactionFrames2: Int = 0,
    @SageIniName("ReactionFrames3") val reactionFrames3: Int = 0,
    @SageIniName("ReactionFrames4") val reactionFrames4: Int = 0,
    @SageIniName("ReactionFrames5") val reactionFrames5: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ClickReactionBehavior>(
        name = "ClickReactionBehavior",
        properties = {
            property("ClickReactionTimer", IntValue) { it.clickReactionTimer }
            property("ReactionFrames1", IntValue) { it.reactionFrames1 }
            property("ReactionFrames2", IntValue) { it.reactionFrames2 }
            property("ReactionFrames3", IntValue) { it.reactionFrames3 }
            property("ReactionFrames4", IntValue) { it.reactionFrames4 }
            property("ReactionFrames5", IntValue) { it.reactionFrames5 }
        },
    )
}
