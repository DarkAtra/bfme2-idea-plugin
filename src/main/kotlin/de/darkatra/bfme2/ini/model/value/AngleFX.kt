package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.FXList

data class AngleFX(val angle: Double = 0.0, val fx: SageReference<FXList>? = null) {

    companion object {

        val type: SageIniValueType<AngleFX> = StructValue("AngleFX") {
            component("Angle", FloatValue) { it.angle }
            component("FX", ReferenceValue<FXList> { listOf(FXList) }) { it.fx }
        }
    }
}
