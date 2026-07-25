package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.SageReference

data class WeatherData(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("HasLightning") val hasLightning: Boolean = false,
    @SageIniName("WeatherSound") val weatherSound: SageReference<AudioEvent>? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<WeatherData>(
        name = "WeatherData",
        tableKey = "weatherdatas",
        properties = {
            property("HasLightning", BooleanValue) { it.hasLightning }
            property("WeatherSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.weatherSound }
        },
    )
}
