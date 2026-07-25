package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class HordeNotifyTargetsOfImminentProbableCrushingUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ScanWidth") val scanWidth: Double = 0.0,
    @SageIniName("TimeBetweenUpdatesMS") val timeBetweenUpdatesMS: Int = 0,
    @SageIniName("ScanAheadTimeMS") val scanAheadTimeMS: Int = 0,
    @SageIniName("ScanHeight") val scanHeight: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<HordeNotifyTargetsOfImminentProbableCrushingUpdate>(
        name = "HordeNotifyTargetsOfImminentProbableCrushingUpdate",
        properties = {
            property("ScanWidth", FloatValue) { it.scanWidth }
            property("TimeBetweenUpdatesMS", IntValue) { it.timeBetweenUpdatesMS }
            property("ScanAheadTimeMS", IntValue) { it.scanAheadTimeMS }
            property("ScanHeight", FloatValue) { it.scanHeight }
        },
    )
}
