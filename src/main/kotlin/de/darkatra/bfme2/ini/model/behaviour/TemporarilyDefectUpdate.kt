package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class TemporarilyDefectUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DefectDuration") val defectDuration: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<TemporarilyDefectUpdate>(
        name = "TemporarilyDefectUpdate",
        properties = {
            property("DefectDuration", IntValue) { it.defectDuration }
        },
    )
}
