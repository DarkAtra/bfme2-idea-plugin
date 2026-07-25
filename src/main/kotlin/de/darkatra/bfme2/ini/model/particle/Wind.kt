package de.darkatra.bfme2.ini.model.particle

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class Wind(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("WindMotion") val windMotion: Untyped? = null,
    @SageIniName("WindAngleChangeMin") val windAngleChangeMin: Double = 0.0,
    @SageIniName("WindAngleChangeMax") val windAngleChangeMax: Double = 0.0,
    @SageIniName("WindPingPongStartAngleMin") val windPingPongStartAngleMin: Double = 0.0,
    @SageIniName("WindPingPongStartAngleMax") val windPingPongStartAngleMax: Double = 0.0,
    @SageIniName("WindPingPongEndAngleMin") val windPingPongEndAngleMin: Double = 0.0,
    @SageIniName("WindPingPongEndAngleMax") val windPingPongEndAngleMax: Double = 0.0,
    @SageIniName("WindStrength") val windStrength: Double = 0.0,
    @SageIniName("TurbulenceAmplitude") val turbulenceAmplitude: Double = 0.0,
    @SageIniName("TurbulenceFrequency") val turbulenceFrequency: Double = 0.0,
    @SageIniName("WindFullStrengthDist") val windFullStrengthDist: Double = 0.0,
    @SageIniName("WindZeroStrengthDist") val windZeroStrengthDist: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Wind>(
        name = "Wind",
        keyedByLabel = true,
        properties = {
            property("WindMotion", Untyped.type) { it.windMotion }
            property("WindAngleChangeMin", FloatValue) { it.windAngleChangeMin }
            property("WindAngleChangeMax", FloatValue) { it.windAngleChangeMax }
            property("WindPingPongStartAngleMin", FloatValue) { it.windPingPongStartAngleMin }
            property("WindPingPongStartAngleMax", FloatValue) { it.windPingPongStartAngleMax }
            property("WindPingPongEndAngleMin", FloatValue) { it.windPingPongEndAngleMin }
            property("WindPingPongEndAngleMax", FloatValue) { it.windPingPongEndAngleMax }
            property("WindStrength", FloatValue) { it.windStrength }
            property("TurbulenceAmplitude", FloatValue) { it.turbulenceAmplitude }
            property("TurbulenceFrequency", FloatValue) { it.turbulenceFrequency }
            property("WindFullStrengthDist", FloatValue) { it.windFullStrengthDist }
            property("WindZeroStrengthDist", FloatValue) { it.windZeroStrengthDist }
        },
    )
}
