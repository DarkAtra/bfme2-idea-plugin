package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList

/**
 * An `ObjectCreationList` of a `TransitionDamageFX`, at an offset like `Loc: X:0 Y:0 Z:0` or at a bone like `Bone:Fire01 RandomBone:No`.
 */
data class OCLAtLocation(
    val bone: String = "",
    val randomBone: Boolean = false,
    val x: Double = 0.0,
    val y: Double = 0.0,
    val z: Double = 0.0,
    val ocl: SageReference<ObjectCreationList>? = null,
) {

    companion object {

        val type: SageIniValueType<OCLAtLocation> = StructValue("OCLAtLocation") {
            component("Bone", StringValue) { it.bone }
            component("RandomBone", BooleanValue) { it.randomBone }
            component("X", FloatValue) { it.x }
            component("Y", FloatValue) { it.y }
            component("Z", FloatValue) { it.z }
            component("OCL", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.ocl }
        }
    }
}
