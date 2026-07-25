package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.Untyped

data class AutoPickUpUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ScanDelayTime") val scanDelayTime: Int = 0,
    @SageIniName("PickUpKindOf") val pickUpKindOf: List<Untyped> = emptyList(),
    @SageIniName("ScanDistance") val scanDistance: Double = 0.0,
    @SageIniName("EatObjectEntry") val eatObjectEntry: List<Map<String, String>> = emptyList(),
    @SageIniName("Bored") val bored: Boolean = false,
    @SageIniName("BoredFilter") val boredFilter: SageFilter? = null,
    @SageIniName("RunFromButton") val runFromButton: Boolean = false,
    @SageIniName("RunFromButtonNumber") val runFromButtonNumber: Int = 0,
    @SageIniName("PickUpFilter") val pickUpFilter: SageFilter? = null,
    @SageIniName("AutoThrowObject") val autoThrowObject: Boolean = false,
    @SageIniName("CanScanWhileAttackingOrMoving") val canScanWhileAttackingOrMoving: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<AutoPickUpUpdate>(
        name = "AutoPickUpUpdate",
        properties = {
            property("ScanDelayTime", IntValue) { it.scanDelayTime }
            property("PickUpKindOf", ListValue(Untyped.type)) { it.pickUpKindOf }
            property("ScanDistance", FloatValue) { it.scanDistance }
            property("EatObjectEntry", ListValue(MapValue(StringValue, StringValue))) { it.eatObjectEntry }
            property("Bored", BooleanValue) { it.bored }
            property("BoredFilter", SageFilter.type) { it.boredFilter }
            property("RunFromButton", BooleanValue) { it.runFromButton }
            property("RunFromButtonNumber", IntValue) { it.runFromButtonNumber }
            property("PickUpFilter", SageFilter.type) { it.pickUpFilter }
            property("AutoThrowObject", BooleanValue) { it.autoThrowObject }
            property("CanScanWhileAttackingOrMoving", BooleanValue) { it.canScanWhileAttackingOrMoving }
        },
    )
}
