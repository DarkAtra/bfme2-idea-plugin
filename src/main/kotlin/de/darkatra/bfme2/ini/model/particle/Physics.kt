package de.darkatra.bfme2.ini.model.particle

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Coords

data class Physics(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("VelocityDamping") val velocityDamping: List<Double> = emptyList(),
    @SageIniName("DriftVelocity") val driftVelocity: Coords? = null,
    @SageIniName("Gravity") val gravity: Double = 0.0,
    @SageIniName("Swirly") val swirly: Boolean = false,
    @SageIniName("ParticlesAttachToBone") val particlesAttachToBone: Boolean = false,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Physics>(
        name = "Physics",
        keyedByLabel = true,
        properties = {
            property("VelocityDamping", ListValue(FloatValue)) { it.velocityDamping }
            property("DriftVelocity", Coords.type) { it.driftVelocity }
            property("Gravity", FloatValue) { it.gravity }
            property("Swirly", BooleanValue) { it.swirly }
            property("ParticlesAttachToBone", BooleanValue) { it.particlesAttachToBone }
        },
    )
}
