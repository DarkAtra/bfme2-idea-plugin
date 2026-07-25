package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class VolumeSliderMultiplier(val slider: Opaque? = null, val multiplier: Int = 0) {

    companion object {

        val type: SageIniValueType<VolumeSliderMultiplier> = StructValue("VolumeSliderMultiplier") {
            component("Slider", Opaque.type) { it.slider }
            component("Multiplier", IntValue) { it.multiplier }
        }
    }
}
