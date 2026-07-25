package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class CameraShakerVolume(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("Duration_Seconds") val durationSeconds: Double = 0.0,
    @SageIniName("Amplitude_Degrees") val amplitudeDegrees: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<CameraShakerVolume>(
        name = "CameraShakerVolume",
        properties = {
            property("Radius", FloatValue) { it.radius }
            property("Duration_Seconds", FloatValue) { it.durationSeconds }
            property("Amplitude_Degrees", FloatValue) { it.amplitudeDegrees }
        },
    )
}
