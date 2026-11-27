package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

/**
 * An `FXList` played at an offset of a `TransitionDamageFX`, e.g. `Loc: X:0 Y:0 Z:0 FXList:FX_BasicSevereScreenShake`.
 */
data class FXListAtLocation(
    val x: Double = 0.0,
    val y: Double = 0.0,
    val z: Double = 0.0,
    val fxList: SageReference<FXList>? = null,
) {

    companion object {

        val type: SageIniValueType<FXListAtLocation> = StructValue("FXListAtLocation") {
            component("X", FloatValue) { it.x }
            component("Y", FloatValue) { it.y }
            component("Z", FloatValue) { it.z }
            component("FXList", ReferenceValue<FXList> { listOf(FXList) }) { it.fxList }
        }
    }
}
