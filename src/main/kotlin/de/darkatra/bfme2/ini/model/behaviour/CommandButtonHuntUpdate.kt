package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class CommandButtonHuntUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ScanRate") val scanRate: Int = 0,
    @SageIniName("ScanRange") val scanRange: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<CommandButtonHuntUpdate>(
        name = "CommandButtonHuntUpdate",
        properties = {
            property("ScanRate", IntValue) { it.scanRate }
            property("ScanRange", FloatValue) { it.scanRange }
        },
    )
}
