package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class BoredUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ScanDelayTime") val scanDelayTime: Int = 0,
    @SageIniName("ScanDistance") val scanDistance: Double = 0.0,
    @SageIniName("BoredFilter") val boredFilter: SageFilter? = null,
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("CanScanWhileAttackingOrMoving") val canScanWhileAttackingOrMoving: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<BoredUpdate>(
        name = "BoredUpdate",
        properties = {
            property("ScanDelayTime", IntValue) { it.scanDelayTime }
            property("ScanDistance", FloatValue) { it.scanDistance }
            property("BoredFilter", SageFilter.type) { it.boredFilter }
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("CanScanWhileAttackingOrMoving", BooleanValue) { it.canScanWhileAttackingOrMoving }
        },
    )
}
