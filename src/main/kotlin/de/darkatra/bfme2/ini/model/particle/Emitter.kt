package de.darkatra.bfme2.ini.model.particle

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Untyped

data class Emitter(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("VelocityType") val velocityType: Untyped? = null,
    @SageIniName("VolumeType") val volumeType: Untyped? = null,
    @SageIniName("IsHollow") val isHollow: Boolean = false,
    @SageIniName("VelOrthoX") val velOrthoX: Untyped? = null,
    @SageIniName("VelOrthoY") val velOrthoY: Untyped? = null,
    @SageIniName("VelOrthoZ") val velOrthoZ: Untyped? = null,
    @SageIniName("VolCylinderRadius") val volCylinderRadius: Double = 0.0,
    @SageIniName("VolCylinderLength") val volCylinderLength: Double = 0.0,
    @SageIniName("VolLineStart") val volLineStart: Coords? = null,
    @SageIniName("VolLineEnd") val volLineEnd: Coords? = null,
    @SageIniName("VelOutwardOther") val velOutwardOther: List<Double> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Emitter>(
        name = "Emitter",
        keyedByLabel = true,
        properties = {
            property("VelocityType", Untyped.type) { it.velocityType }
            property("VolumeType", Untyped.type) { it.volumeType }
            property("IsHollow", BooleanValue) { it.isHollow }
            property("VelOrthoX", Untyped.type) { it.velOrthoX }
            property("VelOrthoY", Untyped.type) { it.velOrthoY }
            property("VelOrthoZ", Untyped.type) { it.velOrthoZ }
            property("VolCylinderRadius", FloatValue) { it.volCylinderRadius }
            property("VolCylinderLength", FloatValue) { it.volCylinderLength }
            property("VolLineStart", Coords.type) { it.volLineStart }
            property("VolLineEnd", Coords.type) { it.volLineEnd }
            property("VelOutwardOther", ListValue(FloatValue)) { it.velOutwardOther }
        },
    )
}
