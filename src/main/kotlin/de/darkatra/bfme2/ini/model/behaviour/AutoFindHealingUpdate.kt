package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue

data class AutoFindHealingUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ScanRate") val scanRate: Int = 0,
    @SageIniName("ScanRange") val scanRange: Double = 0.0,
    @SageIniName("NeverHeal") val neverHeal: Double = 0.0,
    @SageIniName("AlwaysHeal") val alwaysHeal: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<AutoFindHealingUpdate>(
        name = "AutoFindHealingUpdate",
        properties = {
            property("ScanRate", IntValue) { it.scanRate }
            property("ScanRange", FloatValue) { it.scanRange }
            property("NeverHeal", FloatValue) { it.neverHeal }
            property("AlwaysHeal", FloatValue) { it.alwaysHeal }
        },
    )
}
