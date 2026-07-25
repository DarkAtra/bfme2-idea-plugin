package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class DamageFX(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ThrottleTime") val throttleTime: List<Untyped> = emptyList(),
    @SageIniName("AmountForMajorFX") val amountForMajorFX: List<Untyped> = emptyList(),
    @SageIniName("MajorFX") val majorFX: List<Untyped> = emptyList(),
    @SageIniName("MinorFX") val minorFX: List<Untyped> = emptyList(),
    @SageIniName("VeterancyMajorFX") val veterancyMajorFX: SageReference<FXList>? = null,
    @SageIniName("VeterancyMinorFX") val veterancyMinorFX: SageReference<FXList>? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<DamageFX>(
        name = "DamageFX",
        tableKey = "damagefxs",
        properties = {
            property("ThrottleTime", ListValue(Untyped.type)) { it.throttleTime }
            property("AmountForMajorFX", ListValue(Untyped.type)) { it.amountForMajorFX }
            property("MajorFX", ListValue(Untyped.type)) { it.majorFX }
            property("MinorFX", ListValue(Untyped.type)) { it.minorFX }
            property("VeterancyMajorFX", ReferenceValue<FXList> { listOf(FXList) }) { it.veterancyMajorFX }
            property("VeterancyMinorFX", ReferenceValue<FXList> { listOf(FXList) }) { it.veterancyMinorFX }
        },
    )
}
