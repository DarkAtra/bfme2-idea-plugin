package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class FXListAtBonePos(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("FX") val fX: SageReference<FXList>? = null,
    @SageIniName("BoneName") val boneName: Opaque? = null,
    @SageIniName("Weather") val weather: Untyped? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<FXListAtBonePos>(
        name = "FXListAtBonePos",
        properties = {
            property("FX", ReferenceValue<FXList> { listOf(FXList) }) { it.fX }
            property("BoneName", Opaque.type) { it.boneName }
            property("Weather", Untyped.type) { it.weather }
        },
    )
}
