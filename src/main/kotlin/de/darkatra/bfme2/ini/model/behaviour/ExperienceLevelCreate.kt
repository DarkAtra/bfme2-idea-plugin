package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class ExperienceLevelCreate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("LevelToGrant") val levelToGrant: Int = 0,
    @SageIniName("MPOnly") val mPOnly: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ExperienceLevelCreate>(
        name = "ExperienceLevelCreate",
        properties = {
            property("LevelToGrant", IntValue) { it.levelToGrant }
            property("MPOnly", BooleanValue) { it.mPOnly }
        },
    )
}
