package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class EyeTowerPoints(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("LookPoint") val lookPoint: List<Untyped> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<EyeTowerPoints>(
        name = "EyeTowerPoints",
        properties = {
            property("LookPoint", ListValue(Untyped.type)) { it.lookPoint }
        },
    )
}
