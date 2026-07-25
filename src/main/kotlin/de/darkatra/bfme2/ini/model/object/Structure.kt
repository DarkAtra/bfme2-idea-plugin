package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Coords

data class Structure(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Location") val location: Coords? = null,
    @SageIniName("Rebuilds") val rebuilds: Int = 0,
    @SageIniName("Angle") val angle: Double = 0.0,
    @SageIniName("InitiallyBuilt") val initiallyBuilt: Boolean = false,
    @SageIniName("AutomaticallyBuild") val automaticallyBuild: Boolean = false,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Structure>(
        name = "Structure",
        properties = {
            property("Location", Coords.type) { it.location }
            property("Rebuilds", IntValue) { it.rebuilds }
            property("Angle", FloatValue) { it.angle }
            property("InitiallyBuilt", BooleanValue) { it.initiallyBuilt }
            property("AutomaticallyBuild", BooleanValue) { it.automaticallyBuild }
        },
    )
}
