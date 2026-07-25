package de.darkatra.bfme2.ini.model.particle

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class Update(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SizeRate") val sizeRate: List<Double> = emptyList(),
    @SageIniName("SizeRateDamping") val sizeRateDamping: List<Double> = emptyList(),
    @SageIniName("AngleZ") val angleZ: List<Double> = emptyList(),
    @SageIniName("AngularRateZ") val angularRateZ: List<Double> = emptyList(),
    @SageIniName("AngularDamping") val angularDamping: List<Double> = emptyList(),
    @SageIniName("AngularDampingXY") val angularDampingXY: List<Double> = emptyList(),
    @SageIniName("Rotation") val rotation: Untyped? = null,
    @SageIniName("StartSizeX") val startSizeX: List<Double> = emptyList(),
    @SageIniName("StartSizeY") val startSizeY: List<Double> = emptyList(),
    @SageIniName("StartSizeZ") val startSizeZ: List<Double> = emptyList(),
    @SageIniName("SizeDampingX") val sizeDampingX: List<Double> = emptyList(),
    @SageIniName("SizeDampingY") val sizeDampingY: List<Double> = emptyList(),
    @SageIniName("SizeDampingZ") val sizeDampingZ: List<Double> = emptyList(),
    @SageIniName("SizeRateX") val sizeRateX: List<Double> = emptyList(),
    @SageIniName("SizeRateY") val sizeRateY: List<Double> = emptyList(),
    @SageIniName("SizeRateZ") val sizeRateZ: List<Double> = emptyList(),
    @SageIniName("AngleXY") val angleXY: List<Double> = emptyList(),
    @SageIniName("AngularRateXY") val angularRateXY: List<Double> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Update>(
        name = "Update",
        keyedByLabel = true,
        properties = {
            property("SizeRate", ListValue(FloatValue)) { it.sizeRate }
            property("SizeRateDamping", ListValue(FloatValue)) { it.sizeRateDamping }
            property("AngleZ", ListValue(FloatValue)) { it.angleZ }
            property("AngularRateZ", ListValue(FloatValue)) { it.angularRateZ }
            property("AngularDamping", ListValue(FloatValue)) { it.angularDamping }
            property("AngularDampingXY", ListValue(FloatValue)) { it.angularDampingXY }
            property("Rotation", Untyped.type) { it.rotation }
            property("StartSizeX", ListValue(FloatValue)) { it.startSizeX }
            property("StartSizeY", ListValue(FloatValue)) { it.startSizeY }
            property("StartSizeZ", ListValue(FloatValue)) { it.startSizeZ }
            property("SizeDampingX", ListValue(FloatValue)) { it.sizeDampingX }
            property("SizeDampingY", ListValue(FloatValue)) { it.sizeDampingY }
            property("SizeDampingZ", ListValue(FloatValue)) { it.sizeDampingZ }
            property("SizeRateX", ListValue(FloatValue)) { it.sizeRateX }
            property("SizeRateY", ListValue(FloatValue)) { it.sizeRateY }
            property("SizeRateZ", ListValue(FloatValue)) { it.sizeRateZ }
            property("AngleXY", ListValue(FloatValue)) { it.angleXY }
            property("AngularRateXY", ListValue(FloatValue)) { it.angularRateXY }
        },
    )
}
