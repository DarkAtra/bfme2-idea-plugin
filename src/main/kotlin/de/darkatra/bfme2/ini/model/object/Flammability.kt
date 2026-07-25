package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class Flammability(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Fuel") val fuel: Int = 0,
    @SageIniName("MaxBurnRate") val maxBurnRate: Int = 0,
    @SageIniName("Decay") val decay: Int = 0,
    @SageIniName("Resistance") val resistance: Int = 0,
    @SageIniName("FuelFactor") val fuelFactor: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Flammability>(
        name = "Flammability",
        properties = {
            property("Fuel", IntValue) { it.fuel }
            property("MaxBurnRate", IntValue) { it.maxBurnRate }
            property("Decay", IntValue) { it.decay }
            property("Resistance", IntValue) { it.resistance }
            property("FuelFactor", FloatValue) { it.fuelFactor }
        },
    )
}
