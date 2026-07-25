package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Coords

data class RainOfFireUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StartRainTime") val startRainTime: Int = 0,
    @SageIniName("DarknessFadeTime") val darknessFadeTime: Int = 0,
    @SageIniName("RainEmitterHeight") val rainEmitterHeight: Double = 0.0,
    @SageIniName("DarknessLevel") val darknessLevel: Double = 0.0,
    @SageIniName("JitterRadius") val jitterRadius: Double = 0.0,
    @SageIniName("DPSMin") val dPSMin: Double = 0.0,
    @SageIniName("DPSMax") val dPSMax: Double = 0.0,
    @SageIniName("DPSRampupTime") val dPSRampupTime: Int = 0,
    @SageIniName("RainOffset") val rainOffset: Coords? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<RainOfFireUpdate>(
        name = "RainOfFireUpdate",
        properties = {
            property("StartRainTime", IntValue) { it.startRainTime }
            property("DarknessFadeTime", IntValue) { it.darknessFadeTime }
            property("RainEmitterHeight", FloatValue) { it.rainEmitterHeight }
            property("DarknessLevel", FloatValue) { it.darknessLevel }
            property("JitterRadius", FloatValue) { it.jitterRadius }
            property("DPSMin", FloatValue) { it.dPSMin }
            property("DPSMax", FloatValue) { it.dPSMax }
            property("DPSRampupTime", IntValue) { it.dPSRampupTime }
            property("RainOffset", Coords.type) { it.rainOffset }
        },
    )
}
