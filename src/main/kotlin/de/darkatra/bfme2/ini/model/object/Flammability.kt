package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.UnsignedIntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class Flammability(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Fuel") val fuel: UInt = 0u,
    @SageIniName("MaxBurnRate") val maxBurnRate: UInt = 0u,
    @SageIniName("Decay") val decay: UInt = 0u,
    @SageIniName("Resistance") val resistance: UInt = 0u,
    @SageIniName("FuelFactor") val fuelFactor: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Flammability>(
        name = "Flammability",
        properties = {
            property("Fuel", UnsignedIntValue) { it.fuel }
            property("MaxBurnRate", UnsignedIntValue) { it.maxBurnRate }
            property("Decay", UnsignedIntValue) { it.decay }
            property("Resistance", UnsignedIntValue) { it.resistance }
            property("FuelFactor", FloatValue) { it.fuelFactor }
        },
    )
}
