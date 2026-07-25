package de.darkatra.bfme2.ini.model.particle

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class Alpha(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Alpha1") val alpha1: List<Double> = emptyList(),
    @SageIniName("Alpha2") val alpha2: List<Double> = emptyList(),
    @SageIniName("Alpha3") val alpha3: List<Double> = emptyList(),
    @SageIniName("Alpha4") val alpha4: List<Double> = emptyList(),
    @SageIniName("Alpha5") val alpha5: List<Double> = emptyList(),
    @SageIniName("Alpha6") val alpha6: List<Double> = emptyList(),
    @SageIniName("Alpha7") val alpha7: List<Double> = emptyList(),
    @SageIniName("Alpha8") val alpha8: List<Double> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Alpha>(
        name = "Alpha",
        keyedByLabel = true,
        properties = {
            property("Alpha1", ListValue(FloatValue)) { it.alpha1 }
            property("Alpha2", ListValue(FloatValue)) { it.alpha2 }
            property("Alpha3", ListValue(FloatValue)) { it.alpha3 }
            property("Alpha4", ListValue(FloatValue)) { it.alpha4 }
            property("Alpha5", ListValue(FloatValue)) { it.alpha5 }
            property("Alpha6", ListValue(FloatValue)) { it.alpha6 }
            property("Alpha7", ListValue(FloatValue)) { it.alpha7 }
            property("Alpha8", ListValue(FloatValue)) { it.alpha8 }
        },
    )
}
