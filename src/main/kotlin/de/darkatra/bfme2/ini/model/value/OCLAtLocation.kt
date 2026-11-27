package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

/**
 * An `ObjectCreationList` created at an offset of a `TransitionDamageFX`, e.g. `Loc: X:0 Y:0 Z:0 OCL:OCL_Debris`.
 */
data class OCLAtLocation(
    val x: Double = 0.0,
    val y: Double = 0.0,
    val z: Double = 0.0,
    val ocl: SageReference<ObjectCreationList>? = null,
) {

    companion object {

        val type: SageIniValueType<OCLAtLocation> = StructValue("OCLAtLocation") {
            component("X", FloatValue) { it.x }
            component("Y", FloatValue) { it.y }
            component("Z", FloatValue) { it.z }
            component("OCL", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.ocl }
        }
    }
}
