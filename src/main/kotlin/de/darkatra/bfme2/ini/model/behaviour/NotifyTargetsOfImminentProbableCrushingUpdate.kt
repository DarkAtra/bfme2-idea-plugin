package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class NotifyTargetsOfImminentProbableCrushingUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TimeBetweenUpdatesMS") val timeBetweenUpdatesMS: Int = 0,
    @SageIniName("ScanAheadTimeMS") val scanAheadTimeMS: Int = 0,
    @SageIniName("ScanHeight") val scanHeight: Double = 0.0,
    @SageIniName("ScanWidth") val scanWidth: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<NotifyTargetsOfImminentProbableCrushingUpdate>(
        name = "NotifyTargetsOfImminentProbableCrushingUpdate",
        properties = {
            property("TimeBetweenUpdatesMS", IntValue) { it.timeBetweenUpdatesMS }
            property("ScanAheadTimeMS", IntValue) { it.scanAheadTimeMS }
            property("ScanHeight", FloatValue) { it.scanHeight }
            property("ScanWidth", FloatValue) { it.scanWidth }
        },
    )
}
