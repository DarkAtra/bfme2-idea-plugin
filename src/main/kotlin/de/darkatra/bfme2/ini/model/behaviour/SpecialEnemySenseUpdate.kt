package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.SageFilter

data class SpecialEnemySenseUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialEnemyFilter") val specialEnemyFilter: SageFilter? = null,
    @SageIniName("ScanRange") val scanRange: Double = 0.0,
    @SageIniName("ScanInterval") val scanInterval: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SpecialEnemySenseUpdate>(
        name = "SpecialEnemySenseUpdate",
        properties = {
            property("SpecialEnemyFilter", SageFilter.type) { it.specialEnemyFilter }
            property("ScanRange", FloatValue) { it.scanRange }
            property("ScanInterval", IntValue) { it.scanInterval }
        },
    )
}
