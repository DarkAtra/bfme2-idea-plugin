package de.darkatra.bfme2.ini.model.particle

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Coords

data class EmissionVolume(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("IsHollow") val isHollow: Boolean = false,
    @SageIniName("HalfSize") val halfSize: Coords? = null,
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("Length") val length: Double = 0.0,
    @SageIniName("Width") val width: Double = 0.0,
    @SageIniName("Height") val height: Double = 0.0,
    @SageIniName("StartPoint") val startPoint: Coords? = null,
    @SageIniName("EndPoint") val endPoint: Coords? = null,
    @SageIniName("Offset") val offset: Coords? = null,
    @SageIniName("RadiusRate") val radiusRate: Double = 0.0,
    @SageIniName("CellEmissionChance") val cellEmissionChance: Double = 0.0,
    @SageIniName("Amplitude1") val amplitude1: List<Double> = emptyList(),
    @SageIniName("Amplitude2") val amplitude2: List<Double> = emptyList(),
    @SageIniName("Amplitude3") val amplitude3: List<Double> = emptyList(),
    @SageIniName("Frequency1") val frequency1: List<Double> = emptyList(),
    @SageIniName("Frequency2") val frequency2: List<Double> = emptyList(),
    @SageIniName("Frequency3") val frequency3: List<Double> = emptyList(),
    @SageIniName("Phase1") val phase1: List<Double> = emptyList(),
    @SageIniName("Phase2") val phase2: List<Double> = emptyList(),
    @SageIniName("Phase3") val phase3: List<Double> = emptyList(),
    @SageIniName("Xoffset") val xoffset: List<Double> = emptyList(),
    @SageIniName("Yoffset") val yoffset: List<Double> = emptyList(),
    @SageIniName("Zoffset") val zoffset: List<Double> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<EmissionVolume>(
        name = "EmissionVolume",
        keyedByLabel = true,
        properties = {
            property("IsHollow", BooleanValue) { it.isHollow }
            property("HalfSize", Coords.type) { it.halfSize }
            property("Radius", FloatValue) { it.radius }
            property("Length", FloatValue) { it.length }
            property("Width", FloatValue) { it.width }
            property("Height", FloatValue) { it.height }
            property("StartPoint", Coords.type) { it.startPoint }
            property("EndPoint", Coords.type) { it.endPoint }
            property("Offset", Coords.type) { it.offset }
            property("RadiusRate", FloatValue) { it.radiusRate }
            property("CellEmissionChance", FloatValue) { it.cellEmissionChance }
            property("Amplitude1", ListValue(FloatValue)) { it.amplitude1 }
            property("Amplitude2", ListValue(FloatValue)) { it.amplitude2 }
            property("Amplitude3", ListValue(FloatValue)) { it.amplitude3 }
            property("Frequency1", ListValue(FloatValue)) { it.frequency1 }
            property("Frequency2", ListValue(FloatValue)) { it.frequency2 }
            property("Frequency3", ListValue(FloatValue)) { it.frequency3 }
            property("Phase1", ListValue(FloatValue)) { it.phase1 }
            property("Phase2", ListValue(FloatValue)) { it.phase2 }
            property("Phase3", ListValue(FloatValue)) { it.phase3 }
            property("Xoffset", ListValue(FloatValue)) { it.xoffset }
            property("Yoffset", ListValue(FloatValue)) { it.yoffset }
            property("Zoffset", ListValue(FloatValue)) { it.zoffset }
        },
    )
}
